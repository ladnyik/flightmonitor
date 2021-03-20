
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
    "scheduled",
    "real",
    "estimated",
    "other",
    "historical"
})
public class Time_ {

    @JsonProperty("scheduled")
    private Scheduled scheduled;
    @JsonProperty("real")
    private Real_ real;
    @JsonProperty("estimated")
    private Estimated estimated;
    @JsonProperty("other")
    private Other other;
    @JsonProperty("historical")
    private Historical historical;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("scheduled")
    public Scheduled getScheduled() {
        return scheduled;
    }

    @JsonProperty("scheduled")
    public void setScheduled(Scheduled scheduled) {
        this.scheduled = scheduled;
    }

    @JsonProperty("real")
    public Real_ getReal() {
        return real;
    }

    @JsonProperty("real")
    public void setReal(Real_ real) {
        this.real = real;
    }

    @JsonProperty("estimated")
    public Estimated getEstimated() {
        return estimated;
    }

    @JsonProperty("estimated")
    public void setEstimated(Estimated estimated) {
        this.estimated = estimated;
    }

    @JsonProperty("other")
    public Other getOther() {
        return other;
    }

    @JsonProperty("other")
    public void setOther(Other other) {
        this.other = other;
    }

    @JsonProperty("historical")
    public Historical getHistorical() {
        return historical;
    }

    @JsonProperty("historical")
    public void setHistorical(Historical historical) {
        this.historical = historical;
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
