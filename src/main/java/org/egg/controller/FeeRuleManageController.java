package org.egg.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.egg.biz.FeeRuleBiz;
import org.egg.enums.FeeTypeEnum;
import org.egg.model.DO.FeeRule;
import org.egg.model.VO.FeeRuleQueryReq;
import org.egg.model.VO.FeeRuleRes;
import org.egg.response.BaseResult;
import org.egg.response.PageResult;
import org.egg.service.impl.FeeRuleServiceImpl;
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
 * 收费规则管理
 * Created by chendatao on 2018/7/24.
 */
@RequestMapping(value = "/boss/feeRule")
@Controller
public class FeeRuleManageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeeRuleBiz.class);
    @Autowired
    private FeeRuleBiz feeRuleBiz;
    @Autowired
    private FeeRuleServiceImpl feeRuleService;

    /**
     * 管理页面
     *
     * @return
     */
    @RequestMapping("/index")
    public String showIndex(Model model) {
        model.addAttribute("feeTypeMap", FeeTypeEnum.getCodeDescMap());
        return "boss/feeRule";
    }

    @RequestMapping("/queryList")
    @ResponseBody
    public Map<String, Object> queryList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            LOGGER.info("查询fee rule记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            FeeRuleQueryReq feeRuleQueryReq = JSON.parseObject(condition, FeeRuleQueryReq.class);
            feeRuleQueryReq.setPageNo(Integer.valueOf(pageStr));
            feeRuleQueryReq.setPageNum(Integer.valueOf(rowsStr));
            PageResult pageResult = feeRuleBiz.queryList(feeRuleQueryReq);
            if (pageResult.isSuccess()) {
                List<FeeRuleRes> rows = new ArrayList<>();
                if (CollectionUtils.isEmpty(pageResult.getData())) {
                    LOGGER.info("查询fee rule记录成功,查询参数:condition={},size=0", JSON.toJSONString(condition));
                } else {
                    LOGGER.info("查询fee rule记录成功,查询参数:condition={},size={}", JSON.toJSONString(condition), rows.size());
                    rows = pageResult.getData();
                }
                resultMap.put("total", pageResult.getTotal());
                resultMap.put("rows", rows);
                resultMap.put("success", true);
            }
        } catch (Exception e) {
            LOGGER.error("查询fee rule列表记录异常,异常详情={}", e);
        }
        return resultMap;
    }


    @RequestMapping("/delete")
    @ResponseBody
    public BaseResult delete(Integer id) {
        int i = feeRuleService.deleteByPrimaryKey(id);
        BaseResult result = new BaseResult();
        if (i != 0) {
            result.setSuccess(true);
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public BaseResult update(FeeRule record) {
         feeRuleService.update(record);
        BaseResult result = new BaseResult();
        result.setSuccess(true);
        return result;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public BaseResult insert(FeeRule record) {
        BaseResult result = new BaseResult();
        int i = feeRuleService.insertSelective(record);
        if (i != 0) {
            result.setSuccess(true);
        }
        return result;
    }
}
