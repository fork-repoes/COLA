package io.github.alice52.craftsman.domain.metrics.gateway;

import io.github.alice52.craftsman.domain.metrics.model.MetricItem;
import io.github.alice52.craftsman.domain.metrics.model.SubMetric;
import io.github.alice52.craftsman.domain.metrics.model.appquality.AppMetric;
import io.github.alice52.craftsman.domain.metrics.model.devquality.BugMetric;

import java.util.List;

/**
 * MetricGateway
 *
 * @author Frank Zhang
 * @date 2020-07-02 12:16 PM
 */
public interface MetricGateway {
    void save(MetricItem metricItem);

    List<SubMetric> listByTechContribution(String userId);

    List<SubMetric> listByTechInfluence(String userId);

    BugMetric getBugMetric(String userId);

    AppMetric getAppMetric(String userId);
}
