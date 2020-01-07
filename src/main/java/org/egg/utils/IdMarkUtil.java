package org.egg.utils;

import org.apache.commons.lang3.StringUtils;
import org.egg.enums.TableTypeEnum;

import java.util.Date;
import java.util.Random;

/**
 * @author cdt
 * @Description id生成器
 * @date: 2017/11/14 17:53
 */
public class IdMarkUtil {

    /**
     * 唯一标识
     * @return
     */
    public static String getUniqId(TableTypeEnum tableTypeEnum) {
        Random random = new Random();
        return new StringBuilder(tableTypeEnum.getCode()).append(DateUtil.format(new Date(), DateUtil.YMDHMSSS)).append(String.format("%04d", Integer
                .valueOf(StringUtils.left(String.valueOf(Math.abs(random.nextInt())),4)))).toString();
    }

    /**
     * 生产7位的代理推荐码
     * @return
     */
    public static String getAgentCode() {
        Double s = Math.random() * 1000000 + 1000000;
        return ""+s.intValue();
    }


}
