package com.example.mall;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor())  // 注册 UserLoginInterceptor
                .addPathPatterns("/**")  // 拦截所有请求
                .excludePathPatterns("/user/login", "/user/register");  // 不拦截的请求
    }
}