package io.github.alice52.craftsman.userprofile.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;

import io.github.alice52.craftsman.api.UserProfileServiceI;
import io.github.alice52.craftsman.dto.*;
import io.github.alice52.craftsman.dto.clientobject.UserProfileCO;
import io.github.alice52.craftsman.userprofile.executor.RefreshScoreCmdExe;
import io.github.alice52.craftsman.userprofile.executor.UserProfileAddCmdExe;
import io.github.alice52.craftsman.userprofile.executor.UserProfileUpdateCmdExe;
import io.github.alice52.craftsman.userprofile.executor.query.UserProfileGetQryExe;
import io.github.alice52.craftsman.userprofile.executor.query.UserProfileListQryExe;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserProfileServiceImpl
 *
 * @author Frank Zhang
 * @date 2019-02-28 6:22 PM
 */
@Service
@CatchAndLog
public class UserProfileServiceImpl implements UserProfileServiceI {
    @Resource private UserProfileAddCmdExe userProfileAddCmdExe;
    @Resource private UserProfileUpdateCmdExe userProfileUpdateCmdExe;
    @Resource private RefreshScoreCmdExe refreshScoreCmdExe;
    @Resource private UserProfileGetQryExe userProfileGetQryExe;
    @Resource private UserProfileListQryExe userProfileListQryExe;

    @Override
    public Response addUserProfile(UserProfileAddCmd userProfileAddCmd) {
        return userProfileAddCmdExe.execute(userProfileAddCmd);
    }

    @Override
    public Response updateUserProfile(UserProfileUpdateCmd cmd) {
        return userProfileUpdateCmdExe.execute(cmd);
    }

    @Override
    public Response refreshScore(RefreshScoreCmd cmd) {
        return refreshScoreCmdExe.execute(cmd);
    }

    @Override
    public SingleResponse<UserProfileCO> getUserProfileBy(UserProfileGetQry qry) {
        return userProfileGetQryExe.execute(qry);
    }

    @Override
    public MultiResponse<UserProfileCO> listUserProfileBy(UserProfileListQry qry) {
        return userProfileListQryExe.execute(qry);
    }
}
