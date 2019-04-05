package com.dilshan.jerseyclient;



import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RESTJerseyClient {

	public static void main(String ar[]) {
		RESTJerseyClient client = new RESTJerseyClient();
		client.getCtoFResponse();
	}
	
	private void getCtoFResponse() {
		
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/RESTJerseyExample/dilshan/RESTService/convertCtoF");
			ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
			
			if(response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			
			String output = response.getEntity(String.class);
			System.out.println("================getCtoFResponse================");
			System.out.println(output);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
