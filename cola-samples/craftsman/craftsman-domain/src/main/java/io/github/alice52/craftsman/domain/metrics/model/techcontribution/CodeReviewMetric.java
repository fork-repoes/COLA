package io.github.alice52.craftsman.domain.metrics.model.techcontribution;

import io.github.alice52.craftsman.domain.metrics.model.MainMetric;
import io.github.alice52.craftsman.domain.metrics.model.SubMetric;
import io.github.alice52.craftsman.domain.metrics.model.SubMetricType;

/**
 * CodeReview指标
 *
 * @author xueliang.sxl, alisa.hsh, xiangning.lxn
 */
public class CodeReviewMetric extends SubMetric {

    public CodeReviewMetric() {
        this.subMetricType = SubMetricType.CodeReview;
    }

    public CodeReviewMetric(MainMetric parent) {
        this.parent = parent;
        parent.addSubMetric(this);
        this.subMetricType = SubMetricType.CodeReview;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getUnanimousWeight();
    }
}
