/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.InputStream;
import java.util.Properties;

public class GarmentClient {

    public String getGarments(String category, String priceRange) {

        String token = getToken();

        Client client = ClientBuilder.newClient();

        String url = "http://localhost:8080/GarmentsAppication/rest/garments";

        Response response = client.target(url)
                .queryParam("category", category)
                .queryParam("priceRange", priceRange)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .get();

        String result = response.readEntity(String.class);

        response.close();
        client.close();

        return result;
    }

    private String getToken() {

        try {
            Properties properties = new Properties();

            InputStream input = getClass()
                    .getClassLoader()
                    .getResourceAsStream("client.properties");

            properties.load(input);

            return properties.getProperty("jwt-string");

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
