/* https://github.com/cdt */
package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.egg.model.DO.FeeRule;
import org.egg.model.VO.FeeRuleQueryReq;

/**
 * 本文件由 https://github.com/cdt/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author cdt
 * date:2018/07/22 16:45
 */
@Mapper
public interface FeeRuleDAO extends CustomMapper<FeeRuleQueryReq, FeeRule, Integer> {
}