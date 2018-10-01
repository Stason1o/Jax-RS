package messenger.webapi.service;

import messenger.webapi.model.Message;

import java.util.Arrays;
import java.util.List;

public class MessageService {

    public List<Message> getAllMessages() {
        Message m1 = new Message(1L, "Hello World", "FirstAuthor");
        Message m2 = new Message(2L, "Hello World 2!", "FirstAuthor");
        return Arrays.asList(m1, m2);
    }
}
