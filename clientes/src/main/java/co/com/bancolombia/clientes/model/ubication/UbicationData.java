
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
    "customer_address",
    "customer_cityCode",
    "customer_departmentCode",
    "customer_countryCode",
    "customer_phone",
    "customer_cellphone",
    "customer_email"
})
public class UbicationData {

    @JsonProperty("customer_address")
    private String customerAddress;
    @JsonProperty("customer_cityCode")
    private String customerCityCode;
    @JsonProperty("customer_departmentCode")
    private String customerDepartmentCode;
    @JsonProperty("customer_countryCode")
    private String customerCountryCode;
    @JsonProperty("customer_phone")
    private String customerPhone;
    @JsonProperty("customer_cellphone")
    private String customerCellphone;
    @JsonProperty("customer_email")
    private String customerEmail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("customer_address")
    public String getCustomerAddress() {
        return customerAddress;
    }

    @JsonProperty("customer_address")
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @JsonProperty("customer_cityCode")
    public String getCustomerCityCode() {
        return customerCityCode;
    }

    @JsonProperty("customer_cityCode")
    public void setCustomerCityCode(String customerCityCode) {
        this.customerCityCode = customerCityCode;
    }

    @JsonProperty("customer_departmentCode")
    public String getCustomerDepartmentCode() {
        return customerDepartmentCode;
    }

    @JsonProperty("customer_departmentCode")
    public void setCustomerDepartmentCode(String customerDepartmentCode) {
        this.customerDepartmentCode = customerDepartmentCode;
    }

    @JsonProperty("customer_countryCode")
    public String getCustomerCountryCode() {
        return customerCountryCode;
    }

    @JsonProperty("customer_countryCode")
    public void setCustomerCountryCode(String customerCountryCode) {
        this.customerCountryCode = customerCountryCode;
    }

    @JsonProperty("customer_phone")
    public String getCustomerPhone() {
        return customerPhone;
    }

    @JsonProperty("customer_phone")
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @JsonProperty("customer_cellphone")
    public String getCustomerCellphone() {
        return customerCellphone;
    }

    @JsonProperty("customer_cellphone")
    public void setCustomerCellphone(String customerCellphone) {
        this.customerCellphone = customerCellphone;
    }

    @JsonProperty("customer_email")
    public String getCustomerEmail() {
        return customerEmail;
    }

    @JsonProperty("customer_email")
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
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
