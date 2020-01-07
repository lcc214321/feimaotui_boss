package org.egg.service.impl;

import org.egg.mapper.CreditScoreFlowDAO;
import org.egg.model.DO.CreditScoreFlow;
import org.egg.model.VO.CreditScoreFlowQueryReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditScoreFlowServiceImpl  extends AbstractService<CreditScoreFlow> {
    @Autowired
    private CreditScoreFlowDAO creditScoreFlowDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditScoreFlowServiceImpl.class);

    public int queryCount(CreditScoreFlowQueryReq example) {
        int count = this.creditScoreFlowDAO.queryCount(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    public CreditScoreFlow selectByPrimaryKey(Long id) {
        return this.creditScoreFlowDAO.selectByPrimaryKey(id);
    }

    public List<CreditScoreFlow> queryList(CreditScoreFlowQueryReq example) {
        return this.creditScoreFlowDAO.queryList(example);
    }

    public int deleteByPrimaryKey(Long id) {
        return this.creditScoreFlowDAO.deleteByPrimaryKey(id);
    }

//    public int updateByPrimaryKeySelective(CreditScoreFlow record) {
//        return this.creditScoreFlowDAO.updateByPrimaryKeySelective(record);
//    }

    
//    public int updateByPrimaryKey(CreditScoreFlow record) {
//        return this.creditScoreFlowDAO.updateByPrimaryKey(record);
//    }

    
    public int insert(CreditScoreFlow record) {
        return this.creditScoreFlowDAO.insert(record);
    }

    
    public int insertSelective(CreditScoreFlow record) {
        return this.creditScoreFlowDAO.insertSelective(record);
    }

    @Override
    int updateService(CreditScoreFlow record) {
        return this.creditScoreFlowDAO.updateByPrimaryKeySelective(record);
    }
}