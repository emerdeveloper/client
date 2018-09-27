package co.com.bancolombia.clientes.repository;

import org.springframework.stereotype.Repository;

import co.com.bancolombia.clientes.connection.Connection;
import co.com.bancolombia.clientes.model.request.ClientRequest;
import co.com.bancolombia.clientes.model.response.ClientResponse;

@Repository
public class ClientRepository {	
	
	
	public String updateClient(ClientRequest client) {		        
        try {
        	Connection connection = new Connection();
    		return connection.cloudantConnection().database("client", true).update(client).getReason();
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
    		return connection.cloudantConnection().database("client", true).findByIndex(selector, ClientResponse.class).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

}
