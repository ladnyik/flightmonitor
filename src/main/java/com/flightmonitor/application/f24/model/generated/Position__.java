
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
    "latitude",
    "longitude",
    "altitude",
    "country",
    "region"
})
public class Position__ {

    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("altitude")
    private Long altitude;
    @JsonProperty("country")
    private Country__ country;
    @JsonProperty("region")
    private Region__ region;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("altitude")
    public Long getAltitude() {
        return altitude;
    }

    @JsonProperty("altitude")
    public void setAltitude(Long altitude) {
        this.altitude = altitude;
    }

    @JsonProperty("country")
    public Country__ getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(Country__ country) {
        this.country = country;
    }

    @JsonProperty("region")
    public Region__ getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(Region__ region) {
        this.region = region;
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
