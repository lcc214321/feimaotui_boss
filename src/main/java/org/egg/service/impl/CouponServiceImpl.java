package org.egg.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.egg.mapper.CouponDAO;
import org.egg.model.DO.Coupon;
import org.egg.model.DO.CouponExample;
import org.egg.model.VO.CouponQueryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/19 11:38
 */
@Component
@Slf4j
public class CouponServiceImpl {
    @Autowired
    private CouponDAO couponDAO;

    public int queryCount(CouponQueryReq couponQueryReq) {
        CouponExample couponExample = new CouponExample();
        convert(couponQueryReq, couponExample);
        return couponDAO.countByExample(couponExample);
    }

    public List<Coupon> queryList(CouponQueryReq couponQueryReq) {
        CouponExample couponExample = new CouponExample();
        convert(couponQueryReq, couponExample);
        return couponDAO.selectByExample(couponExample);
    }

    public void insert(Coupon coupon) {
        coupon.setCreatedDate(new Date());
        couponDAO.insertSelective(coupon);
    }

    public void update(Coupon coupon) {
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        criteria.andIdEqualTo(coupon.getId());
        couponDAO.updateByExampleSelective(coupon, couponExample);
    }
    public void convert(CouponQueryReq example, CouponExample couponExample) {
        CouponExample.Criteria criteria = couponExample.createCriteria();

        if (example.getCreatedDate() != null) {
            criteria.andCreatedDateEqualTo(example.getCreatedDate());
        }
        if (example.getCreatedDateStart() != null) {
            criteria.andCreatedDateGreaterThanOrEqualTo(example.getCreatedDateStart());
        }
        if (example.getCreatedDateEnd() != null) {
            criteria.andCreatedDateLessThanOrEqualTo(example.getCreatedDateStart());
        }
        if (example.getFirst() != null) {
            couponExample.setStart(example.getFirst());
            couponExample.setEnd(example.getEnd());
        }
//        参数

    }
}
