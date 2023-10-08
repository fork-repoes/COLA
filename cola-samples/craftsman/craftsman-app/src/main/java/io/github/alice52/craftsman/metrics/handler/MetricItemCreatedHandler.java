package io.github.alice52.craftsman.metrics.handler;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;

import io.github.alice52.craftsman.api.UserProfileServiceI;
import io.github.alice52.craftsman.dto.RefreshScoreCmd;
import io.github.alice52.craftsman.dto.domainevent.MetricItemCreatedEvent;

import org.springframework.beans.factory.annotation.Autowired;

@CatchAndLog
public class MetricItemCreatedHandler {

    @Autowired private UserProfileServiceI userProfileService;

    public Response execute(MetricItemCreatedEvent event) {
        RefreshScoreCmd cmd = new RefreshScoreCmd(event.getUserId());
        userProfileService.refreshScore(cmd);
        return Response.buildSuccess();
    }
}
