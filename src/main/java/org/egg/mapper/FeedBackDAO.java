/* https://github.com/cdt */
package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.egg.model.DO.FeedBack;
import org.egg.model.VO.FeedBackQueryReq;

/**
 * 本文件由 https://github.com/cdt/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author cdt
 * date:2018/03/05 21:21
 */
@Mapper
public interface FeedBackDAO extends CustomMapper<FeedBackQueryReq, FeedBack, String> {
}