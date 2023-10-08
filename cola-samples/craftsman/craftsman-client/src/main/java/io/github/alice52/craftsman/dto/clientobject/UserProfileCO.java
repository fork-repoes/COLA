package io.github.alice52.craftsman.dto.clientobject;

import com.alibaba.cola.dto.ClientObject;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserProfileCO extends ClientObject {

    public static final String IS_MANAGER = "y";
    public static final String IS_NOT_MANAGER = "n";

    public static final String DEV_ROLE = "DEV";
    public static final String QA_ROLE = "QA";
    public static final String OTHER_ROLE = "OTHER";

    @NotEmpty private String userId;
    private String userName;
    private String dep;
    private String role;
    private String isManager;

    /** 综合得分 */
    private double totalScore;

    /** 代码质量分 */
    private double appQualityScore;

    /** 技术影响力分 */
    private double techInfluenceScore;

    /** 技术贡献分 */
    private double techContributionScore;

    /** 开发质量分 */
    private double devQualityScore;

    /** checkin代码量 */
    private double checkinCodeQuantity;
}
