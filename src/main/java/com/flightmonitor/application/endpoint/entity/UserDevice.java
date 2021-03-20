package com.flightmonitor.application.endpoint.entity;

import java.time.Instant;

import javax.annotation.Nullable;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

@Entity(noClassnameStored = true, value="UserDevice")
@Indexes(
	    @Index(value = "deviceId", fields = @Field("deviceId"))
	)
public class UserDevice {
	
	@Id
	@Nullable
	private ObjectId id;	
	private String deviceId;
	@Nullable
	private String messageToken;
	private String email;
	private String appCodeName;
	private String appName;
	private String appVersion;
	private String platform;
	@Nullable
	private Instant logIn;
	@Nullable
	private Instant logOut;
	
	public UserDevice() {
		super();
	}
	public UserDevice(String deviceId, String messageToken, String email, String appCodeName, String appName, String appVersion,
			String platform) {
		super();
		this.deviceId = deviceId;
		this.messageToken = messageToken;
		this.email = email;
		this.appCodeName = appCodeName;
		this.appName = appName;
		this.appVersion = appVersion;
		this.platform = platform;
	}
	
	public String getMessageToken() {
		return messageToken;
	}
	public void setMessageToken(String messageToken) {
		this.messageToken = messageToken;
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
	public String getAppCodeName() {
		return appCodeName;
	}
	public void setAppCodeName(String appCodeName) {
		this.appCodeName = appCodeName;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public Instant getLogIn() {
		return logIn;
	}
	public void setLogIn(Instant logIn) {
		this.logIn = logIn;
	}
	public Instant getLogOut() {
		return logOut;
	}
	public void setLogOut(Instant logOut) {
		this.logOut = logOut;
	}	
}
