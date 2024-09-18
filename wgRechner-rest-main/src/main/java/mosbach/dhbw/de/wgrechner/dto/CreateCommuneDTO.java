
package test;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "token",
    "communeName",
    "location",
    "max-people-number"
})
@Generated("jsonschema2pojo")
public class CreateCommuneDTO {

    @JsonProperty("token")
    private String token;
    @JsonProperty("communeName")
    private String communeName;
    @JsonProperty("location")
    private String location;
    @JsonProperty("max-people-number")
    private String maxPeopleNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("communeName")
    public String getCommuneName() {
        return communeName;
    }

    @JsonProperty("communeName")
    public void setCommuneName(String communeName) {
        this.communeName = communeName;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("max-people-number")
    public String getMaxPeopleNumber() {
        return maxPeopleNumber;
    }

    @JsonProperty("max-people-number")
    public void setMaxPeopleNumber(String maxPeopleNumber) {
        this.maxPeopleNumber = maxPeopleNumber;
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
