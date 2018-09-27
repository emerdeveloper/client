
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
    "customer_name",
    "customer_surname",
    "customer_secondSurname"
})
public class NaturalPerson {

    @JsonProperty("customer_name")
    private String customerName;
    @JsonProperty("customer_surname")
    private String customerSurname;
    @JsonProperty("customer_secondSurname")
    private String customerSecondSurname;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("customer_name")
    public String getCustomerName() {
        return customerName;
    }

    @JsonProperty("customer_name")
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @JsonProperty("customer_surname")
    public String getCustomerSurname() {
        return customerSurname;
    }

    @JsonProperty("customer_surname")
    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    @JsonProperty("customer_secondSurname")
    public String getCustomerSecondSurname() {
        return customerSecondSurname;
    }

    @JsonProperty("customer_secondSurname")
    public void setCustomerSecondSurname(String customerSecondSurname) {
        this.customerSecondSurname = customerSecondSurname;
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
