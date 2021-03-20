package com.flightmonitor.application.flightutil;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.flightmonitor.application.endpoint.entity.Notification;
import com.flightmonitor.application.endpoint.entity.ObservedArea;
import com.flightmonitor.application.endpoint.entity.UserArea;
import com.flightmonitor.application.endpoint.entity.UserInfo;
import com.flightmonitor.application.f24.api.F24ApiUtils;
import com.flightmonitor.application.f24.model.FlightShortInfo;
import com.flightmonitor.application.f24.model.generated.FlightDetailedInfo;
import com.flightmonitor.application.f24.model.generated.Trail;
import com.flightmonitor.application.opensky.api.OpenSkyApi;
import com.flightmonitor.application.opensky.api.OpenSkyApiUtils;
import com.flightmonitor.application.opensky.model.AircraftInfo;
import com.flightmonitor.application.opensky.model.FlightRoute;
import com.flightmonitor.application.parms.AppStore;
import com.flightmonitor.application.test.OpenSkyStates;
import com.flightmonitor.application.test.StateVector;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.mongodb.MongoClient;

public class FlightUtils {

	private static final String USERNAME = "ladnyik";
	private static final String PASSWORD = "vocsike8";
	private static String mailUsername = "ladnyik@gmail.com";
	private static String mailPassword = "tqpjppqrhfbjhatz";
	private static Map<String, StateVector> previousOpenSkyFlights = new TreeMap<String, StateVector>();
	private static Map<String, StateVector> actualOpenSkyFlights = new TreeMap<String, StateVector>();
		
	private static Map<String, Map<String, Object>> previousOsF24FlightsByUserArea = new TreeMap<String, Map<String, Object>>();
	private static Map<String, Map<String, Object>> actualOsF24FlightsByUserArea = new TreeMap<String, Map<String, Object>>();
		

	private static boolean first = true;
	private static Session session;
	private static Properties prop = new Properties();
	private static Properties airports = new Properties();

