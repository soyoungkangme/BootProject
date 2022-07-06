package com.fastcampus.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.domain.Users;

@RestController    // JSP 말고 JSON으로 반환 
public class RESTController {
	
	    // GET : SELECT (요청은 다 같음) 
		@GetMapping("/bank")    // @ResponseBody 대신 @RestController 사용함 (JSON 반환)
		public Users httpGet() { 
			Users user = new Users();
			user.setId(1);
			user.setUsername("aaa");
			user.setPassword("aaa");
			user.setEmail("aaa@gmail.com");
			return user;
		}

		// POST 방식 : INSERT 할때 (<form>) 
		@PostMapping("/bank")
		public String httpPost(@RequestBody Users user) {    // 자바 객체 -> JSON 형태로 변환 하여 리턴하는 @ResponseBody의 반대 (사용자 입력값) 
			return "POST 요청 시, 입력값 : " + user.toString();
		}
		
		// PUT : UPDATE (포스트맨으로 테스트) 
		@PutMapping("/bank")
		public String httpPut() {
			return "PUT 요청 처리";
		}
		
		// DELETE : DELETE
		@DeleteMapping("/bank")
		public String httpDelete(@RequestParam int id) {    // 특정 변수로 입력값 받음 
			return "DELETE 요청 시, 입력한 값 : " + id;
		}
}
