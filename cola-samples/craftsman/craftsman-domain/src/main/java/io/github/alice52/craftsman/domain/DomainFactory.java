package io.github.alice52.craftsman.domain;

import io.github.alice52.craftsman.domain.userprofile.model.UserProfile;

public class DomainFactory {

    public static UserProfile getUserProfile() {
        return new UserProfile();
    }
}
