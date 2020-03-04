package org.egg.model.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author dataochen
 * @Description
 * @date: 2020/3/2 10:00
 */
@Data
public class ActiveTeam implements Serializable {
    private String teamNo;
    private List<ActiveUser> userList;
    private String teamName;
    private Date createdTime;
    /**
     * 积分
     */
    private Integer integralTotal;
    /**
     * 开奖状态 OFF/ON
     */
    private String priceStatus;
}
