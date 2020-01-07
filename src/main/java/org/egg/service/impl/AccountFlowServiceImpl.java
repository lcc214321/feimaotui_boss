package org.egg.service.impl;

import org.egg.enums.CommonErrorEnum;
import org.egg.exception.CommonException;
import org.egg.mapper.AccountFlowDAO;
import org.egg.model.DO.AccountFlow;
import org.egg.model.VO.AccountFlowQueryReq;
import org.egg.utils.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class AccountFlowServiceImpl extends AbstractService<AccountFlow> {
    @Autowired
    private AccountFlowDAO accountFlowDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountFlowServiceImpl.class);


    public int queryCount(AccountFlowQueryReq example) {
        int count = this.accountFlowDAO.queryCount(example);
        LOGGER.debug("count: {}", count);
        return count;
    }


    public AccountFlow selectByPrimaryKey(Long id) {
        return this.accountFlowDAO.selectByPrimaryKey(id);
    }


    public List<AccountFlow> queryList(AccountFlowQueryReq example) {
        return this.accountFlowDAO.queryList(example);
    }


    public int deleteByPrimaryKey(Long id) {
        return this.accountFlowDAO.deleteByPrimaryKey(id);
    }


//    public int updateByPrimaryKeySelective(AccountFlow record) {
//        return this.accountFlowDAO.updateByPrimaryKeySelective(record);
//    }


//    public int updateByPrimaryKey(AccountFlow record) {
//        return this.accountFlowDAO.updateByPrimaryKey(record);
//    }


    public int insert(AccountFlow record) {
        return this.accountFlowDAO.insert(record);
    }


    public int insertSelective(AccountFlow record) {
        return this.accountFlowDAO.insertSelective(record);
    }

    public int insertBatchSelective(List<AccountFlow> records) {
        return this.accountFlowDAO.insertBatchSelective(records);
    }

    @Override
    int updateService(AccountFlow record) {
        return this.accountFlowDAO.updateByPrimaryKeySelective(record);
    }

    /**
     * 统一更新状态
     *
     * @param record
     */
    public void updateStatus(AccountFlow record, Integer orginStatus) {

        Map<String, Object> map = null;
        try {
            map = BeanUtil.transBean2Map(record);
        } catch (Exception e) {
            LOGGER.error("updateStatus transBean2Map e={}", e);
            throw new CommonException(CommonErrorEnum.SYSTEM_EXCEPTION);
        }
        map.put("orginStatus", orginStatus);
        accountFlowDAO.updateStatus(map);
    }

    public BigDecimal queryTotalAmountByRem(AccountFlow accountFlow) {
        return accountFlowDAO.queryTotalAmountByRem(accountFlow);
    }

    /**
     * 查询提现处理中的流水单
     *
     * @return
     */
    public List<AccountFlow> queryCashOrderPending() {
        return accountFlowDAO.queryCashOrderPending();
    }

    /**
     * 查询对应用户的流水记录总数量
     * 如果记录是提现，则查询全部状态的
     *
     * @return
     */
    public int queryCountForBalance(AccountFlowQueryReq req) {
        return accountFlowDAO.queryCountForBalance(req);
    }

    /**
     * 查询对应用户的流水记录
     * 如果记录是提现，则查询全部状态的
     *
     * @return
     */
    public List<AccountFlow> queryListForBalance(AccountFlowQueryReq req) {
        return accountFlowDAO.queryListForBalance(req);
    }

}