package org.egg.model.VO;

import org.egg.model.DO.Recommend;

/**
 * @author cdt
 * @Description
 * @date: 2018/9/21 15:40
 */
public class RecommendRes extends Recommend {
    private String recommendTypeStr;

    public String getRecommendTypeStr() {
        return recommendTypeStr;
    }

    public void setRecommendTypeStr(String recommendTypeStr) {
        this.recommendTypeStr = recommendTypeStr;
    }
}
