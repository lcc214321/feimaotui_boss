package org.egg.biz;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.egg.enums.AccountFlowStatusEnum;
import org.egg.enums.AccountFlowTypeEnum;
import org.egg.enums.FlowAccTypeEnum;
import org.egg.enums.FlowUserTypeEnum;
import org.egg.model.DO.AccountFlow;
import org.egg.model.VO.AccountFlowQueryReq;
import org.egg.model.VO.AccountFlowRes;
import org.egg.response.PageResult;
import org.egg.service.impl.AccountFlowServiceImpl;
import org.egg.service.impl.PublishOrderServiceImpl;
import org.egg.service.impl.UserServiceImpl;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.BeanUtil;
import org.egg.utils.CheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cdt
 * @Description 记账引擎
 * @date: 2018/3/16 17:46
 */
@Service
public class AccountFlowBiz {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountFlowBiz.class);

    @Autowired
    private AccountFlowServiceImpl accountFlowService;
    @Autowired
    private PublishOrderServiceImpl publishOrderService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private BizTemplate bizTemplate;
    @Value("page.num")
    private String PAGE_NUM;
    @Value("${environment}")
    private String ENVIRONMENT;




    /**
     * 分页查询
     * accountFlow
     *
     * @param accountFlowQueryReq
     * @return
     */
    public PageResult accountFlowList(AccountFlowQueryReq accountFlowQueryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.process(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("accountFlowQueryReq", accountFlowQueryReq);
                if (accountFlowQueryReq.getPageNum() == null) {
                    //默认每页数
                    accountFlowQueryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = accountFlowService.queryCount(accountFlowQueryReq);
                pageResult.setTotal(i);
                if (i != 0) {
                    List<AccountFlow> accountFlows = accountFlowService.queryList(accountFlowQueryReq);
                    ArrayList<AccountFlowRes> accountFlowResArrayList = new ArrayList<>();
                    if (CollectionUtils.isNotEmpty(accountFlows)) {
                        accountFlows.forEach(item -> {
                            AccountFlowRes accountFlowRes = new AccountFlowRes();
                            BeanUtil.copyProperties(item, accountFlowRes);
                            accountFlowRes.setFlowUserTypeStr(FlowUserTypeEnum.getDescByIndex(item.getFlowUserType()));
                            accountFlowRes.setRecordStatusStr(AccountFlowStatusEnum.getDescByIndex(item.getRecordStatus()));
                            accountFlowRes.setAccTypeStr(FlowAccTypeEnum.getDescByIndex(item.getAccType()));
                            accountFlowRes.setRecordTypeStr(AccountFlowTypeEnum.getDescByIndex(item.getRecordType()));
                            accountFlowResArrayList.add(accountFlowRes);

                        });
                    }
                    pageResult.setData(accountFlowResArrayList);
                }

            }
        });
        return pageResult;
    }



}
