package org.egg.model.VO;

import org.egg.model.DO.ShareRecord;

import java.util.Date;

/**
 * ShareRecord分页查询实体
 */
public class ShareRecordQueryReq extends ShareRecord {
    private Date createdDateStart;

    private Date createdDateEnd;

    /**
     * 每页数
     */
    private Integer pageNum;
    /**
     * 页码
     */
    private Integer pageNo;
    /**
     * 排序字段
     * 默认 发布时间
     */
    private String orderColumn;

    /**
     * 是否正序
     */
    private Boolean ascFlag;
    private Integer first;
    private Integer end;



    public Date getCreatedDateStart() {
        return createdDateStart;
    }

    public void setCreatedDateStart(Date createdDateStart) {
        this.createdDateStart = createdDateStart;
    }

    public Date getCreatedDateEnd() {
        return createdDateEnd;
    }

    public void setCreatedDateEnd(Date createdDateEnd) {
        this.createdDateEnd = createdDateEnd;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public Boolean getAscFlag() {
        return ascFlag;
    }

    public void setAscFlag(Boolean ascFlag) {
        this.ascFlag = ascFlag;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}