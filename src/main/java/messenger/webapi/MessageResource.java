package messenger.webapi;

import messenger.webapi.model.Message;
import messenger.webapi.service.MessageService;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("messages")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class MessageResource {

    private MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @PUT
    @Path(value = "/{messageId}")
    public Message editMessage(@PathParam("messageId") Long messageId, Message message) {
        message.setId(messageId);
        System.out.println("Triggered edit message");
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") Long messageId) {
        messageService.removeMessage(messageId);
    }

    @POST
    public Message addMessage(Message message) {
        return messageService.addMessage(message);
    }

    @GET
    @Path(value = "/{messageId}")
    public Message getMessage(@PathParam("messageId") Long messageId) {
        return messageService.getMessage(messageId);
    }
}
