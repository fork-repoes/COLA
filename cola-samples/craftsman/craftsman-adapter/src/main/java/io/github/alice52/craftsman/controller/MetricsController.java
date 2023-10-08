package io.github.alice52.craftsman.controller;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;

import io.github.alice52.craftsman.api.MetricsServiceI;
import io.github.alice52.craftsman.dto.ATAMetricAddCmd;
import io.github.alice52.craftsman.dto.ATAMetricQry;
import io.github.alice52.craftsman.dto.clientobject.ATAMetricCO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MetricsController {

    @Autowired private MetricsServiceI metricsService;

    @GetMapping(value = "/metrics/ata")
    public MultiResponse<ATAMetricCO> listATAMetrics(@RequestParam String ownerId) {
        ATAMetricQry ataMetricQry = new ATAMetricQry();
        ataMetricQry.setOwnerId(ownerId);
        return metricsService.listATAMetrics(ataMetricQry);
    }

    @PostMapping(value = "/metrics/ata")
    public Response addATAMetric(@RequestBody ATAMetricAddCmd ataMetricAddCmd) {
        return metricsService.addATAMetric(ataMetricAddCmd);
    }
}
