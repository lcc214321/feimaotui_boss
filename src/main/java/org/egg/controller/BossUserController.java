package org.egg.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.egg.biz.UserBiz;
import org.egg.enums.CreditScoreOperatTypeEnum;
import org.egg.enums.UserStatusEnum;
import org.egg.model.DO.User;
import org.egg.model.VO.CreditScoreFlowQueryReq;
import org.egg.model.VO.CreditScoreRes;
import org.egg.model.VO.UserQueryReq;
import org.egg.model.VO.UserVO;
import org.egg.response.BaseResult;
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
 */
@RequestMapping(value = "/boss/user")
@Controller
public class BossUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BossUserController.class);
    @Autowired
    private UserBiz userBiz;

    /**
     * 信誉分管理
     * 管理页面
     *
     * @return
     */
    @RequestMapping("/showCreditScore")
    public String showCreditScore(Model model) {
        model.addAttribute("codeDescMap", CreditScoreOperatTypeEnum.getCodeDescMap());
        return "boss/creditScore";
    }

    /**
     * 用户管理
     * 管理页面
     *
     * @return
     */
    @RequestMapping("/showUser")
    public String showUser(Model model) {
        model.addAttribute("userStatusMap", UserStatusEnum.getIndexDescMap());
        return "boss/user";
    }

    @RequestMapping("/userQueryList/queryList")
    @ResponseBody
    public Map<String, Object> userQueryList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            LOGGER.info("#userQueryList#查询记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            UserQueryReq queryReq = JSON.parseObject(condition, UserQueryReq.class);
            queryReq.setPageNo(Integer.valueOf(pageStr));
            queryReq.setPageNum(Integer.valueOf(rowsStr));
            PageResult pageResult = userBiz.userQueryList(queryReq);
            if (pageResult.isSuccess()) {
                List<UserVO> rows = new ArrayList<>();
                if (CollectionUtils.isEmpty(pageResult.getData())) {
                    LOGGER.info("#userQueryList#查询记录成功,查询参数:condition={},size=0", JSON.toJSONString(condition));
                } else {
                    LOGGER.info("#userQueryList#查询记录成功,查询参数:condition={},size={}", JSON.toJSONString(condition), rows.size());
                    rows = pageResult.getData();
                }
                resultMap.put("total", pageResult.getTotal());
                resultMap.put("rows", rows);
                resultMap.put("success", true);
            }
        } catch (Exception e) {
            LOGGER.error("#userQueryList#查询记录异常,异常详情={}", e);
        }
        return resultMap;
    }

    @RequestMapping("/creditScoreQueryList/queryList")
    @ResponseBody
    public Map<String, Object> creditScoreQueryList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            LOGGER.info("#creditScoreQueryList#查询记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            CreditScoreFlowQueryReq queryReq = JSON.parseObject(condition, CreditScoreFlowQueryReq.class);
            queryReq.setPageNo(Integer.valueOf(pageStr));
            queryReq.setPageNum(Integer.valueOf(rowsStr));
            PageResult pageResult = userBiz.creditScoreQueryList(queryReq);
            if (pageResult.isSuccess()) {
                List<CreditScoreRes> rows = new ArrayList<>();
                if (CollectionUtils.isEmpty(pageResult.getData())) {
                    LOGGER.info("#creditScoreQueryList#查询记录成功,查询参数:condition={},size=0", JSON.toJSONString(condition));
                } else {
                    LOGGER.info("#creditScoreQueryList#查询记录成功,查询参数:condition={},size={}", JSON.toJSONString(condition), rows.size());
                    rows = pageResult.getData();
                }
                resultMap.put("total", pageResult.getTotal());
                resultMap.put("rows", rows);
                resultMap.put("success", true);
            }
        } catch (Exception e) {
            LOGGER.error("#creditScoreQueryList#查询记录异常,异常详情={}", e);
        }
        return resultMap;
    }

    @RequestMapping("/updateStatus")
    @ResponseBody
    public BaseResult updateStatus(User user) {
        LOGGER.info("updateStatus user={}", user);
        BaseResult result = userBiz.updateStatus(user);
        return result;
    }


}
