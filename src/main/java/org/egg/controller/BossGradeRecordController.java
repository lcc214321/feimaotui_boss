package org.egg.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.egg.biz.GradeRecordBiz;
import org.egg.model.DO.GradeRecord;
import org.egg.model.VO.GradeRecordQueryReq;
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
@RequestMapping("/boss/gradeRecord")
@Controller
@Slf4j
public class BossGradeRecordController {
    @Autowired
    private GradeRecordBiz gradeRecordBiz;

    /**
     * 反馈记录页面
     * 管理页面
     *
     * @return
     */
    @RequestMapping("/showGradeManage")
    public String showGradeManage(Model model) {

        return "boss/gradeManage";
    }

    @RequestMapping("/gradeManage/queryList")
    @ResponseBody
    public Map<String, Object> queryList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            log.info("查询queryList记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            GradeRecordQueryReq gradeRecordQueryReq = JSON.parseObject(condition, GradeRecordQueryReq.class);
            gradeRecordQueryReq.setPageNo(Integer.valueOf(pageStr));
            gradeRecordQueryReq.setPageNum(Integer.valueOf(rowsStr));
            PageResult pageResult = gradeRecordBiz.queryList(gradeRecordQueryReq);
            if (pageResult.isSuccess()) {
                List<GradeRecord> rows = new ArrayList<>();
                if (CollectionUtils.isEmpty(pageResult.getData())) {
                    log.info("查询queryList记录成功,查询参数:condition={},size=0", JSON.toJSONString(condition));
                } else {
                    log.info("查询queryList记录成功,查询参数:condition={},size={}", JSON.toJSONString(condition), rows.size());
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
}
