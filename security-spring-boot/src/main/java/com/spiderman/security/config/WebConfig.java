package com.spiderman.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 默认Url根路径跳转到/login，此url为spring security提供
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/loginView");
        registry.addViewController("/loginView").setViewName("login");
//        registry.addViewController("/").setViewName("redirect:/login");
    }
}