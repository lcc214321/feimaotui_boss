package org.egg.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.egg.biz.ApproveBiz;
import org.egg.model.DO.Approve;
import org.egg.model.VO.ApproveQueryReq;
import org.egg.model.VO.BossUserRes;
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
 * @Description 申请飞毛腿跑手审核
 * @date: 2019/12/13 16:09
 */
@RequestMapping("/boss/approveM")
@Controller
@Slf4j
public class BossApproveController {
    @Autowired
    private ApproveBiz approveBiz;

    /**
     * 管理页面
     *
     * @return
     */
    @RequestMapping("/showApprove")
    public String showApprove(Model model) {
        return "boss/approveM";
    }

    @RequestMapping("/queryList")
    @ResponseBody
    public Map<String, Object> queryList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>(4);
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            log.info("#queryList#查询记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            ApproveQueryReq queryReq = JSON.parseObject(condition, ApproveQueryReq.class);
            queryReq.setPageNo(Integer.valueOf(pageStr));
            queryReq.setPageNum(Integer.valueOf(rowsStr));
            PageResult pageResult = approveBiz.queryList4Boss(queryReq);
            if (pageResult.isSuccess()) {
                List<BossUserRes> rows = new ArrayList<>();
                if (CollectionUtils.isEmpty(pageResult.getData())) {
                    log.info("#queryList#查询记录成功,查询参数:condition={},size=0", JSON.toJSONString(condition));
                } else {
                    log.info("#queryList#查询记录成功,查询参数:condition={},size={}", JSON.toJSONString(condition), rows.size());
                    rows = pageResult.getData();
                }
                resultMap.put("total", pageResult.getTotal());
                resultMap.put("rows", rows);
                resultMap.put("success", true);
            }
        } catch (Exception e) {
            log.error("#queryList#查询记录异常,异常详情={}", e);
        }
        return resultMap;
    }

    /**
     * 审核成功
     *
     * @param approve
     * @param id
     * @return
     */
    @RequestMapping("/approveSucc")
    @ResponseBody
    public BaseResult approveSucc(Approve approve, Long id) {
        return approveBiz.approveSucc(approve, id);
    }

    /**
     * 审核失败
     *
     * @param id
     * @return
     */
    @RequestMapping("/approveFail")
    @ResponseBody
    public BaseResult approveFail(Long id) {
        return approveBiz.approveFail(id);
    }
}
