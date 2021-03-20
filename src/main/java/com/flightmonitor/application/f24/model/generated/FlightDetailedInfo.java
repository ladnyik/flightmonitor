
package com.flightmonitor.application.f24.model.generated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "identification",
    "status",
    "level",
    "promote",
    "aircraft",
    "airline",
    "owner",
    "airspace",
    "airport",
    "flightHistory",
    "ems",
    "availability",
    "time",
    "trail",
    "firstTimestamp",
    "s"
})
public class FlightDetailedInfo {

    @JsonProperty("identification")
    private Identification identification;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("level")
    private String level;
    @JsonProperty("promote")
    private Boolean promote;
    @JsonProperty("aircraft")
    private Aircraft aircraft;
    @JsonProperty("airline")
    private Airline airline;
    @JsonProperty("owner")
    private Object owner;
    @JsonProperty("airspace")
    private Object airspace;
    @JsonProperty("airport")
    private Airport airport;
    @JsonProperty("flightHistory")
    private FlightHistory flightHistory;
    @JsonProperty("ems")
    private Object ems;
    @JsonProperty("availability")
    private List<String> availability = null;
    @JsonProperty("time")
    private Time_ time;
    @JsonProperty("trail")
    private List<Trail> trail = null;
    @JsonProperty("firstTimestamp")
    private Long firstTimestamp;
    @JsonProperty("s")
    private String s;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("identification")
    public Identification getIdentification() {
        return identification;
    }

    @JsonProperty("identification")
    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    @JsonProperty("promote")
    public Boolean getPromote() {
        return promote;
    }

    @JsonProperty("promote")
    public void setPromote(Boolean promote) {
        this.promote = promote;
    }

    @JsonProperty("aircraft")
    public Aircraft getAircraft() {
        return aircraft;
    }

    @JsonProperty("aircraft")
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    @JsonProperty("airline")
    public Airline getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    @JsonProperty("owner")
    public Object getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(Object owner) {
        this.owner = owner;
    }

    @JsonProperty("airspace")
    public Object getAirspace() {
        return airspace;
    }

    @JsonProperty("airspace")
    public void setAirspace(Object airspace) {
        this.airspace = airspace;
    }

    @JsonProperty("airport")
    public Airport getAirport() {
        return airport;
    }

    @JsonProperty("airport")
    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    @JsonProperty("flightHistory")
    public FlightHistory getFlightHistory() {
        return flightHistory;
    }

    @JsonProperty("flightHistory")
    public void setFlightHistory(FlightHistory flightHistory) {
        this.flightHistory = flightHistory;
    }

    @JsonProperty("ems")
    public Object getEms() {
        return ems;
    }

    @JsonProperty("ems")
    public void setEms(Object ems) {
        this.ems = ems;
    }

    @JsonProperty("availability")
    public List<String> getAvailability() {
        return availability;
    }

    @JsonProperty("availability")
    public void setAvailability(List<String> availability) {
        this.availability = availability;
    }

    @JsonProperty("time")
    public Time_ getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Time_ time) {
        this.time = time;
    }

    @JsonProperty("trail")
    public List<Trail> getTrail() {
        return trail;
    }

    @JsonProperty("trail")
    public void setTrail(List<Trail> trail) {
        this.trail = trail;
    }

    @JsonProperty("firstTimestamp")
    public Long getFirstTimestamp() {
        return firstTimestamp;
    }

    @JsonProperty("firstTimestamp")
    public void setFirstTimestamp(Long firstTimestamp) {
        this.firstTimestamp = firstTimestamp;
    }

    @JsonProperty("s")
    public String getS() {
        return s;
    }

    @JsonProperty("s")
    public void setS(String s) {
        this.s = s;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
