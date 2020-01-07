/* https://github.com/cdt */
package org.egg.model.DO;

import java.io.Serializable;
import java.util.Date;

/** 
 * @author cdt
 * date:2018/08/13 18:26
 */
public class Recommend implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = 5235024218954452488L;

    private Long id;

    // 用户编号
    private String userNo;

    private String userName;
    // 推荐人用户编号
    private String recommendUserNo;

    private Integer recommendType;

    private String recommendUserName;

    private Date createdDate;

    private Date modifiedDate;

    // 备注
    private String remark;

    /** 
     * 获取 recommend.id
     * @return recommend.id
     */
    public final Long getId() {
        return id;
    }

    /** 
     * 设置 recommend.id
     * @param id recommend.id
     */
    public final void setId(Long id) {
        this.id = id;
    }

    /** 
     * 获取 用户编号 recommend.user_no
     * @return 用户编号
     */
    public final String getUserNo() {
        return userNo;
    }

    /** 
     * 设置 用户编号 recommend.user_no
     * @param userNo 用户编号
     */
    public final void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    /** 
     * 获取 推荐人用户编号 recommend.recommend_user_no
     * @return 推荐人用户编号
     */
    public final String getRecommendUserNo() {
        return recommendUserNo;
    }

    /** 
     * 设置 推荐人用户编号 recommend.recommend_user_no
     * @param recommendUserNo 推荐人用户编号
     */
    public final void setRecommendUserNo(String recommendUserNo) {
        this.recommendUserNo = recommendUserNo == null ? null : recommendUserNo.trim();
    }

    /** 
     * 获取 recommend.created_date
     * @return recommend.created_date
     */
    public final Date getCreatedDate() {
        return createdDate;
    }

    /** 
     * 设置 recommend.created_date
     * @param createdDate recommend.created_date
     */
    public final void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /** 
     * 获取 recommend.modified_date
     * @return recommend.modified_date
     */
    public final Date getModifiedDate() {
        return modifiedDate;
    }

    /** 
     * 设置 recommend.modified_date
     * @param modifiedDate recommend.modified_date
     */
    public final void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /** 
     * 获取 备注 recommend.remark
     * @return 备注
     */
    public final String getRemark() {
        return remark;
    }

    /** 
     * 设置 备注 recommend.remark
     * @param remark 备注
     */
    public final void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRecommendUserName() {
        return recommendUserName;
    }

    public void setRecommendUserName(String recommendUserName) {
        this.recommendUserName = recommendUserName;
    }

    public Integer getRecommendType() {
        return recommendType;
    }

    public void setRecommendType(Integer recommendType) {
        this.recommendType = recommendType;
    }
}