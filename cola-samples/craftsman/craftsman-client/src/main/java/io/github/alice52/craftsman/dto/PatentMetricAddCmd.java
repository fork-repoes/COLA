package io.github.alice52.craftsman.dto;

import io.github.alice52.craftsman.dto.clientobject.PatentMetricCO;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * PatentMetricAddCmd
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:37 AM
 */
@Data
public class PatentMetricAddCmd extends CommonCommand {
    @NotNull private PatentMetricCO patentMetricCO;
}
