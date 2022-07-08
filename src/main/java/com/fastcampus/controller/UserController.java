package com.fastcampus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.domain.User;
import com.fastcampus.persistence.UserRepository;



// JSP, 디비 데이터 서비스 



@RestController
// @Controller    // @ComponentScan에 의해 메모리 로딩 
public class UserController {
	
	
	/*
	@GetMapping("/hello")    // @RequestMapping 사용안함 
	public String hello(Model model) {
		System.out.println("---> hello() 실행");
		model.addAttribute("username", "패캠");    // Model에 키밸류로 정보 저장 -> JSP에서 활용 가능 
		return "hello";    // @Responsbody 없으므로 JSON 아닌 JSP 이름임 (뷰리졸버)
	}
	*/
	
	
	
	@Autowired
	private UserRepository userRepository;    // DAO는 Service 거쳐야함 
	
	// 회원가입 
	@PostMapping("/user")    // = 등록 
	public String insertUser(@RequestBody User user) {    // 사용자의 입력값 세팅 (JSON -> 자바 객체) 
		userRepository.save(user);    // save() = 등록, 수정 처리에 사용
		return user.getUsername() + "님 회원가입 성공";
	}
	
	@PutMapping("/user")
	// @Transactional
	public String updateUser(@RequestBody User user) {    // 식별자 변수 값 없으면 update 작동, 있으면 insert 작동 
		Optional<User> findEntity = userRepository.findById(user.getId());
		if(findEntity.isPresent()) {
			User findUser = findEntity.get();
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
	public User getUser(@PathVariable int id) {   
		Optional<User> findUser = userRepository.findById(id);    // Optional = 검색결과 있으면 isPresent() true 
		if(findUser.isPresent()) {
			return findUser.get();
		} else {
			return new User();
		}
	}
	
	@GetMapping("/user/list")
	public List<User> getUserList() {
		return userRepository.findAll();
	}
	
	@GetMapping("/user/page")    // localhost:8080/user/page?page=1&size=2 (동적요청) 
	public Page<User> getUserListPaging(
		@PageableDefault(page = 0, size = 2, direction = Sort.Direction.DESC, sort = {"id"}) Pageable pageable) {
		return userRepository.findAll(pageable);    
	}
	// id 내림차순 해서 첫 페이지에 상위 2개의 데이터를 pageble에 세팅 -> 데이터 수에 따라 총페이지수 정해짐 
	
	 
	
	/*
	@Autowired
	private UserService userService;
	
	// 회원가입 화면으로 이동 
	@GetMapping("/auth/insertUser") 
	public String insertUser() {
		return "user/insertUser";
	}
	*/
	
	
	/*
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
	*/
	
}
