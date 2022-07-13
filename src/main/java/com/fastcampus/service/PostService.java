package com.fastcampus.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fastcampus.domain.Post;
import com.fastcampus.persistence.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public void insertPost(Post post) {
		postRepository.save(post);
	}
	
	// 목록 조회 
	@Transactional    // fetch=lazy 
	public Page<Post> getPostList(Pageable pageable) {    // 컨트롤러가 인자 넘겨줌 
		return postRepository.findAll(pageable);    // 목록은 findAll() 
	}
}