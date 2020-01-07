package org.egg.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.egg.biz.AccountFlowBiz;
import org.egg.enums.AccountFlowStatusEnum;
import org.egg.enums.AccountFlowTypeEnum;
import org.egg.enums.FlowUserTypeEnum;
import org.egg.model.VO.AccountFlowQueryReq;
import org.egg.model.VO.AccountFlowRes;
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
 * Created by chendatao on 2018/7/25.
 * 账号管理
 */
@RequestMapping("/boss/account")
@Controller
public class BossAccountController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BossAccountController.class);
    @Autowired
    private AccountFlowBiz accountFlowBiz;

    /**
     * 管理页面
     *
     * @return
     */
    @RequestMapping("/showAccountFlow")
    public String showAccountFlow(Model model) {
        model.addAttribute("userTypeMap", FlowUserTypeEnum.getIndexDescMap());
        model.addAttribute("statusMap", AccountFlowStatusEnum.getIndexDescMap());
        model.addAttribute("typeMap", AccountFlowTypeEnum.getIndexDescMap());
        return "boss/accountFlow";
    }

    @RequestMapping("/accountFlowList")
    @ResponseBody
    public Map<String, Object> accountFlowList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            LOGGER.info("#accountFlowList#查询记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            AccountFlowQueryReq queryReq = JSON.parseObject(condition, AccountFlowQueryReq.class);
            queryReq.setPageNo(Integer.valueOf(pageStr));
            queryReq.setPageNum(Integer.valueOf(rowsStr));
            PageResult pageResult = accountFlowBiz.accountFlowList(queryReq);
            if (pageResult.isSuccess()) {
                List<AccountFlowRes> rows = new ArrayList<>();
                if (CollectionUtils.isEmpty(pageResult.getData())) {
                    LOGGER.info("#accountFlowList#查询记录成功,查询参数:condition={},size=0", JSON.toJSONString(condition));
                } else {
                    LOGGER.info("#accountFlowList#查询记录成功,查询参数:condition={},size={}", JSON.toJSONString(condition), rows.size());
                    rows = pageResult.getData();
                }
                resultMap.put("total", pageResult.getTotal());
                resultMap.put("rows", rows);
                resultMap.put("success", true);
            }
        } catch (Exception e) {
            LOGGER.error("#accountFlowList#查询记录异常,异常详情={}", e);
        }
        return resultMap;
    }



}
