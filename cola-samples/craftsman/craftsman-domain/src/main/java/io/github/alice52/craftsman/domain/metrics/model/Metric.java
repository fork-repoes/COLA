package io.github.alice52.craftsman.domain.metrics.model;

import com.alibaba.cola.domain.Entity;

import io.github.alice52.craftsman.domain.userprofile.model.UserProfile;

import lombok.Getter;
import lombok.Setter;

/**
 * Metric 指标
 *
 * @author Frank Zhang
 * @date 2018-07-04 1:23 PM
 */
@Entity
public abstract class Metric implements Measurable {

    @Getter @Setter protected UserProfile metricOwner;
    private double score;

    public Metric() {}

    public Metric(UserProfile metricOwner) {
        this.metricOwner = metricOwner;
    }

    /**
     * 度量名称，用于UI显示
     *
     * @return
     */
    public abstract String getName();

    /**
     * 度量Code，用于数据库存储
     *
     * @return
     */
    public abstract String getCode();

    public abstract double getWeight();

    @Override
    public String toString() {
        return this.getName() + " " + this.score;
    }
}
