/* https://github.com/cdt */
package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.egg.model.DO.Recommend;
import org.egg.model.VO.RecommendQueryReq;

/**
 * 本文件由 https://github.com/cdt/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author cdt
 * date:2018/08/13 18:26
 */
@Mapper
public interface RecommendDAO extends CustomMapper<RecommendQueryReq, Recommend, Long> {
}