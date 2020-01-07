package org.egg.biz;

import org.apache.commons.lang3.StringUtils;
import org.egg.model.DO.FeedBack;
import org.egg.model.VO.FeedBackQueryReq;
import org.egg.response.PageResult;
import org.egg.service.impl.FeedBackServiceImpl;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.CheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chendatao on 2018/7/24.
 */
@Component
public class FeedBackBiz {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeedBackBiz.class);
    @Autowired
    private FeedBackServiceImpl feedBackService;
    @Autowired
    private BizTemplate bizTemplate;
    @Value("page.num")
    private String PAGE_NUM;


    /**
     * 分页查询
     * 反馈记录
     *
     * @param feedBackQueryReq
     * @return
     */
    public PageResult feedBackRecordList(FeedBackQueryReq feedBackQueryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.processTX(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("feedBackQueryReq", feedBackQueryReq);
                if (feedBackQueryReq.getPageNum() == null) {
                    //默认每页数
                    feedBackQueryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = feedBackService.queryCount(feedBackQueryReq);
                pageResult.setTotal(i);
                List<FeedBack> feedBacks = new ArrayList<>();
                if (i != 0) {
                    feedBacks = feedBackService.queryList(feedBackQueryReq);
                }
                pageResult.setData(feedBacks);

            }
        });
        return pageResult;
    }

}
