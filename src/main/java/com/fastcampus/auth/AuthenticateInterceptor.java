/*
package com.fastcampus.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.fastcampus.domain.User;


// Controller 사전/사후 처리 (서브릿이라면 필터)
// BankWebMvcConfiguration에 등록 
// 시큐리티가 자동 제공 


public class AuthenticateInterceptor implements HandlerInterceptor {
	
	// 로그인 검증 
	@Override    
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)    // Controller 실행 전 동작 
			throws Exception {
		HttpSession session = request.getSession();    // 세션에 회원정보 있는지 확인 (LoginController에서 로그인 성공하면 세션에 principal라는 이름으로 사용자정보 저장함) 
		User principal = (User) session.getAttribute("principal");    // session에 User 엔티티 정보 있는지 확인  
		if(principal == null) {
			response.sendRedirect("/auth/login");    // 로그인해라 
		}
		
		return true;
	}
	
}
*/
