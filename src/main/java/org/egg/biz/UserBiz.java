package org.egg.biz;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.egg.enums.ApproveStatusEnum;
import org.egg.enums.CommonErrorEnum;
import org.egg.enums.CreditScoreOperatTypeEnum;
import org.egg.enums.UserStatusEnum;
import org.egg.exception.CommonException;
import org.egg.model.DO.CreditScoreFlow;
import org.egg.model.DO.User;
import org.egg.model.DTO.UserModifyDto;
import org.egg.model.VO.*;
import org.egg.response.BaseResult;
import org.egg.response.PageResult;
import org.egg.service.impl.*;
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
 * Created by chendatao on 2017/12/3.
 */
@Service
public class UserBiz {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserBiz.class);
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private BizTemplate bizTemplate;
    @Autowired
    private PublishOrderServiceImpl publishOrderService;
    @Autowired
    private AcceptOrderServiceImpl acceptOrderService;
    @Autowired
    private AccountFlowServiceImpl accountFlowService;
    @Autowired
    private CreditScoreFlowServiceImpl creditScoreFlowService;
    @Autowired
    private RecommendServiceImpl recommendService;
    @Value("page.num")
    private String PAGE_NUM;

//    boss

    /**
     * 分页查询
     * 用户信息
     *
     * @param userStuQueryReq
     * @return
     */
    public PageResult userQueryList(UserQueryReq userStuQueryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.processTX(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("userQueryReq", userStuQueryReq);
                if (userStuQueryReq.getPageNum() == null) {
                    //默认每页数
                    userStuQueryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = userService.queryCount(userStuQueryReq);
                pageResult.setTotal(i);
                if (i != 0) {
                    List<User> users = userService.queryList(userStuQueryReq);
                    ArrayList<UserVO> UserResArrayList = new ArrayList<>();
                    if (CollectionUtils.isNotEmpty(users)) {
                        users.forEach(item -> {
                            UserVO userVO = new UserVO();
                            BeanUtil.copyProperties(item, userVO);
                            userVO.setUserStatusStr(UserStatusEnum.getDescByCode(item.getUserStatus()));
                            userVO.setRealStatusStr(ApproveStatusEnum.getDescByCode(item.getRealStatus()));
                            UserResArrayList.add(userVO);
                        });
                        pageResult.setData(UserResArrayList);
                    }
                }

            }
        });
        return pageResult;
    }

    /**
     * 分页查询
     * 信誉分
     *
     * @param creditScoreFlowQueryReq
     * @return
     */
    public PageResult creditScoreQueryList(CreditScoreFlowQueryReq creditScoreFlowQueryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.processTX(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("creditScoreFlowQueryReq", creditScoreFlowQueryReq);
                if (creditScoreFlowQueryReq.getPageNum() == null) {
                    //默认每页数
                    creditScoreFlowQueryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = creditScoreFlowService.queryCount(creditScoreFlowQueryReq);
                pageResult.setTotal(i);
                if (i != 0) {
                    List<CreditScoreFlow> creditScoreFlows = creditScoreFlowService.queryList(creditScoreFlowQueryReq);
                    ArrayList<CreditScoreRes> creditScoreResArrayList = new ArrayList<CreditScoreRes>();
                    if (CollectionUtils.isNotEmpty(creditScoreFlows)) {
                        creditScoreFlows.forEach(item -> {
                            CreditScoreRes creditScoreRes = new CreditScoreRes();
                            BeanUtil.copyProperties(item, creditScoreRes);
                            creditScoreRes.setOperTypeStr(CreditScoreOperatTypeEnum.getDescByCode(item.getOperType()));
                            creditScoreResArrayList.add(creditScoreRes);
                        });
                        pageResult.setData(creditScoreResArrayList);
                    }
                }

            }
        });
        return pageResult;
    }

    /**
     * 根据主键id更新状态
     *
     * @param user
     * @return
     */
    public BaseResult updateStatus(User user) {
        BaseResult result = new BaseResult();
        bizTemplate.process(result, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("user.id", user.getId());
                CheckUtil.isNotNull("user.status", user.getUserStatus());
                CheckUtil.isNotNull("user.version", user.getVersion());
            }

            @Override
            public void doAction() {
                userService.update(user);
            }
        });
        return result;
    }


    public BaseResult modifyUser(UserModifyDto userModifyDto, String userNo) {
        BaseResult result = BaseResult.builder();
        bizTemplate.process(result, new TemplateCallBack() {
            @Override
            public void doCheck() {

            }

            @Override
            public void doAction() {
                UserQueryReq userQueryReq = new UserQueryReq();
                userQueryReq.setUserNo(userNo);
                userQueryReq.setUserStatus(UserStatusEnum.EFFECT.getCode());
                List<User> users = userService.queryList(userQueryReq);
                if (CollectionUtils.isEmpty(users)) {
                    LOGGER.error("#modifyUser users is empty,userNo={}", userNo);
                    throw new CommonException(CommonErrorEnum.PARAM_ERROR);
                }
                User user = users.get(0);
                user.setGender(userModifyDto.getGender());
                user.setNickName(userModifyDto.getNickName());
                user.setSchName(userModifyDto.getSchName());
                user.setAddressL(userModifyDto.getAddressL());
                user.setAddressQ(userModifyDto.getAddressQ());
                userService.updateByPrimaryKeySelective(user);
            }
        });
        return result;
    }

}
