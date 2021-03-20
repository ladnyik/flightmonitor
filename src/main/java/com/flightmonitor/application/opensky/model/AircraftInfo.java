package com.flightmonitor.application.opensky.model;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "acars", "adsb", "built", "categoryDescription", "country", "engines", "firstFlightDate",
		"firstSeen", "icao24", "icaoAircraftClass", "lastSeen", "lineNumber", "manufacturerIcao", "manufacturerName",
		"model", "modes", "notes", "operator", "operatorCallsign", "operatorIata", "operatorIcao", "owner", "regUntil",
		"registered", "registration", "selCal", "serialNumber", "status", "timestamp", "typecode", "vdl" })
public class AircraftInfo {

	@JsonProperty("acars")
	private Boolean acars;
	@JsonProperty("adsb")
	private Boolean adsb;
	@JsonProperty("built")
	private Object built;
	@JsonProperty("categoryDescription")
	private String categoryDescription;
	@JsonProperty("country")
	private String country;
	@JsonProperty("engines")
	private String engines;
	@JsonProperty("firstFlightDate")
	private Object firstFlightDate;
	@JsonProperty("firstSeen")
	private Object firstSeen;
	@JsonProperty("icao24")
	private String icao24;
	@JsonProperty("icaoAircraftClass")
	private String icaoAircraftClass;
	@JsonProperty("lastSeen")
	private Object lastSeen;
	@JsonProperty("lineNumber")
	private String lineNumber;
	@JsonProperty("manufacturerIcao")
	private String manufacturerIcao;
	@JsonProperty("manufacturerName")
	private String manufacturerName;
	@JsonProperty("model")
	private String model;
	@JsonProperty("modes")
	private Boolean modes;
	@JsonProperty("notes")
	private String notes;
	@JsonProperty("operator")
	private String operator;
	@JsonProperty("operatorCallsign")
	private String operatorCallsign;
	@JsonProperty("operatorIata")
	private String operatorIata;
	@JsonProperty("operatorIcao")
	private String operatorIcao;
	@JsonProperty("owner")
	private String owner;
	@JsonProperty("regUntil")
	private Object regUntil;
	@JsonProperty("registered")
	private Object registered;
	@JsonProperty("registration")
	private String registration;
	@JsonProperty("selCal")
	private String selCal;
	@JsonProperty("serialNumber")
	private String serialNumber;
	@JsonProperty("status")
	private String status;
	@JsonProperty("timestamp")
	private Long timestamp;
	@JsonProperty("typecode")
	private String typecode;
	@JsonProperty("vdl")
	private Boolean vdl;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("acars")
	public Boolean getAcars() {
		return acars;
	}

	@JsonProperty("acars")
	public void setAcars(Boolean acars) {
		this.acars = acars;
	}

	@JsonProperty("adsb")
	public Boolean getAdsb() {
		return adsb;
	}

	@JsonProperty("adsb")
	public void setAdsb(Boolean adsb) {
		this.adsb = adsb;
	}

	@JsonProperty("built")
	public Object getBuilt() {
		return built;
	}

	@JsonProperty("built")
	public void setBuilt(Object built) {
		this.built = built;
	}

	@JsonProperty("categoryDescription")
	public String getCategoryDescription() {
		return categoryDescription;
	}

	@JsonProperty("categoryDescription")
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("engines")
	public String getEngines() {
		return engines;
	}

	@JsonProperty("engines")
	public void setEngines(String engines) {
		this.engines = engines;
	}

	@JsonProperty("firstFlightDate")
	public Object getFirstFlightDate() {
		return firstFlightDate;
	}

	@JsonProperty("firstFlightDate")
	public void setFirstFlightDate(Object firstFlightDate) {
		this.firstFlightDate = firstFlightDate;
	}

	@JsonProperty("firstSeen")
	public Object getFirstSeen() {
		return firstSeen;
	}

	@JsonProperty("firstSeen")
	public void setFirstSeen(Object firstSeen) {
		this.firstSeen = firstSeen;
	}

	@JsonProperty("icao24")
	public String getIcao24() {
		return icao24;
	}

	@JsonProperty("icao24")
	public void setIcao24(String icao24) {
		this.icao24 = icao24;
	}

	@JsonProperty("icaoAircraftClass")
	public String getIcaoAircraftClass() {
		return icaoAircraftClass;
	}

	@JsonProperty("icaoAircraftClass")
	public void setIcaoAircraftClass(String icaoAircraftClass) {
		this.icaoAircraftClass = icaoAircraftClass;
	}

	@JsonProperty("lastSeen")
	public Object getLastSeen() {
		return lastSeen;
	}

