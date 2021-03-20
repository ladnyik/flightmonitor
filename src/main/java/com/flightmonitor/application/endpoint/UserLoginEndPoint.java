package com.flightmonitor.application.endpoint;

import java.sql.Timestamp;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.flightmonitor.application.endpoint.entity.Notification;
import com.flightmonitor.application.endpoint.entity.UserInfo;
import com.flightmonitor.application.parms.AppStore;
import com.mongodb.MongoClient;
import com.mongodb.client.result.UpdateResult;
import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;

@Endpoint
@AnonymousAllowed
public class UserLoginEndPoint{

	public boolean userLogin(UserInfo userInfo) {
		boolean enabled;
		Morphia morphia = new Morphia();
		morphia.mapPackage("com.flightmonitor.application.endpoint.entity");
		Datastore datastore = morphia.createDatastore(new MongoClient("localhost",AppStore.getMongoPort()), "flightmonitor");
		datastore.ensureIndexes();
		
		Query<UserInfo> userQuery = datastore.createQuery(UserInfo.class).field("email").equal(userInfo.getEmail());
		List<UserInfo> user	= userQuery.asList();
		System.out.println(user.size());
		if (user.size() > 0) {
			UserInfo user1 = user.get(0);
			user1.setDisplayName(userInfo.getDisplayName());
			user1.setPhotoURL(userInfo.getPhotoURL());
			user1.setEmailVerified(userInfo.isEmailVerified());
			user1.setAccessToken(userInfo.getAccessToken());
			user1.setLogIn((new Timestamp(System.currentTimeMillis())).toInstant());
			user1.setLogOut(null);
			datastore.save(user1);
			enabled = user1.isEnabled();
		}
		else {
			userInfo.setEnabled(true);
			userInfo.setLogIn((new Timestamp(System.currentTimeMillis())).toInstant());
			userInfo.setLogOut(null);
			datastore.save(userInfo);
			enabled = true;
			Notification notification = new Notification(userInfo.getEmail(), false, false, false);
			datastore.save(notification);		
		}
		return enabled;
	}	
	
	public void userLogout(String email) {

		Morphia morphia = new Morphia();
		morphia.mapPackage("com.flightmonitor.application.endpoint.entity");
		Datastore datastore = morphia.createDatastore(new MongoClient("localhost",AppStore.getMongoPort()), "flightmonitor");
		datastore.ensureIndexes();
		
		Query<UserInfo> userQuery = datastore.createQuery(UserInfo.class).field("email").equal(email);
		List<UserInfo> user	= userQuery.asList();
		if (user.size() > 0) {
			System.out.println("updating");
			UserInfo user1 = user.get(0);
			user1.setLogIn(null);
			user1.setLogOut((new Timestamp(System.currentTimeMillis())).toInstant());
			datastore.save(user1);
		}
		else {

		}		
	}
}
