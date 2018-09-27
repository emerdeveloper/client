
package co.com.bancolombia.clientes.model.basicinformation;

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
    "customer_type",
    "customer_state",
    "customer_stateUpdateDate",
    "customer_vinculationState",
    "customer_vinculationDate",
    "customer_vinculationOffice",
    "natural_person",
    "juridical_person"
})
public class BasicInformationData {

    @JsonProperty("header")
    private BasicInformationHeader header;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("customer_type")
    private String customerType;
    @JsonProperty("customer_state")
    private String customerState;
    @JsonProperty("customer_stateUpdateDate")
    private String customerStateUpdateDate;
    @JsonProperty("customer_vinculationState")
    private String customerVinculationState;
    @JsonProperty("customer_vinculationDate")
    private String customerVinculationDate;
    @JsonProperty("customer_vinculationOffice")
    private String customerVinculationOffice;
    @JsonProperty("natural_person")
    private NaturalPerson naturalPerson;
    @JsonProperty("juridical_person")
    private JuridicalPerson juridicalPerson;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("header")
    public BasicInformationHeader getHeader() {
        return header;
    }

    @JsonProperty("header")
    public void setHeader(BasicInformationHeader header) {
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

    @JsonProperty("customer_type")
    public String getCustomerType() {
        return customerType;
    }

    @JsonProperty("customer_type")
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @JsonProperty("customer_state")
    public String getCustomerState() {
        return customerState;
    }

    @JsonProperty("customer_state")
    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    @JsonProperty("customer_stateUpdateDate")
    public String getCustomerStateUpdateDate() {
        return customerStateUpdateDate;
    }

    @JsonProperty("customer_stateUpdateDate")
    public void setCustomerStateUpdateDate(String customerStateUpdateDate) {
        this.customerStateUpdateDate = customerStateUpdateDate;
    }

    @JsonProperty("customer_vinculationState")
    public String getCustomerVinculationState() {
        return customerVinculationState;
    }

    @JsonProperty("customer_vinculationState")
    public void setCustomerVinculationState(String customerVinculationState) {
        this.customerVinculationState = customerVinculationState;
    }

    @JsonProperty("customer_vinculationDate")
    public String getCustomerVinculationDate() {
        return customerVinculationDate;
    }

    @JsonProperty("customer_vinculationDate")
    public void setCustomerVinculationDate(String customerVinculationDate) {
        this.customerVinculationDate = customerVinculationDate;
    }

    @JsonProperty("customer_vinculationOffice")
    public String getCustomerVinculationOffice() {
        return customerVinculationOffice;
    }

    @JsonProperty("customer_vinculationOffice")
    public void setCustomerVinculationOffice(String customerVinculationOffice) {
        this.customerVinculationOffice = customerVinculationOffice;
    }

    @JsonProperty("natural_person")
    public NaturalPerson getNaturalPerson() {
        return naturalPerson;
    }

    @JsonProperty("natural_person")
    public void setNaturalPerson(NaturalPerson naturalPerson) {
        this.naturalPerson = naturalPerson;
    }

    @JsonProperty("juridical_person")
    public JuridicalPerson getJuridicalPerson() {
        return juridicalPerson;
    }

    @JsonProperty("juridical_person")
    public void setJuridicalPerson(JuridicalPerson juridicalPerson) {
        this.juridicalPerson = juridicalPerson;
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
