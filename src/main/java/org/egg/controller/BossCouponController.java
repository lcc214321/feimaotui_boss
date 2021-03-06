package org.egg.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.egg.biz.CouponBiz;
import org.egg.enums.CouponTypeEnum;
import org.egg.model.DO.Coupon;
import org.egg.model.VO.CouponQueryReq;
import org.egg.model.VO.CouponRes;
import org.egg.response.BaseResult;
import org.egg.response.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/16 11:00
 */
@RequestMapping("/boss/coupon")
@Controller
@Slf4j
public class BossCouponController {
    @Autowired
    private CouponBiz couponBiz;

    /**
     * 管理页面
     *
     * @return
     */
    @RequestMapping("/showCouponM")
    public String showCouponM(Model model) {
        Map<String, String> codeDescMap = CouponTypeEnum.getCodeDescMap();
        model.addAttribute("codeDescMap", codeDescMap);
        return "boss/coupon";
    }

    @RequestMapping("/queryList")
    @ResponseBody
    public Map<String, Object> queryList(HttpServletRequest request, CouponQueryReq couponQueryReq) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            PageResult pageResult = couponBiz.queryList4Boss(couponQueryReq);
            if (pageResult.isSuccess()) {
                List<CouponRes> rows = new ArrayList<>();
                if (CollectionUtils.isEmpty(pageResult.getData())) {
                    log.info("查询queryList记录成功,查询参数:couponQueryReq={},size=0", JSON.toJSONString(couponQueryReq));
                } else {
                    log.info("查询queryList记录成功,查询参数:couponQueryReq={},size={}", JSON.toJSONString(couponQueryReq), rows.size());
                    rows = pageResult.getData();
                }
                resultMap.put("total", pageResult.getTotal());
                resultMap.put("rows", rows);
                resultMap.put("success", true);
            }
        } catch (Exception e) {
            log.error("查询queryList记录异常,异常详情={}", e);
        }
        return resultMap;
    }

    @RequestMapping("/createCoupon")
    @ResponseBody
    public BaseResult createCoupon(Coupon coupon) {
        return couponBiz.createCoupon(coupon);
    }

    @RequestMapping("/modifyCoupon")
    @ResponseBody
    public BaseResult modifyCoupon(Coupon coupon) {
        return couponBiz.modifyCoupon(coupon);
    }

}
