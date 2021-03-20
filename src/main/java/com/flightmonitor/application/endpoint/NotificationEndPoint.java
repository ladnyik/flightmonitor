package com.flightmonitor.application.endpoint;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.flightmonitor.application.endpoint.entity.Notification;
import com.flightmonitor.application.endpoint.entity.UserInfo;
import com.flightmonitor.application.parms.AppStore;
import com.mongodb.MongoClient;
import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;

@Endpoint
@AnonymousAllowed
public class NotificationEndPoint {
	
	public Notification getNotifications(String email) {
		Morphia morphia = new Morphia();
		morphia.mapPackage("com.flightmonitor.application.endpoint.entity");
		Datastore datastore = morphia.createDatastore(new MongoClient("localhost",AppStore.getMongoPort()), "flightmonitor");
		datastore.ensureIndexes();
		Query<Notification> notificationQuery = datastore.createQuery(Notification.class).field("email").equal(email);
		List<Notification> notification	= notificationQuery.asList();
		System.out.println(notification.size());
		if (notification.size() > 0) {
			return notification.get(0);
		}
		else {
			return null;
		}		
	}
	
	public void setNotifications(Notification notification) {
		
		System.out.println(notification.getEmail());
		Morphia morphia = new Morphia();
		morphia.mapPackage("com.flightmonitor.application.endpoint.entity");
		Datastore datastore = morphia.createDatastore(new MongoClient("localhost",AppStore.getMongoPort()), "flightmonitor");
		datastore.ensureIndexes();
		
		Query<Notification> notificationQuery = datastore.createQuery(Notification.class).field("email").equal(notification.getEmail());
		List<Notification> notifications = notificationQuery.asList();
		System.out.println(notifications.size());
		if (notifications.size() > 0) {
			System.out.println("updating");
			Notification notification1 = notifications.get(0);
			notification1.setSendF24Messages(notification.isSendF24Messages());
			notification1.setSendOpenSkyMessages(notification.isSendOpenSkyMessages());
			notification1.setSendOsF24Messages(notification.isSendOsF24Messages());
			datastore.save(notification1);
		}
		else {
			datastore.save(notification);
		}		
	}
}
