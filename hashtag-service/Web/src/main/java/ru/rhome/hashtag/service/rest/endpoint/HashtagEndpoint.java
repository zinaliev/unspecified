package ru.rhome.hashtag.service.rest.endpoint;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by zinaliev on 06.11.2016.
 */

@Path("/tags")
@Consumes("application/json")
@Produces("application/json")
public class HashtagEndpoint {

    @POST
    @Path("/add/{tag}")
    public Response add(@PathParam("tag") String tag){

        return Response.ok().build();
    }
}
