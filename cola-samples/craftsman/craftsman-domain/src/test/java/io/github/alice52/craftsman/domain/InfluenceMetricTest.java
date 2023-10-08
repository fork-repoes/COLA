package io.github.alice52.craftsman.domain;

import io.github.alice52.craftsman.domain.metrics.model.techinfluence.*;
import io.github.alice52.craftsman.domain.metrics.model.weight.DevWeight;
import io.github.alice52.craftsman.domain.metrics.model.weight.QAWeight;
import io.github.alice52.craftsman.domain.userprofile.model.UserProfile;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class InfluenceMetricTest {

    public static void prepareSubMetrics(InfluenceMetric influenceMetric) {
        ATAMetric ataMetric = new ATAMetric(influenceMetric);
        ataMetric.addMetricItem(new ATAMetricItem("article", 19, 99, 14, 2));
        ataMetric.addMetricItem(new ATAMetricItem("article", 20, 100, 15, 3));
        ataMetric.addMetricItem(new ATAMetricItem("article", 100, 500, 75, 15));

        PatentMetric patentMetric = new PatentMetric(influenceMetric);
        patentMetric.addMetricItem(
                new PatentMetricItem(
                        "patentName",
                        "patentDesc",
                        "patentNo",
                        "sharingLink",
                        AuthorType.FIRST_AUTHOR));
        patentMetric.addMetricItem(
                new PatentMetricItem(
                        "patentName",
                        "patentDesc",
                        "patentNo",
                        "sharingLink",
                        AuthorType.OTHER_AUTHOR));

        SharingMetric sharingMetric = new SharingMetric(influenceMetric);
        sharingMetric.addMetricItem(
                new SharingMetricItem("title", SharingScope.TEAM, new Date(), "sharingLink"));
        sharingMetric.addMetricItem(
                new SharingMetricItem("title", SharingScope.BU, new Date(), "sharingLink"));
        sharingMetric.addMetricItem(
                new SharingMetricItem("title", SharingScope.ALIBABA, new Date(), "sharingLink"));
        sharingMetric.addMetricItem(
                new SharingMetricItem("title", SharingScope.COMMUNITY, new Date(), "sharingLink"));
    }

    @Test
    public void testDevScore() {
        UserProfile userProfile = new UserProfile();
        userProfile.setWeight(new DevWeight());
        InfluenceMetric influenceMetric = new InfluenceMetric(userProfile);
        prepareSubMetrics(influenceMetric);

        Assert.assertEquals(124.5, influenceMetric.calculateScore(), 0.01);
    }

    @Test
    public void testQAScore() {
        UserProfile userProfile = new UserProfile();
        userProfile.setWeight(new QAWeight());
        InfluenceMetric influenceMetric = new InfluenceMetric(userProfile);
        prepareSubMetrics(influenceMetric);

        Assert.assertEquals(124.5, influenceMetric.calculateScore(), 0.01);
    }
}
