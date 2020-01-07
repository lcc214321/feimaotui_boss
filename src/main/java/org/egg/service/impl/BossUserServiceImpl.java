package org.egg.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.egg.enums.BossUserStatusEnum;
import org.egg.enums.TableTypeEnum;
import org.egg.mapper.BossUserDAO;
import org.egg.model.DO.BossUser;
import org.egg.model.DO.BossUserExample;
import org.egg.model.VO.BossUserQueryReq;
import org.egg.utils.IdMarkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/16 11:49
 */
@Component
@Slf4j
public class BossUserServiceImpl {
    @Autowired
    private BossUserDAO bossUserDAO;

    public int queryCount(BossUserQueryReq bossUserQueryReq) {
        BossUserExample bossUserExample = new BossUserExample();
        convert(bossUserQueryReq, bossUserExample);
        return bossUserDAO.countByExample(bossUserExample);
    }

    public List<BossUser> queryList(BossUserQueryReq bossUserQueryReq) {
        BossUserExample bossUserExample = new BossUserExample();
        convert(bossUserQueryReq, bossUserExample);
        return bossUserDAO.selectByExample(bossUserExample);
    }

    public int update(BossUser bossUser) {
        return bossUserDAO.updateByPrimaryKeySelective(bossUser);
    }

    public void create(BossUser bossUser) {
        bossUser.setCreatedDate(new Date());
        bossUser.setStatus(BossUserStatusEnum.EFFECT.getCode());
        bossUser.setBossUserNo(IdMarkUtil.getUniqId(TableTypeEnum.BOSS_USER_TABLE));
        bossUserDAO.insertSelective(bossUser);
    }

    public void convert(BossUserQueryReq example, BossUserExample bossUserExample) {
        BossUserExample.Criteria criteria = bossUserExample.createCriteria();

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
            bossUserExample.setStart(example.getFirst());
            bossUserExample.setEnd(example.getEnd());
        }

//        参数
        if (StringUtils.isNotBlank(example.getBossUserNo())) {
            criteria.andBossUserNoEqualTo(example.getBossUserNo());
        }
        if (StringUtils.isNotBlank(example.getLoginName())) {
            criteria.andLoginNameEqualTo(example.getLoginName());
        }
        if (StringUtils.isNotBlank(example.getLoginPwd())) {
            criteria.andLoginPwdEqualTo(example.getLoginPwd());
        }
        if (StringUtils.isNotBlank(example.getLevel())) {
            criteria.andLevelEqualTo(example.getLevel());
        }
        if (StringUtils.isNotBlank(example.getStatus())) {
            criteria.andStatusEqualTo(example.getStatus());
        }
    }
}
