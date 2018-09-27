
package co.com.bancolombia.clientes.model.basicinformation;

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
    "meta",
    "data",
    "links"
})
public class BasicInformationResponse {

    @JsonProperty("meta")
    private BasicInformationMeta meta;
    @JsonProperty("data")
    private List<BasicInformationData> data = null;
    @JsonProperty("links")
    private Links links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("meta")
    public BasicInformationMeta getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(BasicInformationMeta meta) {
        this.meta = meta;
    }

    @JsonProperty("data")
    public List<BasicInformationData> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<BasicInformationData> data) {
        this.data = data;
    }

    @JsonProperty("links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(Links links) {
        this.links = links;
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
