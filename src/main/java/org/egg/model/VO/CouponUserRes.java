package org.egg.model.VO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/19 11:57
 */
@Data
public class CouponUserRes {
    private Long id;

    private String couponId;

    private String userNo;
    /**
     * @see org.egg.enums.CouponUserStatusEnum
     */
    private String status;

    private Date expireDate;

    private Date createdDate;

    private Date modifiedDate;
    private String statusStr;

    private String couponType;
    private String couponTypeStr;

    private BigDecimal thresholdValue;

    private BigDecimal value;

    private String maxValue;

    private String giftFlag;

}
