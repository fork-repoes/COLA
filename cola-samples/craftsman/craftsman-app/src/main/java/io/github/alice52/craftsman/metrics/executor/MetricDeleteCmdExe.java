package io.github.alice52.craftsman.metrics.executor;

import com.alibaba.cola.dto.Response;

import io.github.alice52.craftsman.dto.MetricDeleteCmd;
import io.github.alice52.craftsman.metrics.mapper.MetricMapper;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * MetricDeleteCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-04 3:01 PM
 */
@Component
public class MetricDeleteCmdExe {

    @Resource private MetricMapper metricMapper;

    public Response execute(MetricDeleteCmd cmd) {

        metricMapper.delete(cmd.getMetricId(), cmd.getOperater());

        return Response.buildSuccess();
    }
}
