package com.fastcampus.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.domain.User;



// RESTAPI : 브라우저가 서버에 요청하는 등록, 수정, 삭제, 상세, 목록 요청을 서버에서 처리하는 것 
// localhost:8080/bank 로 전부 동일한 URL 요청 



@RestController    // JSP 아닌 JSON 반환 
public class RESTController {
	
	    // GET 방식 = SELECT 요청 시 메서드 실행 
		@GetMapping("/bank")  
		// @ResponseBody    // 대신 @RestController 사용함 (자바 객체 -> JSON to browser) 
		public User httpGet() { 
			User user = new User();
			user.setId(1);
			user.setUsername("aaa");
			user.setPassword("aaa");
			user.setEmail("aaa@gmail.com");
			return user;    // to browser from server  // JSP 아닌 JSON (ResponseBody 대신 RestController)
		}

		// POST = INSERT (<form>)  
		@PostMapping("/bank")
		public String httpPost(@RequestBody User user) {    // from browser (JSON by JQuery 프론트)  // JSON -> 자바객체 to method
			return "POST 요청 시, 입력값 : " + user.toString();
		}
		// form 태그 사용하지 않고 요청 가능해야 put, delete도 요청 가능 
		
		// PUT = UPDATE (브라우저에서 테스트 못함 -> 포스트맨) 
		@PutMapping("/bank")
		public String httpPut() {
			return "PUT 요청 처리";
		}
		
		@DeleteMapping("/bank")    // localhost:1111/bank?id=7
		public String httpDelete(@RequestParam int id) {    // 브라우저에서 전달된 값을 뒤에 선언한 변수로 받을수 있음 
			return id + "번 삭제 완료"; 
		}
}
