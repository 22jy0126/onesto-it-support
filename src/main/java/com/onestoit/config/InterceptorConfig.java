package com.onestoit.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class InterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/course/**");
	}
	
}
