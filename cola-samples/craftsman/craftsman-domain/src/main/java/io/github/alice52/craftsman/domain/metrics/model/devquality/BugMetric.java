package io.github.alice52.craftsman.domain.metrics.model.devquality;

import io.github.alice52.craftsman.domain.metrics.model.SubMetric;
import io.github.alice52.craftsman.domain.metrics.model.SubMetricType;
import io.github.alice52.craftsman.domain.userprofile.model.Role;

/** BUG数指标 */
public class BugMetric extends SubMetric {

    public BugMetric() {
        this.subMetricType = SubMetricType.Bug;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getUnanimousWeight();
    }

    @Override
    public double calculateScore() {
        if (metricOwner.getRole() == Role.OTHER) {
            return 0;
        }
        return super.calculateScore();
    }
}
