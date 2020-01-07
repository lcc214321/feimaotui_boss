package org.egg.model.VO;


import org.egg.model.DO.ShareRecord;

public class ShareRecordVo extends ShareRecord {

    private String shareTypeStr;
    private String shareStatusStr;
    private String createdDateStr;

    public String getShareTypeStr() {
        return shareTypeStr;
    }

    public void setShareTypeStr(String shareTypeStr) {
        this.shareTypeStr = shareTypeStr;
    }

    public String getShareStatusStr() {
        return shareStatusStr;
    }

    public void setShareStatusStr(String shareStatusStr) {
        this.shareStatusStr = shareStatusStr;
    }

    public String getCreatedDateStr() {
        return createdDateStr;
    }

    public void setCreatedDateStr(String createdDateStr) {
        this.createdDateStr = createdDateStr;
    }

}
