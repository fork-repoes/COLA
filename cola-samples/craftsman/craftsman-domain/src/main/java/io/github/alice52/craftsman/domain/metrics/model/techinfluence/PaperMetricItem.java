package io.github.alice52.craftsman.domain.metrics.model.techinfluence;

import com.alibaba.fastjson.JSON;

import io.github.alice52.craftsman.domain.metrics.model.MetricItem;

import lombok.Data;

/**
 * PaperMetricItem
 *
 * @author Frank Zhang
 * @date 2018-09-20 3:26 PM
 */
@Data
public class PaperMetricItem extends MetricItem {

    private static final double PAPER_SCORE = 10;
    private String paperName;
    private String paperDesc;
    private String magazine;
    private String paperLink;

    public PaperMetricItem() {}

    public PaperMetricItem(String paperName, String paperDesc, String magazine, String paperLink) {
        this.paperName = paperName;
        this.paperDesc = paperDesc;
        this.magazine = magazine;
        this.paperLink = paperLink;
    }

    public static PaperMetricItem valueOf(String json) {
        return JSON.parseObject(json, PaperMetricItem.class);
    }

    @Override
    public double calculateScore() {
        return PAPER_SCORE;
    }
}
