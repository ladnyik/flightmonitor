package com.flightmonitor.application.endpoint.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

@Entity(noClassnameStored = true)
@Indexes(@Index(value = "deviceId", fields = @Field("deviceId")))
public class UserArea {

	@Id
	private ObjectId id;
	private String deviceId;
	@Nullable
	private String email;

	
	@Nullable
	private List<ObservedArea> areas = new ArrayList<ObservedArea>();
	public UserArea() {
		super();
	}

	public UserArea(String deviceId) {
		super();
		this.deviceId = deviceId;
	}

	public UserArea(String deviceId, String email) {
		super();
		this.deviceId = deviceId;
		this.email = email;
	}

	public UserArea(String deviceId, String email, List<ObservedArea> areas) {
		super();
		this.deviceId = deviceId;
		this.email = email;
		this.areas = areas;
	}
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ObservedArea> getAreas() {
		return areas;
	}

	public void setAreas(List<ObservedArea> areas) {
		this.areas = areas;
	}

}
