package org.egg.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.egg.enums.ApproveStatusEnum;
import org.egg.mapper.ApproveDAO;
import org.egg.model.DO.Approve;
import org.egg.model.DO.ApproveExample;
import org.egg.model.VO.ApproveQueryReq;
import org.egg.response.BaseResult;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/9 21:32
 */
@Component
@Slf4j
public class ApproveService extends AbstractService<Approve> {
    @Autowired
    private ApproveDAO approveDAO;
    @Autowired
    private BizTemplate bizTemplate;

    public BaseResult insertApprove(Approve approve) {
        log.info("insertApprove approve={}", JSONObject.toJSONString(approve));
        BaseResult builder = BaseResult.builder();
        bizTemplate.process(builder, new TemplateCallBack() {
            @Override
            public void doCheck() {

            }

            @Override
            public void doAction() {
                approve.setCreatedDate(new Date());
                approve.setStatus(ApproveStatusEnum.INIT.getCode());
                approveDAO.insertSelective(approve);
            }
        });
        log.info("insertApprove builder={}", JSONObject.toJSONString(builder));
        return builder;
    }

    public List<Approve> queryList(ApproveQueryReq queryReq) {
        ApproveExample approveExample = new ApproveExample();
        convert(queryReq,approveExample);
        return approveDAO.selectByExample(approveExample);
    }

    public int queryCount(ApproveQueryReq queryReq) {
        ApproveExample approveExample = new ApproveExample();
        convert(queryReq,approveExample);
        return approveDAO.countByExample(approveExample);
    }
    @Override
    int updateService(Approve record) {
        return approveDAO.updateByPrimaryKeySelective(record);
    }

    private void convert(ApproveQueryReq example, ApproveExample approveExample) {
        ApproveExample.Criteria criteria = approveExample.createCriteria();

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
            approveExample.setStart(example.getFirst());
            approveExample.setEnd(example.getEnd());
        }


//        参数
        if (StringUtils.isNotBlank(example.getUserNo())) {
            criteria.andUserNoEqualTo(example.getUserNo());
        }
        if (example.getId() != null) {
            criteria.andIdEqualTo(example.getId());
        }
        if (StringUtils.isNotBlank(example.getStuNo())) {
            criteria.andStuNoEqualTo(example.getStuNo());
        }
        if (StringUtils.isNotBlank(example.getStatus())) {
            criteria.andStatusEqualTo(example.getStatus());
        }
        if (StringUtils.isNotBlank(example.getTelNo())) {
            criteria.andTelNoEqualTo(example.getTelNo());
        }

    }
}
