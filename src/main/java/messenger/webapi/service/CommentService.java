package messenger.webapi.service;

import messenger.webapi.db.Database;
import messenger.webapi.model.Comment;
import messenger.webapi.model.ErrorMessage;
import messenger.webapi.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

public class CommentService {

    private Map<Long, Message> messages = Database.getMessages();

    public CommentService() {
        messages.put(1L, new Message(1L, "Hello world", "Test"));
        messages.put(2L, new Message(2L, "Hello AGAIN", "Test test"));
    }

    public List<Comment> getAllComments(Long messageId) {
        return new ArrayList<>(messages.get(messageId).getComments().values());
    }

    public Comment getComment(Long messageId, Long  commentId) {
        ErrorMessage errorMessage = new ErrorMessage("Not Found", 404, "Link");
        Response response = Response.status(NOT_FOUND)
            .entity(errorMessage)
            .build();

        Message message = messages.get(messageId);
        if (message == null) {
            throw new WebApplicationException(response);
        }

        Map<Long, Comment> comments = message.getComments();
        Comment comment = comments.get(commentId);

        if (comment == null) {
            throw new NotFoundException();
        }

        return comment;
    }

    public Comment addComment(Long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size() + 1L);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(Long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if (comment.getId() <= 0) {
            return null;
        }
        comments.put(comment.getId(), comment);
        System.out.println(comments.get(comment.getId()));
        System.out.println("Message is updated with " + comment);
        return comment;
    }

    public Comment removeComment(Long messageId, Long commentId) {
        return messages.get(messageId).getComments().remove(commentId);
    }
}
