
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
    "departure",
    "arrival"
})
public class Scheduled {

    @JsonProperty("departure")
    private Long departure;
    @JsonProperty("arrival")
    private Long arrival;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("departure")
    public Long getDeparture() {
        return departure;
    }

    @JsonProperty("departure")
    public void setDeparture(Long departure) {
        this.departure = departure;
    }

    @JsonProperty("arrival")
    public Long getArrival() {
        return arrival;
    }

    @JsonProperty("arrival")
    public void setArrival(Long arrival) {
        this.arrival = arrival;
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
