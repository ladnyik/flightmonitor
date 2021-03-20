
package com.flightmonitor.application.f24.model.generated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "thumbnails",
    "medium",
    "large"
})
public class Images {

    @JsonProperty("thumbnails")
    private List<Thumbnail> thumbnails = null;
    @JsonProperty("medium")
    private List<Medium> medium = null;
    @JsonProperty("large")
    private List<Large> large = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("thumbnails")
    public List<Thumbnail> getThumbnails() {
        return thumbnails;
    }

    @JsonProperty("thumbnails")
    public void setThumbnails(List<Thumbnail> thumbnails) {
        this.thumbnails = thumbnails;
    }

    @JsonProperty("medium")
    public List<Medium> getMedium() {
        return medium;
    }

    @JsonProperty("medium")
    public void setMedium(List<Medium> medium) {
        this.medium = medium;
    }

    @JsonProperty("large")
    public List<Large> getLarge() {
        return large;
    }

    @JsonProperty("large")
    public void setLarge(List<Large> large) {
        this.large = large;
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
