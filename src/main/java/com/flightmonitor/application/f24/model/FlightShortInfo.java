package com.flightmonitor.application.f24.model;

public class FlightShortInfo {
	
	private String F24Id;
	private String airCraftIcaoCode;
	private double longitude;
	private double latitude;
	private int track;
	private int calibratedAltitude;
	private int groundSpeedInKnots;
	private String aircraftType;
	private String registration;
	private String originatingAirport;
	private String destitanionAirport;
	private String flightNumber;
	private String callSign;
	private String airlineIcaoCode;
	private int vertical;
	
	private String country;
	
	public FlightShortInfo(String F24Id, String airCraftIcaoCode, double longitude, double latitude, int track, int calibratedAltitude,
			int groundSpeedInKnots, String aircraftType, String registration, String originatingAirport,
			String destitanionAirport, String flightNumber, String callSign, String airlineIcaoCode, int vertical) {
		super();
		this.F24Id = F24Id;
		this.airCraftIcaoCode = airCraftIcaoCode;
		this.longitude = longitude;
		this.latitude = latitude;
		this.track = track;
		this.calibratedAltitude = calibratedAltitude;
		this.groundSpeedInKnots = groundSpeedInKnots;
		this.aircraftType = aircraftType;
		this.registration = registration;
		this.originatingAirport = originatingAirport;
		this.destitanionAirport = destitanionAirport;
		this.flightNumber = flightNumber;
		this.callSign = callSign;
		this.airlineIcaoCode = airlineIcaoCode;
		this.vertical = vertical;
	}

	public String getF24Id() {
		return F24Id;
	}

	public void setF24Id(String f24Id) {
		F24Id = f24Id;
	}

	public String getAirCraftIcaoCode() {
		return airCraftIcaoCode;
	}

	public void setAirCraftIcaoCode(String airCraftIcaoCode) {
		this.airCraftIcaoCode = airCraftIcaoCode;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public int getCalibratedAltitude() {
		return calibratedAltitude;
	}

	public void setCalibratedAltitude(int calibratedAltitude) {
		this.calibratedAltitude = calibratedAltitude;
	}

	public int getGroundSpeedInKnots() {
		return groundSpeedInKnots;
	}

	public void setGroundSpeedInKnots(int groundSpeedInKnots) {
		this.groundSpeedInKnots = groundSpeedInKnots;
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getOriginatingAirport() {
		return originatingAirport;
	}

	public void setOriginatingAirport(String originatingAirport) {
		this.originatingAirport = originatingAirport;
	}

	public String getDestitanionAirport() {
		return destitanionAirport;
	}

	public void setDestitanionAirport(String destitanionAirport) {
		this.destitanionAirport = destitanionAirport;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getCallSign() {
		return callSign;
	}

	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}

	public String getAirlineIcaoCode() {
		return airlineIcaoCode;
	}

	public void setAirlineIcaoCode(String airlineIcaoCode) {
		this.airlineIcaoCode = airlineIcaoCode;
	}

	public int getVertical() {
		return vertical;
	}

	public void setVertical(int vertical) {
		this.vertical = vertical;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return String.format("%-7s %s %f %f", this.callSign, this.getRegistration(), this.getLongitude(), this.getLatitude() );
	}
	
}
