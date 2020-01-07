package org.egg.biz;

import org.apache.commons.lang3.StringUtils;
import org.egg.model.DO.WxAccessToken;
import org.egg.model.DO.WxAccessTokenUser;
import org.egg.model.VO.WxAccessTokenQueryReq;
import org.egg.model.VO.WxAccessTokenUserQueryReq;
import org.egg.response.PageResult;
import org.egg.service.impl.WxAccessTokenServiceImpl;
import org.egg.service.impl.WxAccessTokenUserServiceImpl;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chendatao on 2018/7/24.
 */
@Component
public class WxBiz {
    @Autowired
    private WxAccessTokenServiceImpl wxAccessTokenService;
    @Autowired
    private WxAccessTokenUserServiceImpl wxAccessTokenUserService;
    @Autowired
    private BizTemplate bizTemplate;
    @Value("page.num")
    private String PAGE_NUM;

    /**
     * 分页查询 平台微信token
     *
     * @param wxAccessTokenQueryReq
     * @return
     */
    public PageResult wxTokenQueryList(WxAccessTokenQueryReq wxAccessTokenQueryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.processTX(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("wxAccessTokenQueryReq", wxAccessTokenQueryReq);
                if (wxAccessTokenQueryReq.getPageNum() == null) {
                    //默认每页数
                    wxAccessTokenQueryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = wxAccessTokenService.queryCount(wxAccessTokenQueryReq);
                pageResult.setTotal(i);
                List<WxAccessToken> wxAccessTokens = new ArrayList<>();
                if (i != 0) {
                    wxAccessTokens = wxAccessTokenService.queryList(wxAccessTokenQueryReq);
                }
                    pageResult.setData(wxAccessTokens);

            }
        });
        return pageResult;
    }

    /**
     * 分页查询 用户微信token
     *
     * @param wxAccessTokenUserQueryReq
     * @return
     */
    public PageResult wxUserTokenQueryList(WxAccessTokenUserQueryReq wxAccessTokenUserQueryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.processTX(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("wxAccessTokenUserQueryReq", wxAccessTokenUserQueryReq);
                if (wxAccessTokenUserQueryReq.getPageNum() == null) {
                    //默认每页数
                    wxAccessTokenUserQueryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = wxAccessTokenUserService.queryCount(wxAccessTokenUserQueryReq);
                pageResult.setTotal(i);
                List<WxAccessTokenUser> wxAccessTokens  = new ArrayList<>();
                if (i != 0) {
                    wxAccessTokens = wxAccessTokenUserService.queryList(wxAccessTokenUserQueryReq);
                }
                    pageResult.setData(wxAccessTokens);

            }
        });
        return pageResult;
    }


}
