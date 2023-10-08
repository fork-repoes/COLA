package io.github.alice52.craftsman.metrics.executor;

import com.alibaba.cola.dto.Response;

import io.github.alice52.craftsman.domain.metrics.gateway.MetricGateway;
import io.github.alice52.craftsman.domain.metrics.model.techinfluence.AuthorType;
import io.github.alice52.craftsman.domain.metrics.model.techinfluence.InfluenceMetric;
import io.github.alice52.craftsman.domain.metrics.model.techinfluence.PatentMetric;
import io.github.alice52.craftsman.domain.metrics.model.techinfluence.PatentMetricItem;
import io.github.alice52.craftsman.domain.userprofile.model.UserProfile;
import io.github.alice52.craftsman.dto.PatentMetricAddCmd;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * PatentMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:41 AM
 */
@Component
public class PatentMetricAddCmdExe {

    @Resource private MetricGateway metricGateway;

    public Response execute(PatentMetricAddCmd cmd) {
        PatentMetricItem patentMetricItem = new PatentMetricItem();
        BeanUtils.copyProperties(cmd.getPatentMetricCO(), patentMetricItem);
        patentMetricItem.setSubMetric(
                new PatentMetric(
                        new InfluenceMetric(
                                new UserProfile(cmd.getPatentMetricCO().getOwnerId()))));
        patentMetricItem.setAuthorType(AuthorType.valueOf(cmd.getPatentMetricCO().getAuthorType()));
        metricGateway.save(patentMetricItem);
        return Response.buildSuccess();
    }
}
