package org.egg.model.DO;/* https://github.com/cdt */

import org.egg.enums.CreditScoreSourceTypeEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cdt
 * date:2018/03/16 19:32
 */
public class CreditScoreFlow implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = 1723525280671462570L;

    private Long id;

    private String recordNo;

    private String userNo;

    // 信誉分
    private Integer score;

    // 操作类型 0：增加 1：扣减
    private Integer operType;
    /**
     * 操作类型 CreditScoreSourceTypeEnum.code
     * @see CreditScoreSourceTypeEnum
     */
    private String recordType;
    // 备注
    private String remark;

    private Date createdDate;

    private Integer version;

    /**
     * 获取 credit_score_flow.id
     * @return credit_score_flow.id
     */
    public final Long getId() {
        return id;
    }

    /**
     * 设置 credit_score_flow.id
     * @param id credit_score_flow.id
     */
    public final void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 credit_score_flow.record_no
     * @return credit_score_flow.record_no
     */
    public final String getRecordNo() {
        return recordNo;
    }

    /**
     * 设置 credit_score_flow.record_no
     * @param recordNo credit_score_flow.record_no
     */
    public final void setRecordNo(String recordNo) {
        this.recordNo = recordNo == null ? null : recordNo.trim();
    }

    /**
     * 获取 credit_score_flow.user_no
     * @return credit_score_flow.user_no
     */
    public final String getUserNo() {
        return userNo;
    }

    /**
     * 设置 credit_score_flow.user_no
     * @param userNo credit_score_flow.user_no
     */
    public final void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    /**
     * 获取 信誉分 credit_score_flow.score
     * @return 信誉分
     */
    public final Integer getScore() {
        return score;
    }

    /**
     * 设置 信誉分 credit_score_flow.score
     * @param score 信誉分
     */
    public final void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取 操作类型 0：增加 1：扣减 credit_score_flow.oper_type
     * @return 操作类型 0：增加 1：扣减
     */
    public final Integer getOperType() {
        return operType;
    }

    /**
     * 设置 操作类型 0：增加 1：扣减 credit_score_flow.oper_type
     * @param operType 操作类型 0：增加 1：扣减
     */
    public final void setOperType(Integer operType) {
        this.operType = operType;
    }

    /**
     * 获取 备注 credit_score_flow.remark
     * @return 备注
     */
    public final String getRemark() {
        return remark;
    }

    /**
     * 设置 备注 credit_score_flow.remark
     * @param remark 备注
     */
    public final void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 credit_score_flow.created_date
     * @return credit_score_flow.created_date
     */
    public final Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 设置 credit_score_flow.created_date
     * @param createdDate credit_score_flow.created_date
     */
    public final void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取 credit_score_flow.version
     * @return credit_score_flow.version
     */
    public final Integer getVersion() {
        return version;
    }

    /**
     * 设置 credit_score_flow.version
     * @param version credit_score_flow.version
     */
    public final void setVersion(Integer version) {
        this.version = version;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"recordNo\":\"")
                .append(recordNo).append('\"');
        sb.append(",\"userNo\":\"")
                .append(userNo).append('\"');
        sb.append(",\"score\":")
                .append(score);
        sb.append(",\"operType\":")
                .append(operType);
        sb.append(",\"recordType\":\"")
                .append(recordType).append('\"');
        sb.append(",\"remark\":\"")
                .append(remark).append('\"');
        sb.append(",\"createdDate\":\"")
                .append(createdDate).append('\"');
        sb.append(",\"version\":")
                .append(version);
        sb.append('}');
        return sb.toString();
    }
}