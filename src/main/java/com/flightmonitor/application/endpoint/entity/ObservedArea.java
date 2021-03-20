package com.flightmonitor.application.endpoint.entity;

public class ObservedArea {	
	
	private Area area;
	private boolean sendEmailNotification;
	private String description;
	private Integer minAltitude;
	private Integer maxAltitude;
	private Integer minSpeed;
	private Integer maxSpeed;
	private Integer minTrack;
	private Integer maxTrack;
	private Integer minVertical;
	private Integer maxVertical;
	
	public ObservedArea() {
		super();
	}

	public ObservedArea(boolean sendEmailNotification, Area area, String description, Integer minAltitude, Integer maxAltitude, Integer minSpeed,
			Integer maxSpeed, Integer minTrack, Integer maxTrack, Integer minVertical, Integer maxVertical) {
		super();
		this.sendEmailNotification = sendEmailNotification;
		this.area = area;
		this.description = description;
		this.minAltitude = minAltitude;
		this.maxAltitude = maxAltitude;
		this.minSpeed = minSpeed;
		this.maxSpeed = maxSpeed;
		this.minTrack = minTrack;
		this.maxTrack = maxTrack;
		this.minVertical = minVertical;
		this.maxVertical = maxVertical;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public boolean isSendEmailNotification() {
		return sendEmailNotification;
	}

	public void setSendEmailNotification(boolean sendEmailNotification) {
		this.sendEmailNotification = sendEmailNotification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMinSpeed() {
		return minSpeed;
	}

	public void setMinSpeed(Integer minSpeed) {
		this.minSpeed = minSpeed;
	}

	public Integer getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(Integer maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Integer getMinTrack() {
		return minTrack;
	}

	public void setMinTrack(Integer minTrack) {
		this.minTrack = minTrack;
	}

	public Integer getMaxTrack() {
		return maxTrack;
	}

	public void setMaxTrack(Integer maxTrack) {
		this.maxTrack = maxTrack;
	}

	public Integer getMinVertical() {
		return minVertical;
	}

	public void setMinVertical(Integer minVertical) {
		this.minVertical = minVertical;
	}

	public Integer getMaxVertical() {
		return maxVertical;
	}

	public void setMaxVertical(Integer maxVertical) {
		this.maxVertical = maxVertical;
	}

	public Integer getMinAltitude() {
		return minAltitude;
	}

	public void setMinAltitude(Integer minAltitude) {
		this.minAltitude = minAltitude;
	}

	public Integer getMaxAltitude() {
		return maxAltitude;
	}

	public void setMaxAltitude(Integer maxAltitude) {
		this.maxAltitude = maxAltitude;
	}	
}
