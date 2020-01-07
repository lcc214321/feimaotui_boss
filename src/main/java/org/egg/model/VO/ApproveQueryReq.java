package org.egg.model.VO;

import lombok.Data;
import org.egg.model.DO.Approve;

import java.util.Date;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/13 16:17
 */
@Data
public class ApproveQueryReq extends Approve {
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