	@JsonProperty("lastSeen")
	public void setLastSeen(Object lastSeen) {
		this.lastSeen = lastSeen;
	}

	@JsonProperty("lineNumber")
	public String getLineNumber() {
		return lineNumber;
	}

	@JsonProperty("lineNumber")
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	@JsonProperty("manufacturerIcao")
	public String getManufacturerIcao() {
		return manufacturerIcao;
	}

	@JsonProperty("manufacturerIcao")
	public void setManufacturerIcao(String manufacturerIcao) {
		this.manufacturerIcao = manufacturerIcao;
	}

	@JsonProperty("manufacturerName")
	public String getManufacturerName() {
		return manufacturerName;
	}

	@JsonProperty("manufacturerName")
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	@JsonProperty("model")
	public String getModel() {
		return model;
	}

	@JsonProperty("model")
	public void setModel(String model) {
		this.model = model;
	}

	@JsonProperty("modes")
	public Boolean getModes() {
		return modes;
	}

	@JsonProperty("modes")
	public void setModes(Boolean modes) {
		this.modes = modes;
	}

	@JsonProperty("notes")
	public String getNotes() {
		return notes;
	}

	@JsonProperty("notes")
	public void setNotes(String notes) {
		this.notes = notes;
	}

	@JsonProperty("operator")
	public String getOperator() {
		return operator;
	}

	@JsonProperty("operator")
	public void setOperator(String operator) {
		this.operator = operator;
	}

	@JsonProperty("operatorCallsign")
	public String getOperatorCallsign() {
		return operatorCallsign;
	}

	@JsonProperty("operatorCallsign")
	public void setOperatorCallsign(String operatorCallsign) {
		this.operatorCallsign = operatorCallsign;
	}

	@JsonProperty("operatorIata")
	public String getOperatorIata() {
		return operatorIata;
	}

	@JsonProperty("operatorIata")
	public void setOperatorIata(String operatorIata) {
		this.operatorIata = operatorIata;
	}

	@JsonProperty("operatorIcao")
	public String getOperatorIcao() {
		return operatorIcao;
	}

	@JsonProperty("operatorIcao")
	public void setOperatorIcao(String operatorIcao) {
		this.operatorIcao = operatorIcao;
	}

	@JsonProperty("owner")
	public String getOwner() {
		return owner;
	}

	@JsonProperty("owner")
	public void setOwner(String owner) {
		this.owner = owner;
	}

	@JsonProperty("regUntil")
	public Object getRegUntil() {
		return regUntil;
	}

	@JsonProperty("regUntil")
	public void setRegUntil(Object regUntil) {
		this.regUntil = regUntil;
	}

	@JsonProperty("registered")
	public Object getRegistered() {
		return registered;
	}

	@JsonProperty("registered")
	public void setRegistered(Object registered) {
		this.registered = registered;
	}

	@JsonProperty("registration")
	public String getRegistration() {
		return registration;
	}

	@JsonProperty("registration")
	public void setRegistration(String registration) {
		this.registration = registration;
	}

	@JsonProperty("selCal")
	public String getSelCal() {
		return selCal;
	}

	@JsonProperty("selCal")
	public void setSelCal(String selCal) {
		this.selCal = selCal;
	}

	@JsonProperty("serialNumber")
	public String getSerialNumber() {
		return serialNumber;
	}

	@JsonProperty("serialNumber")
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("timestamp")
	public Long getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	@JsonProperty("typecode")
	public String getTypecode() {
		return typecode;
	}

	@JsonProperty("typecode")
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	@JsonProperty("vdl")
	public Boolean getVdl() {
		return vdl;
	}

	@JsonProperty("vdl")
	public void setVdl(Boolean vdl) {
		this.vdl = vdl;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("acars", acars).append("adsb", adsb).append("built", built)
				.append("categoryDescription", categoryDescription).append("country", country)
				.append("engines", engines).append("firstFlightDate", firstFlightDate).append("firstSeen", firstSeen)
				.append("icao24", icao24).append("icaoAircraftClass", icaoAircraftClass).append("lastSeen", lastSeen)
				.append("lineNumber", lineNumber).append("manufacturerIcao", manufacturerIcao)
				.append("manufacturerName", manufacturerName).append("model", model).append("modes", modes)
				.append("notes", notes).append("operator", operator).append("operatorCallsign", operatorCallsign)
				.append("operatorIata", operatorIata).append("operatorIcao", operatorIcao).append("owner", owner)
				.append("regUntil", regUntil).append("registered", registered).append("registration", registration)
				.append("selCal", selCal).append("serialNumber", serialNumber).append("status", status)
				.append("timestamp", timestamp).append("typecode", typecode).append("vdl", vdl)
				.append("additionalProperties", additionalProperties).toString();
	}

}