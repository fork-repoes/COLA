package io.github.alice52.craftsman.dto.clientobject;

import lombok.Data;

/**
 * SharingMetricCO
 *
 * @author Frank Zhang
 * @date 2019-03-02 4:55 PM
 */
@Data
public class SharingMetricCO extends AbstractMetricCO {

    public static final String TEAM_SCOPE = "TEAM";
    public static final String BU_SCOPE = "BU";
    public static final String ALIBABA_SCOPE = "ALIBABA";
    public static final String COMMUNITY_SCOPE = "COMMUNITY";

    /** 分享标题 */
    private String sharingName;

    /** 分享范围 */
    private String sharingScope;

    /** 分享日期 */
    private String sharingDate;

    /** 分享文档链接 */
    private String sharingLink;
}
