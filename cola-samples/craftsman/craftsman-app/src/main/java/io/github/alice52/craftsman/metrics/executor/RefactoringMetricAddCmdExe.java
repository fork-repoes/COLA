package io.github.alice52.craftsman.metrics.executor;

import com.alibaba.cola.dto.Response;

import io.github.alice52.craftsman.domain.metrics.gateway.MetricGateway;
import io.github.alice52.craftsman.domain.metrics.model.techcontribution.ContributionMetric;
import io.github.alice52.craftsman.domain.metrics.model.techcontribution.RefactoringLevel;
import io.github.alice52.craftsman.domain.metrics.model.techcontribution.RefactoringMetric;
import io.github.alice52.craftsman.domain.metrics.model.techcontribution.RefactoringMetricItem;
import io.github.alice52.craftsman.domain.userprofile.model.UserProfile;
import io.github.alice52.craftsman.dto.RefactoringMetricAddCmd;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RefactoringMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:15 AM
 */
@Component
public class RefactoringMetricAddCmdExe {

    @Autowired private MetricGateway metricGateway;

    public Response execute(RefactoringMetricAddCmd cmd) {
        RefactoringMetricItem refactoringMetricItem = new RefactoringMetricItem();
        BeanUtils.copyProperties(cmd.getRefactoringMetricCO(), refactoringMetricItem);
        refactoringMetricItem.setSubMetric(
                new RefactoringMetric(
                        new ContributionMetric(
                                new UserProfile(cmd.getRefactoringMetricCO().getOwnerId()))));
        refactoringMetricItem.setRefactoringLevel(
                RefactoringLevel.valueOf(cmd.getRefactoringMetricCO().getRefactoringLevel()));
        metricGateway.save(refactoringMetricItem);
        return Response.buildSuccess();
    }
}
