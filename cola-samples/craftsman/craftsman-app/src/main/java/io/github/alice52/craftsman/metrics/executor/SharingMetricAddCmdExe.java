package io.github.alice52.craftsman.metrics.executor;

import com.alibaba.cola.dto.Response;

import io.github.alice52.craftsman.domain.metrics.gateway.MetricGateway;
import io.github.alice52.craftsman.domain.metrics.model.techinfluence.InfluenceMetric;
import io.github.alice52.craftsman.domain.metrics.model.techinfluence.SharingMetric;
import io.github.alice52.craftsman.domain.metrics.model.techinfluence.SharingMetricItem;
import io.github.alice52.craftsman.domain.metrics.model.techinfluence.SharingScope;
import io.github.alice52.craftsman.domain.userprofile.model.UserProfile;
import io.github.alice52.craftsman.dto.SharingMetricAddCmd;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * SharingMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-02 5:00 PM
 */
@Component
public class SharingMetricAddCmdExe {

    @Resource private MetricGateway metricGateway;

    public Response execute(SharingMetricAddCmd cmd) {
        SharingMetricItem sharingMetricItem = new SharingMetricItem();
        BeanUtils.copyProperties(cmd.getSharingMetricCO(), sharingMetricItem);
        sharingMetricItem.setSubMetric(
                new SharingMetric(
                        new InfluenceMetric(
                                new UserProfile(cmd.getSharingMetricCO().getOwnerId()))));
        sharingMetricItem.setSharingScope(
                SharingScope.valueOf(cmd.getSharingMetricCO().getSharingScope()));
        metricGateway.save(sharingMetricItem);
        return Response.buildSuccess();
    }
}
