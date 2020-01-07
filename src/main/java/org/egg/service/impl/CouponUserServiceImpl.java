package org.egg.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.egg.enums.CouponTypeEnum;
import org.egg.enums.CouponUserStatusEnum;
import org.egg.mapper.CouponUserDAO;
import org.egg.mapper.CouponUserExtDAO;
import org.egg.model.DO.CouponUser;
import org.egg.model.DO.CouponUserExample;
import org.egg.model.VO.CouponUserQueryReq;
import org.egg.model.VO.CouponUserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/19 15:18
 */
@Component
@Slf4j
public class CouponUserServiceImpl {
    @Autowired
    private CouponUserDAO couponUserDAO;
    @Autowired
    private CouponUserExtDAO couponUserExtDAO;

    public int queryCount(CouponUserQueryReq couponUserQueryReq) {
        CouponUserExample couponUserExample = new CouponUserExample();
        convert(couponUserQueryReq, couponUserExample);
        return couponUserDAO.countByExample(couponUserExample);
    }

    public List<CouponUser> queryList(CouponUserQueryReq couponUserQueryReq) {
        CouponUserExample couponUserExample = new CouponUserExample();
        convert(couponUserQueryReq, couponUserExample);
        return couponUserDAO.selectByExample(couponUserExample);
    }

    public void insertRecord(CouponUser couponUser) {
        couponUser.setStatus(CouponUserStatusEnum.NOT_USED.getCode());
        couponUser.setCreatedDate(new Date());
        couponUserDAO.insertSelective(couponUser);
    }

    public List<CouponUserRes> queryList4Base(CouponUserQueryReq couponUserQueryReq) {
        CouponUserExample couponUserExample = new CouponUserExample();
        convert(couponUserQueryReq, couponUserExample);
        List<CouponUserRes> couponUserRes = couponUserExtDAO.queryList(couponUserExample);
        if (!CollectionUtils.isEmpty(couponUserRes)) {
            List<CouponUserRes> collect = couponUserRes.stream().map(item -> {
                item.setStatusStr(CouponUserStatusEnum.getDescByCode(item.getStatus()));
                item.setCouponTypeStr(CouponTypeEnum.getDescByCode(item.getCouponType()));
                return item;
            }).collect(Collectors.toList());
            return collect;
        }
        return couponUserRes;
    }

    public void expireCouponUpdate() {
        couponUserExtDAO.expireCouponUpdate();
    }

    public void updateStatus(CouponUser couponUser, String originStatus) {
        CouponUserExample couponUserExample = new CouponUserExample();
        CouponUserExample.Criteria criteria = couponUserExample.createCriteria();
        criteria.andIdEqualTo(couponUser.getId());
        criteria.andStatusEqualTo(originStatus);
        couponUserDAO.updateByExampleSelective(couponUser, couponUserExample);
    }

    public void convert(CouponUserQueryReq example, CouponUserExample couponUserExample) {
        CouponUserExample.Criteria criteria = couponUserExample.createCriteria();

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
            couponUserExample.setStart(example.getFirst());
            couponUserExample.setEnd(example.getEnd());
        }
//        參數
        if (StringUtils.isNotBlank(example.getCouponId())) {
            criteria.andCouponIdEqualTo(example.getCouponId());
        }
        if (StringUtils.isNotBlank(example.getUserNo())) {
            criteria.andUserNoEqualTo(example.getUserNo());
        }
        if (StringUtils.isNotBlank(example.getStatus())) {
            criteria.andStatusEqualTo(example.getStatus());
        }
        if (example.getExpireDateStart() != null) {
            criteria.andExpireDateGreaterThan(example.getExpireDateStart());
        }
        if (example.getExpireDateEnd() != null) {
            criteria.andExpireDateLessThan(example.getExpireDateEnd());
        }
    }
}
