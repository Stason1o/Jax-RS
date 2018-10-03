package messenger.webapi.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//@XmlRootElement
public class Message {

    private Long id;
    private String message;
    private LocalDateTime created;
    private String author;
    private Map<Long, Comment> comments = new HashMap<>();

    public Message() {
    }

    public Message(Long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.created = LocalDateTime.now();
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlTransient // Ignore comments in xml file
    public Map<Long, Comment> getComments() {
        return comments;
    }

    public void setComments(Map<Long, Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("id=").append(id);
        sb.append(", message='").append(message).append('\'');
        sb.append(", created=").append(created);
        sb.append(", author='").append(author).append('\'');
        sb.append(", comments=").append(comments);
        sb.append('}');
        return sb.toString();
    }
}
