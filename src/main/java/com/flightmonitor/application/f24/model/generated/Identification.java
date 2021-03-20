
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
    "id",
    "row",
    "number",
    "callsign"
})
public class Identification {

    @JsonProperty("id")
    private String id;
    @JsonProperty("row")
    private Long row;
    @JsonProperty("number")
    private Number number;
    @JsonProperty("callsign")
    private String callsign;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("row")
    public Long getRow() {
        return row;
    }

    @JsonProperty("row")
    public void setRow(Long row) {
        this.row = row;
    }

    @JsonProperty("number")
    public Number getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(Number number) {
        this.number = number;
    }

    @JsonProperty("callsign")
    public String getCallsign() {
        return callsign;
    }

    @JsonProperty("callsign")
    public void setCallsign(String callsign) {
        this.callsign = callsign;
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
