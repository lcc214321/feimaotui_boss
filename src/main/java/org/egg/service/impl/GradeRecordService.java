package org.egg.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.egg.mapper.GradeRecordDAO;
import org.egg.model.DO.GradeRecord;
import org.egg.model.DO.GradeRecordExample;
import org.egg.model.VO.GradeRecordQueryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/9 18:36
 */
@Component
@Slf4j
public class GradeRecordService {
    @Autowired
    private GradeRecordDAO gradeRecordDAO;

    public void insertRecord(GradeRecord gradeRecord) {
        gradeRecord.setCreatedDate(new Date());
        gradeRecordDAO.insertSelective(gradeRecord);
    }

    public int queryCount(GradeRecordQueryReq gradeRecordQueryReq) {
        GradeRecordExample gradeRecordExample = new GradeRecordExample();
        convert(gradeRecordQueryReq, gradeRecordExample);
        return gradeRecordDAO.countByExample(gradeRecordExample);
    }

    public List<GradeRecord> queryList(GradeRecordQueryReq gradeRecordQueryReq) {
        GradeRecordExample gradeRecordExample = new GradeRecordExample();
        convert(gradeRecordQueryReq, gradeRecordExample);
        return gradeRecordDAO.selectByExample(gradeRecordExample);
    }

    public void convert(GradeRecordQueryReq example, GradeRecordExample gradeRecordExample) {
        GradeRecordExample.Criteria criteria = gradeRecordExample.createCriteria();

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
            gradeRecordExample.setStart(example.getFirst());
            gradeRecordExample.setEnd(example.getEnd());
        }

//   参数
        if (StringUtils.isNotBlank(example.getTargetUserNo())) {
            criteria.andTargetUserNoEqualTo(example.getTargetUserNo());
        }
        if (StringUtils.isNotBlank(example.getUserNo())) {
            criteria.andUserNoEqualTo(example.getUserNo());
        }
        if (StringUtils.isNotBlank(example.getAcceptRecordNo())) {
            criteria.andAcceptRecordNoEqualTo(example.getAcceptRecordNo());
        }

    }
}
