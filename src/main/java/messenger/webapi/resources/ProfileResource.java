package messenger.webapi.resources;

import messenger.webapi.model.Message;
import messenger.webapi.model.Profile;
import messenger.webapi.service.ProfileService;

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
import static javax.ws.rs.core.MediaType.TEXT_XML;

@Path("profiles")
@Consumes(APPLICATION_JSON)
@Produces(value = {APPLICATION_JSON, TEXT_XML})
public class ProfileResource {

    private ProfileService profileService = new ProfileService();

    @GET
    public List<Profile> getProfiles() {
        return profileService.getAllProfiles();
    }

    @PUT
    @Path(value = "/{profileId}")
    public Profile editProfile(@PathParam("profileId") Long profileId, Profile profile) {
        profile.setId(profileId);
        System.out.println("Triggered edit message");
        return profileService.updateProfile(profile);
    }

    @DELETE
    @Path("/{profileId}")
    public void deleteMessage(@PathParam("profileId") Long profileId) {
        profileService.removeProfile(profileId);
    }

    @POST
    public Profile addProfile(Profile profile) {
        return profileService.addProfile(profile);
    }

    @GET
    @Path(value = "/{profileId}")
    public Profile getProfile(@PathParam("profileId") Long profileId) {
        return profileService.getProfile(profileId);
    }
}
