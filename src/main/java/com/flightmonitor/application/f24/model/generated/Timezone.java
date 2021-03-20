
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
    "offset",
    "offsetHours",
    "abbr",
    "abbrName",
    "isDst"
})
public class Timezone {

    @JsonProperty("name")
    private String name;
    @JsonProperty("offset")
    private Long offset;
    @JsonProperty("offsetHours")
    private String offsetHours;
    @JsonProperty("abbr")
    private String abbr;
    @JsonProperty("abbrName")
    private String abbrName;
    @JsonProperty("isDst")
    private Boolean isDst;
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

    @JsonProperty("offset")
    public Long getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(Long offset) {
        this.offset = offset;
    }

    @JsonProperty("offsetHours")
    public String getOffsetHours() {
        return offsetHours;
    }

    @JsonProperty("offsetHours")
    public void setOffsetHours(String offsetHours) {
        this.offsetHours = offsetHours;
    }

    @JsonProperty("abbr")
    public String getAbbr() {
        return abbr;
    }

    @JsonProperty("abbr")
    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    @JsonProperty("abbrName")
    public String getAbbrName() {
        return abbrName;
    }

    @JsonProperty("abbrName")
    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }

    @JsonProperty("isDst")
    public Boolean getIsDst() {
        return isDst;
    }

    @JsonProperty("isDst")
    public void setIsDst(Boolean isDst) {
        this.isDst = isDst;
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
