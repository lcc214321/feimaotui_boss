package org.egg.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.egg.biz.BossUserBiz;
import org.egg.enums.BossUserLevelEnum;
import org.egg.enums.BossUserStatusEnum;
import org.egg.enums.CommonErrorEnum;
import org.egg.model.DO.BossUser;
import org.egg.model.DTO.BossLoginDto;
import org.egg.model.VO.BossUserQueryReq;
import org.egg.model.VO.BossUserRes;
import org.egg.response.BaseResult;
import org.egg.response.PageResult;
import org.egg.utils.ConstantsUtil;
import org.egg.utils.PropertiesOrderly;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by chendatao on 2018/7/24.
 */
@RequestMapping(value = "/boss")
@Controller
public class BossController extends BossBaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BossController.class);
    @Autowired
    private BossUserBiz bossUserBiz;
    /**
     * 分级用户的菜单权限
     */
    private static Map<String, Map<String, String>> menu_map = new HashMap<>();

    static {
        Map<String, String> LEVEL_ONE = new LinkedHashMap<>();
        Map<String, String> LEVEL_TWO = new LinkedHashMap<>();
        Map<String, String> BOSS = new LinkedHashMap<>();
        obtain(LEVEL_ONE, "/boss_menu_one.properties");
        obtain(LEVEL_TWO, "/boss_menu_two.properties");
        obtain(BOSS, "/boss_menu.properties");
        menu_map.put(BossUserLevelEnum.LEVEL_ONE.getCode(), LEVEL_ONE);
        menu_map.put(BossUserLevelEnum.LEVEL_TWO.getCode(), LEVEL_TWO);
        menu_map.put(BossUserLevelEnum.BOSS.getCode(), BOSS);
    }

    private static void obtain(Map<String, String> LEVEL, String configPath) {
        try {
            EncodedResource encodedResource = new EncodedResource(new ClassPathResource(configPath), "UTF-8");
            PropertiesOrderly propertiesOrderly = new PropertiesOrderly();
            PropertiesLoaderUtils.fillProperties(propertiesOrderly, encodedResource);
            LinkedHashMap<Object, Object> map = propertiesOrderly.getMap();
            Set<Map.Entry<Object, Object>> entries = map.entrySet();
            for (Map.Entry<Object, Object> entry : entries) {
                LEVEL.put(entry.getKey().toString(), entry.getValue().toString());
            }
        } catch (IOException e) {
            LOGGER.error("读取后台菜单数据错误 e={}", e);
        }
    }


    @RequestMapping(value = "/error")
    public ModelAndView commonError(String errorMsg, ModelAndView modelAndView) {

        modelAndView.setViewName("boss/error");
        modelAndView.addObject("errorMsg", errorMsg);
        return modelAndView;
    }

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        BossUser account = getAccount(request);
        Map<String, String> strings = menu_map.get(account.getLevel());
        model.addAttribute("menuList", strings);
        model.addAttribute("user", account);
        return "boss/main";
    }

    @RequestMapping("/toBossLogin")
    public String toBossLogin(String returnUrl) {
        return "boss/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult login(HttpServletRequest request, BossLoginDto bossLoginDto) {
        try {
            BaseResult login = bossUserBiz.login(bossLoginDto, request);

            return login;
        } catch (Exception e) {
            return new BaseResult(CommonErrorEnum.PARAM_ENCRY_ERROR);
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult logout(HttpServletRequest request) {
        BaseResult result = new BaseResult();
        result.setSuccess(true);
        HttpSession session = request.getSession();
        session.setAttribute(ConstantsUtil.BOSS_USER_KEY, null);
        return result;
    }

    /**
     * 管理页面
     *
     * @return
     */
    @RequestMapping("/showUser")
    public String showUser(Model model) {
        model.addAttribute("userStatusMap", BossUserStatusEnum.getIndexDescMap());
        model.addAttribute("userLevel", BossUserLevelEnum.getCodeDescMap());
        return "boss/bossUser";
    }

    @RequestMapping("/queryList")
    @ResponseBody
    public Map<String, Object> userQueryList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            LOGGER.info("#userQueryList#查询记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            BossUserQueryReq queryReq = JSON.parseObject(condition, BossUserQueryReq.class);
            queryReq.setPageNo(Integer.valueOf(pageStr));
            queryReq.setPageNum(Integer.valueOf(rowsStr));
            PageResult pageResult = bossUserBiz.queryList(queryReq);
            if (pageResult.isSuccess()) {
                List<BossUserRes> rows = new ArrayList<>();
                if (CollectionUtils.isEmpty(pageResult.getData())) {
                    LOGGER.info("#userQueryList#查询记录成功,查询参数:condition={},size=0", JSON.toJSONString(condition));
                } else {
                    LOGGER.info("#userQueryList#查询记录成功,查询参数:condition={},size={}", JSON.toJSONString(condition), rows.size());
                    rows = pageResult.getData();
                }
                resultMap.put("total", pageResult.getTotal());
                resultMap.put("rows", rows);
                resultMap.put("success", true);
            }
        } catch (Exception e) {
            LOGGER.error("#userQueryList#查询记录异常,异常详情={}", e);
        }
        return resultMap;
    }

    @RequestMapping("/updateStatus")
    @ResponseBody
    public BaseResult updateStatus(BossUser user) {
        LOGGER.info("updateStatus user={}", user);
        BaseResult result = bossUserBiz.updateStatus(user);
        return result;
    }

    @RequestMapping("/createUser")
    @ResponseBody
    public BaseResult createUser(BossUser user) {
        LOGGER.info("createUser user={}", user);
        BaseResult result = bossUserBiz.addUser(user);
        return result;
    }

    @RequestMapping("/resetPwd")
    @ResponseBody
    public BaseResult resetPwd(String userNo) {
        LOGGER.info("resetPwd userNo={}", userNo);
        BaseResult result = bossUserBiz.restPwd(userNo);
        return result;
    }

    @RequestMapping("/modifyPwd")
    @ResponseBody
    public BaseResult modifyPwd(HttpServletRequest request, String oldPwd, String newPwd) {
        LOGGER.info("modifyPwd oldPwd={},newPwd={}", oldPwd, newPwd);
        BossUser account = getAccount(request);
        BaseResult result = bossUserBiz.modifyPwd(account.getBossUserNo(), oldPwd, newPwd, request);
        return result;
    }


}