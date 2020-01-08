package org.egg.configurer;

import org.egg.Interceptor.BossLoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author dataochen
 * @Description springboot 配置
 * @date: 2017/11/7 16:29
 */
//@Configuration
public class MyWebAppConfigurer
        implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new BossLoginInterceptor()).addPathPatterns("/boss/**").excludePathPatterns("/boss/login")
                .excludePathPatterns("/boss/toBossLogin").excludePathPatterns("/css/**")
                .excludePathPatterns("/easyui/**").excludePathPatterns("/fonts/**").excludePathPatterns("/images/**")
                .excludePathPatterns("/js/**");
    }

}