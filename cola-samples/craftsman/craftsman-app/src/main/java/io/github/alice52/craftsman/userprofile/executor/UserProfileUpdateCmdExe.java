package io.github.alice52.craftsman.userprofile.executor;

import com.alibaba.cola.dto.Response;

import io.github.alice52.craftsman.domain.userprofile.gateway.UserProfileGateway;
import io.github.alice52.craftsman.domain.userprofile.model.UserProfile;
import io.github.alice52.craftsman.dto.UserProfileUpdateCmd;
import io.github.alice52.craftsman.userprofile.convertor.UserProfileConvertor;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileUpdateCmdExe {

    @Resource private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileUpdateCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.update(userProfile);
        return Response.buildSuccess();
    }
}
