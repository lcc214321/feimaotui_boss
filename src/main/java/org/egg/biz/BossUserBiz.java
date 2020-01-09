package org.egg.biz;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.egg.enums.BossUserLevelEnum;
import org.egg.enums.BossUserStatusEnum;
import org.egg.enums.CommonErrorEnum;
import org.egg.exception.CommonException;
import org.egg.model.DO.BossUser;
import org.egg.model.DTO.BossLoginDto;
import org.egg.model.VO.BossUserQueryReq;
import org.egg.model.VO.BossUserRes;
import org.egg.response.BaseResult;
import org.egg.response.PageResult;
import org.egg.service.impl.BossUserServiceImpl;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.CheckUtil;
import org.egg.utils.ConstantsUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/16 14:18
 */
@Component
@Slf4j
public class BossUserBiz {

    @Autowired
    private BossUserServiceImpl bossUserService;
    @Autowired
    private BizTemplate bizTemplate;
    @Value("page.num")
    private String PAGE_NUM;

    public BaseResult login(BossLoginDto bossLoginDto, HttpServletRequest request) {
        BaseResult result = new BaseResult();
        bizTemplate.process(result, new TemplateCallBack() {
            @Override
            public void doCheck() {

            }

            @Override
            public void doAction() {

                String name = bossLoginDto.getName();
                String pwd = bossLoginDto.getPwd();
                BossUserQueryReq bossUserQueryReq = new BossUserQueryReq();
                bossUserQueryReq.setLoginName(name);
                bossUserQueryReq.setLoginPwd(pwd);
                bossUserQueryReq.setStatus(BossUserStatusEnum.EFFECT.getCode());
                List<BossUser> bossUsers = bossUserService.queryList(bossUserQueryReq);
                if (CollectionUtils.isEmpty(bossUsers)) {
                    log.error("用户名密码不正确 bossLoginDto={}", JSONObject.toJSONString(bossLoginDto));
                    throw new CommonException(CommonErrorEnum.ACCOUNT_PASSWORD_ERROR);
                }
                HttpSession session = request.getSession();
                session.setAttribute(ConstantsUtil.BOSS_USER_KEY, bossUsers.get(0));
            }
        });
        return result;
    }

