package messenger.webapi;

import messenger.webapi.model.Message;
import messenger.webapi.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("messages")
public class MessageResource {

    private MessageService messageService = new MessageService();

    @GET
    @Produces(value = MediaType.APPLICATION_XML)
    public List<Message> getMessage() {
        return messageService.getAllMessages();
    }


}
