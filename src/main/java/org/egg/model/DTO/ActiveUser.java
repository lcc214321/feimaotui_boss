package org.egg.model.DTO;

import lombok.Data;

import java.util.Date;

/**
 * @author dataochen
 * @Description
 * @date: 2020/3/2 10:08
 */
@Data

public class ActiveUser {
    private String userNo;
    private String headUrl;
    private String nickName;
    private Integer integral;
    /**
     * 入队时间
     */
    private Date joinTime;
}