    /**
     * 分页查询
     *
     * @param bossUserQueryReq
     * @return
     */
    public PageResult queryList(BossUserQueryReq bossUserQueryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.process(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("bossUserQueryReq", bossUserQueryReq);
            }

            @Override
            public void doAction() {
                int i = bossUserService.queryCount(bossUserQueryReq);
                pageResult.setTotal(i);
                if (i != 0) {
                    List<BossUser> bossUsers = bossUserService.queryList(bossUserQueryReq);
                    if (CollectionUtils.isEmpty(bossUsers)) {
                        return;
                    }
                    ArrayList<BossUserRes> bossUserRes = new ArrayList<>();
                    bossUsers.forEach(item -> {
                        BossUserRes bossUserRes1 = new BossUserRes();
                        BeanUtils.copyProperties(item,bossUserRes1);
                        bossUserRes1.setUserStatusStr(BossUserStatusEnum.getDescByCode(item.getStatus()));
                        bossUserRes1.setLevelStr(BossUserLevelEnum.getCodeDescMap().get(item.getLevel()));
                        bossUserRes.add(bossUserRes1);
                    });
                    pageResult.setData(bossUserRes);
                }

            }
        });
        return pageResult;
    }

    public BaseResult modifyBossUser(BossUser bossUser) {
        BaseResult result = new BaseResult();
        bizTemplate.process(result, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("bossUser.id", bossUser.getId());
            }

            @Override
            public void doAction() {
                bossUserService.update(bossUser);
            }
        });
        return result;
    }

    public BaseResult switchStatus(String loginName, String status) {
        BaseResult result = new BaseResult();
        bizTemplate.process(result, new TemplateCallBack() {
            @Override
            public void doCheck() {
            }

            @Override
            public void doAction() {
                BossUserQueryReq bossUserQueryReq = new BossUserQueryReq();
                bossUserQueryReq.setLoginName(loginName);
                List<BossUser> bossUsers = bossUserService.queryList(bossUserQueryReq);
                if (CollectionUtils.isEmpty(bossUsers)) {
                    throw new CommonException(CommonErrorEnum.PARAM_ERROR);
                }
                BossUser bossUser = bossUsers.get(0);
                bossUser.setStatus(status);
                bossUserService.update(bossUser);
            }
        });
        return result;
    }

    public BaseResult delete(String loginName) {
        BaseResult result = new BaseResult();
        bizTemplate.process(result, new TemplateCallBack() {
            @Override
            public void doCheck() {
            }

            @Override
            public void doAction() {
                BossUserQueryReq bossUserQueryReq = new BossUserQueryReq();
                bossUserQueryReq.setLoginName(loginName);
                List<BossUser> bossUsers = bossUserService.queryList(bossUserQueryReq);
                if (CollectionUtils.isEmpty(bossUsers)) {
                    throw new CommonException(CommonErrorEnum.PARAM_ERROR);
                }
                BossUser bossUser = bossUsers.get(0);
                bossUser.setStatus(BossUserStatusEnum.CANCEL.getCode());
                bossUserService.update(bossUser);
            }
        });
        return result;
    }

    public BaseResult restPwd(String loginName) {
        BaseResult result = new BaseResult();
        bizTemplate.process(result, new TemplateCallBack() {
            @Override
            public void doCheck() {
            }

            @Override
            public void doAction() {
                BossUserQueryReq bossUserQueryReq = new BossUserQueryReq();
                bossUserQueryReq.setLoginName(loginName);
                List<BossUser> bossUsers = bossUserService.queryList(bossUserQueryReq);
                if (CollectionUtils.isEmpty(bossUsers)) {
                    throw new CommonException(CommonErrorEnum.PARAM_ERROR);
                }
                BossUser bossUser = bossUsers.get(0);
                bossUser.setLoginPwd("123456");
                bossUserService.update(bossUser);
            }
        });
        return result;
    }

    public BaseResult addUser(BossUser bossUser) {
        BaseResult result = new BaseResult();
        bizTemplate.process(result, new TemplateCallBack() {
            @Override
            public void doCheck() {
            }

            @Override
            public void doAction() {
                BossUserQueryReq bossUserQueryReq = new BossUserQueryReq();
                bossUserQueryReq.setLoginName(bossUser.getLoginName());
                List<BossUser> bossUsers = bossUserService.queryList(bossUserQueryReq);
                if (!CollectionUtils.isEmpty(bossUsers)) {
                    throw new CommonException("用戶名已存在");
                }
                bossUserService.create(bossUser);
            }
        });
        return result;
    }

    public BaseResult modifyPwd(String userNo, String oldPwd, String newPwd, HttpServletRequest request) {
        BaseResult result = new BaseResult();
        bizTemplate.process(result, new TemplateCallBack() {
            @Override
            public void doCheck() {
            }

            @Override
            public void doAction() {
                BossUserQueryReq bossUserQueryReq = new BossUserQueryReq();
                bossUserQueryReq.setBossUserNo(userNo);
                List<BossUser> bossUsers = bossUserService.queryList(bossUserQueryReq);
                if (CollectionUtils.isEmpty(bossUsers)) {
                    throw new CommonException(CommonErrorEnum.PARAM_ERROR);
                }
                BossUser bossUser = bossUsers.get(0);
                if (!bossUser.getLoginPwd().equals(oldPwd)) {
                    throw new CommonException(CommonErrorEnum.PARAM_ERROR.getCode(), "原密码错误");
                }
                bossUser.setLoginPwd(newPwd);
                bossUserService.update(bossUser);
                HttpSession session = request.getSession();
                session.setAttribute(ConstantsUtil.BOSS_USER_KEY, null);
            }
        });
        return result;
    }

}
