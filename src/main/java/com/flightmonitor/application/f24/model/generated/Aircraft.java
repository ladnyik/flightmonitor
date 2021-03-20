
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
    "model",
    "countryId",
    "registration",
    "hex",
    "age",
    "msn",
    "images"
})
public class Aircraft {

    @JsonProperty("model")
    private Model model;
    @JsonProperty("countryId")
    private Long countryId;
    @JsonProperty("registration")
    private String registration;
    @JsonProperty("hex")
    private String hex;
    @JsonProperty("age")
    private Object age;
    @JsonProperty("msn")
    private Object msn;
    @JsonProperty("images")
    private Images images;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("model")
    public Model getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(Model model) {
        this.model = model;
    }

    @JsonProperty("countryId")
    public Long getCountryId() {
        return countryId;
    }

    @JsonProperty("countryId")
    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @JsonProperty("registration")
    public String getRegistration() {
        return registration;
    }

    @JsonProperty("registration")
    public void setRegistration(String registration) {
        this.registration = registration;
    }

    @JsonProperty("hex")
    public String getHex() {
        return hex;
    }

    @JsonProperty("hex")
    public void setHex(String hex) {
        this.hex = hex;
    }

    @JsonProperty("age")
    public Object getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Object age) {
        this.age = age;
    }

    @JsonProperty("msn")
    public Object getMsn() {
        return msn;
    }

    @JsonProperty("msn")
    public void setMsn(Object msn) {
        this.msn = msn;
    }

    @JsonProperty("images")
    public Images getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(Images images) {
        this.images = images;
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
