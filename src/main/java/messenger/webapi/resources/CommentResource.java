package messenger.webapi.resources;

import messenger.webapi.model.Comment;
import messenger.webapi.service.CommentService;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_XML;

@Path("/")
@Consumes(APPLICATION_JSON)
@Produces(value = {APPLICATION_JSON, TEXT_XML})
public class CommentResource {

    private CommentService commentService = new CommentService();

    @GET
    public List<Comment> getAllComments(@PathParam("messageId") Long messageId) {
        return commentService.getAllComments(messageId);
    }

    @POST
    public Comment addComment(@PathParam("messageId") Long messageId, Comment comment) {
        return commentService.addComment(messageId, comment);
    }

    @PUT
    @Path("/{commentId}")
    public Comment updateComment(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId, Comment comment) {
        comment.setId(commentId);
        return commentService.updateComment(messageId, comment);
    }

    @DELETE
    @Path("/{commentId}")
    public void deleteComment(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId) {
        commentService.removeComment(messageId, commentId);
    }

    @GET
    @Path("/{commentId}")
    public Comment getComment(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId) {
        return commentService.getComment(messageId, commentId);
    }

    @Path("/{commentId}/likes")
    public LikesResource getLikes(@PathParam("messageId") String messageId, @PathParam("commentId") String commentId) {
        return new LikesResource();
    }

}
