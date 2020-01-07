package org.egg.biz;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.egg.enums.AcceptOrderStatusEnum;
import org.egg.enums.CommonErrorEnum;
import org.egg.enums.PublishOrderStatusEnum;
import org.egg.exception.CommonException;
import org.egg.model.DO.AcceptOrder;
import org.egg.model.DO.PubOrder;
import org.egg.model.VO.*;
import org.egg.response.BaseResult;
import org.egg.response.CommonSingleResult;
import org.egg.response.PageResult;
import org.egg.service.impl.AcceptOrderServiceImpl;
import org.egg.service.impl.PublishOrderServiceImpl;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.BeanUtil;
import org.egg.utils.CheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chendatao on 2017/12/12.
 */
@Service
public class AcceptOrderBiz {
    private static final Logger LOGGER = LoggerFactory.getLogger(AcceptOrderBiz.class);
    @Autowired
    private AcceptOrderServiceImpl acceptOrderService;
    @Autowired
    private PublishOrderServiceImpl publishOrderService;
    @Autowired
    private BizTemplate bizTemplate;
    @Autowired
    private FeeRuleBiz feeRuleBiz;
    @Autowired
    @Qualifier("poolExecutorSendMsg")
    private ThreadPoolTaskExecutor poolExecutorSendMsg;

    @Value("${page.num}")
    private String PAGE_NUM;
    @Value("${black.user.no}")
    private String BLANK_USER_NO;


    /**
     * 查询接单+单子详情
     *
     * @param accOrderNo
     * @return
     */
    public CommonSingleResult<AccAndPubOrderDetail> queryDetail(String accOrderNo, String userNo) {
        CommonSingleResult<AccAndPubOrderDetail> accAndPubOrderDetailCommonSingleResult = new CommonSingleResult<>();
        bizTemplate.process(accAndPubOrderDetailCommonSingleResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotBlank("accOrderNo", accOrderNo);
            }

            @Override
            public void doAction() {
                AcceptOrderQueryReq acceptOrderQueryReq = new AcceptOrderQueryReq();
                acceptOrderQueryReq.setOrderNo(accOrderNo);
                if (StringUtils.isNotBlank(userNo)) {
                    acceptOrderQueryReq.setUserNo(userNo);
                }
                int i = acceptOrderService.queryCount(acceptOrderQueryReq);
                if (i == 0) {
                    throw new CommonException(CommonErrorEnum.PARAM_ORDER_NOT_EXIST);
                }
                AccAndPubOrderDetail accAndPubOrderDetail = new AccAndPubOrderDetail();
                List<AcceptOrder> acceptOrders = acceptOrderService.queryList(acceptOrderQueryReq);
                AcceptOrderRes acceptOrderRes = new AcceptOrderRes();
                BeanUtil.copyProperties(acceptOrders.get(0), acceptOrderRes);
                acceptOrderRes.setOrderStatusStr(AcceptOrderStatusEnum.getDescByCode(acceptOrderRes.getStatus()));
                accAndPubOrderDetail.setAcceptOrderRes(acceptOrderRes);
                PublishOrderQueryReq publishOrderQueryReq = new PublishOrderQueryReq();
                publishOrderQueryReq.setOrderNo(acceptOrderRes.getPubOrderNo());
                List<PubOrder> publishOrders = publishOrderService.queryList(publishOrderQueryReq);
                PublishOrderRes publishOrderRes = new PublishOrderRes();
                BeanUtil.copyProperties(publishOrders.get(0), publishOrderRes);
                publishOrderRes.setStatusStr(PublishOrderStatusEnum.getDescByCode(publishOrders.get(0).getStatus()));
                accAndPubOrderDetail.setPublishOrderRes(publishOrderRes);
                accAndPubOrderDetail.setScoNo(publishOrders.get(0).getScoNo());
                accAndPubOrderDetailCommonSingleResult.setData(accAndPubOrderDetail);
            }
        });
        return accAndPubOrderDetailCommonSingleResult;
    }


    /**
     * 查询接单列表
     *
     * @param acceptOrderQueryReq
     * @return
     */
    public PageResult queryListBoss(AcceptOrderQueryReq acceptOrderQueryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.process(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("acceptOrderQueryReq", acceptOrderQueryReq);
                if (acceptOrderQueryReq.getPageNum() == null) {
                    //默认每页数
                    acceptOrderQueryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            1000 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = acceptOrderService.queryCount(acceptOrderQueryReq);
                pageResult.setTotal(i);
                ArrayList<AcceptOrderRes> acceptOrderRes = new ArrayList<>();
                if (i != 0) {
                    List<AcceptOrder> acceptOrders = acceptOrderService.queryList(acceptOrderQueryReq);
                    if (!CollectionUtils.isEmpty(acceptOrders)) {
                        acceptOrders.forEach(items -> {
                            AcceptOrderRes acceptOrderRes1 = new AcceptOrderRes();
                            BeanUtil.copyProperties(items, acceptOrderRes1);
                            acceptOrderRes1.setOrderStatusStr(AcceptOrderStatusEnum.getDescByCode(items.getStatus()));
                            acceptOrderRes.add(acceptOrderRes1);
                        });
                    }
                }
                pageResult.setData(acceptOrderRes);
            }
        });
        return pageResult;
    }


    /**
     * 管理员关闭订单
     * 更新发布单状态为管理员关闭
     * 更新接单状态为管理员关闭
     * 无资金流转 线下补偿
     * @param acceptOrder
     * @return
     */
    public BaseResult closeAdmin(String acceptOrder) {
        LOGGER.info("#closeAdmin acceptOrder={}", acceptOrder);
        BaseResult builder = BaseResult.builder();
        bizTemplate.processTX(builder, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotBlank("单号", acceptOrder);
            }

            @Override
            public void doAction() {
            }
        });
        LOGGER.info("#closeAdmin builder={}", JSONObject.toJSONString(builder));
        return builder;
    }
}
