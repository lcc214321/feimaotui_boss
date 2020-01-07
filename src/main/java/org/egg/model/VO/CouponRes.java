package org.egg.model.VO;

import lombok.Data;
import org.egg.model.DO.Coupon;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/19 11:41
 */
@Data
public class CouponRes extends Coupon {
    private String couponTypeStr;

}
