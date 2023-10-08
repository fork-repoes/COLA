package io.github.alice52.craftsman.metrics.convertor;

import io.github.alice52.craftsman.domain.metrics.model.MetricItem;
import io.github.alice52.craftsman.metrics.entity.MetricDO;

/**
 * @author frankzhang
 */
public class MetricConvertor {

    public static MetricDO toDataObject(MetricItem metricItem) {
        MetricDO metricDO = new MetricDO();
        metricDO.setUserId(metricItem.getMetricOwner().getUserId());
        metricDO.setMainMetric(metricItem.getSubMetric().getParent().getCode());
        metricDO.setSubMetric(metricItem.getSubMetric().getCode());
        metricDO.setMetricItem(metricItem.toJsonString());
        metricDO.setCreator("test");
        metricDO.setModifier("test");
        return metricDO;
    }
}
