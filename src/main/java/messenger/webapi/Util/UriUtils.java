package messenger.webapi.Util;

import messenger.webapi.model.Comment;
import messenger.webapi.model.Message;
import messenger.webapi.resources.CommentResource;
import messenger.webapi.resources.MessageResource;
import messenger.webapi.resources.ProfileResource;

import java.rmi.MarshalException;
import javax.ws.rs.core.UriInfo;

public class UriUtils {

    public static String getUriForMessage(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
            .path(MessageResource.class)
            .path(Long.toString(message.getId()))
            .build()
            .toString();
    }

    public static String getUriForProfile(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
            .path(ProfileResource.class)
            .path(message.getAuthor())
            .build()
            .toString();
    }

    public static String getUriForComments(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
            .path(MessageResource.class)
            .path(MessageResource.class, "getCommentResource")
            .path(CommentResource.class)
            .resolveTemplate("messageId", message.getId())
            .build()
            .toString();
    }

}
