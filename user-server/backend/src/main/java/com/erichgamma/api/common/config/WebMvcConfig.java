package com.erichgamma.api.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.erichgamma.api.common.component.interceptor.AuthInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(@SuppressWarnings("null") InterceptorRegistry registry) {
        // registry.addInterceptor(new LocaleChangeInterceptor()).excludePathPatterns("/favicon.ico").addPathPatterns("/api/**");
        registry
        .addInterceptor(authInterceptor)
        .addPathPatterns("/api/**")
        .addPathPatterns("/api/auth/**")
        .excludePathPatterns("/favicon.ico");
    }
}
