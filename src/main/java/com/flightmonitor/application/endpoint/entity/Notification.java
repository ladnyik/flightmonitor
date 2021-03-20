package com.flightmonitor.application.endpoint.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

@Entity(noClassnameStored = true)
@Indexes(
	    @Index(value = "email", fields = @Field("email"))
	)

public class Notification {
	
	@Id
	private ObjectId id;	
	private String email;
	private boolean sendOpenSkyMessages;
	private boolean sendF24Messages;
	private boolean sendOsF24Messages;
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notification(String email, boolean sendOpenSkyMessages, boolean sendF24Messages, boolean sendOsF24Messages) {
		super();
		this.email = email;
		this.sendOpenSkyMessages = sendOpenSkyMessages;
		this.sendF24Messages = sendF24Messages;
		this.sendOsF24Messages = sendOsF24Messages;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSendOpenSkyMessages() {
		return sendOpenSkyMessages;
	}

	public void setSendOpenSkyMessages(boolean sendOpenSkyMessages) {
		this.sendOpenSkyMessages = sendOpenSkyMessages;
	}

	public boolean isSendF24Messages() {
		return sendF24Messages;
	}

	public void setSendF24Messages(boolean sendF24Messages) {
		this.sendF24Messages = sendF24Messages;
	}

	public boolean isSendOsF24Messages() {
		return sendOsF24Messages;
	}

	public void setSendOsF24Messages(boolean sendOsF24Messages) {
		this.sendOsF24Messages = sendOsF24Messages;
	}	
}
