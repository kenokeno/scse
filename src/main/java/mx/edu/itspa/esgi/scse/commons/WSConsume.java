package mx.edu.itspa.esgi.scse.commons;

import java.util.List;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WSConsume {
	public static <E> List<E> getAll(String target, List<E> lt){
		Response response = null;
		ResteasyWebTarget webTarget;
		ResteasyClient client = new ResteasyClientBuilder().build();
		String responseJSON =null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			webTarget = client.target(target);
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			response = invocationBuilder.get();
			
			System.out.println("Estatus: "+response.getStatus());
			
			if(response.getStatus() != 200) {
				throw new RuntimeException("Failed: HTTP error code: " + response.getStatus());
			}
			
			responseJSON = response.readEntity(String.class);
			
			lt = objectMapper.readValue(responseJSON, new TypeReference<List<E>>() {});			
		}catch(Exception e) {
			System.out.print("Error: " + e.getMessage());
		}finally {
			if(response != null)response.close();
			if(client !=null)client.close();
		}
		return lt;
	}
	
	public static <E> E get(String target, E entity){
		Response response = null;
		ResteasyWebTarget webTarget;
		ResteasyClient client = new ResteasyClientBuilder().build();
		String responseJSON =null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			webTarget = client.target(target);
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			response = invocationBuilder.get();
			
			if(response.getStatus() != 200) {
				throw new RuntimeException("Failed: HTTP error code: " + response.getStatus());
			}
			
			responseJSON = response.readEntity(String.class);
			entity = (E) objectMapper.readValue(responseJSON, entity.getClass());
			//lt = objectMapper.readValue(responseJSON, new TypeReference<List<E>>() {});
		}catch(Exception e) {
			System.out.print("Error: " + e.getMessage());
		}finally {
			if(response != null)response.close();
			if(client !=null)client.close();
		}
		return entity;
	}
}