	static {
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS
		session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailUsername, mailPassword);
			}
		});
		try {
			airports.load(FlightUtils.class.getClassLoader().getResourceAsStream("airports.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void sendOpenSkyF24FlightAlerts() throws MessagingException, IOException {

		Morphia morphia = new Morphia();
		morphia.mapPackage("com.flightmonitor.application.endpoint.entity");
		Datastore datastore = morphia.createDatastore(new MongoClient("localhost",AppStore.getMongoPort()), "flightmonitor");
		datastore.ensureIndexes();
		Query<UserArea> userAreaQuery = datastore.createQuery(UserArea.class);
		List<UserArea> userAreas = userAreaQuery.asList();
		for (UserArea userArea : userAreas) {
			Query<Notification> notificationQuery = datastore.createQuery(Notification.class).field("email")
					.equal(userArea.getEmail());
			List<Notification> notification = notificationQuery.asList();
			System.out.println(notification.size());
			if (notification.size() > 0) {
				if ( !notification.get(0).isSendOsF24Messages())
					continue;
			}
			else
				continue;				
			
			for (ObservedArea observedArea : userArea.getAreas()) {
				// Map<String, FlightShortInfo> airCrafts = F24ApiUtils.getFlights(48.319729,
				// 46.906817, 18.2280541,20.285942);
				//Map<String, Object> previousOsF24Flights = new TreeMap<String, Object>();
				//Map<String, Object> actualOsF24Flights = new TreeMap<String, Object>();
				if (!observedArea.isSendEmailNotification())
					continue;
				
				Map<String, Object>previousOsF24Flights;
				Map<String, Object> actualOsF24Flights;
				
				if ( actualOsF24FlightsByUserArea.containsKey(userArea.getEmail() + observedArea.getDescription()) ){
					previousOsF24Flights = previousOsF24FlightsByUserArea.get(userArea.getEmail()+ observedArea.getDescription());
				}
				else {
					previousOsF24Flights = new TreeMap<String, Object>();
					previousOsF24FlightsByUserArea.put(userArea.getEmail()+ observedArea.getDescription(), previousOsF24Flights);
				}
				
				if ( actualOsF24FlightsByUserArea.containsKey(userArea.getEmail() + observedArea.getDescription()) ){
					actualOsF24Flights = actualOsF24FlightsByUserArea.get(userArea.getEmail() + observedArea.getDescription());
				}
				else {
					actualOsF24Flights = new TreeMap<String, Object>();
					actualOsF24FlightsByUserArea.put(userArea.getEmail() + observedArea.getDescription(), actualOsF24Flights);
				}
				
				Map<String, FlightShortInfo> airCrafts = F24ApiUtils.getFlights(
						observedArea.getArea().getTopLatitude(), observedArea.getArea().getBottomLatitude(),
						observedArea.getArea().getBottomLongitude(), observedArea.getArea().getTopLongitude());

				for (Map.Entry<String, FlightShortInfo> entry : airCrafts.entrySet()) {
					actualOsF24Flights.put(entry.getKey(), entry.getValue());
				}

				OpenSkyApi api = new OpenSkyApi(USERNAME, PASSWORD);
				OpenSkyStates os = null;
				try {
					// os = api.getStates(0, null, new OpenSkyApi.BoundingBox(46.906817, 48.319729,
					// 18.228054, 20.285942));
					os = api.getStates(0, null,
							new OpenSkyApi.BoundingBox(observedArea.getArea().getBottomLatitude(),
									observedArea.getArea().getTopLatitude(),
									observedArea.getArea().getBottomLongitude(),
									observedArea.getArea().getTopLongitude()));
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (os != null && os.getStates() != null) {
					Map<String, StateVector> actualOpenSkyFlightsForCompare = new TreeMap<String, StateVector>();
					for (StateVector state : os.getStates()) {
						actualOpenSkyFlightsForCompare.put(state.getIcao24().toUpperCase(), state);
					}
					SetView<String> difference = Sets.difference(actualOpenSkyFlightsForCompare.keySet(),
							actualOsF24Flights.keySet());
					for (String icao : difference) {
						actualOsF24Flights.put(icao, actualOpenSkyFlightsForCompare.get(icao));
					}

					SetView<String> intersection = Sets.intersection(actualOpenSkyFlightsForCompare.keySet(),
							actualOsF24Flights.keySet());
					for (String icao : intersection) {
						Object obj = actualOsF24Flights.get(icao);
						if (obj instanceof FlightShortInfo) {
							FlightShortInfo flightShortInfo = (FlightShortInfo) obj;
							System.out.println(flightShortInfo);
							flightShortInfo.setCountry(actualOpenSkyFlightsForCompare.get(icao).getOriginCountry());
						}
					}
				}
				Set<String> icaos = new HashSet<String>();
				for (Map.Entry<String,Object> flightEntry : actualOsF24Flights.entrySet()) {
					String icao = flightEntry.getKey();
					Object flight = flightEntry.getValue();
					if (flight instanceof FlightShortInfo) {
						FlightShortInfo flightShortInfo = (FlightShortInfo)flight;
						if ( 
								(
										(int) Math.round(flightShortInfo.getVertical() / (3.2808 * 60)) > observedArea.getMinVertical() &&
										(int) Math.round(flightShortInfo.getVertical() / (3.2808 * 60)) < observedArea.getMaxVertical()
								) 
								&&
								(
										(int) Math.round(flightShortInfo.getCalibratedAltitude() / 3.2808) > observedArea.getMinAltitude() &&
										(int) Math.round(flightShortInfo.getCalibratedAltitude() / 3.2808) < observedArea.getMaxAltitude()
								) 
								&&
								(
										Math.round(flightShortInfo.getGroundSpeedInKnots() * 1.852) > observedArea.getMinSpeed() &&
										Math.round(flightShortInfo.getGroundSpeedInKnots() * 1.852) < observedArea.getMaxSpeed()
								) 
						) {
							
						}
						else {
							icaos.add(icao);
						}
					}
				}
				for(String icao : icaos) {
					actualOsF24Flights.remove(icao);
				}
//				previousOsF24Flights.clear();
//				first = false;

				SetView<String> difference = Sets.difference(actualOsF24Flights.keySet(),
						previousOsF24Flights.keySet());
				if (first)
					first = false;
				else {
					for (String id : difference) {
						Object flight = actualOsF24Flights.get(id);
						System.out.println(flight);
						if (flight instanceof StateVector && (((StateVector) flight).getCallsign() != null
								&& ((StateVector) flight).getCallsign().length() != 0))
							sendOsAlert(observedArea.getDescription(),(StateVector) flight);
						if (flight instanceof FlightShortInfo)
							sendF24Alert(observedArea.getDescription(), (FlightShortInfo) flight);
					}
				}

				previousOsF24Flights.clear();
				previousOsF24Flights.putAll(actualOsF24Flights);
				actualOsF24Flights.clear();
			}
		}

	}

//	public static void sendF24FlightAlerts() throws AddressException, MessagingException {
//
//		Map<String, FlightShortInfo> airCrafts = F24ApiUtils.getFlights(48.319729, 46.906817, 18.2280541, 20.285942);
//		for (Map.Entry<String, FlightShortInfo> entry : airCrafts.entrySet()) {
//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//			actualF24Flights.put(entry.getKey(), entry.getValue());
//		}
//
//		SetView<String> difference;
//
//		previousF24Flights.clear();
//
//		difference = Sets.difference(actualF24Flights.keySet(), previousF24Flights.keySet());
//		if (first)
//			first = false;
//		else {
//			System.out.println(String.format("Elteres %d", difference.size()));
//			for (String id : difference) {
//				javax.mail.Message message = new MimeMessage(session);
//				message.setFrom(new InternetAddress("ladnyik@gmail.com"));
//				message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse("ladnyik@gmail.com"));
//				FlightShortInfo flightShortInfo = actualF24Flights.get(id);
//				message.setSubject(String.format("%s %s %s", flightShortInfo.getCallSign(),
//						flightShortInfo.getOriginatingAirport(), flightShortInfo.getDestitanionAirport()));
//
//				Document doc = Jsoup.parse("<html></html>");
//				Element style = doc.head().appendElement("style");
//				style.appendText("table, th, td {\n" + "  border: 1px solid black;\n" + "} " + "div {display: inline;} "
//						+ ".red{color: red} " + ".bold{font-weight: bold} ");
//
//				message.setContent(doc.toString(), "text/html; charset=utf-8");
//				Transport.send(message);
//			}
//		}
//
//		previousF24Flights.clear();
//		previousF24Flights.putAll(actualF24Flights);
//		actualF24Flights.clear();
//
//	}

	public static void sendOpenSkyFlightAlerts() throws IOException, AddressException, MessagingException {

		OpenSkyApi api = new OpenSkyApi(USERNAME, PASSWORD);
		// 46.906817, 18.228054
		// 48.319729, 20.285942
		OpenSkyStates os = api.getStates(0, null,
				new OpenSkyApi.BoundingBox(46.906817, 48.319729, 18.228054, 20.285942));

		if (os == null)
			return;

		for (StateVector state : os.getStates()) {
			actualOpenSkyFlights.put(state.getIcao24(), state);
		}
		SetView<String> difference;

		// previousFLights.clear();

		difference = Sets.difference(actualOpenSkyFlights.keySet(), previousOpenSkyFlights.keySet());

		if (first)
			first = false;
		else {
			System.out.println(String.format("Elteres %d", difference.size()));
			for (String icao : difference) {
				StateVector state = actualOpenSkyFlights.get(icao);
				System.out.println(state);
				if (state.getCallsign() == null || state.getCallsign().length() == 0)
					continue;
				//sendOsAlert(state);
			}
		}
		previousOpenSkyFlights.clear();
		previousOpenSkyFlights.putAll(actualOpenSkyFlights);
		actualOpenSkyFlights.clear();
	}

	private static void sendF24Alert(String area, FlightShortInfo flightShortInfo) throws AddressException, MessagingException {

		javax.mail.Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("ladnyik@gmail.com"));
		message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse("ladnyik@gmail.com"));
		message.setSubject(String.format("%s %s %s", flightShortInfo.getCallSign(),
				flightShortInfo.getOriginatingAirport(), flightShortInfo.getDestitanionAirport()));

		Document doc = Jsoup.parse("<html></html>");
		Element style = doc.head().appendElement("style");
		style.appendText("table, th, td {\n" + "  border: 1px solid black;\n" + "} " + "div {display: inline;} "
				+ ".red{color: red} " + ".bold{font-weight: bold} ");

		Element h1 = doc.body().appendElement("h3");
		h1.text(area);
		
		if (flightShortInfo.getCallSign() != null) {
			Element link = doc.body().appendElement("a");
			link.text(flightShortInfo.getCallSign());
			link.attr("href", "https://www.flightradar24.com/" + flightShortInfo.getCallSign().trim());
		}
		
		Element table = doc.body().appendElement("table");
		table.attr("style", "width:100%");

		Element tr = table.appendElement("tr");
		tr.appendElement("td").text("Call Sign");
		tr.appendElement("td").text(flightShortInfo.getCallSign().trim());

		if (flightShortInfo.getCountry() != null) {
			tr = table.appendElement("tr");
			tr.appendElement("td").text("Country");
			tr.appendElement("td").text(flightShortInfo.getCountry());
		}

		tr = table.appendElement("tr");
		tr.appendElement("td").text("Altitude");
		tr.appendElement("td").text((int) Math.round(flightShortInfo.getCalibratedAltitude() / 3.2808) + " meter");

		tr = table.appendElement("tr");
		tr.appendElement("td").text("Speed");
		tr.appendElement("td").text((int) Math.round(flightShortInfo.getGroundSpeedInKnots() * 1.852) + " km/h");

		tr = table.appendElement("tr");
		tr.appendElement("td").text("Heading");
		tr.appendElement("td").text(Integer.toString(flightShortInfo.getTrack()));

		tr = table.appendElement("tr");
		tr.appendElement("td").text("Flight Number");
		tr.appendElement("td").text(flightShortInfo.getFlightNumber());

		tr = table.appendElement("tr");
		tr.appendElement("td").text("Registration");
		tr.appendElement("td").text(flightShortInfo.getRegistration());

		tr = table.appendElement("tr");
		tr.appendElement("td").text("Vertical");
		tr.appendElement("td").text((int) Math.round(flightShortInfo.getVertical() / (3.2808 * 60)) + " m/s");
		FlightDetailedInfo flightDetailedInfo = F24ApiUtils.getFlightDetail(flightShortInfo.getF24Id());
		AircraftInfo aircraftInfo = OpenSkyApiUtils
				.getAircraftInfo(flightShortInfo.getAirCraftIcaoCode().toLowerCase());
		if (aircraftInfo != null) {
			tr = table.appendElement("tr");
			tr.appendElement("td").text("Manufacturer");
			tr.appendElement("td").text(aircraftInfo.getManufacturerName());
			tr = table.appendElement("tr");
			tr.appendElement("td").text("Model");
			tr.appendElement("td").text(aircraftInfo.getModel());
			tr = table.appendElement("tr");
			tr.appendElement("td").text("Owner");
			tr.appendElement("td").text(aircraftInfo.getOwner());
			tr = table.appendElement("tr");
			tr.appendElement("td").text("Registration");
			tr.appendElement("td").text(aircraftInfo.getRegistration());
		} else {
			if (flightDetailedInfo.getAircraft().getModel() != null) {
				tr = table.appendElement("tr");
				tr.appendElement("td").text("Model");
				tr.appendElement("td").text(flightDetailedInfo.getAircraft().getModel().getText());
			}
			if (flightDetailedInfo.getAircraft().getRegistration() != null) {
				tr = table.appendElement("tr");
				tr.appendElement("td").text("Registration");
				tr.appendElement("td").text(flightDetailedInfo.getAircraft().getRegistration());
			}
		}
		if (flightDetailedInfo.getAirline() != null && flightDetailedInfo.getAirline().getCode() != null) {
			tr = table.appendElement("tr");
			tr.appendElement("td").text("Operator CallSing");
			tr.appendElement("td").text(flightDetailedInfo.getAirline().getCode().getIata() + " - "
					+ flightDetailedInfo.getAirline().getName());
		}

		tr = table.appendElement("tr");
		tr.appendElement("td").text("Route");
		tr.appendElement("td")
				.text((flightDetailedInfo.getAirport().getOrigin() != null
						? flightDetailedInfo.getAirport().getOrigin().getCode().getIata()
						: "")
						+ "-"
						+ (flightDetailedInfo.getAirport().getOrigin() != null
								? flightDetailedInfo.getAirport().getOrigin().getName()
								: "")
						+ " -> "
						+ (flightDetailedInfo.getAirport().getDestination() != null
								? flightDetailedInfo.getAirport().getDestination().getCode().getIata()
								: "")
						+ "-"
						+ (flightDetailedInfo.getAirport().getDestination() != null
								? flightDetailedInfo.getAirport().getDestination().getName()
								: "")

				);

		if (flightShortInfo.getLatitude() != 0.0 && flightShortInfo.getLongitude() != 0.0) {
			Element img = doc.body().appendElement("img");
			String shape = null;
			boolean first = true;
			if (flightDetailedInfo.getTrail() != null && flightDetailedInfo.getTrail().size() > 0) {
				for (Trail trail : flightDetailedInfo.getTrail()) {
					if (first) {
						first = false;
						shape = "&shape=" + flightShortInfo.getLongitude() + "," + flightShortInfo.getLatitude() + "|";
					} else
						shape += "|";
					shape += trail.getLat() + "," + trail.getLng();
				}
			}

			img.attr("src", "https://www.mapquestapi.com/staticmap/v5/map?&center=" + flightShortInfo.getLongitude()
					+ "," + flightShortInfo.getLatitude() + "&locations=" + flightShortInfo.getLongitude() + ","
					+ flightShortInfo.getLatitude() + "&size=@2x&key=nE8z6qn6QaCTVfrAxkPKeCaHJY9Zofkq&zoom=8&banner="
					+ flightShortInfo.getCallSign()
					+ (flightShortInfo.getCountry() != null ? "-" + flightShortInfo.getCountry() : "")
					+ "|sm-top-A0021B-000000" + (shape != null ? shape : ""));
			System.out.println(img.attr("src"));
			img.attr("width", "400");
			img.attr("height", "400");
		}
		
		if (flightDetailedInfo.getAircraft().getImages() != null && flightDetailedInfo.getAircraft().getImages().getMedium() !=null &&
				flightDetailedInfo.getAircraft().getImages().getMedium().size() > 0
				 ) {
			Element img = doc.body().appendElement("img");
			img.attr("src", flightDetailedInfo.getAircraft().getImages().getMedium().get(0).getSrc().replaceAll("\\\\", ""));
			System.out.println(flightDetailedInfo.getAircraft().getImages().getMedium().get(0).getSrc().replaceAll("\\\\", ""));
		}
						
		message.setContent(doc.toString(), "text/html; charset=utf-8");

		Transport.send(message);

	}

	private static void sendOsAlert(String area, StateVector state) throws AddressException, MessagingException {

		javax.mail.Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("ladnyik@gmail.com"));
		message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse("ladnyik@gmail.com"));
		message.setSubject(String.format("%s %s %s %s", state.getCallsign().trim(), state.getOriginCountry(),
				(state.getIcao24() != null ? state.getIcao24() : "N/A"), (state.getGeoAltitude() == null ? "N/A"
						: (new Integer((int) state.getGeoAltitude().doubleValue())).toString())));
		Document doc = Jsoup.parse("<html></html>");
		Element style = doc.head().appendElement("style");
		style.appendText("table, th, td {\n" + "  border: 1px solid black;\n" + "} " + "div {display: inline;} "
				+ ".red{color: red} " + ".bold{font-weight: bold} ");
		
		Element h1 = doc.body().appendElement("h3");
		h1.text(area);
		
		if (state.getCallsign() != null) {
			System.out.println("radar24");
			Element link = doc.body().appendElement("a");
			link.text(state.getCallsign().trim());
			link.attr("href", "https://www.flightradar24.com/" + state.getCallsign().trim());
			System.out.println(link);
		}
		Element table = doc.body().appendElement("table");
		table.attr("style", "width:100%");
		Element tr = table.appendElement("tr");
		tr.appendElement("td").text("Call Sign");
		tr.appendElement("td").text(state.getCallsign().trim());
		tr = table.appendElement("tr");
		tr.appendElement("td").text("Country");
		tr.appendElement("td").text(state.getOriginCountry().trim());
		tr = table.appendElement("tr");
		tr.appendElement("td").text("Altitude");
		tr.appendElement("td").text((state.getGeoAltitude() == null ? "N/A"
				: (new Integer((int) state.getGeoAltitude().doubleValue())).toString()));
		tr = table.appendElement("tr");
		tr.appendElement("td").text("Speed");
		tr.appendElement("td")
				.text((new Integer((int) (state.getVelocity().doubleValue() * 3.6f))).toString() + " km/h");
		tr = table.appendElement("tr");
		tr.appendElement("td").text("Vertical");
		tr.appendElement("td").text((state.getVerticalRate() == null ? "N/A"
				: (new Integer((int) (state.getVerticalRate().doubleValue()))).toString() + " m/s"));
		if (state.isOnGround()) {
			tr = table.appendElement("tr");
			tr.appendElement("td").text("On ground");
			tr.appendElement("td").text("true");
		}
		if (state.getHeading() != null) {
			tr = table.appendElement("tr");
			tr.appendElement("td").text("Heading");
			tr.appendElement("td").text((new Integer((int) (state.getHeading().doubleValue()))).toString());
		}
		AircraftInfo aircraftInfo = OpenSkyApiUtils.getAircraftInfo(state.getIcao24());
		if (aircraftInfo != null) {
			tr = table.appendElement("tr");
			tr.appendElement("td").text("Manufacturer");
			tr.appendElement("td").text(aircraftInfo.getManufacturerName());
			tr = table.appendElement("tr");
			tr.appendElement("td").text("Model");
			tr.appendElement("td").text(aircraftInfo.getModel());
			tr = table.appendElement("tr");
			tr.appendElement("td").text("Owner");
			tr.appendElement("td").text(aircraftInfo.getOwner());
			tr = table.appendElement("tr");
			tr.appendElement("td").text("Registration");
			tr.appendElement("td").text(aircraftInfo.getRegistration());
			tr = table.appendElement("tr");
			tr.appendElement("td").text("Operator CallSing");
			tr.appendElement("td").text(aircraftInfo.getOperatorCallsign());
		}
		FlightRoute flightRoute = OpenSkyApiUtils.getAircraftRoute(state.getCallsign().trim());
		if (flightRoute != null && flightRoute.getRoute() != null) {
			tr = table.appendElement("tr");
			tr.appendElement("td").text("Route");
			// tr.appendElement("td").text(flightRoute.getRoute().toString().replace("[",
			// "").replace("]", ""));
			String airPorts = "";
			for (String airPortCode : flightRoute.getRoute()) {
				String realAirPortCode = airPortCode.replace("[", "").replace("]", "");
				airPorts += airports.get(realAirPortCode) + " -> ";
			}
			if (airPorts.length() > 0)
				tr.appendElement("td").text(airPorts);
			else
				tr.appendElement("td").text("N/A");
		} else {
			tr = table.appendElement("tr");
			tr.appendElement("td").text("Route");
			tr.appendElement("td").text("N/A");
		}
		if (state.getLatitude() != null && state.getLongitude() != null) {
			Element img = doc.body().appendElement("img");
			if (state.isOnGround())
				img.attr("src", "https://www.mapquestapi.com/staticmap/v5/map?locations=" + state.getLatitude() + ","
						+ state.getLongitude() + "&size=@2x&key=nE8z6qn6QaCTVfrAxkPKeCaHJY9Zofkq&zoom=8&banner="
						+ state.getCallsign().trim() + "-" + state.getOriginCountry().trim() + "|sm-top-A0021B-000000");
			else {
				Double R = 6378.1;
				Double d = 20.0;
				Double fromLat = state.getLatitude(), fromLon = state.getLongitude();
				Double toLat, toLon;
				Double brng = state.getHeading();

				Double lat1 = Math.toRadians(fromLat);
				Double lon1 = Math.toRadians(fromLon);

				toLat = Math.asin(Math.sin(lat1) * Math.cos(d / R)
						+ Math.cos(lat1) * Math.sin(d / R) * Math.cos(Math.toRadians(brng)));
				toLon = lon1 + Math.atan2(Math.sin(Math.toRadians(brng)) * Math.sin(d / R) * Math.cos(lat1),
						Math.cos(d / R) - Math.sin(lat1) * Math.sin(toLat));

				img.attr("src",
						"https://www.mapquestapi.com/staticmap/v5/map?locations=" + state.getLatitude() + ","
								+ state.getLongitude()
								+ "|flag-lg-OPEN&size=@2x&key=nE8z6qn6QaCTVfrAxkPKeCaHJY9Zofkq&zoom=8&banner="
								+ state.getCallsign().trim() + "-" + state.getOriginCountry().trim()
								+ "|sm-top-A0021B-000000&shape=border:0000ff|" + fromLat + "," + fromLon + "|"
								+ Math.toDegrees(toLat) + "," + Math.toDegrees(toLon));
			}
			img.attr("width", "400");
			img.attr("height", "400");
		}
		message.setContent(doc.toString(), "text/html; charset=utf-8");
		Transport.send(message);

	}
}
