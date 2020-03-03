package org.egg.biz;

import lombok.extern.slf4j.Slf4j;
import org.egg.enums.CommonErrorEnum;
import org.egg.exception.CommonException;
import org.egg.model.DTO.ActiveTeam;
import org.egg.model.VO.ActiveQueryReq;
import org.egg.response.BaseResult;
import org.egg.response.PageResult;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.BeanUtil;
import org.egg.utils.CheckUtil;
import org.egg.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dataochen
 * @Description
 * @date: 2020/3/3 17:40
 */
@Component
@Slf4j
public class ActiveBiz {
    @Autowired
    private BizTemplate bizTemplate;
    @Autowired
    private RedisUtil redisUtil;
    /**
     * 活动 队伍key
     */
    private static final String ACTIVE_TEAM = "ACTIVE_TEAM_";

    /**
     * 发放奖品
     * 指定队伍方法
     *todo
     * @return
     */
    public BaseResult allocationPrice(String teamNo) {
        log.info("allocationPrice teamNo={}", teamNo);
        BaseResult builder = BaseResult.builder();
        bizTemplate.process(builder, new TemplateCallBack() {
            @Override
            public void doCheck() {

            }

            @Override
            public void doAction() {
                ActiveTeam activeTeam = new ActiveTeam();
                String key = ACTIVE_TEAM + teamNo;
                Map<Object, Object> hmget = redisUtil.hmget(key);
                if (CollectionUtils.isEmpty(hmget)) {
                    log.error("队伍不存在 ");
                    throw new CommonException(CommonErrorEnum.PARAM_ERROR);
                }

                HashMap<String, Object> stringObjectHashMap = new HashMap<>(hmget.size());
                hmget.forEach((key1, value) -> stringObjectHashMap.put(key1.toString(), value));
                try {
                    BeanUtil.transMap2Bean(stringObjectHashMap, activeTeam);
                } catch (Exception e) {
                    log.error("getTeam e={}", e);
                    throw new CommonException(CommonErrorEnum.SYSTEM_EXCEPTION);
                }
                Integer integralTotal = activeTeam.getIntegralTotal();
                if (integralTotal < 10) {
                    log.error("队伍积分不足 integralTotal={}", integralTotal);
                    throw new CommonException(CommonErrorEnum.PARAM_ERROR);
                } else if (integralTotal >= 30) {
//                    发放2个奖品
                } else {
//                    发放1个奖品

                }

//        type:ONE 1.5元 队伍内随机分 ；TWO:均分1.21元 现金红包

                //    //                1.查询队伍人数 随机分配金额
//    ActiveOpenId openInfo = redisService.getOpenInfo(userNo);
//    ActiveTeam team = redisService.getTeam(openInfo.getTeamNo());
//    int size = team.getUserList().size();
//    List<BigDecimal> bigDecimals = CommonUtil.randomRedPackage(new BigDecimal("1.5"), size);
            }
        });
        return builder;
    }

    /**
     * 查询数据
     * 不支持分页
     *
     * @param activeQueryReq
     * @return
     */
    public PageResult queryList(ActiveQueryReq activeQueryReq) {
        PageResult result = new PageResult();
        bizTemplate.process(result, new TemplateCallBack() {
            @Override
            public void doCheck() {
                CheckUtil.isNotNull("activeQueryReq", activeQueryReq);
                if (activeQueryReq.getPageNum() == null) {
                    //默认每页数
                    activeQueryReq.setPageNum(10);
                }
            }

            @Override
            public void doAction() {
                ArrayList<ActiveTeam> activeTeams = new ArrayList<>();
                Set keys = redisUtil.keys(ACTIVE_TEAM);
                if (CollectionUtils.isEmpty(keys)) {
                    return;
                }
                keys.forEach(x -> {
                    ActiveTeam activeTeam = new ActiveTeam();
                    Map<Object, Object> hmget = redisUtil.hmget(x.toString());
                    if (CollectionUtils.isEmpty(hmget)) {
                        return;
                    }

                    HashMap<String, Object> stringObjectHashMap = new HashMap<>(hmget.size());
                    hmget.forEach((key1, value) -> stringObjectHashMap.put(key1.toString(), value));
                    try {
                        BeanUtil.transMap2Bean(stringObjectHashMap, activeTeam);
                    } catch (Exception e) {
                        log.error("getTeam e={}", e);
                        return;
                    }
                    activeTeams.add(activeTeam);
                });
                result.setData(activeTeams);
                result.setTotal(keys.size());
//                筛选
                if (activeQueryReq.getMinIntegralTotal() != null) {
                    List<ActiveTeam> collect = activeTeams.stream().filter(x -> x.getIntegralTotal() > activeQueryReq.getMinIntegralTotal())
                            .collect(Collectors.toList());
                    result.setData(collect);
                    result.setTotal(collect.size());
                }
//                排序 倒叙
                if (!StringUtils.isEmpty(activeQueryReq.getOrderByColumn())) {
                    List<ActiveTeam> data = result.getData();
                    if ("integralTotal".equals(activeQueryReq.getOrderByColumn())) {
                        Collections.sort(data, (x1, x2) -> x1.getIntegralTotal().compareTo(x2.getIntegralTotal()) == -1 ? 1 : -1);
                    } else {
                        Collections.sort(data, (x1, x2) -> x1.getCreatedTime().compareTo(x2.getCreatedTime()) == -1 ? 1 : -1);
                    }
                }
            }
        });
        return result;
    }
}
