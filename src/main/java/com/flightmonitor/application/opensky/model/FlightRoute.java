package com.flightmonitor.application.opensky.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "callsign", "flightNumber", "operatorIata", "route", "updateTime" })
public class FlightRoute {

	@JsonProperty("callsign")
	private String callsign;
	@JsonProperty("flightNumber")
	private Long flightNumber;
	@JsonProperty("operatorIata")
	private String operatorIata;
	@JsonProperty("route")
	private List<String> route = null;
	@JsonProperty("updateTime")
	private Long updateTime;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("callsign")
	public String getCallsign() {
		return callsign;
	}

	@JsonProperty("callsign")
	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	@JsonProperty("flightNumber")
	public Long getFlightNumber() {
		return flightNumber;
	}

	@JsonProperty("flightNumber")
	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}

	@JsonProperty("operatorIata")
	public String getOperatorIata() {
		return operatorIata;
	}

	@JsonProperty("operatorIata")
	public void setOperatorIata(String operatorIata) {
		this.operatorIata = operatorIata;
	}

	@JsonProperty("route")
	public List<String> getRoute() {
		return route;
	}

	@JsonProperty("route")
	public void setRoute(List<String> route) {
		this.route = route;
	}

	@JsonProperty("updateTime")
	public Long getUpdateTime() {
		return updateTime;
	}

	@JsonProperty("updateTime")
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
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
		return new ToStringBuilder(this).append("callsign", callsign).append("flightNumber", flightNumber)
				.append("operatorIata", operatorIata).append("route", route).append("updateTime", updateTime)
				.append("additionalProperties", additionalProperties).toString();
	}

}