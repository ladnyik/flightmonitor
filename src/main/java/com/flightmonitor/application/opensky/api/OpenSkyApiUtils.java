package com.flightmonitor.application.opensky.api;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import com.flightmonitor.application.opensky.model.AircraftInfo;
import com.flightmonitor.application.opensky.model.FlightRoute;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class OpenSkyApiUtils {
	
	private static final String HOST = "opensky-network.org";
	private static final String API_ROOT = "https://" + HOST + "/api";
	private static final String API_AIRCRAFINFO = API_ROOT + "/metadata/aircraft/icao/";
	private static final String API_AIRCRAFROUTE = API_ROOT + "/routes?callsign=";

	static {
		SSLContext ctx;
		try {
			ctx = SSLContext.getInstance("TLSv1.2");
			ctx.init(null, null, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(ctx.getSocketFactory());
			System.out.println("ssl factory OK");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static FlightRoute getAircraftRoute(String callSign) {

		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		client.setConnectTimeout(20000);
		client.setReadTimeout(20000);
		//client.addFilter(new LoggingFilter(System.out));
		WebResource webResource = client.resource(API_AIRCRAFROUTE + callSign.trim());
		ClientResponse response = webResource.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			//throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			return null;
		}
		else
			System.out.println(response.getStatus() );

		FlightRoute flightRoute = response.getEntity(FlightRoute.class);

//		System.out.println("Output from Server .... \n");
//		System.out.println(aircraftInfo);
		return flightRoute;
	}

	public static AircraftInfo getAircraftInfo(String icao) {

		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		client.setConnectTimeout(20000);
		client.setReadTimeout(20000);
		//client.addFilter(new LoggingFilter(System.out));
		WebResource webResource = client.resource(API_AIRCRAFINFO + icao);
		ClientResponse response = webResource.get(ClientResponse.class);
		try {
			response = webResource.get(ClientResponse.class);
		}
		catch(Exception e){
			return null;
		}

		if (response.getStatus() != 200) {
			//throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			return null;
		}
		else
			System.out.println(response.getStatus() );

		AircraftInfo aircraftInfo = response.getEntity(AircraftInfo.class);

//		System.out.println("Output from Server .... \n");
//		System.out.println(aircraftInfo);
		return aircraftInfo;
	}
	
}
