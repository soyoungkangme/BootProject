package com.fastcampus.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.domain.Users;
import com.fastcampus.service.UserService;

// @RestController
@Controller
public class UserController {
	
	/*
	@GetMapping("/hello")
	public String hello(Model model) {
		System.out.println("---> hello() 실행");
		model.addAttribute("username", "패캠");
		return "hello";    // @Responsbody 없으므로 JSP 이름임 (뷰리졸버)
	}
	*/
	
	/*
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	public String insertUser(@RequestBody Users user) {    // 사용자의 입력값 세팅 (JSON -> 자바 객체) 
		userRepository.save(user);
		return user.getUsername() + "님 회원가입 성공";
	    	
	}
	
	@PutMapping("/user")
	// @Transactional
	public String updateUser(@RequestBody Users user) {    // 식별자 변수 값 없으면 update 작동, 있으면 insert 작동 
		Optional<Users> findEntity = userRepository.findById(user.getId());
		if(findEntity.isPresent()) {
			Users findUser = findEntity.get();
			findUser.setUsername(user.getUsername());
			findUser.setPassword(user.getPassword());
			findUser.setEmail(user.getEmail());
			userRepository.save(findUser);
			return "회원 수정 성공";
		} else {
			return user.getId() + "번 회원이 없습니다.";
		}
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return "회원 삭제 성공";
	}
	
	@GetMapping("/user/get/{id}")
	public Users getUser(@PathVariable int id) {   
		Optional<Users> findUser = userRepository.findById(id);    // Optional = 검색결과 있으면 isPresent() true 
		if(findUser.isPresent()) {
			return findUser.get();
		} else {
			return new Users();
		}
	}
	
	@GetMapping("/user/list")
	public List<Users> getUserList() {
		return userRepository.findAll();
	}
	
	@GetMapping("/user/page")    // localhost:8080/user/page?page=1&size=2 (동적요청) 
	public Page<Users> getUserListPaging(
		@PageableDefault(page = 0, size = 2, direction = Sort.Direction.DESC, sort = {"id"}) Pageable pageable) {
		return userRepository.findAll(pageable);    
	}
	// id 내림차순 해서 첫 페이지에 상위 2개의 데이터를 pageble에 세팅 -> 데이터 수에 따라 총페이지수 정해짐 
	 */ 
	 
	
	@Autowired
	private UserService userService;
	
	// 회원가입 화면으로 이동 
	@GetMapping("/auth/insertUser") 
	public String insertUser() {
		return "user/insertUser";
	}
	
	// 회원가입 처리 
	@PostMapping("/auth/insertUser")
	public @ResponseBody String insertUser(@RequestBody Users user) {    // JSP 아닌 문자열 그대로 리턴 (요청한곳으로 = user.js)
		
		// username으로 등록된 회원 있나 검색
		Users findUser = userService.getUser(user.getUsername());
		if (findUser == )
		
		user.setRole("USER");
		user.setCreateDate(new Timestamp(System.currentTimeMillis()));
		userService.insertUser(user);
		return user.getUsername() + " 회원 가입 성공";
	}
	
}
