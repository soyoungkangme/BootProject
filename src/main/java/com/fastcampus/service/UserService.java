package com.fastcampus.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcampus.domain.User;
import com.fastcampus.persistence.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;    // Service가 DAO 의존 (리모컨) 
	
	
	// 회원가입 
	@Transactional
	public void insertUser(User user) {    // 프론트에서 받은 사용자 입력값 
		user.setRole("USER");    // 그냥 회원가입 하면 무조건 일반회원 
		userRepository.save(user);    // 등록, 수정 = save() 
	}
	
	
	// 회원 검색 
	@Transactional
	public User getUser(String username) {	
		Optional<User> findUser = userRepository.findUserByUsername(username);    // 쿼리 메소드 (매개변수로 받은값 고대로 넘겨줌)  
		if(findUser.isPresent()) {    // 검색결과 있으면 true
			return findUser.get();    // User 객체로 변환해서 리턴 
		}
		return new User();    // 없으면 비어있는 객체 리턴 
	}
}