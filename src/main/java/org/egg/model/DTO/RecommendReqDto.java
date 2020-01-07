package org.egg.model.DTO;

import java.math.BigDecimal;

/**
 * @author cdt
 * @Description 推荐奖励dto
 * @date: 2018/8/13 19:56
 */
public class RecommendReqDto {
    /**
     * 被推荐的用户
     */
    private String userNo;
    /**
     * 推荐人
     */
    private String recommendUserNo;
    /**
     * 计算奖励金依赖的平台手续费
     */
    private BigDecimal fee;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getRecommendUserNo() {
        return recommendUserNo;
    }

    public void setRecommendUserNo(String recommendUserNo) {
        this.recommendUserNo = recommendUserNo;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
