package com.flightmonitor.application.parms;

import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;

@Endpoint
@AnonymousAllowed
public class AppStoreUtil {

	public int getMongoPort() {		
		return AppStore.getMongoPort();
	}

}
