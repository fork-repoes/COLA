package io.github.alice52.craftsman.userprofile;

import io.github.alice52.craftsman.domain.DomainFactory;
import io.github.alice52.craftsman.domain.metrics.model.weight.WeightFactory;
import io.github.alice52.craftsman.domain.userprofile.gateway.UserProfileGateway;
import io.github.alice52.craftsman.domain.userprofile.model.Role;
import io.github.alice52.craftsman.domain.userprofile.model.UserProfile;
import io.github.alice52.craftsman.userprofile.convertor.UserProfileConvertor;
import io.github.alice52.craftsman.userprofile.entity.UserProfileDO;
import io.github.alice52.craftsman.userprofile.mapper.UserProfileMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * UserProfileGatewayImpl
 *
 * @author Frank Zhang
 * @date 2020-07-02 12:32 PM
 */
@Component
@Slf4j
public class UserProfileGatewayImpl implements UserProfileGateway {

    @Resource private UserProfileMapper userProfileMapper;

    public void create(UserProfile userProfile) {
        userProfileMapper.create(UserProfileConvertor.toDataObjectForCreate(userProfile));
    }

    public void update(UserProfile userProfile) {
        userProfileMapper.update(UserProfileConvertor.toDataObjectForUpdate(userProfile));
    }

    public UserProfile getByUserId(String userId) {
        UserProfileDO userProfileDO = userProfileMapper.getByUserId(userId);
        if (userProfileDO == null) {
            log.warn("There is no UserProfile for : " + userId);
            return null;
        }
        UserProfile userProfile = DomainFactory.getUserProfile();
        BeanUtils.copyProperties(userProfileDO, userProfile);
        Role role = Role.valueOf(userProfileDO.getRole());
        userProfile.setRole(role);
        userProfile.setWeight(WeightFactory.get(role));
        return userProfile;
    }
}
