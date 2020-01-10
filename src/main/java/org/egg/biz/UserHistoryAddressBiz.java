package org.egg.biz;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.egg.model.DO.UserHistoryAddress;
import org.egg.model.VO.UserHistoryAddressQuery;
import org.egg.response.PageResult;
import org.egg.service.impl.UserHistoryAdressServiceImpl;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author dataochen
 * @Description
 * @date: 2020/1/3 16:37
 */
@Component
@Slf4j
public class UserHistoryAddressBiz {
    @Autowired
    private UserHistoryAdressServiceImpl userHistoryAdressService;
    @Autowired
    private BizTemplate bizTemplate;
    @Value("page.num")
    private String PAGE_NUM;

    public PageResult queryList(UserHistoryAddressQuery userHistoryAddressQuery) {
        PageResult result = new PageResult();
        log.info("userHistoryAddressQuery={}", JSONObject.toJSONString(userHistoryAddressQuery));
        bizTemplate.process(result, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("userHistoryAddressQuery", userHistoryAddressQuery);
                if (userHistoryAddressQuery.getPageNum() == null) {
                    //默认每页数
                    userHistoryAddressQuery.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                List<UserHistoryAddress> userHistoryAddresses = userHistoryAdressService.queryList(userHistoryAddressQuery);
                result.setData(userHistoryAddresses);

            }
        });
        log.info("userHistoryAddressCommonSingleResult={}", JSONObject.toJSONString(result));
        return result;
    }
}
