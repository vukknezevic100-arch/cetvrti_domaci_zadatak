package rest.client;

import model.TimeResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/time")
@RegisterRestClient(configKey = "time-api")
public interface TimeAPI {

    @GET
    @Path("/current/zone")
    TimeResponse getTime(@QueryParam("timeZone") String timeZone);
}