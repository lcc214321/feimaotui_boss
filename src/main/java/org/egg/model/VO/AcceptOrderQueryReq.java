package org.egg.model.VO;

import lombok.Data;
import org.egg.model.DO.AcceptOrder;

import java.util.Date;

/**
 * AcceptOrder分页查询实体
 */
@Data
public class AcceptOrderQueryReq extends AcceptOrder {
    private Date createdDateStart;

    private Date createdDateEnd;
    private Date timeDelayStart;
    private Date timeDelayEnd;

    /**
     * 每页数
     */
    private Integer pageNum;
    /**
     * 页码
     */
    private Integer pageNo;



    private Integer first;
    private Integer end;
    public Integer getFirst() {
        return (pageNo==null||pageNum==null)?null:(pageNo-1)*pageNum;
    }

    public Integer getEnd() {
        return pageNum;
    }

}