package org.egg.biz;

import org.apache.commons.lang3.StringUtils;
import org.egg.enums.PublishOrderStatusEnum;
import org.egg.model.DO.PubOrder;
import org.egg.model.VO.PublishOrderQueryReq;
import org.egg.model.VO.PublishOrderRes;
import org.egg.response.PageResult;
import org.egg.service.impl.AcceptOrderServiceImpl;
import org.egg.service.impl.PublishOrderServiceImpl;
import org.egg.service.impl.UserServiceImpl;
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

import java.util.ArrayList;
import java.util.List;

/**
 * @author chendatao
 * @date 2017/12/10
 */
@Service
public class PublishOrderBiz {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublishOrderBiz.class);
    @Autowired
    private BizTemplate bizTemplate;
    @Autowired
    private PublishOrderServiceImpl publishOrderService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AcceptOrderServiceImpl acceptOrderService;
    @Autowired
    private AcceptOrderBiz acceptOrderBiz;
    @Autowired
    @Qualifier("poolExecutorSendMsg")
    private ThreadPoolTaskExecutor poolExecutorSendMsg;
    @Autowired
    private FeeRuleBiz feeRuleBiz;
    @Autowired
    private CouponUserBiz couponUserBiz;

    @Value("publish.expire.date")
    private String PUBLISH_EXPIRE_DATE;
    @Value("page.num")
    private String PAGE_NUM;



    /**
     * 分页查询 发单接口
     *
     * @param publishOrderQueryReq
     * @return
     */
    public PageResult queryList(PublishOrderQueryReq publishOrderQueryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.processTX(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("publishOrderQueryReq", publishOrderQueryReq);
                if (publishOrderQueryReq.getPageNum() == null) {
                    //默认每页数
                    publishOrderQueryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = publishOrderService.queryCount(publishOrderQueryReq);
                pageResult.setTotal(i);
                if (i != 0) {
                    List<PubOrder> publishOrders = publishOrderService.queryList(publishOrderQueryReq);
                    ArrayList<PublishOrderRes> publishOrderRes = new ArrayList<>();
                    publishOrders.forEach(items -> {
                        PublishOrderRes publishOrderRes1 = new PublishOrderRes();
                        BeanUtil.copyProperties(items, publishOrderRes1);
                        publishOrderRes1.setStatusStr(PublishOrderStatusEnum.getDescByCode(items.getStatus()));
                        //                隐藏凭证
                        publishOrderRes1.setScoNo("");
                        publishOrderRes1.setPrice(feeRuleBiz.calcFee(publishOrderRes1.getPrice()));
                        publishOrderRes.add(publishOrderRes1);
                    });
                    pageResult.setData(publishOrderRes);
                }

            }
        });
        return pageResult;
    }


}
