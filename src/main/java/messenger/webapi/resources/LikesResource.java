package messenger.webapi.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("like")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class LikesResource {

    @GET
    public String getLike() {
        return "like!!!";
    }

    @GET
    @Path("/{likeId}")
    public String getComment(@PathParam("likeId") String likeId, @PathParam("commentId") String commentId) {
        return "comment id: " + commentId + " likeId: " + likeId;
    }
}
