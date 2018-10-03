package messenger.webapi.service;

import messenger.webapi.db.Database;
import messenger.webapi.model.Comment;
import messenger.webapi.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommentService {

    private Map<Long, Message> messages = Database.getMessages();

    public CommentService() {
        messages.put(1L, new Message(1L, "Hello world", "Test"));
        messages.put(2L, new Message(2L, "Hello AGAIN", "Test test"));
    }

    public List<Comment> getAllComments(Long messageId) {
        return new ArrayList<>(messages.get(messageId).getComments().values());
    }

//    public List<Message> getAllMessagesForYear(int year) {
//        return messages.values().stream()
//            .filter(message -> message.getCreated().getYear() == year)
//            .collect(Collectors.toList());
//    }
//
//    public List<Message> getAllMessagesPaginated(int start, int size) {
//        List<Message> messages = new ArrayList<>(this.messages.values());
//        if (start + size > messages.size()) return new ArrayList<>();
//        return messages.subList(start, start + size);
//    }

    public Comment getComment(Long messageId, Long  commentId) {
        return messages.get(messageId).getComments().get(commentId);
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
