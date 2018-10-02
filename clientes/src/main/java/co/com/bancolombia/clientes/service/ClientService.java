package co.com.bancolombia.clientes.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.com.bancolombia.clientes.model.basicinformation.BasicInformationResponse;
import co.com.bancolombia.clientes.model.basicinformation.NaturalPerson;
import co.com.bancolombia.clientes.model.request.ClientRequest;
import co.com.bancolombia.clientes.model.response.ClientResponse;
import co.com.bancolombia.clientes.model.response.Datum;
import co.com.bancolombia.clientes.model.response.Header;
import co.com.bancolombia.clientes.model.ubication.UbicationData;
import co.com.bancolombia.clientes.model.ubication.UbicationResponse;
import co.com.bancolombia.clientes.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	private ClientResponse localClientResponse;

	public ClientResponse getClientInformation(ClientRequest clientRequest) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("authorization", "Bearer " + clientRequest.getData().get(0).getHeader().getToken());
		headers.set("accept", "application/vnd.bancolombia.v1+json");

		HttpEntity entity = new HttpEntity<>(null, headers);

		ResponseEntity<UbicationResponse> ubicationResponse = restTemplate.exchange(
				"https://sbapi.bancolombia.com/v1/sales-services/customer-management/customer-reference-data-management/customers/ubication",
				HttpMethod.GET, entity, UbicationResponse.class);

		ResponseEntity<BasicInformationResponse> basicInformationResponse = restTemplate.exchange(
				"https://sbapi.bancolombia.com/v2/sales-services/customer-management/customer-reference-data-management/customer",
				HttpMethod.GET, entity, BasicInformationResponse.class);

		ClientResponse clientResponse = createClientObject(basicInformationResponse, ubicationResponse);

		if (validateIfClientExist(clientResponse)) {
			clientResponse = localClientResponse;
		} else {
			clientRepository.createClient(clientResponse);
		}

		return clientResponse;

	}

	private boolean validateIfClientExist(ClientResponse clientResponse) {
		boolean isExistingClient = false;
		try {
			localClientResponse = clientRepository.getClient(clientResponse.getData().get(0).getFullName());
			if (null != localClientResponse)
				isExistingClient = true;
		} catch (Exception e) {

		}
		return isExistingClient;
	}

	private ClientResponse createClientObject(ResponseEntity<BasicInformationResponse> basicInformationResponse,
			ResponseEntity<UbicationResponse> ubicationResponse) {
		ClientResponse client = new ClientResponse();
		UbicationData ubicationData = ubicationResponse.getBody().getData().get(0).getUbicationData();
		NaturalPerson basicInformationData = basicInformationResponse.getBody().getData().get(0).getNaturalPerson();
		Datum clientData = new Datum();
		clientData.setFirstName(basicInformationData.getCustomerName());
		clientData.setLastName(
				basicInformationData.getCustomerSurname() + " " + basicInformationData.getCustomerSecondSurname());
		clientData.setEmail(ubicationData.getCustomerEmail());
		clientData.setAddress(ubicationData.getCustomerAddress());
		clientData.setCellPhone(ubicationData.getCustomerCellphone());
		clientData.setPhone(ubicationData.getCustomerPhone());
		clientData.setFullName(clientData.getFirstName() + " " + clientData.getLastName());
		clientData.setUpdated(false);
		client.addData(clientData);
		return client;
	}

	public ClientResponse updateClientInformation(ClientRequest clientRequest) throws IOException {
		ClientResponse clientResponse = new ClientResponse();
		Datum clientData = new Datum();

		clientResponse.addData(clientData);
		clientRequest.getData().get(0).setUpdated(true);
		clientRequest.getData().get(0).setFullName(
				clientRequest.getData().get(0).getFirstName() + " " + clientRequest.getData().get(0).getLastName());
		String status = clientRepository.updateClient(clientRequest);
		if (status.equals("Created"))
			clientData.setHeader(new Header("200"));
		else
			clientData.setHeader(new Header("500"));
		return clientResponse;
	}

}
