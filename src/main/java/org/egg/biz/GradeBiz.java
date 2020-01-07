package org.egg.biz;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.egg.enums.CommonErrorEnum;
import org.egg.exception.CommonException;
import org.egg.model.DO.AcceptOrder;
import org.egg.model.DO.GradeRecord;
import org.egg.model.VO.AcceptOrderQueryReq;
import org.egg.response.BaseResult;
import org.egg.service.impl.AcceptOrderServiceImpl;
import org.egg.service.impl.GradeRecordService;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/9 19:47
 */
@Component
@Slf4j
public class GradeBiz {

    @Autowired
    private GradeRecordService gradeRecordService;
    @Autowired
    private AcceptOrderServiceImpl acceptOrderService;
    @Autowired
    private BizTemplate bizTemplate;

    public BaseResult insertRecord(GradeRecord gradeRecord) {
        log.info("#insertRecord gradeRecord={}", JSONObject.toJSONString(gradeRecord));
        BaseResult builder = BaseResult.builder();
        bizTemplate.process(builder, new TemplateCallBack() {
            @Override
            public void doCheck() {
                AcceptOrderQueryReq acceptOrderQueryReq = new AcceptOrderQueryReq();
                acceptOrderQueryReq.setOrderNo(gradeRecord.getAcceptRecordNo());
                List<AcceptOrder> acceptOrders = acceptOrderService.queryList(acceptOrderQueryReq);
                if (CollectionUtils.isEmpty(acceptOrders)) {
                    log.error("#insertRecord acceptOrders is empty");
                    throw new CommonException(CommonErrorEnum.PARAM_ERROR);
                }
                AcceptOrder acceptOrder = acceptOrders.get(0);
                gradeRecord.setTargetUserNo(acceptOrder.getUserNo());
            }

            @Override
            public void doAction() {
                gradeRecordService.insertRecord(gradeRecord);
            }
        });
        log.info("#insertRecord builder={}", JSONObject.toJSONString(builder));
        return builder;
    }
}
