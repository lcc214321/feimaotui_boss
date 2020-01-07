/* https://github.com/cdt */
package org.egg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.egg.model.DO.AccountFlow;
import org.egg.model.VO.AccountFlowQueryReq;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 本文件由 https://github.com/cdt/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author cdt
 * date:2018/03/16 17:30
 */
@Mapper
public interface AccountFlowDAO extends CustomMapper<AccountFlowQueryReq, AccountFlow, Long> {
    void updateCashSucc(Long id);

    BigDecimal queryTotalAmountByRem(AccountFlow accountFlow);

    /**
     * 查询提现处理中的流水单
     * @return
     */
    List<AccountFlow> queryCashOrderPending();
    /**
     * 查询对应用户的流水记录总数量
     * 如果记录是提现，则查询全部状态的
     *
     * @return
     */
    int queryCountForBalance(AccountFlowQueryReq req);
    /**
     * 查询对应用户的流水记录
     * 如果记录是提现，则查询全部状态的
     * @return
     */
    List<AccountFlow> queryListForBalance(AccountFlowQueryReq req);

    int updateStatus(Map<String, Object> map);
}