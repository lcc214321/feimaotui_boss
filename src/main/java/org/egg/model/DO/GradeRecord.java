package org.egg.model.DO;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class GradeRecord {
    private Long id;
    @NotBlank
    private Integer score;

    private String targetUserNo;

    private String userNo;

    @NotBlank
    private String acceptRecordNo;

    private String content;

    private Date createdDate;

    private Date modifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTargetUserNo() {
        return targetUserNo;
    }

    public void setTargetUserNo(String targetUserNo) {
        this.targetUserNo = targetUserNo == null ? null : targetUserNo.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getAcceptRecordNo() {
        return acceptRecordNo;
    }

    public void setAcceptRecordNo(String acceptRecordNo) {
        this.acceptRecordNo = acceptRecordNo == null ? null : acceptRecordNo.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}