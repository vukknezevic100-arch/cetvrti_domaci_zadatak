package resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import rest.client.TimeAPI;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import model.TimeResponse;

@Path("/time")
public class TimeResource {

    @Inject
    @RestClient
    TimeAPI timeApi;

    @GET
    @Path("/getTime/{country}/{city}")
    public Response getTime(@PathParam("country") String country, @PathParam("city") String city) {
        String fullTimeZone = country + "/" + city;
        TimeResponse timeResponse = timeApi.getTime(fullTimeZone);

        return Response.ok(timeResponse).build();
    }
}