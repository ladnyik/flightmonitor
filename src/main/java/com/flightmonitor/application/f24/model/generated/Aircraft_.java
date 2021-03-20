
package com.flightmonitor.application.f24.model.generated;

import java.util.HashMap;
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
    "airport",
    "time"
})
public class Aircraft_ {

    @JsonProperty("identification")
    private Identification_ identification;
    @JsonProperty("airport")
    private Airport_ airport;
    @JsonProperty("time")
    private Time time;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("identification")
    public Identification_ getIdentification() {
        return identification;
    }

    @JsonProperty("identification")
    public void setIdentification(Identification_ identification) {
        this.identification = identification;
    }

    @JsonProperty("airport")
    public Airport_ getAirport() {
        return airport;
    }

    @JsonProperty("airport")
    public void setAirport(Airport_ airport) {
        this.airport = airport;
    }

    @JsonProperty("time")
    public Time getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Time time) {
        this.time = time;
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
