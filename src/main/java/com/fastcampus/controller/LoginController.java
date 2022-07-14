/*
package com.fastcampus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.domain.User;
import com.fastcampus.service.UserService;



// 시큐리티가 자동 제공 



@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	// 로그인 화면으로 이동 
	@GetMapping("/auth/login")    // HTML 
	public String login() {
		return "system/login";    // JSP
	}
	
	// 로그인
	@PostMapping("/auth/login")    // URL 같지만 요청 방식 다름 
	public @ResponseBody String login(@RequestBody User user, HttpSession session) {    // 프론트에서 JSON으로 받은 데이터 자바 객체로 받음 
		
      User findUser = userService.getUser(user.getUsername());    // 아이디 중복 체크 (select) 
		if(findUser.getUsername() == null) {    
			return "아이디에 해당하는 회원이 존재하지 않아요.";
		} else {
			if(user.getPassword().equals(findUser.getPassword())) {    // 비밀번호 검증 (사용자 입력한 값과 검색한 객체 비교) 
				session.setAttribute("principal", findUser);    // 세션에 사용자 입력 값 저장 -> JSP에서 로그인 성공시 메뉴 바꾸는데 이용, authentication에 이용  
				return findUser.getUsername() + "님 로그인 성공하셨습니다.";    // js에 리턴 
			} else {
				return "비밀번호 오류!";
			}
		}
	}
		
	// 로그아웃
	@GetMapping("/auth/logout")
	public String logout(HttpSession session) {
		session.invalidate();    // 기억안난다 
		return "redirect:/";     // 기억안남  
	}
}
*/
