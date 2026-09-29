package client.resource;

import client.GarmentClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/client")
public class ClientResource {

    private GarmentClient garmentClient = new GarmentClient();

    @GET
    @Path("/garments")
    @Produces(MediaType.APPLICATION_JSON)
    public String getGarments(
            @QueryParam("category") String category,
            @QueryParam("priceRange") String priceRange) {

        return garmentClient.getGarments(category, priceRange);
    }
}