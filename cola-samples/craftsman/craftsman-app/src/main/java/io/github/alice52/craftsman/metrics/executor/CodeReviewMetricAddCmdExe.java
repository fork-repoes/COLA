package io.github.alice52.craftsman.metrics.executor;

import com.alibaba.cola.dto.Response;

import io.github.alice52.craftsman.domain.metrics.gateway.MetricGateway;
import io.github.alice52.craftsman.domain.metrics.model.techcontribution.CodeReviewMetric;
import io.github.alice52.craftsman.domain.metrics.model.techcontribution.CodeReviewMetricItem;
import io.github.alice52.craftsman.domain.metrics.model.techcontribution.ContributionMetric;
import io.github.alice52.craftsman.domain.userprofile.model.UserProfile;
import io.github.alice52.craftsman.dto.CodeReviewMetricAddCmd;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * CodeReviewMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:14 AM
 */
@Component
public class CodeReviewMetricAddCmdExe {

    @Autowired private MetricGateway metricGateway;

    public Response execute(CodeReviewMetricAddCmd cmd) {
        CodeReviewMetricItem codeReviewMetricItem = new CodeReviewMetricItem();
        BeanUtils.copyProperties(cmd, codeReviewMetricItem);
        codeReviewMetricItem.setSubMetric(
                new CodeReviewMetric(new ContributionMetric(new UserProfile(cmd.getOwnerId()))));
        metricGateway.save(codeReviewMetricItem);
        return Response.buildSuccess();
    }
}
