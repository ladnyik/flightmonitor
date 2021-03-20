
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
    "live",
    "text",
    "icon",
    "estimated",
    "ambiguous",
    "generic"
})
public class Status {

    @JsonProperty("live")
    private Boolean live;
    @JsonProperty("text")
    private String text;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("estimated")
    private Object estimated;
    @JsonProperty("ambiguous")
    private Boolean ambiguous;
    @JsonProperty("generic")
    private Generic generic;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("live")
    public Boolean getLive() {
        return live;
    }

    @JsonProperty("live")
    public void setLive(Boolean live) {
        this.live = live;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("estimated")
    public Object getEstimated() {
        return estimated;
    }

    @JsonProperty("estimated")
    public void setEstimated(Object estimated) {
        this.estimated = estimated;
    }

    @JsonProperty("ambiguous")
    public Boolean getAmbiguous() {
        return ambiguous;
    }

    @JsonProperty("ambiguous")
    public void setAmbiguous(Boolean ambiguous) {
        this.ambiguous = ambiguous;
    }

    @JsonProperty("generic")
    public Generic getGeneric() {
        return generic;
    }

    @JsonProperty("generic")
    public void setGeneric(Generic generic) {
        this.generic = generic;
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
