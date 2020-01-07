package org.egg.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.egg.mapper.UserHistoryAddressMapper;
import org.egg.model.DO.UserHistoryAddress;
import org.egg.model.DO.UserHistoryAddressExample;
import org.egg.model.VO.UserHistoryAddressQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author dataochen
 * @Description
 * @date: 2020/1/3 16:28
 */
@Component
@Slf4j
public class UserHistoryAdressServiceImpl {
    @Autowired
    private UserHistoryAddressMapper userHistoryAddressMapper;

    public void insert(UserHistoryAddress userHistoryAddress) {
        userHistoryAddress.setCreatedDate(new Date());
        userHistoryAddressMapper.insertSelective(userHistoryAddress);
    }

    public List<UserHistoryAddress> queryList(UserHistoryAddressQuery userHistoryAddressQuery) {
        UserHistoryAddressExample userHistoryAddressExample = new UserHistoryAddressExample();
        convert(userHistoryAddressQuery, userHistoryAddressExample);
        List<UserHistoryAddress> userHistoryAddresses = userHistoryAddressMapper.selectByExample(userHistoryAddressExample);
        return userHistoryAddresses;
    }

    private void convert(UserHistoryAddressQuery example, UserHistoryAddressExample userHistoryAddressExample) {
        UserHistoryAddressExample.Criteria criteria = userHistoryAddressExample.createCriteria();
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
            userHistoryAddressExample.setStart(example.getFirst());
            userHistoryAddressExample.setEnd(example.getEnd());
        }
        userHistoryAddressExample.setOrderByClause("createdDate desc");
    }
}
