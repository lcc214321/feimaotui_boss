package org.egg.service.impl;

import org.egg.mapper.ShareRecordDAO;
import org.egg.model.DO.ShareRecord;
import org.egg.model.VO.ShareRecordQueryReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShareRecordServiceImpl {
    @Autowired
    private ShareRecordDAO shareRecordDAO;

    private static final Logger logger = LoggerFactory.getLogger(ShareRecordServiceImpl.class);

    
    public int queryCount(ShareRecordQueryReq example) {
        int count = this.shareRecordDAO.queryCount(example);
        logger.debug("count: {}", count);
        return count;
    }

    
    public ShareRecord selectByPrimaryKey(Integer id) {
        return this.shareRecordDAO.selectByPrimaryKey(id);
    }

    
    public List<ShareRecord> queryList(ShareRecordQueryReq example) {
        return this.shareRecordDAO.queryList(example);
    }

    
    public int deleteByPrimaryKey(Integer id) {
        return this.shareRecordDAO.deleteByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(ShareRecord record) {
        return this.shareRecordDAO.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(ShareRecord record) {
        return this.shareRecordDAO.updateByPrimaryKey(record);
    }

    
    public int insert(ShareRecord record) {
        return this.shareRecordDAO.insert(record);
    }

    
    public int insertSelective(ShareRecord record)
    {
        record.setCreatedDate(new Date());
        return this.shareRecordDAO.insertSelective(record);
    }
}