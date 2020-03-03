package org.egg.model.VO;

/**
 * @author dataochen
 * @Description
 * @date: 2020/3/3 17:45
 */

public class ActiveQueryReq {


    private Integer minIntegralTotal;
    private String orderByColumn;
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

    public Integer getMinIntegralTotal() {
        return minIntegralTotal;
    }

    public void setMinIntegralTotal(Integer minIntegralTotal) {
        this.minIntegralTotal = minIntegralTotal;
    }

    public String getOrderByColumn() {
        return orderByColumn;
    }

    public void setOrderByColumn(String orderByColumn) {
        this.orderByColumn = orderByColumn;
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
}
