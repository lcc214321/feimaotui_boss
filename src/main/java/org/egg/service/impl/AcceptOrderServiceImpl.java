package org.egg.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.egg.mapper.AcceptOrderDAO;
import org.egg.mapper.PubOrderEtxDAO;
import org.egg.model.DO.AcceptOrder;
import org.egg.model.DO.AcceptOrderExample;
import org.egg.model.VO.AcceptOrderQueryReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AcceptOrderServiceImpl extends AbstractService<AcceptOrder> {
    @Autowired
    private AcceptOrderDAO acceptOrderDAO;
    @Autowired
    private PubOrderEtxDAO pubOrderEtxDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(AcceptOrderServiceImpl.class);


    public int queryCount(AcceptOrderQueryReq example) {
        AcceptOrderExample acceptOrderExample = new AcceptOrderExample();
        convert(example, acceptOrderExample);
        int count = 0;
        try {
            count = this.acceptOrderDAO.countByExample(acceptOrderExample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.debug("count: {}", count);
        return count;
    }


    public AcceptOrder selectByPrimaryKey(Long id) {
        return this.acceptOrderDAO.selectByPrimaryKey(id);
    }


    public List<AcceptOrder> queryList(AcceptOrderQueryReq example) {
        AcceptOrderExample acceptOrderExample = new AcceptOrderExample();
        convert(example, acceptOrderExample);
        return this.acceptOrderDAO.selectByExample(acceptOrderExample);
    }


    public int deleteByPrimaryKey(Long id) {
        return this.acceptOrderDAO.deleteByPrimaryKey(id);
    }


//    public int updateByPrimaryKeySelective(AcceptOrder record) {
//        return this.acceptOrderDAO.updateByPrimaryKeySelective(record);
//    }


//    public int updateByPrimaryKey(AcceptOrder record) {
//        return this.acceptOrderDAO.updateByPrimaryKey(record);
//    }


    public int insert(AcceptOrder record) {
        return this.acceptOrderDAO.insert(record);
    }



    // TODO: 2019/12/2

    /**
     * 接单中 且超时未送达
     *
     * @return
     */
    public void cc() {

    }


    @Override
    int updateService(AcceptOrder record) {
        return acceptOrderDAO.updateByPrimaryKeySelective(record);
    }


    private void convert(AcceptOrderQueryReq example, AcceptOrderExample acceptOrderExample) {
        AcceptOrderExample.Criteria criteria = acceptOrderExample.createCriteria();

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
            acceptOrderExample.setStart(example.getFirst());
            acceptOrderExample.setEnd(example.getEnd());
        }

        if (example.getTimeDelayStart() != null) {
            criteria.andTimeDelayGreaterThan(example.getTimeDelayStart());
        }
        if (example.getTimeDelayEnd() != null) {
            criteria.andTimeDelayLessThan(example.getTimeDelayEnd());
        }

//        参数
        if (StringUtils.isNotBlank(example.getUserNo())) {
            criteria.andUserNoEqualTo(example.getUserNo());
        }
        if (example.getId() != null) {
            criteria.andIdEqualTo(example.getId());
        }
        if (StringUtils.isNotBlank(example.getOrderNo())) {
            criteria.andOrderNoEqualTo(example.getOrderNo());
        }
        if (StringUtils.isNotBlank(example.getStatus())) {
            criteria.andStatusEqualTo(example.getStatus());
        }
        if (StringUtils.isNotBlank(example.getPubOrderNo())) {
            criteria.andPubOrderNoEqualTo(example.getPubOrderNo());
        }

    }

    public List<Map<String, Object>> queryList4Accept(Map<String, Object> param) {
        return pubOrderEtxDAO.queryList4Accept(param);
    }
}