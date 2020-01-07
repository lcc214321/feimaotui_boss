package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.egg.model.DO.CouponUser;
import org.egg.model.DO.CouponUserExample;

import java.util.List;

@Mapper
public interface CouponUserDAO {
    int countByExample(CouponUserExample example);

    int deleteByExample(CouponUserExample example);

    int insert(CouponUser record);

    int insertSelective(CouponUser record);

    List<CouponUser> selectByExample(CouponUserExample example);

    int updateByExampleSelective(@Param("record") CouponUser record, @Param("example") CouponUserExample example);

    int updateByExample(@Param("record") CouponUser record, @Param("example") CouponUserExample example);
}