package com.flightmonitor.application.test;

import java.io.IOException;

import com.flightmonitor.application.opensky.api.OpenSkyApi;
import com.flightmonitor.application.opensky.api.OpenSkyApiUtils;
import com.flightmonitor.application.opensky.model.AircraftInfo;
import com.flightmonitor.application.opensky.model.FlightRoute;

public class GetFlights {

	private static final String USERNAME = "ladnyik";
	private static final String PASSWORD = "vocsike8";

	public static void main(String[] args) throws IOException, InterruptedException {
		OpenSkyApi api = new OpenSkyApi(USERNAME, PASSWORD);
		OpenSkyStates os = api.getStates(0, null,new OpenSkyApi.BoundingBox(45.828368,48.698270, 16.234403, 23.012820));
		for(StateVector state : os.getStates()) {
			System.out.println("----------------\n"+state.getCallsign());
			Thread.sleep(500);
			AircraftInfo aircraftInfo = OpenSkyApiUtils.getAircraftInfo(state.getIcao24());
			if (aircraftInfo != null)
				System.out.println(String.format("getflight %s %s ", aircraftInfo.getRegistration(), aircraftInfo.getModel()));
			Thread.sleep(500);
			FlightRoute flightRoute = OpenSkyApiUtils.getAircraftRoute(state.getCallsign().trim());
			if (flightRoute != null)
				System.out.println(flightRoute.getRoute());
		}
	}
// 47.942405, 48.445841,  15.683518, 17.321106
// 48.445841, 17.321106
/* 
	45.828368,48.698270, 16.234403, 23.012820
	48.698270, 23.012820
*/
}
