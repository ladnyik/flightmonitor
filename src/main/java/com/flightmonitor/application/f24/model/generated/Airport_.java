
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
    "origin",
    "destination"
})
public class Airport_ {

    @JsonProperty("origin")
    private Origin_ origin;
    @JsonProperty("destination")
    private Destination_ destination;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("origin")
    public Origin_ getOrigin() {
        return origin;
    }

    @JsonProperty("origin")
    public void setOrigin(Origin_ origin) {
        this.origin = origin;
    }

    @JsonProperty("destination")
    public Destination_ getDestination() {
        return destination;
    }

    @JsonProperty("destination")
    public void setDestination(Destination_ destination) {
        this.destination = destination;
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
