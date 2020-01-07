package org.egg.model.VO;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 查询单子对应的账户密码等信息
 * Created by chendatao on 2017/12/10.
 */
public class PublishOrderInfoReq implements Serializable {
    private static final long serialVersionUID = 3732374835481035328L;
    @NotBlank
    private String orderNo;


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

}
