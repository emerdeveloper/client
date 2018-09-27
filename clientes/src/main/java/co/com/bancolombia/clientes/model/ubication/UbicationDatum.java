
package co.com.bancolombia.clientes.model.ubication;

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
    "header",
    "status",
    "ubicationData"
})
public class UbicationDatum {

    @JsonProperty("header")
    private UbicationHeader header;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("ubicationData")
    private UbicationData ubicationData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("header")
    public UbicationHeader getHeader() {
        return header;
    }

    @JsonProperty("header")
    public void setHeader(UbicationHeader header) {
        this.header = header;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("ubicationData")
    public UbicationData getUbicationData() {
        return ubicationData;
    }

    @JsonProperty("ubicationData")
    public void setUbicationData(UbicationData ubicationData) {
        this.ubicationData = ubicationData;
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
