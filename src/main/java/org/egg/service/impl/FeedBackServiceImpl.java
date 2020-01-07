package org.egg.service.impl;

import org.egg.enums.TableTypeEnum;
import org.egg.mapper.FeedBackDAO;
import org.egg.model.DO.FeedBack;
import org.egg.model.VO.FeedBackQueryReq;
import org.egg.utils.IdMarkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FeedBackServiceImpl {
    @Autowired
    private FeedBackDAO feedBackDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedBackServiceImpl.class);

    public int queryCount(FeedBackQueryReq example) {
        int count = this.feedBackDAO.queryCount(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    public FeedBack selectByPrimaryKey(String feedBackNo) {
        return this.feedBackDAO.selectByPrimaryKey(feedBackNo);
    }

    public List<FeedBack> queryList(FeedBackQueryReq example) {
        return this.feedBackDAO.queryList(example);
    }

    public int deleteByPrimaryKey(String feedBackNo) {
        return this.feedBackDAO.deleteByPrimaryKey(feedBackNo);
    }

    public int updateByPrimaryKeySelective(FeedBack record) {
        return this.feedBackDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(FeedBack record) {
        return this.feedBackDAO.updateByPrimaryKey(record);
    }

    public int insert(FeedBack record) {
        return this.feedBackDAO.insert(record);
    }

    public int insertSelective(FeedBack record) {
        record.setCreatedDate(new Date());
        record.setFeedBackNo(IdMarkUtil.getUniqId(TableTypeEnum.FEED_BACK_TABLE));
        return this.feedBackDAO.insertSelective(record);
    }

}