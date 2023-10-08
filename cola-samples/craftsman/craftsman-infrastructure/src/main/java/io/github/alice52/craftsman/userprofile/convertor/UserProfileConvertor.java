package io.github.alice52.craftsman.userprofile.convertor;

import io.github.alice52.craftsman.domain.userprofile.model.Role;
import io.github.alice52.craftsman.domain.userprofile.model.UserProfile;
import io.github.alice52.craftsman.dto.clientobject.UserProfileCO;
import io.github.alice52.craftsman.userprofile.entity.UserProfileDO;

import org.springframework.beans.BeanUtils;

public class UserProfileConvertor {

    public static UserProfile toEntity(UserProfileCO userProfileCO) {
        UserProfile userProfile = new UserProfile();
        BeanUtils.copyProperties(userProfileCO, userProfile);
        userProfile.setRole(Role.valueOf(userProfileCO.getRole()));
        return userProfile;
    }

    public static UserProfileDO toDataObject(UserProfile userProfile) {
        UserProfileDO userProfileDO = new UserProfileDO();
        BeanUtils.copyProperties(userProfile, userProfileDO);
        userProfileDO.setRole(userProfile.getRole().name());
        return userProfileDO;
    }

    public static UserProfileDO toDataObjectForCreate(UserProfile userProfile) {
        UserProfileDO userProfileDO = toDataObject(userProfile);
        return userProfileDO;
    }

    public static UserProfileDO toDataObjectForUpdate(UserProfile userProfile) {
        UserProfileDO userProfileDO = toDataObject(userProfile);
        return userProfileDO;
    }
}
