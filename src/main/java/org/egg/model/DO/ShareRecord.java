/* https://github.com/dataochen */
package org.egg.model.DO;

import java.io.Serializable;
import java.util.Date;

/** 
 * @author dataochen
 * date:2018/04/16 14:48
 */
public class ShareRecord implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = 841321708090474806L;

    private Integer id;

    private String userNo;
//0.朋友圈分享 1.发送给朋友 2.qq 3.微博 4.qq空间
    private Integer shareType;

    // 0:已分享 1：取消分享
    private Integer shareStatus;

    private Date createdDate;

    /** 
     * 获取 share_record.id
     * @return share_record.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 share_record.id
     * @param id share_record.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 share_record.user_no
     * @return share_record.user_no
     */
    public final String getUserNo() {
        return userNo;
    }

    /** 
     * 设置 share_record.user_no
     * @param userNo share_record.user_no
     */
    public final void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    /** 
     * 获取 share_record.share_type
     * @return share_record.share_type
     */
    public final Integer getShareType() {
        return shareType;
    }

    /** 
     * 设置 share_record.share_type
     * @param shareType share_record.share_type
     */
    public final void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    /** 
     * 获取 0:已分享 1：取消分享 share_record.share_status
     * @return 0:已分享 1：取消分享
     */
    public final Integer getShareStatus() {
        return shareStatus;
    }

    /** 
     * 设置 0:已分享 1：取消分享 share_record.share_status
     * @param shareStatus 0:已分享 1：取消分享
     */
    public final void setShareStatus(Integer shareStatus) {
        this.shareStatus = shareStatus;
    }

    /** 
     * 获取 share_record.created_date
     * @return share_record.created_date
     */
    public final Date getCreatedDate() {
        return createdDate;
    }

    /** 
     * 设置 share_record.created_date
     * @param createdDate share_record.created_date
     */
    public final void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", userNo=").append(userNo);
        sb.append(", shareType=").append(shareType);
        sb.append(", shareStatus=").append(shareStatus);
        sb.append(", createdDate=").append(createdDate);
        sb.append("]");
        return sb.toString();
    }
}