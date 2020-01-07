package org.egg.service.impl;

import org.egg.mapper.RecommendDAO;
import org.egg.model.DO.Recommend;
import org.egg.model.VO.RecommendQueryReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendServiceImpl extends AbstractService<Recommend> {
    @Autowired
    private RecommendDAO recommendDAO;

    private static final Logger logger = LoggerFactory.getLogger(RecommendServiceImpl.class);

   
    public int queryCount(RecommendQueryReq example) {
        int count = this.recommendDAO.queryCount(example);
        logger.debug("count: {}", count);
        return count;
    }

   
    public Recommend selectByPrimaryKey(Long id) {
        return this.recommendDAO.selectByPrimaryKey(id);
    }

   
    public List<Recommend> queryList(RecommendQueryReq example) {
        return this.recommendDAO.queryList(example);
    }

   
    public int deleteByPrimaryKey(Long id) {
        return this.recommendDAO.deleteByPrimaryKey(id);
    }

   
    public int updateByPrimaryKeySelective(Recommend record) {
        return this.recommendDAO.updateByPrimaryKeySelective(record);
    }

   
    public int updateByPrimaryKey(Recommend record) {
        return this.recommendDAO.updateByPrimaryKey(record);
    }

   
    public int insert(Recommend record) {
        return this.recommendDAO.insert(record);
    }

   
    public int insertSelective(Recommend record) {
        return this.recommendDAO.insertSelective(record);
    }

    @Override
    int updateService(Recommend record) {
        return recommendDAO.updateByPrimaryKeySelective(record);
    }
}