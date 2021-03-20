
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
    "lat",
    "lng",
    "alt",
    "spd",
    "ts",
    "hd"
})
public class Trail {

    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lng")
    private Double lng;
    @JsonProperty("alt")
    private Long alt;
    @JsonProperty("spd")
    private Long spd;
    @JsonProperty("ts")
    private Long ts;
    @JsonProperty("hd")
    private Long hd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @JsonProperty("lng")
    public Double getLng() {
        return lng;
    }

    @JsonProperty("lng")
    public void setLng(Double lng) {
        this.lng = lng;
    }

    @JsonProperty("alt")
    public Long getAlt() {
        return alt;
    }

    @JsonProperty("alt")
    public void setAlt(Long alt) {
        this.alt = alt;
    }

    @JsonProperty("spd")
    public Long getSpd() {
        return spd;
    }

    @JsonProperty("spd")
    public void setSpd(Long spd) {
        this.spd = spd;
    }

    @JsonProperty("ts")
    public Long getTs() {
        return ts;
    }

    @JsonProperty("ts")
    public void setTs(Long ts) {
        this.ts = ts;
    }

    @JsonProperty("hd")
    public Long getHd() {
        return hd;
    }

    @JsonProperty("hd")
    public void setHd(Long hd) {
        this.hd = hd;
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
