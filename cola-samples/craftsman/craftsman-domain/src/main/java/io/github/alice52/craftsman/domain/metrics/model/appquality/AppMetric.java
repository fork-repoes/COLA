package io.github.alice52.craftsman.domain.metrics.model.appquality;

import io.github.alice52.craftsman.domain.metrics.model.SubMetric;
import io.github.alice52.craftsman.domain.metrics.model.SubMetricType;

public class AppMetric extends SubMetric {

    public AppMetric() {
        this.subMetricType = SubMetricType.App;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getUnanimousWeight();
    }

    @Override
    public double calculateScore() {
        int appCount = super.getMetricItemList().size();
        if (appCount == 0) {
            return 0;
        }
        double sumScore = super.calculateScore();
        return sumScore / appCount;
    }
}
