package org.egg.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.egg.biz.RecommendBiz;
import org.egg.enums.RecommendTypeEnum;
import org.egg.model.DO.Recommend;
import org.egg.model.VO.RecommendQueryReq;
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
 * @author cdt
 * @Description 推荐记录
 * @date: 2018/9/18 11:15
 */
@RequestMapping(value = "/boss/recommend")
@Controller
public class RecommendController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RecommendController.class);

    @Autowired
    private RecommendBiz recommendBiz;

    @RequestMapping("/show")
    public String show(Model model) {
        model.addAttribute("codeDescMap", RecommendTypeEnum.getCodeDescMap());
        return "boss/recommendManage";
    }

    @RequestMapping("/queryList")
    @ResponseBody
    public Map<String, Object> queryList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            LOGGER.info("查询推荐记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            RecommendQueryReq recommendQueryReq = JSON.parseObject(condition, RecommendQueryReq.class);
            recommendQueryReq.setPageNo(Integer.valueOf(pageStr));
            recommendQueryReq.setPageNum(Integer.valueOf(rowsStr));
            PageResult pageResult = recommendBiz.queryList(recommendQueryReq);
            if (pageResult.isSuccess()) {
                List<Recommend> rows = new ArrayList<>();
                if (CollectionUtils.isEmpty(pageResult.getData())) {
                    LOGGER.info("查询推荐记录成功,查询参数:condition={},size=0", JSON.toJSONString(condition));
                } else {
                    LOGGER.info("查询推荐记录成功,查询参数:condition={},size={}", JSON.toJSONString(condition), rows.size());
                    rows = pageResult.getData();
                }
                resultMap.put("total", pageResult.getTotal());
                resultMap.put("rows", rows);
                resultMap.put("success", true);
            }
        } catch (Exception e) {
            LOGGER.error("查询推荐记录记录异常,异常详情={}", e);
        }
        return resultMap;
    }

}
