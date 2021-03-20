
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
    "status",
    "eventTime"
})
public class Generic {

    @JsonProperty("status")
    private Status_ status;
    @JsonProperty("eventTime")
    private EventTime eventTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("status")
    public Status_ getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status_ status) {
        this.status = status;
    }

    @JsonProperty("eventTime")
    public EventTime getEventTime() {
        return eventTime;
    }

    @JsonProperty("eventTime")
    public void setEventTime(EventTime eventTime) {
        this.eventTime = eventTime;
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
