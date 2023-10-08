package io.github.alice52.craftsman.domain.metrics.model.techinfluence;

import io.github.alice52.craftsman.domain.metrics.model.MainMetric;
import io.github.alice52.craftsman.domain.metrics.model.SubMetric;
import io.github.alice52.craftsman.domain.metrics.model.SubMetricType;

/**
 * SharingMetric 线下技术分享指标
 *
 * @author Frank Zhang
 * @date 2018-07-04 1:25 PM
 */
public class SharingMetric extends SubMetric {

    public SharingMetric() {
        this.subMetricType = SubMetricType.Sharing;
    }

    public SharingMetric(MainMetric parent) {
        this.parent = parent;
        parent.addSubMetric(this);
        this.subMetricType = SubMetricType.Sharing;
    }

    @Override
    public double getWeight() {
        return parent.getMetricOwner().getWeight().getUnanimousWeight();
    }
}
