package co.com.bancolombia.clientes.repository;

import org.springframework.stereotype.Repository;

import com.cloudant.client.api.query.QueryResult;
import com.google.gson.JsonObject;

import co.com.bancolombia.clientes.connection.Connection;
import co.com.bancolombia.clientes.model.request.ClientRequest;
import co.com.bancolombia.clientes.model.response.ClientResponse;

@Repository
public class ClientRepository {

	public String updateClient(ClientRequest client) {
		try {
			Connection connection = new Connection();
			JsonObject obect = new JsonObject();
			JsonObject object2 = new JsonObject();
			object2.addProperty("_id", client.get_id());
			obect.add("selector", object2);
			QueryResult<ClientResponse> query = connection.cloudantConnection().database("client", true)
					.query(obect.toString(), ClientResponse.class);
			ClientResponse clientResponse = query.getDocs().get(0);
			clientResponse.getData().get(0).setEmail(client.getData().get(0).getEmail());
			clientResponse.getData().get(0).setPhone(client.getData().get(0).getPhone());
			clientResponse.getData().get(0).setCellPhone(client.getData().get(0).getCellPhone());
			clientResponse.getData().get(0).setAddress(client.getData().get(0).getAddress());
			clientResponse.getData().get(0).setOcupation(client.getData().get(0).getOcupation());
			clientResponse.getData().get(0).setIsUpdated(true);
			return connection.cloudantConnection().database("client", true).update(clientResponse).getReason();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String createClient(ClientResponse client) {
		try {
			Connection connection = new Connection();
			return connection.cloudantConnection().database("client", true).save(client).getReason();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ClientResponse getClient(String fullName) {
		try {
			Connection connection = new Connection();
			String selector = "{'selector': {'data': {'$elemMatch': {xxx}}}}";
			selector = selector.replace("xxx", "'fullName': '" + fullName + "'");
			System.out.println(selector);
			return connection.cloudantConnection().database("client", true).findByIndex(selector, ClientResponse.class)
					.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
