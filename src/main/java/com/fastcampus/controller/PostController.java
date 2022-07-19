package com.fastcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.domain.Post;
import com.fastcampus.domain.User;
import com.fastcampus.security.jpa.UserDetailsImpl;
import com.fastcampus.service.PostService;



@Controller
public class PostController {

	
	@Autowired
	private PostService postService;

	
	// 포스트 목록 조회 = 메인 화면 
	@GetMapping({"", "/"})
	public String getPostList(Model model,
			@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable) {    // 페이징 (page는 동적으로 전달, 디폴트 0) 
		model.addAttribute("postList", postService.getPostList(pageable));    // postList라는 이름으로 Page 객체 저장 (검색된 목록 + 페이징 정보) 
		return "welcome";    // JSP  // Model에 저장하면 응답 프로토콜에 자동 저장됐었지??
	}
	// 로그인 안한 상태에서도 보이므로 세션으로 로그인 검증해야함 -> 서블릿 아니라서 필터 사용 불가능 => Interceptor -> 시큐리티 
	
	
	// 등록 화면으로 이동 (헤더에 1:1문의 버튼 만들기)
	@GetMapping("/post/insertPost")   
	public String insertPost() {
		return "post/insertPost";    // 포스트 등록 화면 만들기 (JSP) 
	}
	
	
	// 포스트 등록 
	@PostMapping("/post/insertPost")
	public @ResponseBody String insertPost(@RequestBody Post post, 
			                               // HttpSession session
			                               @AuthenticationPrincipal UserDetailsImpl userDetails) {   
		
		// 로그인 성공시 저장한 User 객체 정보를 post에 세팅해야 POST의 FK(USER_ID) 컬럼에 USER의 ID(PK = 일련번호) 등록됨 *****
		// User principal = (User) session.getAttribute("principal");
		User principal = (User) userDetails.getUser();
		post.setUser(principal);    // 포스트 등록될때 유저 아이디 세팅 
		
		postService.insertPost(post);		
		return "새로운 1:1 문의를 등록했습니다.";
	}
	
}


