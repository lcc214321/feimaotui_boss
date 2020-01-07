package org.egg.utils;

import org.apache.commons.lang3.StringUtils;
import org.egg.enums.CommonErrorEnum;
import org.egg.exception.CommonException;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by chendatao on 2017/12/3.
 */
public class CheckUtil {
    /**
     * 检查
     * @param obj
     * @return
     */
    public static final void isNotBlank(String objName,String obj) {
        if (StringUtils.isBlank(obj)) {
            throw new CommonException(CommonErrorEnum.PARAM_ERROR.getCode(), new StringBuilder(objName).append(" 不能为空，为必填项").toString());
        }
    }
    public static final void isNotNull(String objName,Object obj) {
        if (null==obj) {
            throw new CommonException(CommonErrorEnum.PARAM_ERROR.getCode(), new StringBuilder(objName).append(" is null").toString());
        }
    }

    public static final void isNotEmpty(String objName, Object obj) {
        if (null == obj) {
            throw new CommonException(CommonErrorEnum.PARAM_ERROR.getCode(), new StringBuilder(objName).append(" is null").toString());
        }
        if (obj instanceof BigDecimal) {
            if (BigDecimal.ZERO.compareTo((BigDecimal) obj) > -1) {
                throw new CommonException(CommonErrorEnum.PARAM_ERROR.getCode(), new StringBuilder(objName).append(" is less than or equal to zero,is ").append((BigDecimal) obj).toString());

            }
        }
        if (obj instanceof Collection) {
            if (CollectionUtils.isEmpty((Collection) obj)) {
                throw new CommonException(CommonErrorEnum.PARAM_ERROR.getCode(), new StringBuilder(objName).append(" is empty collection").toString());

            }
        }
    }


}
