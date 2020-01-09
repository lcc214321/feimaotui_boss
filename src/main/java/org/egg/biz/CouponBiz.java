package org.egg.biz;

import lombok.extern.slf4j.Slf4j;
import org.egg.enums.CouponTypeEnum;
import org.egg.model.DO.Coupon;
import org.egg.model.VO.CouponQueryReq;
import org.egg.model.VO.CouponRes;
import org.egg.response.BaseResult;
import org.egg.response.PageResult;
import org.egg.service.impl.CouponServiceImpl;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.CheckUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/20 16:21
 */
@Component
@Slf4j
public class CouponBiz {
    @Autowired
    private CouponServiceImpl couponService;
    @Autowired
    private BizTemplate bizTemplate;
    @Value("page.num")
    private String PAGE_NUM;

    public PageResult queryList4Boss(CouponQueryReq couponQueryReq) {
        PageResult result = new PageResult();
        bizTemplate.process(result, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("couponQueryReq", couponQueryReq);
            }

            @Override
            public void doAction() {
                int i = couponService.queryCount(couponQueryReq);
                result.setTotal(i);
                if (i != 0) {
                    List<Coupon> coupons = couponService.queryList(couponQueryReq);
                    ArrayList<CouponRes> couponRes = new ArrayList<CouponRes>();
                    if (CollectionUtils.isEmpty(coupons)) {
                        return;
                    }
                    List<CouponRes> collect = coupons.stream().map(m -> {
                        CouponRes couponRes1 = new CouponRes();
                        BeanUtils.copyProperties(m, couponRes1);
                        couponRes1.setCouponTypeStr(CouponTypeEnum.getDescByCode(m.getCouponType()));
                        return couponRes1;
                    }).collect(Collectors.toList());
                    result.setData(collect);
                }
            }
        });
        return result;
    }

    public BaseResult createCoupon(Coupon coupon) {
        BaseResult builder = BaseResult.builder();
        bizTemplate.process(builder, new TemplateCallBack() {
            @Override
            public void doCheck() {

            }

            @Override
            public void doAction() {
                couponService.insert(coupon);
            }
        });
        return builder;
    }
    public BaseResult modifyCoupon(Coupon coupon) {
        BaseResult builder = BaseResult.builder();
        bizTemplate.process(builder, new TemplateCallBack() {
            @Override
            public void doCheck() {

            }

            @Override
            public void doAction() {
                couponService.update(coupon);
            }
        });
        return builder;
    }

}
