package org.egg.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.egg.biz.ActiveBiz;
import org.egg.model.VO.ActiveQueryReq;
import org.egg.model.VO.BossUserRes;
import org.egg.response.BaseResult;
import org.egg.response.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * @date: 2020/2/28 15:52
 */
@RequestMapping("/boss/active")
@Controller
@Slf4j
public class BossActiveController {
    @Autowired
    private ActiveBiz activeBiz;

    /**
     * 寝室组队活动管理页
     */
    @RequestMapping("/index")
    public String index() {
        return "boss/active";
    }


    /**
     * 发放奖品名额
     */
    @RequestMapping("/allocationPrice")
    @ResponseBody
    public BaseResult allocationPrice() {
        return null;
    }
    /**
     * 寝室组队数据集合查询
     *
     */
    @RequestMapping("/queryList")
    @ResponseBody
    public Map<String, Object> queryList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>(4);
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            log.info("#queryList#查询记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            ActiveQueryReq queryReq = JSON.parseObject(condition, ActiveQueryReq.class);
            queryReq.setPageNo(Integer.valueOf(pageStr));
            queryReq.setPageNum(Integer.valueOf(rowsStr));
            PageResult pageResult = activeBiz.queryList(queryReq);
//            查询需要审核的申请记录
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

}
