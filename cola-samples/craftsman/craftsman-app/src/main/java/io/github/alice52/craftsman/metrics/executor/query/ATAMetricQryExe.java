package io.github.alice52.craftsman.metrics.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.fastjson.JSON;

import io.github.alice52.craftsman.domain.metrics.model.SubMetricType;
import io.github.alice52.craftsman.dto.ATAMetricQry;
import io.github.alice52.craftsman.dto.clientobject.ATAMetricCO;
import io.github.alice52.craftsman.metrics.entity.MetricDO;
import io.github.alice52.craftsman.metrics.mapper.MetricMapper;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

@Component
public class ATAMetricQryExe {

    @Resource private MetricMapper metricMapper;

    public MultiResponse<ATAMetricCO> execute(ATAMetricQry cmd) {
        List<MetricDO> metricDOList =
                metricMapper.listBySubMetric(
                        cmd.getOwnerId(), SubMetricType.ATA.getMetricSubTypeCode());
        List<ATAMetricCO> ataMetricCOList = new ArrayList<>();
        metricDOList.forEach(
                metricDO -> {
                    ATAMetricCO ataMetricCO =
                            JSON.parseObject(metricDO.getMetricItem(), ATAMetricCO.class);
                    ataMetricCO.setOwnerId(metricDO.getUserId());
                    ataMetricCOList.add(ataMetricCO);
                });
        return MultiResponse.of(ataMetricCOList);
    }
}
