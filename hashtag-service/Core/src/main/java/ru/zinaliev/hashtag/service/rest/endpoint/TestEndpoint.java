package ru.zinaliev.hashtag.service.rest.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by zinaliev on 06.11.2016.
 */
@Path("test")
public class TestEndpoint {

    @GET
    @Path("/isAlive")
    public Response isAlive(){
        return Response.ok("Hashtag service REST API is up").build();
    }
}
