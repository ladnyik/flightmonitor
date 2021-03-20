package com.flightmonitor.application.test;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.flightmonitor.application.endpoint.entity.Area;
import com.flightmonitor.application.endpoint.entity.ObservedArea;
import com.flightmonitor.application.endpoint.entity.UserArea;
import com.mongodb.MongoClient;

public class MongoTest {

	public static void main(String[] args) {

		Morphia morphia = new Morphia();
		morphia.mapPackage("com.flightmonitor.application.endpoint.entity");
		Datastore datastore = morphia.createDatastore(new MongoClient(), "flightmonitor");
		datastore.ensureIndexes();
		
		UserArea userArea = new UserArea();
		userArea.setEmail("ladnyik@gmail.com");
		ObservedArea observedArea = new ObservedArea();
		observedArea.setDescription("Budapest környéke");
		
		//observedArea.setMinAltitutude(0);
		//observedArea.setMaxAltitutude(Integer.MAX_VALUE);
		observedArea.setMinSpeed(0);
		observedArea.setMaxSpeed(3000);
		observedArea.setMinTrack(0);
		observedArea.setMinTrack(0);
		observedArea.setMaxTrack(360);
		Area area = new Area(46.906817, 18.2280541, 48.319729, 20.285942);
		observedArea.setArea(area);
		List<ObservedArea> areas = new ArrayList<ObservedArea>();
		areas.add(observedArea);
		userArea.setAreas(areas);
		datastore.save(userArea);
	}
}
