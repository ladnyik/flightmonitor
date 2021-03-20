package com.flightmonitor.application.endpoint.entity;

import java.time.Instant;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

@Entity(noClassnameStored = true, value="User")
@Indexes(
	    @Index(value = "email", fields = @Field("email"))
	)
public class UserInfo {

	@Id
	private ObjectId id;	
	private String email;
	private String displayName;
	private boolean emailVerified;
	private String photoURL;
	private String accessToken;
	private boolean enabled;;
	private Instant logIn;
	private Instant logOut;

	public UserInfo() {
		super();
	}

	public UserInfo(String email, String displayName, boolean emailVerified, String photoURL, String accessToken, boolean enabled) {
		super();
		this.email = email;
		this.displayName = displayName;
		this.emailVerified = emailVerified;
		this.photoURL = photoURL;
		this.accessToken = accessToken;
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s %s %s %b %s", this.email, this.photoURL, this.getDisplayName(), this.isEmailVerified(),
				this.getAccessToken());
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
