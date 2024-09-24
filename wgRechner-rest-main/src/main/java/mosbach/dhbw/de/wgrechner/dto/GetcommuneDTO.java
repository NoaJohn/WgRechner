
package mosbach.dhbw.de.wgrechner.dto;
//WIP noch keinen Nutzen
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class GetcommuneDTO {

    @JsonProperty("communeName")
    private String communeName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("communeName")
    public String getCommuneName() {
        return communeName;
    }

    @JsonProperty("communeName")
    public void setCommuneName(String communeName) {
        this.communeName = communeName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public GetcommuneDTO(String communeName) {
        this.communeName = communeName;
    }
}
