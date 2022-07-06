package com.fastcampus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.domain.Users;
import com.fastcampus.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	// 로그인 화면으로 이동 
	@GetMapping("/auth/login") 
	public String login() {
		return "system/login";
	}
	
	// 로그인 처리 
	// 로그인 인증 처리
		@PostMapping("/auth/login")
		public @ResponseBody String login(@RequestBody Users user, HttpSession session) {    // 프론트에서 JSON으로 받은 데이터 자바 객체로 받음 
			Users findUser = userService.getUser(user.getUsername());
			
			if(findUser.getUsername() == null) {    // 아이디 검증 
				return "아이디가 존재하지 않아요.";
			} else {
				if(user.getPassword().equals(findUser.getPassword())) {    // 비밀번호 검증 
					session.setAttribute("principal", findUser);
					return findUser.getUsername() + "님 로그인 성공하셨습니다.";
				} else {
					return "비밀번호 오류!";
				}
			}
		}
		
		// 로그아웃 처리
		@GetMapping("/auth/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";		
		}
}
