
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
    "utc",
    "local"
})
public class EventTime {

    @JsonProperty("utc")
    private Long utc;
    @JsonProperty("local")
    private Long local;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("utc")
    public Long getUtc() {
        return utc;
    }

    @JsonProperty("utc")
    public void setUtc(Long utc) {
        this.utc = utc;
    }

    @JsonProperty("local")
    public Long getLocal() {
        return local;
    }

    @JsonProperty("local")
    public void setLocal(Long local) {
        this.local = local;
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
