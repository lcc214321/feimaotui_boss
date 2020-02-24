package org.egg.controller;

import com.alibaba.fastjson.JSON;
import com.jingda.api.OrderFacade;
import org.apache.commons.collections.CollectionUtils;
import org.egg.biz.AcceptOrderBiz;
import org.egg.biz.PublishOrderBiz;
import org.egg.enums.AcceptOrderStatusEnum;
import org.egg.enums.CommonErrorEnum;
import org.egg.enums.PublishOrderStatusEnum;
import org.egg.enums.PublishOrdersOCEnum;
import org.egg.model.VO.AcceptOrderQueryReq;
import org.egg.model.VO.AcceptOrderRes;
import org.egg.model.VO.PublishOrderQueryReq;
import org.egg.model.VO.PublishOrderRes;
import org.egg.response.BaseResult;
import org.egg.response.PageResult;
import org.egg.service.impl.AcceptOrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cdt
 * @Description 审核
 * @date: 2018/3/8 22:49
 */
@Controller
@RequestMapping("/boss/order")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private AcceptOrderBiz acceptOrderBiz;
    @Autowired
    private PublishOrderBiz publishOrderBiz;
    @Autowired
    private AcceptOrderServiceImpl acceptOrderService;
//    @Autowired
    private OrderFacade orderFacade;

    @Value("${black.user.no}")
    private String BLANK_USER_NO;

    //查询accept_order status 1 待审核 审核通过/失败 失败需要上传失败原因和截图凭证 check_fail_reason,file_url
    @RequestMapping("/queryList")
    @ResponseBody
    public Map<String, Object> queryList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            LOGGER.info("查询接单记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            AcceptOrderQueryReq acceptOrderQueryReq = JSON.parseObject(condition, AcceptOrderQueryReq.class);
            acceptOrderQueryReq.setPageNo(Integer.valueOf(pageStr));
            acceptOrderQueryReq.setPageNum(Integer.valueOf(rowsStr));
            PageResult pageResult = acceptOrderBiz.queryListBoss(acceptOrderQueryReq);
            if (pageResult.isSuccess()) {
                List<AcceptOrderRes> rows = new ArrayList<>();
                if (CollectionUtils.isEmpty(pageResult.getData())) {
                    LOGGER.info("查询接单记录成功,查询参数:condition={},size=0", JSON.toJSONString(condition));
                } else {
                    LOGGER.info("查询接单记录成功,查询参数:condition={},size={}", JSON.toJSONString(condition), rows.size());
                    rows = pageResult.getData();
                }
                resultMap.put("total", pageResult.getTotal());
                resultMap.put("rows", rows);
                resultMap.put("success", true);
            }
        } catch (Exception e) {
            LOGGER.error("查询接单列表记录异常,异常详情={}", e);
        }
        return resultMap;
    }

//    @RequestMapping("/showDetail")
//    public ModelAndView queryDetail(String acceptOrderNo, ModelAndView model, HttpServletRequest request) {
//        CommonSingleResult<AccAndPubOrderDetail> result = acceptOrderBiz.queryDetail(acceptOrderNo, null);
//        if (result.isSuccess()) {
//            model.addObject("errorDesc", result.getRespDesc());
//        }
//        model.addObject("data", result.getData());
//        model.setViewName("boss/checkMD");
//        return model;
//    }


    @RequestMapping("/index")
    public ModelAndView index(ModelAndView model) {
        model.addObject("indexDescMap", AcceptOrderStatusEnum.getIndexDescMap());
        model.setViewName("boss/checkManage");
        return model;

    }

    /**
     * boss 发布单管理页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/showPubOrder")
    public ModelAndView showPubOrder(ModelAndView model) {
        model.addObject("orderStatusMap", PublishOrderStatusEnum.getIndexDescMap());
        model.setViewName("boss/publishOrder");
        return model;

    }

    @RequestMapping("/publishOrderQueryList")
    @ResponseBody
    public Map<String, Object> publishOrderQueryList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            LOGGER.info("#publishOrderQueryList#查询记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            PublishOrderQueryReq queryReq = JSON.parseObject(condition, PublishOrderQueryReq.class);
            queryReq.setPageNo(Integer.valueOf(pageStr));
            queryReq.setPageNum(Integer.valueOf(rowsStr));
            queryReq.setOrderColumn(PublishOrdersOCEnum.ID.getCode());
            queryReq.setAscFlag(false);
            if (org.apache.commons.lang3.StringUtils.isNotBlank(queryReq.getBlankUserNo())) {
                queryReq.setBlankUserNo(BLANK_USER_NO);
            }
            PageResult pageResult = publishOrderBiz.queryList(queryReq);
            if (pageResult.isSuccess()) {
                List<PublishOrderRes> rows = new ArrayList<>();
                if (CollectionUtils.isEmpty(pageResult.getData())) {
                    LOGGER.info("#publishOrderQueryList#查询记录成功,查询参数:condition={},size=0", JSON.toJSONString(condition));
                } else {
                    LOGGER.info("#publishOrderQueryList#查询记录成功,查询参数:condition={},size={}", JSON.toJSONString(condition), rows.size());
                    rows = pageResult.getData();
                }
                resultMap.put("total", pageResult.getTotal());
                resultMap.put("rows", rows);
                resultMap.put("success", true);
            }
        } catch (Exception e) {
            LOGGER.error("#publishOrderQueryList#查询列表记录异常,异常详情={}", e);
        }
        return resultMap;
    }

    @RequestMapping("/closeAdmin")
    @ResponseBody
    public BaseResult closeAdmin(String acceptOrderNo) {
        BaseResult result = new BaseResult();
        result.setSuccess(true);
        com.jingda.domain.BaseResult baseResult = null;
        try {
            baseResult = orderFacade.closeAdmin(acceptOrderNo);
        } catch (Exception e) {
            LOGGER.error("closeAdmin e={}", e);
            result.setSuccess(false);
            result.setRespCode(CommonErrorEnum.SYSTEM_EXCEPTION.getCode());
            result.setRespDesc(CommonErrorEnum.SYSTEM_EXCEPTION.getDescription());
            return result;
        }
        if (!baseResult.isSuccess()) {
            result.setRespCode(baseResult.getCode());
            result.setRespDesc(baseResult.getDesc());
            baseResult.setSuccess(false);
        }
        return result;
    }
}
