package org.egg.biz;

import org.apache.commons.lang3.StringUtils;
import org.egg.enums.ShareStatusEnum;
import org.egg.enums.ShareTypeEnum;
import org.egg.model.DO.ShareRecord;
import org.egg.model.VO.ShareRecordQueryReq;
import org.egg.model.VO.ShareRecordVo;
import org.egg.response.PageResult;
import org.egg.service.impl.ShareRecordServiceImpl;
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
 * @date: 2018/12/21 18:20
 */
@Component
public class ShareRecordBiz {
    @Autowired
    private ShareRecordServiceImpl shareRecordService;
    @Autowired
    private BizTemplate bizTemplate;
    @Value("page.num")
    private String PAGE_NUM;

    /**
     * 分页查询
     *
     * @param shareRecordQueryReq
     * @return
     */
    public PageResult queryList(ShareRecordQueryReq shareRecordQueryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.process(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("shareRecordQueryReq", shareRecordQueryReq);
                if (shareRecordQueryReq.getPageNum() == null) {
                    //默认每页数
                    shareRecordQueryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = shareRecordService.queryCount(shareRecordQueryReq);
                pageResult.setTotal(i);
                if (i != 0) {
                    List<ShareRecord> shareRecords = shareRecordService.queryList(shareRecordQueryReq);
                    if (CollectionUtils.isEmpty(shareRecords)) {
                        return;
                    }
                    ArrayList<ShareRecordVo> shareRecordVos = new ArrayList<>();
                    for (ShareRecord shareRecord : shareRecords) {
                        ShareRecordVo shareRecordVo = new ShareRecordVo();
                        BeanUtil.copyProperties(shareRecord, shareRecordVo);
                        shareRecordVo.setShareStatusStr(ShareStatusEnum.getDescByCode(shareRecord.getShareStatus()));
                        shareRecordVo.setShareTypeStr(ShareTypeEnum.getDescByCode(shareRecord.getShareType()));
                        shareRecordVos.add(shareRecordVo);
                    }
                    pageResult.setData(shareRecordVos);
                }

            }
        });
        return pageResult;
    }
}
