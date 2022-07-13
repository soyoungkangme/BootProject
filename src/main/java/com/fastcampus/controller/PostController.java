package com.fastcampus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.domain.Post;
import com.fastcampus.domain.User;
import com.fastcampus.service.PostService;



// 



@Controller
public class PostController {
	
	@Autowired
	private PostService postService;

	@GetMapping({"", "/"})
	public String getPostList(Model model, @PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable) {
		model.addAttribute("postList", postService.getPostList(pageable));
		return "welcome";    // jsp
	}
	
	@GetMapping("/post/insertPost")    // 등록 화면으로 이동 
	public String insertPost() {
		return "post/insertPost";
	}
	
	@PostMapping("/post/insertPost")
	public @ResponseBody String insertPost(@RequestBody Post post, HttpSession session) {
		// Post 객체 등록하기 위해 반드시 User 객체를 Post에 설정 -> Post가 POST 테이블에 등록될때 FK(USER_ID) 컬럼에 회원의 PK(ID) 등록해줌 
		User principal = (User) session.getAttribute("principal");
		post.setUser(principal);
		
		postService.insertPost(post)
;		return "새로운 1:1 문의를 등록했습니다.";
	}
}