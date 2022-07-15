package com.fastcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.domain.User;
import com.fastcampus.service.UserService;



// JSP + Model -> JSON(body) 
// 메서드와 URI 매핑, 사용자 입력값을 인자로 받음 (URL 형태 알기), UserRepository의 메서드 알기, 리턴 값은 응답 프로토콜의 body에 담김 (JSON)
// 등록, 수정, 삭제, 상세, 목록, 페이징 



// @RestController   // @Controller + @ResponseBody 
@Controller    // @ComponentScan에 의해 메모리 로딩, JSON 아닌 JSP 반환 
public class UserController {
	
	
	/*
	@GetMapping("/hello")    // @RequestMapping 사용안함 
	public String hello(Model model) {
		System.out.println("---> hello() 실행");
		model.addAttribute("username", "패캠");    // Model에 키밸류로 정보 저장 -> JSP에서 활용 가능 
		return "hello";    // @Responsbody 없으므로 JSON 아닌 JSP 이름임 (뷰리졸버)
	}
	*/
	
	
	
	/*
	@Autowired
	private UserRepository userRepository;    // = DAO
	
	
	// 회원가입 = save() : 등록, 수정 (내부적으로 insert SQL 실행 by JPA) 
	@PostMapping("/user")   
	public String insertUser(@RequestBody User user) {    // 사용자의 입력값 세팅 (JSON -> 자바 객체) 
		userRepository.save(user);   
		return user.getUsername() + "님 회원가입 성공";   
	}
	// post, localhost:1111/user, body, low, json 
//	{
//    "username" : "bbb",
//    "password" : "bbb",
//    "email" : "bbb@gmail.com",
//    "role" : "USER"
//    }
	
	
	
	// 회원 수정 = findById(), save() -> 내부적으로 select, update SQL 동작 (JPA hibernate) 
	@PutMapping("/user")    // 똑같은 /user 인데 put 방식 = 수정  
	@Transactional    // 메서드 내부에서 예외 발생하면 rollback, 아니면 commit (save() 주석처리해도됨) 
	public String updateUser(@RequestBody User user) {    // @Id 비어서 전달되면 insert 동작, 채워져서 전달되면 update 동작 
		Optional<User> findEntity = userRepository.findById(user.getId());    // 수정할 데이터 먼저 select 
		if(findEntity.isPresent()) {
			User findUser = findEntity.get();    // User 타입으로 형변환 
			findUser.setUsername(user.getUsername());
			findUser.setPassword(user.getPassword());
			findUser.setEmail(user.getEmail());    // 이름, 비번, 이메일 수정 
			// userRepository.save(findUser);
			return "회원 수정 성공";
		} else {
			return user.getId() + "번 회원이 없습니다.";
		}
	}
	// put, localhost:1111/user, body, low, json 
//	{
//	"id" : "1",    // 식별자 변수가 채워져서 전달되므로 update 동작  
//    "username" : "guest",
//    "password" : "guest123",
//    "email" : "guest@gmail.com",
//    "role" : "USER"    // 수정 할때 사용 안하니 넘겨줘도 상관없음 
//    }
	
	
	// deleteById()
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {    // @PathVariable = 사용자 입력값을 바로 인자로 받을수 있음 
		userRepository.deleteById(id);
		return "회원 삭제 성공";
	}
	// delete, localhost:1111/user/1
	
	
	// 회원정보 검색 = findById() : PK에 해당하는 엔티티 상세조회 
	@GetMapping("/user/get/{id}")
	public User getUser(@PathVariable int id) {    // @RequestParam 처럼 요청 path 상의 파라미터 값을 바로 받을수 있음    
		Optional<User> findUser = userRepository.findById(id);    // Optional = 검색결과 없을때 nullPointException 방지 
		if(findUser.isPresent()) {    // 검색결과 있다면 
			return findUser.get();    // 검색결과 리턴 (JSON 자동 변환, @RestController)  // get() = User 타입으로 변환하여 리턴 
		} else {
			return new User();    // 없다면 비어있는 객체 리턴
		}
		// return userRepository.findById(id).get();    // 무조건 검색결과 있다면 한줄로 가능 
	}
	// get(서버에 select 요청), lodalhost:1111/user/get/1 (?id=1 안해도됨) 
	
	
	// 목록 검색 = findAll()
	@GetMapping("/user/list")    // 똑같은 요청방식인 경우, URL로 구분 (내가 정함) 
	public List<User> getUserList() {
		return userRepository.findAll();
	}
	// get, localhost:1111/user/list 
	
	
	// 데이터 페이징 = @PageableDefault 
	@GetMapping("/user/page")    // 목록 검색과 URL로 구분     
	public Page<User> getUserListPaging(
		@PageableDefault(page = 1, size = 3, direction = Sort.Direction.DESC, sort = {"id"}) Pageable pageable) {
		return userRepository.findAll(pageable);  
	}
	// id로 내림차순(DESC) 하여 한페이지에 3개씩(맨뒤) 정렬, 두번째 페이지 조회  
	// localhost:1111/user/page -> content = 검색결과, last = 마지막 페이지, number = 요청한 페이지+1, totalElement = 총 데이터 수, totalPages = 총 페이지 수 
	// -> 페이징 화면 구성할때 이용할 정보들 

	// get 방식은 브라우저에서 가능 -> localhost:1111/user/page?page=1&size=2 (page, size 동적요청) 
	*/ 
	
	
	
	@Autowired
	private UserService userService;
	
	// 로그인 화면으로 이동 (LoginController에서 가져옴) 
	@GetMapping("/auth/login") 
	public String login() {
		return "system/login";
	}
	
	// 회원가입 화면으로 이동 
	@GetMapping("/auth/insertUser")    // header.jsp 
	public String insertUser() {
		return "user/insertUser";    // JSON 아닌 JSP 
	}
	
	
	// 회원가입
	@PostMapping("/auth/insertUser")
	public @ResponseBody String insertUser(@RequestBody User user) {    // JSP 아닌 문자열 그대로 리턴 (요청한곳으로 = user.js)
		
		// id 중복 체크
		User findUser = userService.getUser(user.getUsername());    // 검색 
		if(findUser.getUsername() == null) {
			user.setRole("USER");
			userService.insertUser(user);    // 신규 가입 
			return user.getUsername() + " 회원 가입 성공";    // JSP 아닌 문자열 그대로 리턴 (@ResponseBody) 
		} else {
			return user.getUsername() + " 아이디는 이미 존재합니다";
		}
	}
	
}
