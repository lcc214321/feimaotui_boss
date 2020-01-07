package org.egg.biz;

import org.apache.commons.lang3.StringUtils;
import org.egg.model.DO.GradeRecord;
import org.egg.model.VO.GradeRecordQueryReq;
import org.egg.response.PageResult;
import org.egg.service.impl.GradeRecordService;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author dataochen
 * @Description
 * @date: 2018/12/21 18:20
 */
@Component
public class GradeRecordBiz {
    @Autowired
    private GradeRecordService gradeRecordService;
    @Autowired
    private BizTemplate bizTemplate;
    @Value("page.num")
    private String PAGE_NUM;

    /**
     * 分页查询
     *
     * @param gradeRecordQueryReq
     * @return
     */
    public PageResult queryList(GradeRecordQueryReq gradeRecordQueryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.process(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("gradeRecordQueryReq", gradeRecordQueryReq);
                if (gradeRecordQueryReq.getPageNum() == null) {
                    //默认每页数
                    gradeRecordQueryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = gradeRecordService.queryCount(gradeRecordQueryReq);
                pageResult.setTotal(i);
                if (i != 0) {
                    List<GradeRecord> gradeRecords = gradeRecordService.queryList(gradeRecordQueryReq);
                    if (CollectionUtils.isEmpty(gradeRecords)) {
                        return;
                    }
                    pageResult.setData(gradeRecords);
                }

            }
        });
        return pageResult;
    }
}
