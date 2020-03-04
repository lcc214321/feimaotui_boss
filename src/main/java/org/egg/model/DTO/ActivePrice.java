package org.egg.model.DTO;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author dataochen
 * @Description
 * @date: 2020/3/3 15:52
 */
@Data
public class ActivePrice extends RedisMqBase {
    private String name;
    private String type;
    private BigDecimal amount;
    private String userNo;
}
