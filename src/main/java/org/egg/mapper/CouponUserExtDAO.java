package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.egg.model.DO.CouponUserExample;
import org.egg.model.VO.CouponUserRes;

import java.util.List;

@Mapper
public interface CouponUserExtDAO {
    void expireCouponUpdate();

    List<CouponUserRes> queryList(CouponUserExample couponUserExample);


}