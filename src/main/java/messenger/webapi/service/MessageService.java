package messenger.webapi.service;

import messenger.webapi.db.Database;
import messenger.webapi.model.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MessageService {

    private Map<Long, Message> messages = Database.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1L, "Hello world", "Test"));
        messages.put(2L, new Message(2L, "Hello AGAIN", "Test test"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public List<Message> getAllMessagesForYear(int year) {
        return messages.values().stream()
            .filter(message -> message.getCreated().getYear() == year)
            .collect(Collectors.toList());
    }

    public List<Message> getAllMessagesPaginated(int start, int size) {
        List<Message> messages = new ArrayList<>(this.messages.values());
        if (start + size > messages.size()) return new ArrayList<>();
        return messages.subList(start, start + size);
    }

    public Message getMessage(long id) {
        return messages.get(id);
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1L);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        System.out.println(messages.get(message.getId()));
        System.out.println("Message is updated with " + message);
        return message;
    }

    public void removeMessage(long id) {
        messages.remove(id);
    }
}
