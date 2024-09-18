
package mosbach.dhbw.de.tasks.controller.model;

import java.util.LinkedHashMap;
import java.util.Map;
//import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
//
public class Task {

    @JsonProperty("modul")
    private String modul;
    @JsonProperty("type")
    private String type;
    @JsonProperty("grade")
    private String grade;
    @JsonProperty("date-as-number")
    private String dateAsNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("modul")
    public String getModul() {
        return modul;
    }

    @JsonProperty("modul")
    public void setModul(String modul) {
        this.modul = modul;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("grade")
    public String getGrade() {
        return grade;
    }

    @JsonProperty("grade")
    public void setGrade(String grade) {
        this.grade = grade;
    }

    @JsonProperty("date-as-number")
    public String getDateAsNumber() {
        return dateAsNumber;
    }

    @JsonProperty("date-as-number")
    public void setDateAsNumber(String dateAsNumber) {
        this.dateAsNumber = dateAsNumber;
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
