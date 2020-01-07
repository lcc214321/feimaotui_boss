package org.egg.biz;

import org.apache.commons.lang3.StringUtils;
import org.egg.enums.RecommendTypeEnum;
import org.egg.model.DO.Recommend;
import org.egg.model.VO.RecommendQueryReq;
import org.egg.model.VO.RecommendRes;
import org.egg.response.PageResult;
import org.egg.service.impl.RecommendServiceImpl;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.BeanUtil;
import org.egg.utils.CheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cdt
 * @Description
 * @date: 2018/8/14 15:39
 */
@Component
public class RecommendBiz {
    private static final Logger LOGGER = LoggerFactory.getLogger(RecommendBiz.class);

    @Autowired
    private RecommendServiceImpl recommendService;
    @Autowired
    private BizTemplate bizTemplate;
    @Value("page.num")
    private String PAGE_NUM;

    /**
     * 分页查询
     *
     * @param recommendQueryReq
     * @return
     */
    public PageResult queryList(RecommendQueryReq recommendQueryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.processTX(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("recommendQueryReq", recommendQueryReq);
                if (recommendQueryReq.getPageNum() == null) {
                    //默认每页数
                    recommendQueryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = recommendService.queryCount(recommendQueryReq);
                pageResult.setTotal(i);
                if (i != 0) {
                    List<Recommend> recommends = recommendService.queryList(recommendQueryReq);
                    if (CollectionUtils.isEmpty(recommends)) {
                        return;
                    }
                    ArrayList<RecommendRes> recommendResArrayList = new ArrayList<>();
                    for (Recommend recommend : recommends) {
                        RecommendRes recommendRes = new RecommendRes();
                        BeanUtil.copyProperties(recommend, recommendRes);
                        recommendRes.setRecommendTypeStr(RecommendTypeEnum.getEnumByCode(recommend.getRecommendType()).getDesc());
                        recommendResArrayList.add(recommendRes);
                    }
                    pageResult.setData(recommendResArrayList);
                }

            }
        });
        return pageResult;
    }
}
