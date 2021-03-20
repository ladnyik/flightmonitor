package com.flightmonitor.application.test;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.flightmonitor.application.endpoint.UserAreaEndPoint;
import com.flightmonitor.application.endpoint.entity.Area;
import com.flightmonitor.application.endpoint.entity.ObservedArea;
import com.flightmonitor.application.endpoint.entity.UserArea;
import com.mongodb.MongoClient;

public class MongoTestGetUpdate {

	public static void main(String[] args) {
			
		UserAreaEndPoint userAreaEndPoint = new UserAreaEndPoint();
		UserArea userArea = userAreaEndPoint.getUserArea("ladnyik@gmail.com");
		userArea.getAreas().get(0).setDescription("Budapest környéke");
		userAreaEndPoint.setUserArea(userArea);
		
	}
}
