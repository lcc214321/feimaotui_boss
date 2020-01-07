package org.egg.aop;

import lombok.extern.slf4j.Slf4j;
import org.egg.enums.BossUserLevelEnum;
import org.egg.model.DO.BossUser;
import org.egg.utils.ConstantsUtil;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/16 11:26
 */
@Configuration
@Slf4j
public class AuthCheckFilter implements Filter {
    private final String[] LEVEL_ONE_URL = {"/boss/approveM/*"};
    private final String[] LEVEL_TWO_URL = {"/boss/approveM/*", "/boss/order/*", "/boss/feedBack/*", "/boss/user"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Object attribute = session.getAttribute(ConstantsUtil.BOSS_USER_KEY);
        if (attribute == null) {
            return;
        }
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();

        BossUser attribute1 = (BossUser) attribute;
        String level = attribute1.getLevel();
        BossUserLevelEnum bossUserLevelEnum = BossUserLevelEnum.getCodeEnumMap().get(level);
        boolean flag = true;
        switch (bossUserLevelEnum) {
            case LEVEL_ONE:
                for (String s : LEVEL_ONE_URL) {
                    if (s.contains("/*")) {
//                        通配符
                        flag = requestURI.startsWith(s.split("/*")[0]);
                    } else {
//                        相等
                        flag = requestURI.equals(s);
                    }
                }
                break;
            case LEVEL_TWO:
                for (String s : LEVEL_TWO_URL) {
                    if (s.contains("/*")) {
//                        通配符
                        flag = requestURI.startsWith(s.split("/*")[0]);
                    } else {
//                        相等
                        flag = requestURI.equals(s);
                    }
                }
                break;
            default:
                break;
        }
        if (!flag) {
            log.error("#沒有权限 requestURI={}", requestURI);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
