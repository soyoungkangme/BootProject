package com.fastcampus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;



// 1. 인터셉터(로그인 인증) 등록 (JPA) -> 스프링 시큐리티는 자동 
// 2. 스프링 시큐리티 커스터 마이징 = 내가만든 JSP 사용, 메모리 상의 계정 말고 엔티티/JPA 사용
//    by 시큐리티 관련 자동설정 클래스 비활성화(@EnableWebSecurity, extends WebSecurityConfigurerAdapter) 




// SpringSecurityFilterChain 빈생성 에러나서 이렇게 바꿈 
@EnableWebSecurity
public class BankWebMvcConfiguration {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/auth/**", "/js/**", "/image/**", "/webjars/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();
        http.formLogin().loginPage("/auth/login");
        http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");
        return http.build();
    }
}
// Spring Security는 UserDetailsService가 빈으로 등록돼있으면 자동으로 이를 선택해서 적용시키므로 UserDetailsService를 메서드로 등록하지 않아도됨 




/*
@Configuration    // 환경설정 클래스임 (@ComponentScan에 포함X) 
@EnableWebSecurity    // 스프링 시큐리티 스타터의 특정 자동설정 클래스 비활성화 by @Conditonal (커스터마이징) 
public class BankWebMvcConfiguration extends WebSecurityConfigurerAdapter {  // implements WebMvcConfigurer {   // 웹 관련된 환경설정 클래스는 상속받아야함 
	
	
	// 인터셉터 등록 
	// @Override
	// public void addInterceptors(InterceptorRegistry registry) {    
	//  	registry.addInterceptor(new AuthenticateInterceptor().addPathPatterns("/"));    // Controller와 Interceptor 매핑 
    // }
     
	
	
	// 비활성화 후 시큐리티는 내가 설정하는 대로 동작 (커스터마이징) 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// 로그인 인증 설정 
		http.authorizeRequests().antMatchers("/", "/auth/**", "/js/**", "image/**", "/webjars/**").permitAll();    // 특정 경로에 대한 요청은 인증 없이 접근 허용
		http.authorizeHttpRequests().anyRequest().authenticated();    // 위의 경로 외에는 모두 인증(로그인 성공) 거치도록함
		
		// 로그인 화면 설정 
		// http.formLogin();    // 시큐리티가 제공하는 기본 로그인 화면 사용 
		http.formLogin().loginPage("/auth/login");    // 내가 만든 로그인 화면 사용 (LoginController 아닌 UserController에 있음) 
		http.csrf().disable();    // CSRF 토큰 비활성화 (시큐리티가 제공하는 로그인 화면은 CSRF 토큰 무조건 전달, 내가 만든 로그인 화면은 CSRF 토큰 전달 안함)
		
		// 로그아웃 설정 
		http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");    // 컨트롤러, JSP 매핑 
		
	}
	
	
	// JPA(엔티티) 연동 (메모리상의 비번 사용안하도록) 
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);    // Service -> Repository -> Entity
	}
	// 더이상 시큐리티가 비번 제공하지 않음, 테이블에 등록한 USERNAME, PASSWORD로 로그인하면됨 
	
}


// 자동설정 클래스 = 빈등록(메모리 로딩) 하는 클래스
// WebSecurityConfigurerAdapter -> 필터 형태로 바뀜
*/
