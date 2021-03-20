package com.flightmonitor.application.endpoint.entity;


public class Area {
	
	private double bottomLatitude;
	private double bottomLongitude;
	private double topLatitude;
	private double topLongitude;
	
	
	public Area() {
		super();
	}

	public Area(double bottomLatitude, double bottomLongitude, double topLatitude, double topLongitude) {
		super();
		this.bottomLatitude = bottomLatitude;
		this.bottomLongitude = bottomLongitude;
		this.topLatitude = topLatitude;
		this.topLongitude = topLongitude;
	}

	public double getBottomLatitude() {
		return bottomLatitude;
	}

	public void setBottomLatitude(double bottomLatitude) {
		this.bottomLatitude = bottomLatitude;
	}

	public double getBottomLongitude() {
		return bottomLongitude;
	}

	public void setBottomLongitude(double bottomLongitude) {
		this.bottomLongitude = bottomLongitude;
	}

	public double getTopLatitude() {
		return topLatitude;
	}

	public void setTopLatitude(double topLatitude) {
		this.topLatitude = topLatitude;
	}

	public double getTopLongitude() {
		return topLongitude;
	}

	public void setTopLongitude(double topLongitude) {
		this.topLongitude = topLongitude;
	}

}
