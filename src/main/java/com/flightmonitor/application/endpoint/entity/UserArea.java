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
@Indexes(@Index(value = "email", fields = @Field("email")))
public class UserArea {

	@Id
	private ObjectId id;
	private String email;
	
	@Nullable
	private List<ObservedArea> areas = new ArrayList<ObservedArea>();
	public UserArea() {
		super();
	}

	public UserArea(String email) {
		super();
		this.email = email;
	}

	public UserArea(String email, List<ObservedArea> areas) {
		super();
		this.email = email;
		this.areas = areas;
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
