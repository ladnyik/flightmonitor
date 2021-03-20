package com.flightmonitor.application.test;

import java.util.Map;

import com.flightmonitor.application.f24.api.F24ApiUtils;
import com.flightmonitor.application.f24.model.FlightShortInfo;
import com.flightmonitor.application.f24.model.generated.FlightDetailedInfo;


public class FlightRadar24TestAreaEnquiry {

	public static void main(String[] args) {
		System.out.println(Long.MAX_VALUE);
		Map<String,FlightShortInfo> airCrafts = F24ApiUtils.getFlights(48.319729,46.906817,18.2280541,20.285942);
		System.out.println(airCrafts.size());
		 for (Map.Entry<String,FlightShortInfo> entry : airCrafts.entrySet()) {  
	            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	            FlightDetailedInfo flightDetailedInfo = F24ApiUtils.getFlightDetail(entry.getKey());
	            System.out.println(flightDetailedInfo.getIdentification().getCallsign());
		 }
		
	}
}
