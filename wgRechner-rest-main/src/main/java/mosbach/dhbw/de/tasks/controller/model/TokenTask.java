
package mosbach.dhbw.de.tasks.controller.model;

import java.util.LinkedHashMap;
import java.util.Map;
//import javax.annotation.Generated; muss entfernt werden, da es dieses nicht gibt
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
/*
@JsonPropertyOrder({
    "token",
    "task"
})
@Generated("jsonschema2pojo")
*/
public class TokenTask {

    @JsonProperty("token")
    private String token;
    @JsonProperty("task")
    private Task task;
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

    @JsonProperty("task")
    public Task getTask() {
        return task;
    }

    @JsonProperty("task")
    public void setTask(Task task) {
        this.task = task;
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
