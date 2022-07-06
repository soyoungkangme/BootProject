package com.fastcampus.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcampus.domain.Users;
import com.fastcampus.persistence.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void insertUser(Users user) {
		user.setRole("USER");    // 그냥 회원가입 하면 무조건 일반회원 
		userRepository.save(user);
	}
	
	@Transactional
	public Users getUser(String username) {	
		Optional<Users> findUser = userRepository.findUserByUsername(username);
		if(findUser.isPresent()) {
			return findUser.get();    // 엔티티 리턴 
		}
		return new Users();		
	}
}