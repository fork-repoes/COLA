package io.github.alice52.craftsman.userprofile.executor;

import com.alibaba.cola.dto.Response;

import io.github.alice52.craftsman.domain.userprofile.gateway.UserProfileGateway;
import io.github.alice52.craftsman.domain.userprofile.model.UserProfile;
import io.github.alice52.craftsman.dto.UserProfileAddCmd;
import io.github.alice52.craftsman.userprofile.convertor.UserProfileConvertor;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * UserProfileAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-02-28 6:25 PM
 */
@Component
public class UserProfileAddCmdExe {

    @Resource private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileAddCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.create(userProfile);
        return Response.buildSuccess();
    }
}
