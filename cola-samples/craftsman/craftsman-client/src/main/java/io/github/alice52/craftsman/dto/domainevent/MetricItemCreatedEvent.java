package io.github.alice52.craftsman.dto.domainevent;

import lombok.Data;

@Data
public class MetricItemCreatedEvent {

    private String id;

    private String userId;

    private String mainMetricType;
}
