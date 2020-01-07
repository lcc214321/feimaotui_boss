package org.egg.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.egg.enums.SmsStatusEnum;
import org.egg.mapper.SmsRecordDAO;
import org.egg.model.DO.SmsRecord;
import org.egg.model.DO.SmsRecordExample;
import org.egg.model.VO.SmsRecordQueryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/4 21:50
 */
@Component
@Slf4j
public class SmsRecordService {
    @Autowired
    private SmsRecordDAO smsRecordDAO;


    public int queryCount(SmsRecordQueryReq example) {
        SmsRecordExample smsRecordExample = new SmsRecordExample();
        convert(example, smsRecordExample);
        int count = this.smsRecordDAO.countByExample(smsRecordExample);
        return count;
    }


    public List<SmsRecord> queryList(SmsRecordQueryReq example) {
        SmsRecordExample smsRecordExample = new SmsRecordExample();
        convert(example, smsRecordExample);
        return this.smsRecordDAO.selectByExample(smsRecordExample);
    }


    public int updateByPrimaryKeySelective(SmsRecord record) {
        SmsRecordExample smsRecordExample = new SmsRecordExample();
        smsRecordExample.createCriteria().andIdEqualTo(record.getId());
        return this.smsRecordDAO.updateByExampleSelective(record, smsRecordExample);
    }


    public int insert(SmsRecord record) {
        return this.smsRecordDAO.insert(record);
    }


    public int insertSelective(SmsRecord record) {
        record.setCreatedDate(new Date());
        record.setSmsStatus(SmsStatusEnum.PROCESS.getIndex());
        return this.smsRecordDAO.insertSelective(record);
    }

    private void convert(SmsRecordQueryReq example, SmsRecordExample smsRecordExample) {
        SmsRecordExample.Criteria criteria = smsRecordExample.createCriteria();

        if (StringUtils.isNotBlank(example.getSmsType())) {
            criteria.andSmsTypeEqualTo(example.getSmsType());
        }
        if (StringUtils.isNotBlank(example.getSmsTemplateId())) {
            criteria.andSmsTemplateIdEqualTo(example.getSmsTemplateId());
        }
        if (StringUtils.isNotBlank(example.getSmsStatus())) {
            criteria.andSmsStatusEqualTo(example.getSmsStatus());
        }
        if (StringUtils.isNotBlank(example.getSmsPhone())) {
            criteria.andSmsPhoneEqualTo(example.getSmsPhone());
        }
        if (example.getCreatedDate() != null) {
            criteria.andCreatedDateEqualTo(example.getCreatedDate());
        }
        if (example.getCreatedDateStart() != null) {
            criteria.andCreatedDateGreaterThanOrEqualTo(example.getCreatedDateStart());
        }
        if (example.getCreatedDateEnd() != null) {
            criteria.andCreatedDateLessThanOrEqualTo(example.getCreatedDateStart());
        }
        if (example.getFirst() != null) {
            smsRecordExample.setStart(example.getFirst());
            smsRecordExample.setEnd(example.getEnd());
        }
    }
}
