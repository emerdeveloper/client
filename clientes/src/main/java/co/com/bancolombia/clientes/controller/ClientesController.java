package co.com.bancolombia.clientes.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.bancolombia.clientes.model.request.ClientRequest;
import co.com.bancolombia.clientes.model.response.ClientResponse;
import co.com.bancolombia.clientes.service.ClientService;

@RestController
public class ClientesController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="/getClient", method=RequestMethod.POST)
	public ClientResponse getClient(@RequestBody ClientRequest clientRequest) {
		try {
			return clientService.getClientInformation(clientRequest);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value="/updateClient", method=RequestMethod.POST)
	public ClientResponse updateClient(@RequestBody ClientRequest clientRequest) {
		try {
			return clientService.updateClientInformation(clientRequest);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getDeclaration", method = RequestMethod.GET)
	public void getFile(HttpServletResponse response) {
	    try {
	      // get your file as InputStream
	      InputStream is = new FileInputStream(new File("src/main/resources/Example of Declaration.pdf"));
	      // copy it to response's OutputStream
	      org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
//	      response.flushBuffer();
	      response.setContentType("application/pdf");
	    } catch (IOException ex) {
	      throw new RuntimeException("IOError writing file to output stream");
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
}
