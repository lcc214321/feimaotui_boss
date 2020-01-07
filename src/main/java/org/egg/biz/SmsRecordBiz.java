package org.egg.biz;

import org.apache.commons.lang3.StringUtils;
import org.egg.model.DO.SmsRecord;
import org.egg.model.VO.SmsRecordQueryReq;
import org.egg.response.PageResult;
import org.egg.service.impl.SmsRecordService;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author dataochen
 * @Description
 * @date: 2018/12/21 18:20
 */
@Component
public class SmsRecordBiz {
    @Autowired
    private SmsRecordService smsRecordService;
    @Autowired
    private BizTemplate bizTemplate;
    @Value("page.num")
    private String PAGE_NUM;

    /**
     * 分页查询
     *
     * @param smsRecordQueryReq
     * @return
     */
    public PageResult queryList(SmsRecordQueryReq smsRecordQueryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.process(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("smsRecordQueryReq", smsRecordQueryReq);
                if (smsRecordQueryReq.getPageNum() == null) {
                    //默认每页数
                    smsRecordQueryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = smsRecordService.queryCount(smsRecordQueryReq);
                pageResult.setTotal(i);
                if (i != 0) {
                    List<SmsRecord> smsRecords = smsRecordService.queryList(smsRecordQueryReq);
                    if (CollectionUtils.isEmpty(smsRecords)) {
                        return;
                    }
                    pageResult.setData(smsRecords);
                }

            }
        });
        return pageResult;
    }
}
