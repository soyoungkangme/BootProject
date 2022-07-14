package com.fastcampus.config;

import org.springframework.context.annotation.Configuration;

@Configuration    // 환경설정 클래스임 (@ComponentScan에 포함X) 
public class BankWebMvcConfiguration  {  // implements WebMvcConfigurer {   // 웹 관련된 환경설정 클래스는 상속받아야함 
	
	/*
	@Override
	public void addInterceptors(InterceptorRegistry registry) {    // 인터셉터 등록 
		registry.addInterceptor(new AuthenticateInterceptor().addPathPatterns("/"));    // Controller와 Interceptor 매핑 
    }
    */
	
}
//인터셉터 대신 시큐리티 사용 