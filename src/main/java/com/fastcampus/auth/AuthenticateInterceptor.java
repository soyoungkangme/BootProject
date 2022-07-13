//package com.fastcampus.auth;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import com.fastcampus.domain.User;
//
//// 로그인 했을때만 동작할것들 
//// 서브릿이라면 필터, 시큐리티에서는 이것도 필요 없음 
//
//
//public class AuthenticateInterceptor implements HandlerInterceptor {
//	
//	@Override    // Controller 실행 전 동작 
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		
//		HttpSession session = request.getSession();    // 세션에 회원정보 있는지 확인 
//		User principal = (User) session.getAttribute("principal");    // LoginController 에서 등록한거 가져옴 
//		if(principal == null) {
//			response.sendRedirect("/auth/login");    // 로그인해라 
//		}
//		
//		return true;
//	}
//	
//}
