package io.github.alice52.craftsman.domain.metrics.model.techcontribution;

import io.github.alice52.craftsman.domain.metrics.model.MainMetric;
import io.github.alice52.craftsman.domain.metrics.model.MainMetricType;
import io.github.alice52.craftsman.domain.userprofile.model.UserProfile;

import lombok.Data;

/**
 * ContributionMetric
 *
 * @author Frank Zhang
 * @date 2018-08-27 7:06 PM
 */
@Data
public class ContributionMetric extends MainMetric {

    private CodeReviewMetric codeReviewMetric;
    private RefactoringMetric refactoringMetric;
    private MiscMetric miscMetric;

    public ContributionMetric(UserProfile metricOwner) {
        this.metricOwner = metricOwner;
        metricOwner.setContributionMetric(this);
        this.metricMainType = MainMetricType.TECH_CONTRIBUTION;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getTechContributionWeight();
    }
}
