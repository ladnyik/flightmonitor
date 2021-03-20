
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
    "website",
    "info"
})
public class Destination {

    @JsonProperty("name")
    private String name;
    @JsonProperty("code")
    private Code__ code;
    @JsonProperty("position")
    private Position_ position;
    @JsonProperty("timezone")
    private Timezone_ timezone;
    @JsonProperty("visible")
    private Boolean visible;
    @JsonProperty("website")
    private Object website;
    @JsonProperty("info")
    private Info_ info;
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
    public Code__ getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(Code__ code) {
        this.code = code;
    }

    @JsonProperty("position")
    public Position_ getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Position_ position) {
        this.position = position;
    }

    @JsonProperty("timezone")
    public Timezone_ getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(Timezone_ timezone) {
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
    public Object getWebsite() {
        return website;
    }

    @JsonProperty("website")
    public void setWebsite(Object website) {
        this.website = website;
    }

    @JsonProperty("info")
    public Info_ getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(Info_ info) {
        this.info = info;
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
