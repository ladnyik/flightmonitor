
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
    "terminal",
    "baggage",
    "gate"
})
public class Info {

    @JsonProperty("terminal")
    private String terminal;
    @JsonProperty("baggage")
    private Object baggage;
    @JsonProperty("gate")
    private String gate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("terminal")
    public String getTerminal() {
        return terminal;
    }

    @JsonProperty("terminal")
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    @JsonProperty("baggage")
    public Object getBaggage() {
        return baggage;
    }

    @JsonProperty("baggage")
    public void setBaggage(Object baggage) {
        this.baggage = baggage;
    }

    @JsonProperty("gate")
    public String getGate() {
        return gate;
    }

    @JsonProperty("gate")
    public void setGate(String gate) {
        this.gate = gate;
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
