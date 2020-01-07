package org.egg.biz;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.egg.enums.CommonErrorEnum;
import org.egg.enums.FeeTypeEnum;
import org.egg.exception.CommonException;
import org.egg.model.DO.FeeRule;
import org.egg.model.VO.FeeRuleQueryReq;
import org.egg.model.VO.FeeRuleRes;
import org.egg.response.PageResult;
import org.egg.service.impl.FeeRuleServiceImpl;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.BeanUtil;
import org.egg.utils.CheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chendatao on 2018/7/24.
 */
@Component
public class FeeRuleBiz {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeeRuleBiz.class);
    @Autowired
    private FeeRuleServiceImpl feeRuleService;
    @Autowired
    private BizTemplate bizTemplate;
    @Value("page.num")
    private String PAGE_NUM;

    public List<FeeRule> feeRules;

    /**
     * 分页查询
     *
     * @param feeRuleQueryReq
     * @return
     */
    public PageResult queryList(FeeRuleQueryReq feeRuleQueryReq) {
        PageResult pageResult = new PageResult();
        bizTemplate.processTX(pageResult, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("feeRuleQueryReq", feeRuleQueryReq);
                if (feeRuleQueryReq.getPageNum() == null) {
                    //默认每页数
                    feeRuleQueryReq.setPageNum(StringUtils.isBlank(PAGE_NUM) ?
                            100 : Integer.valueOf(PAGE_NUM));
                }
            }

            @Override
            public void doAction() {
                int i = feeRuleService.queryCount(feeRuleQueryReq);
                pageResult.setTotal(i);
                if (i != 0) {
                    List<FeeRule> feeRules = feeRuleService.queryList(feeRuleQueryReq);
                    ArrayList<FeeRuleRes> feeRuleResList = new ArrayList<>();
                    feeRules.forEach(items -> {
                        FeeRuleRes feeRuleRes = new FeeRuleRes();
                        BeanUtil.copyProperties(items, feeRuleRes);
                        feeRuleRes.setFeeTypeStr(FeeTypeEnum.getEnumByCode(items.getFeeType()).getDesc());
                        feeRuleResList.add(feeRuleRes);
                    });
                    pageResult.setData(feeRuleResList);
                }

            }
        });
        return pageResult;
    }

    /**
     * 计算平台手续费
     * 1.查询赏金对应的手续费收费规则
     * ps 目前定的规则是按赏金满减后
     *
     * @param rewardAmount 赏金
     * @return 手续费
     */
    public BigDecimal calcFee(BigDecimal rewardAmount) {
        BigDecimal fee = BigDecimal.ZERO;
        //1.查询赏金对应的手续费收费规则
        fee = ruleEngine(rewardAmount, rewardAmount, fee);
        LOGGER.info("赏金对应的手续费 fee={}", fee);
        //3.手续费不能小于0.01元
        if (fee.compareTo(new BigDecimal("0.01")) == -1) {
            LOGGER.warn("正常结算中 手续费小于0.01元 取0.01，fee={}", fee);
            fee = new BigDecimal("0.01");
        }
        LOGGER.info("最终 fee={}", fee);
        BigDecimal subtract = rewardAmount.subtract(fee);
        return subtract;
    }

    /**
     * 由于赏金和信誉分计算规则一样 只是来源金额一个是赏金一个是赏金计算后等到的手续费
     *
     * @param value  计算依赖 赏金或信誉分
     * @param source 计算依赖金额 赏金或赏金计算后等到的手续费
     * @param fee    当前手续费
     */
    private BigDecimal ruleEngine(BigDecimal value, BigDecimal source, BigDecimal fee) {
        FeeRuleQueryReq feeRuleQueryReq = new FeeRuleQueryReq();
        //列表是按阈值正序排序
        if (CollectionUtils.isEmpty(feeRules)) {
            feeRules = feeRuleService.queryList(feeRuleQueryReq);
        }
        if (CollectionUtils.isEmpty(feeRules)) {
            //无折扣规则
            return fee;
        }
        for (FeeRule feeRule : feeRules) {

            if (value.compareTo(feeRule.getFeeThresholdValue()) == -1) {
                FeeTypeEnum enumByCode2 = FeeTypeEnum.getEnumByCode(feeRule.getFeeType());
                //    命中此范围的规则
                switch (enumByCode2) {
                    case THRESHOLD_SUBTRACT:
                        //满减
                        fee = source.subtract(feeRule.getFeeValue());
                        break;
                    case THRESHOLD_DISCOUNT:
                        //满折 手续费是赏金的几折 splitFeeValue[i]是小数点不是百分比
                        fee = source.multiply(feeRule.getFeeValue());
                        break;
                    default:
                        throw new CommonException(CommonErrorEnum.WARN_ERROR_TIP);
                }
                break;
            }
            //    否则继续下一个
        }
        return fee;
    }

}
