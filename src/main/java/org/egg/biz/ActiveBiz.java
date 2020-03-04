package org.egg.biz;

import lombok.extern.slf4j.Slf4j;
import org.egg.enums.CommonErrorEnum;
import org.egg.exception.CommonException;
import org.egg.model.DTO.ActivePrice;
import org.egg.model.DTO.ActiveTeam;
import org.egg.model.DTO.ActiveUser;
import org.egg.model.VO.ActiveQueryReq;
import org.egg.response.BaseResult;
import org.egg.response.PageResult;
import org.egg.template.BizTemplate;
import org.egg.template.TemplateCallBack;
import org.egg.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
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
    @Autowired
    private SnowFlake snowFlake;
    /**
     * 活动 队伍key
     */
    private static final String ACTIVE_TEAM = "ACTIVE_TEAM_";
    /**
     * 活动 中奖名单key
     */
    public static final String ACTIVE_PRICE = "ACTIVE_PRICE_";

    /**
     * 发放奖品
     * 指定队伍方法
     *
     *
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
                String priceStatus = activeTeam.getPriceStatus();
//                是否已开奖
                if ("ON".equals(priceStatus)) {
                    log.error("已开奖 ");
                    throw new CommonException(CommonErrorEnum.PARAM_ERROR.getCode(), "已开奖");
                }
                int size = activeTeam.getUserList().size();
//                人数必须大于等于4人 小于等于8人
                if (size < 4 || size > 8) {
                    log.warn("人数不满足 size={}", size);
                    throw new CommonException(CommonErrorEnum.PARAM_ERROR.getCode(), "人数不满足");
                }

                Integer integralTotal = activeTeam.getIntegralTotal();
                integralTotal = integralTotal == null ? 0 : integralTotal;
                List<ActiveUser> userList = activeTeam.getUserList();
                if (integralTotal < 10) {
                    log.error("队伍积分不足 integralTotal={}", integralTotal);
                    throw new CommonException(CommonErrorEnum.PARAM_ERROR);
                } else {
//                    发放1个奖品 ONE
                    ArrayList<ActivePrice> activePrices = new ArrayList<>();
                    sendPrice4One(userList, activePrices);


                    if (integralTotal >= 30) {
                        ArrayList<ActivePrice> activePrices2 = new ArrayList<>();
                        sendPrice4One(userList, activePrices2);
                        activePrices.addAll(activePrices2);
                    }
                    redisUtil.do4Transaction(() -> {
                        for (ActivePrice activePrice : activePrices) {
                            String key2 = ACTIVE_PRICE + activePrice.getUserNo();
                            redisUtil.lSet(key2, activePrice);
                        }
//                        已开奖
                        redisUtil.hset(key, "priceStatus", "ON");
                    });
                }
            }
        });
        return builder;
    }

    /**
     * 发放ONE类奖品
     * 1.5元 队伍内随机分
     */
    private void sendPrice4One(List<ActiveUser> userList, List<ActivePrice> activePrices) {

        List<BigDecimal> bigDecimals = CommonUtil.randomRedPackage(new BigDecimal("1.5"), userList.size());
        for (int i = 0; i < userList.size(); i++) {
            ActivePrice activePrice = new ActivePrice();
            activePrice.setName("10分奖励红包");
            activePrice.setType("ONE");
            activePrice.setMsgNo(snowFlake.nextId() + "");
            activePrice.setAmount(bigDecimals.get(i));
            activePrice.setUserNo(userList.get(i).getUserNo());
            activePrices.add(activePrice);
        }
    }

    /**
     * 发放TWO类奖品
     * 均分1.21元
     *
     * @param userList
     * @param activePrices
     */
    private void sendPrice4Two(List<ActiveUser> userList, List<ActivePrice> activePrices) {
        for (int i = 0; i < userList.size(); i++) {
            ActivePrice activePrice = new ActivePrice();
            activePrice.setName("30分奖励红包");
            activePrice.setType("TWO");
            activePrice.setMsgNo(snowFlake.nextId() + "");
            activePrice.setAmount(new BigDecimal("1.21"));
            activePrice.setUserNo(userList.get(i).getUserNo());
            activePrices.add(activePrice);
        }
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
                if (activeQueryReq.getPriceStatus() != null) {
                    List<ActiveTeam> data = result.getData();
                    List<ActiveTeam> collect = data.stream().filter(x -> activeQueryReq.getPriceStatus().equals(x.getPriceStatus()))
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
