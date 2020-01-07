package org.egg.controller;

import com.alibaba.fastjson.JSON;
import org.egg.biz.ShareRecordBiz;
import org.egg.enums.ShareStatusEnum;
import org.egg.enums.ShareTypeEnum;
import org.egg.model.VO.BossUserRes;
import org.egg.model.VO.ShareRecordQueryReq;
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
 * @author dataochen
 * @Description
 * @date: 2018/12/21 18:14
 */
@RequestMapping(value = "/boss/shareRecord")
@Controller
public class BossShareRecordController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BossShareRecordController.class);
    @Autowired
    private ShareRecordBiz shareRecordBiz;

    @RequestMapping("/show")
    public String show(Model model) {
        model.addAttribute("typeCodeDescMap", ShareTypeEnum.getCodeDescMap());
        model.addAttribute("statusCodeDescMap", ShareStatusEnum.getCodeDescMap());
        return "boss/shareRecordManage";
    }


    @RequestMapping("/queryDb")
    @ResponseBody
    public Map<String, Object> query(HttpServletRequest request) {

        Map<String, Object> resultMap = new HashMap<>();
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            LOGGER.info("#query#查询记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            ShareRecordQueryReq queryReq = JSON.parseObject(condition, ShareRecordQueryReq.class);
            queryReq.setPageNo(Integer.valueOf(pageStr));
            queryReq.setPageNum(Integer.valueOf(rowsStr));
            PageResult pageResult = shareRecordBiz.queryList(queryReq);
            if (pageResult.isSuccess()) {
                List<BossUserRes> rows = new ArrayList<>();
                if (org.apache.commons.collections.CollectionUtils.isEmpty(pageResult.getData())) {
                    LOGGER.info("#query#查询记录成功,查询参数:condition={},size=0", JSON.toJSONString(condition));
                } else {
                    LOGGER.info("#query#查询记录成功,查询参数:condition={},size={}", JSON.toJSONString(condition), rows.size());
                    rows = pageResult.getData();
                }
                resultMap.put("total", pageResult.getTotal());
                resultMap.put("rows", rows);
                resultMap.put("success", true);
            }
        } catch (Exception e) {
            LOGGER.error("#query#查询记录异常,异常详情={}", e);
        }
        return resultMap;

    }
}
