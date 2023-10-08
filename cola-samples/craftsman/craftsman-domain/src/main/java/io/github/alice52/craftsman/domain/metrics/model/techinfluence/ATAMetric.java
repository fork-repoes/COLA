package io.github.alice52.craftsman.domain.metrics.model.techinfluence;

import io.github.alice52.craftsman.domain.metrics.model.MainMetric;
import io.github.alice52.craftsman.domain.metrics.model.SubMetric;
import io.github.alice52.craftsman.domain.metrics.model.SubMetricType;

/**
 * ATAMetric ATA文章指标
 *
 * @author Frank Zhang
 * @date 2018-07-04 1:24 PM
 */
public class ATAMetric extends SubMetric {

    public ATAMetric() {
        this.subMetricType = SubMetricType.ATA;
    }

    public ATAMetric(MainMetric parent) {
        this.parent = parent;
        parent.addSubMetric(this);
        this.subMetricType = SubMetricType.ATA;
    }

    @Override
    public double getWeight() {
        return parent.getMetricOwner().getWeight().getUnanimousWeight();
    }
}
