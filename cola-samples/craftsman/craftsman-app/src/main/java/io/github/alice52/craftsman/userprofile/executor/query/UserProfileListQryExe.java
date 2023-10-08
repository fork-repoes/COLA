package io.github.alice52.craftsman.userprofile.executor.query;

import com.alibaba.cola.dto.MultiResponse;

import io.github.alice52.craftsman.dto.UserProfileListQry;
import io.github.alice52.craftsman.dto.clientobject.UserProfileCO;
import io.github.alice52.craftsman.userprofile.entity.UserProfileDO;
import io.github.alice52.craftsman.userprofile.mapper.UserProfileMapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

@Component
public class UserProfileListQryExe {

    @Resource private UserProfileMapper userProfileMapper;

    public MultiResponse<UserProfileCO> execute(UserProfileListQry qry) {
        List<UserProfileDO> userProfileDOList = userProfileMapper.listByDep(qry.getDep());
        List<UserProfileCO> userProfileCOList = new ArrayList<>();
        userProfileDOList.forEach(
                userDO -> {
                    UserProfileCO userProfileCO = new UserProfileCO();
                    BeanUtils.copyProperties(userDO, userProfileCO);
                    userProfileCOList.add(userProfileCO);
                });
        return MultiResponse.of(userProfileCOList);
    }
}
