
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
    "name",
    "code",
    "position",
    "timezone",
    "visible",
    "website"
})
public class Destination_ {

    @JsonProperty("name")
    private String name;
    @JsonProperty("code")
    private Code____ code;
    @JsonProperty("position")
    private Position___ position;
    @JsonProperty("timezone")
    private Timezone___ timezone;
    @JsonProperty("visible")
    private Boolean visible;
    @JsonProperty("website")
    private String website;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("code")
    public Code____ getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(Code____ code) {
        this.code = code;
    }

    @JsonProperty("position")
    public Position___ getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Position___ position) {
        this.position = position;
    }

    @JsonProperty("timezone")
    public Timezone___ getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(Timezone___ timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("visible")
    public Boolean getVisible() {
        return visible;
    }

    @JsonProperty("visible")
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @JsonProperty("website")
    public String getWebsite() {
        return website;
    }

    @JsonProperty("website")
    public void setWebsite(String website) {
        this.website = website;
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
