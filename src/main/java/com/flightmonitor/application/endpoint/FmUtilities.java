package com.flightmonitor.application.endpoint;

import com.flightmonitor.application.parms.AppStore;
import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;

@Endpoint
@AnonymousAllowed
public class FmUtilities {
	
	public int getMongoPort() {
		return AppStore.getMongoPort();		
	}
	
}
