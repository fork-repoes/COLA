package io.github.alice52.craftsman.domain;

import io.github.alice52.craftsman.domain.metrics.model.techinfluence.InfluenceMetric;
import io.github.alice52.craftsman.domain.metrics.model.techinfluence.SharingMetric;
import io.github.alice52.craftsman.domain.metrics.model.techinfluence.SharingMetricItem;
import io.github.alice52.craftsman.domain.metrics.model.techinfluence.SharingScope;
import io.github.alice52.craftsman.domain.userprofile.model.UserProfile;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * SharingMetricTest
 *
 * @author Frank Zhang
 * @date 2019-02-26 4:14 PM
 */
public class SharingMetricTest {

    @Test
    public void testSharingMetric() {
        SharingMetric sharingMetric = new SharingMetric(new InfluenceMetric(new UserProfile()));
        sharingMetric.addMetricItem(
                new SharingMetricItem("title", SharingScope.TEAM, new Date(), "sharingLink"));
        sharingMetric.addMetricItem(
                new SharingMetricItem("title", SharingScope.BU, new Date(), "sharingLink"));
        sharingMetric.addMetricItem(
                new SharingMetricItem("title", SharingScope.ALIBABA, new Date(), "sharingLink"));
        sharingMetric.addMetricItem(
                new SharingMetricItem("title", SharingScope.COMMUNITY, new Date(), "sharingLink"));

        Assert.assertEquals(92, sharingMetric.calculateScore(), 0.01);
    }
}
