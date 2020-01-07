package org.egg.service.impl;

import org.egg.mapper.FeeRuleDAO;
import org.egg.model.DO.FeeRule;
import org.egg.model.VO.FeeRuleQueryReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FeeRuleServiceImpl extends AbstractService<FeeRule> {
    @Autowired
    private FeeRuleDAO feeRuleDAO;

    private static final Logger logger = LoggerFactory.getLogger(FeeRuleServiceImpl.class);

    
    public int queryCount(FeeRuleQueryReq example) {
        int count = this.feeRuleDAO.queryCount(example);
        logger.debug("count: {}", count);
        return count;
    }

    public FeeRule selectByPrimaryKey(Integer id) {
        return this.feeRuleDAO.selectByPrimaryKey(id);
    }

    public List<FeeRule> queryList(FeeRuleQueryReq example) {
        return this.feeRuleDAO.queryList(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.feeRuleDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(FeeRule record) {
        return this.feeRuleDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(FeeRule record) {
        return this.feeRuleDAO.updateByPrimaryKey(record);
    }

    public int insert(FeeRule record) {
        return this.feeRuleDAO.insert(record);
    }

    public int insertSelective(FeeRule record) {
        record.setCreatedDate(new Date());
        return this.feeRuleDAO.insertSelective(record);
    }

    @Override
    int updateService(FeeRule record) {
        return feeRuleDAO.updateByPrimaryKeySelective(record);
    }
}