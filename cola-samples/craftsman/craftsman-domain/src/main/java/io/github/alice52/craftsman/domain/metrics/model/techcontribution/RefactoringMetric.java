package io.github.alice52.craftsman.domain.metrics.model.techcontribution;

import io.github.alice52.craftsman.domain.metrics.model.MainMetric;
import io.github.alice52.craftsman.domain.metrics.model.SubMetric;
import io.github.alice52.craftsman.domain.metrics.model.SubMetricType;

/**
 * 重构指标
 *
 * @author xueliang.sxl, alisa.hsh, xiangning.lxn
 */
public class RefactoringMetric extends SubMetric {

    public RefactoringMetric() {
        this.subMetricType = SubMetricType.Refactoring;
    }

    public RefactoringMetric(MainMetric parent) {
        this.parent = parent;
        parent.addSubMetric(this);
        this.subMetricType = SubMetricType.Refactoring;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getUnanimousWeight();
    }
}
