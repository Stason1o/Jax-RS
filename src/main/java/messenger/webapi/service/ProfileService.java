package messenger.webapi.service;

import messenger.webapi.db.Database;
import messenger.webapi.model.Message;
import messenger.webapi.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

    private Map<Long, Profile> profiles = Database.getProfiles();

    public ProfileService() {
        profiles.put(1L, new Profile(1L, "profile1", "Test FirstName", "Test LastName"));
    }

    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile(Long profileId) {
        return profiles.get(profileId);
    }

    public Profile addProfile(Profile profile) {
        profile.setId(profiles.size() + 1L);
        profiles.put(profile.getId(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile) {
        if (profile.getId() <= 0) {
            return null;
        }
        profiles.put(profile.getId(), profile);
        System.out.println(profiles.get(profile.getId()));
        System.out.println("Message is updated with " + profile);
        return profile;
    }

    public void removeProfile(Long profileName) {
        profiles.remove(profileName);
    }
}
