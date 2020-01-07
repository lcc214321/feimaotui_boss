package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.egg.model.DO.Coupon;
import org.egg.model.DO.CouponExample;

import java.util.List;

@Mapper
public interface CouponDAO {
    int countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    List<Coupon> selectByExample(CouponExample example);

    int updateByExampleSelective(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByExample(@Param("record") Coupon record, @Param("example") CouponExample example);
}