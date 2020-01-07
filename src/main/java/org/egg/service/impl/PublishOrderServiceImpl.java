package org.egg.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.egg.enums.PublishOrderStatusEnum;
import org.egg.mapper.PubOrderDAO;
import org.egg.model.DO.PubOrder;
import org.egg.model.DO.PubOrderExample;
import org.egg.model.VO.PublishOrderQueryReq;
import org.egg.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author chendatao
 */
@Service
public class PublishOrderServiceImpl extends AbstractService<PubOrder> {
    @Autowired
    private PubOrderDAO publishOrderDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(PublishOrderServiceImpl.class);


    public int queryCount(PublishOrderQueryReq example) {
        PubOrderExample pubOrderExample = new PubOrderExample();
        convert(example, pubOrderExample);
        int count = this.publishOrderDAO.countByExample(pubOrderExample);
        return count;
    }


    public PubOrder selectByPrimaryKey(Long id) {
        return this.publishOrderDAO.selectByPrimaryKey(id);
    }


    public List<PubOrder> queryList(PublishOrderQueryReq example) {
        PubOrderExample pubOrderExample = new PubOrderExample();
        convert(example, pubOrderExample);
        return this.publishOrderDAO.selectByExample(pubOrderExample);
    }


    public int deleteByPrimaryKey(Long id) {
        return this.publishOrderDAO.deleteByPrimaryKey(id);
    }


//    public int updateByPrimaryKeySelective(PubOrder record) {
//        return this.publishOrderDAO.updateByPrimaryKeySelective(record);
//    }


    public int updateByPrimaryKey(PubOrder record) {
        return this.publishOrderDAO.updateByPrimaryKey(record);
    }


    public int insert(PubOrder record) {
        return this.publishOrderDAO.insert(record);
    }


    public int insertSelective(PubOrder record) {
        return this.publishOrderDAO.insertSelective(record);
    }

    /**
     * 超过一小时没有被接的单子
     *
     * @return
     */
    public List<PubOrder> queryExpireList() {
        Date date = new Date();
        Date date1 = DateUtil.addHour(-1, date);
        PubOrderExample pubOrderExample = new PubOrderExample();
        PubOrderExample.Criteria criteria = pubOrderExample.createCriteria();
        criteria.andStatusEqualTo(PublishOrderStatusEnum.PAY_SUCC.getCode())
                .andModifiedDateLessThanOrEqualTo(date1);
        return this.publishOrderDAO.selectByExample(pubOrderExample);
    }


    @Override
    int updateService(PubOrder record) {
        return this.publishOrderDAO.updateByPrimaryKeySelective(record);
    }

    private void convert(PublishOrderQueryReq example, PubOrderExample pubOrderExample) {
        PubOrderExample.Criteria criteria = pubOrderExample.createCriteria();
        if (StringUtils.isNotBlank(example.getUserNo())) {
            criteria.andUserNoEqualTo(example.getUserNo());
        }
        if (example.getId() != null) {
            criteria.andIdEqualTo(example.getId());
        }
        if (StringUtils.isNotBlank(example.getOrderNo())) {
            criteria.andOrderNoEqualTo(example.getOrderNo());
        }
        if (StringUtils.isNotBlank(example.getKdType())) {
            criteria.andKdTypeEqualTo(example.getKdType());
        }
        if (StringUtils.isNotBlank(example.getStatus())) {
            criteria.andStatusEqualTo(example.getStatus());
        }
        if (StringUtils.isNotBlank(example.getWuliuNo())) {
            criteria.andWuliuNoEqualTo(example.getWuliuNo());
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
        if (StringUtils.isNotBlank(example.getOrderColumn())) {
            StringBuilder stringBuilder = new StringBuilder("order by ");
            stringBuilder.append(example.getOrderColumn());
            stringBuilder.append(" ");
            if (example.getAscFlag()) {
                stringBuilder.append("asc");
            } else {
                stringBuilder.append("desc");
            }

            pubOrderExample.setOrderByClause(stringBuilder.toString());
        }
        if (example.getFirst() != null) {
            pubOrderExample.setStart(example.getFirst());
            pubOrderExample.setEnd(example.getEnd());
        }
    }
}