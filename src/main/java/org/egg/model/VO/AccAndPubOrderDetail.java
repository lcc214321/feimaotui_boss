package org.egg.model.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by chendatao on 2017/12/13.
 */
@Data
public class AccAndPubOrderDetail implements Serializable {
    private AcceptOrderRes acceptOrderRes;

    private PublishOrderRes publishOrderRes;
    /**
     * 需求单取件凭证
     */
    private String scoNo;
}
