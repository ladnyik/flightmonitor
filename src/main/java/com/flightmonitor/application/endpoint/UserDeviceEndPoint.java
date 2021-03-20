package com.flightmonitor.application.endpoint;

import java.sql.Timestamp;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.flightmonitor.application.endpoint.entity.Notification;
import com.flightmonitor.application.endpoint.entity.UserDevice;
import com.flightmonitor.application.endpoint.entity.UserInfo;
import com.flightmonitor.application.parms.AppStore;
import com.mongodb.MongoClient;
import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;

@Endpoint
@AnonymousAllowed
public class UserDeviceEndPoint {
	
	public void userDeviceLogin(UserDevice userDevice) {
		
		Morphia morphia = new Morphia();
		morphia.mapPackage("com.flightmonitor.application.endpoint.entity");
		Datastore datastore = morphia.createDatastore(new MongoClient("localhost",AppStore.getMongoPort()), "flightmonitor");
		datastore.ensureIndexes();
		
		Query<UserDevice> userDeviceQuery = datastore.createQuery(UserDevice.class).field("deviceId").equal(userDevice.getDeviceId());
		List<UserDevice> userDevices= userDeviceQuery.asList();

		if (userDevices.size() > 0) {
			UserDevice userDevice1 = userDevices.get(0);
			userDevice.setAppCodeName(userDevice.getAppCodeName());
			userDevice.setAppName(userDevice.getAppName());
			userDevice.setAppVersion(userDevice.getAppVersion());
			userDevice1.setPlatform(userDevice.getPlatform());
			userDevice1.setLogIn((new Timestamp(System.currentTimeMillis())).toInstant());
			userDevice1.setLogOut(null);
			
			datastore.save(userDevice1);
		}
		else {
			datastore.save(userDevice);			
		}
		
	}	
	public void userDeviceLogout(String deviceId) {
		Morphia morphia = new Morphia();
		morphia.mapPackage("com.flightmonitor.application.endpoint.entity");
		Datastore datastore = morphia.createDatastore(new MongoClient("localhost",AppStore.getMongoPort()), "flightmonitor");
		datastore.ensureIndexes();
		
		Query<UserDevice> userDeviceQuery = datastore.createQuery(UserDevice.class).field("deviceId").equal(deviceId);
		List<UserDevice> userDevices= userDeviceQuery.asList();

		if (userDevices.size() > 0) {
			UserDevice userDevice1 = userDevices.get(0);
			userDevice1.setLogOut((new Timestamp(System.currentTimeMillis())).toInstant());
			userDevice1.setLogIn(null);			
			datastore.save(userDevice1);
		}
		else {			
		}
	}
	
	public void updateMessagingToken(String deviceId, String messagingToken) {
		Morphia morphia = new Morphia();
		morphia.mapPackage("com.flightmonitor.application.endpoint.entity");
		Datastore datastore = morphia.createDatastore(new MongoClient("localhost",AppStore.getMongoPort()), "flightmonitor");
		datastore.ensureIndexes();
		
		Query<UserDevice> userDeviceQuery = datastore.createQuery(UserDevice.class).field("deviceId").equal(deviceId);
		List<UserDevice> userDevices= userDeviceQuery.asList();

		if (userDevices.size() > 0) {
			UserDevice userDevice1 = userDevices.get(0);
			userDevice1.setMessageToken(messagingToken);			
			datastore.save(userDevice1);
		}
		else {			
		}
	}
}
