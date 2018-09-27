
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
    "_messageId",
    "_version",
    "_requestDate",
    "_responseSize",
    "_clientRequest"
})
public class UbicationMeta {

    @JsonProperty("_messageId")
    private String messageId;
    @JsonProperty("_version")
    private String version;
    @JsonProperty("_requestDate")
    private String requestDate;
    @JsonProperty("_responseSize")
    private String responseSize;
    @JsonProperty("_clientRequest")
    private String clientRequest;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("_messageId")
    public String getMessageId() {
        return messageId;
    }

    @JsonProperty("_messageId")
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @JsonProperty("_version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("_version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("_requestDate")
    public String getRequestDate() {
        return requestDate;
    }

    @JsonProperty("_requestDate")
    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    @JsonProperty("_responseSize")
    public String getResponseSize() {
        return responseSize;
    }

    @JsonProperty("_responseSize")
    public void setResponseSize(String responseSize) {
        this.responseSize = responseSize;
    }

    @JsonProperty("_clientRequest")
    public String getClientRequest() {
        return clientRequest;
    }

    @JsonProperty("_clientRequest")
    public void setClientRequest(String clientRequest) {
        this.clientRequest = clientRequest;
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
