package org.egg.biz;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.egg.model.VO.CouponUserQueryReq;
import org.egg.model.VO.CouponUserRes;
import org.egg.response.PageResult;
import org.egg.service.impl.CouponUserServiceImpl;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/19 17:20
 */
@Component
@Slf4j
public class CouponUserBiz {
    @Autowired
    private CouponUserServiceImpl couponUserService;
    @Autowired
    private BizTemplate bizTemplate;
    @Value("page.num")
    private String PAGE_NUM;


    public PageResult queryList4Base(CouponUserQueryReq couponUserQueryReq) {
        PageResult couponUserResCommonListResult = new PageResult();
        bizTemplate.process(couponUserResCommonListResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("couponUserQueryReq", couponUserQueryReq);
                if (couponUserQueryReq.getPageNum() == null) {
                    //默认每页数
                    couponUserQueryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = couponUserService.queryCount(couponUserQueryReq);
                couponUserResCommonListResult.setTotal(i);
                if (i != 0) {
                    List<CouponUserRes> couponUserRes = couponUserService.queryList4Base(couponUserQueryReq);
                    couponUserResCommonListResult.setData(couponUserRes);
                }
            }
        });
        return couponUserResCommonListResult;
    }

}
