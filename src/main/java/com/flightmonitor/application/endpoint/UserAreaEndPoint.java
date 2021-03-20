package com.flightmonitor.application.endpoint;

import java.util.List;

import javax.annotation.Nullable;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.flightmonitor.application.endpoint.entity.Notification;
import com.flightmonitor.application.endpoint.entity.UserArea;
import com.flightmonitor.application.parms.AppStore;
import com.mongodb.MongoClient;
import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;

@Endpoint
@AnonymousAllowed
public class UserAreaEndPoint {
	
	public UserArea getUserArea(String email) {
		System.out.println("getuserarea:" + email);
		Morphia morphia = new Morphia();
		morphia.mapPackage("com.flightmonitor.application.endpoint.entity");
		Datastore datastore = morphia.createDatastore(new MongoClient("localhost",AppStore.getMongoPort()), "flightmonitor");
		datastore.ensureIndexes();
		Query<UserArea> userAreaQuery = datastore.createQuery(UserArea.class).field("email").equal(email);
		List<UserArea> userAreas = userAreaQuery.asList();
		System.out.println("size " + userAreas.size());
		if (userAreas.size() > 0) {
			return userAreas.get(0);
		}
		else {				
			UserArea userArea  = new UserArea(email);
			return userArea;
		}		
	}
	
	public void setUserArea(UserArea userAreas) {
		Morphia morphia = new Morphia();
		morphia.mapPackage("com.flightmonitor.application.endpoint.entity");
		Datastore datastore = morphia.createDatastore(new MongoClient("localhost",AppStore.getMongoPort()), "flightmonitor");
		datastore.ensureIndexes();
		datastore.save(userAreas);
	}
}
