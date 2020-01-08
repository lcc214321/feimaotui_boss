package org.egg.biz;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.egg.enums.ApproveStatusEnum;
import org.egg.model.DO.Approve;
import org.egg.model.DO.User;
import org.egg.model.VO.ApproveQueryReq;
import org.egg.model.VO.ApproveRes;
import org.egg.model.VO.UserQueryReq;
import org.egg.response.BaseResult;
import org.egg.response.PageResult;
import org.egg.service.impl.ApproveService;
import org.egg.service.impl.UserServiceImpl;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.BeanUtil;
import org.egg.utils.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/13 16:32
 */
@Component
@Slf4j
public class ApproveBiz {
    @Value("page.num")
    private String PAGE_NUM;
    @Value("${environment}")
    private String ENVIRONMENT;
    @Autowired
    private BizTemplate bizTemplate;
    @Autowired
    private ApproveService approveService;
    @Autowired
    private UserServiceImpl userService;

    public PageResult queryList4Boss(ApproveQueryReq queryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.process(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("queryReq", queryReq);
                if (queryReq.getPageNum() == null) {
                    //默认每页数
                    queryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = approveService.queryCount(queryReq);
                pageResult.setTotal(i);
                if (i != 0) {
                    List<Approve> approves = approveService.queryList(queryReq);
                    if (CollectionUtils.isEmpty(approves)) {
                        return;
                    }
                    ArrayList<ApproveRes> approveRes = new ArrayList<>();
                    for (Approve item : approves) {
                        ApproveRes approveRes1 = new ApproveRes();
                        BeanUtil.copyProperties(item, approveRes1);
                        approveRes1.setRealStatusStr(ApproveStatusEnum.getDescByCode(item.getStatus()));
                        approveRes.add(approveRes1);
                    }
                    pageResult.setData(approveRes);
                }

            }
        });
        return pageResult;
    }

    public BaseResult approveSucc(Approve approve, Long id) {
        BaseResult builder = BaseResult.builder();
        UserQueryReq userQueryReq = new UserQueryReq();
        userQueryReq.setUserNo(approve.getUserNo());
        List<User> users = userService.queryList(userQueryReq);
        User user = users.get(0);
        bizTemplate.processTX(builder, new TemplateCallBack() {
            @Override
            public void doCheck() {

                CheckUtil.isNotBlank("性别", approve.getGender());
                CheckUtil.isNotBlank("真实姓名", approve.getRealName());
                CheckUtil.isNotBlank("学校", approve.getStuSchName());
                CheckUtil.isNotBlank("证件号", approve.getRealIdNo());
                CheckUtil.isNotBlank("寝室楼号", approve.getStuAddressL());
                CheckUtil.isNotBlank("寝室地址", approve.getStuAddressQ());

            }

            @Override
            public void doAction() {
                if (ApproveStatusEnum.SUCC.getCode().equals(user.getRealStatus())) {
                    approve.setStatus(ApproveStatusEnum.CLOSE.getCode());
                } else {
                    approve.setStatus(ApproveStatusEnum.SUCC.getCode());
                    //                查询用户信息并同步
                    user.setRealName(approve.getRealName());
                    user.setGender(approve.getGender());
                    user.setSchName(approve.getStuSchName());
                    user.setRealIdNo(approve.getRealIdNo());
                    user.setAddressL(approve.getStuAddressL());
                    user.setAddressQ(approve.getStuAddressQ());
                    user.setRealStatus(ApproveStatusEnum.SUCC.getCode());
                    userService.update(user);
                }
                approveService.update(approve);

            }
        });
        return builder;
    }

    public BaseResult approveFail(Long id) {
        BaseResult builder = BaseResult.builder();
        bizTemplate.process(builder, new TemplateCallBack() {
            @Override
            public void doCheck() {
            }

            @Override
            public void doAction() {
                Approve approve = new Approve();
                approve.setStatus(ApproveStatusEnum.FAIL.getCode());
                approve.setId(id);
                approveService.update(approve);

            }
        });
        return builder;
    }
}
