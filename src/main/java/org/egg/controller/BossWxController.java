package org.egg.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.egg.biz.WxBiz;
import org.egg.enums.WxFlowDetailStatusEnum;
import org.egg.model.DO.WxAccessToken;
import org.egg.model.DO.WxAccessTokenUser;
import org.egg.model.VO.WxAccessTokenQueryReq;
import org.egg.model.VO.WxAccessTokenUserQueryReq;
import org.egg.response.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * Created by chendatao on 2018/7/24.
 */
@RequestMapping(value = "/boss/wx")
@Controller
public class BossWxController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BossWxController.class);
    @Autowired
    private WxBiz wxBiz;

    /**
     * 平台微信token
     * 管理页面
     *
     * @return
     */
    @RequestMapping("/showWxToken")
    public String showWxToken(Model model) {
        return "boss/wxToken";
    }

    /**
     * 用户微信token
     * 管理页面
     *
     * @return
     */
    @RequestMapping("/showWxUserToken")
    public String showWxUserToken(Model model) {
        return "boss/wxUserToken";
    }

    /**
     * 微信资金流水页面
     * 管理页面
     *
     * @return
     */
    @RequestMapping("/showWxFlow")
    public String showWxFlow(Model model) {
        model.addAttribute("indexDescMap", WxFlowDetailStatusEnum.getIndexDescMap());
        return "boss/wxFlow";
    }

    @RequestMapping("/wxToken/queryList")
    @ResponseBody
    public Map<String, Object> wxTokenQueryList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            LOGGER.info("查询WxToken记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            WxAccessTokenQueryReq wxAccessTokenQueryReq = JSON.parseObject(condition, WxAccessTokenQueryReq.class);
            wxAccessTokenQueryReq.setPageNo(Integer.valueOf(pageStr));
            wxAccessTokenQueryReq.setPageNum(Integer.valueOf(rowsStr));
            PageResult pageResult = wxBiz.wxTokenQueryList(wxAccessTokenQueryReq);
            if (pageResult.isSuccess()) {
                List<WxAccessToken> rows = new ArrayList<>();
                if (CollectionUtils.isEmpty(pageResult.getData())) {
                    LOGGER.info("查询WxToken记录成功,查询参数:condition={},size=0", JSON.toJSONString(condition));
                } else {
                    LOGGER.info("查询WxToken记录成功,查询参数:condition={},size={}", JSON.toJSONString(condition), rows.size());
                    rows = pageResult.getData();
                }
                resultMap.put("total", pageResult.getTotal());
                resultMap.put("rows", rows);
                resultMap.put("success", true);
            }
        } catch (Exception e) {
            LOGGER.error("查询WxToken记录异常,异常详情={}", e);
        }
        return resultMap;
    }

    @RequestMapping("/wxUserToken/queryList")
    @ResponseBody
    public Map<String, Object> wxUserTokenQueryList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            LOGGER.info("查询wxUserTokenQueryList记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            WxAccessTokenUserQueryReq wxAccessTokenUserQueryReq = JSON.parseObject(condition, WxAccessTokenUserQueryReq.class);
            wxAccessTokenUserQueryReq.setPageNo(Integer.valueOf(pageStr));
            wxAccessTokenUserQueryReq.setPageNum(Integer.valueOf(rowsStr));
            PageResult pageResult = wxBiz.wxUserTokenQueryList(wxAccessTokenUserQueryReq);
            if (pageResult.isSuccess()) {
                List<WxAccessTokenUser> rows = new ArrayList<>();
                if (CollectionUtils.isEmpty(pageResult.getData())) {
                    LOGGER.info("查询wxUserTokenQueryList记录成功,查询参数:condition={},size=0", JSON.toJSONString(condition));
                } else {
                    LOGGER.info("查询wxUserTokenQueryList记录成功,查询参数:condition={},size={}", JSON.toJSONString(condition), rows.size());
                    rows = pageResult.getData();
                }
                resultMap.put("total", pageResult.getTotal());
                resultMap.put("rows", rows);
                resultMap.put("success", true);
            }
        } catch (Exception e) {
            LOGGER.error("查询wxUserTokenQueryList记录异常,异常详情={}", e);
        }
        return resultMap;
    }


}
