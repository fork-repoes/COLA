package io.github.alice52.craftsman.userprofile.executor.query;

import com.alibaba.cola.dto.SingleResponse;

import io.github.alice52.craftsman.dto.UserProfileGetQry;
import io.github.alice52.craftsman.dto.clientobject.UserProfileCO;
import io.github.alice52.craftsman.userprofile.entity.UserProfileDO;
import io.github.alice52.craftsman.userprofile.mapper.UserProfileMapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileGetQryExe {

    @Resource private UserProfileMapper userProfileMapper;

    public SingleResponse<UserProfileCO> execute(UserProfileGetQry qry) {
        UserProfileDO userProfileDO = userProfileMapper.getByUserId(qry.getUserId());
        UserProfileCO userProfileCO = new UserProfileCO();
        BeanUtils.copyProperties(userProfileDO, userProfileCO);
        return SingleResponse.of(userProfileCO);
    }
}
