package com.flightmonitor.application.f24.api;

import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.flightmonitor.application.f24.model.FlightShortInfo;
import com.flightmonitor.application.f24.model.generated.FlightDetailedInfo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


public class F24ApiUtils {

	private static final String F24_AREAENQUIRY = "https://data-live.flightradar24.com/zones/fcgi/feed.js?faa=1&bounds=%s,%s,%s,%s";
	private static final String F24_FLIGHTINFO = "https://data-live.flightradar24.com/clickhandler/?version=1.5&flight=%s";
	private static Set<String> set = new HashSet<String>();
	
	static {
		SSLContext ctx;
		try {
			ctx = SSLContext.getInstance("TLSv1.2");
			ctx.init(null, null, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(ctx.getSocketFactory());
			System.out.println("ssl factory OK");
			set.add("version");
			set.add("full_count");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static FlightDetailedInfo getFlightDetail(String id) {
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		client.setConnectTimeout(20000);
		client.setReadTimeout(20000);
		WebResource webResource = client.resource(String.format(F24_FLIGHTINFO, id));
		ClientResponse response = webResource.header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36").header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9").get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			//throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			System.out.println(response.getStatus());
			return null;
		}
		FlightDetailedInfo flightDetailedInfo = response.getEntity(FlightDetailedInfo.class);
		return flightDetailedInfo;

	}
	
	public static Map<String,FlightShortInfo>  getFlights(double topRightLongitude , double bottomLeftLongitude, double bottomLeftLatitude, double topRightLatitude) {

		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		client.setConnectTimeout(20000);
		client.setReadTimeout(20000);
		//client.addFilter(new LoggingFilter(System.out));
		//System.out.println(String.format(F24_AREAENQUIRY, convertDouble(topRightLongitude), convertDouble(bottomLeftLongitude), convertDouble(bottomLeftLatitude),convertDouble(topRightLatitude)));
		WebResource webResource = client.resource(String.format(F24_AREAENQUIRY, convertDouble(topRightLongitude), convertDouble(bottomLeftLongitude), convertDouble(bottomLeftLatitude),convertDouble(topRightLatitude)));
		ClientResponse response = webResource.header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36").header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9").get(ClientResponse.class);

		if (response.getStatus() != 200) {
			//throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			System.out.println(response.getStatus());
			return new TreeMap<String,FlightShortInfo>();
		}
		
		Map<String,FlightShortInfo> airCrafts = new TreeMap<String,FlightShortInfo>();
		
		String json = response.getEntity(String.class);
		//System.out.println(json);
		JSONObject obj = new JSONObject(json);
		for(String key : obj.keySet()) {
			if ( obj.get(key) instanceof JSONArray ) {
				JSONArray array = (JSONArray)obj.get(key);
//				System.out.println(key);
//				for(Object elem: array) {
//					System.out.println(elem);
//				}
				
				FlightShortInfo flightShortInfo = new FlightShortInfo(
						key,
						(String)array.get(0),
						((BigDecimal)array.get(1)).doubleValue(),
						((BigDecimal)array.get(2)).doubleValue(),
						(int)array.get(3),
						(int)array.get(4),
						(int)array.get(5),
						(String)array.get(8),
						(String)array.get(9),
						(String)array.get(11),
						(String)array.get(12),
						(String)array.get(13),
						(String)array.get(16),
						(String)array.get(18),
						(int)array.get(15)
				);
				//System.out.println(flightShortInfo);
//				if (
//						bottomLeftLongitude <= flightShortInfo.getLongitude() &&
//						flightShortInfo.getLongitude() <= topRightLongitude &&
//						bottomLeftLatitude <= flightShortInfo.getLatitude() &&
//						flightShortInfo.getLatitude() <= topRightLatitude						
//					)
					airCrafts.put(flightShortInfo.getAirCraftIcaoCode(), flightShortInfo);
			}
		}
		return airCrafts;
	}	
	
	private static String convertDouble(double doubleNumber){
		return Double.toString(doubleNumber);
	}
}
