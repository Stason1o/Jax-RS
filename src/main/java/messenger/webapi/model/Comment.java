package messenger.webapi.model;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {

    private Long id;
    private String message;
    private LocalDateTime created;
    private String author;

    public Comment() {
    }

    public Comment(Long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.created = LocalDateTime.now();
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
}
