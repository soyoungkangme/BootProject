package com.fastcampus.security.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fastcampus.domain.User;
import com.fastcampus.persistence.UserRepository;



// UserService


@Service    // for componentScan 
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {    // 사용자가 입력한 username 받아서 
		User principal = userRepository.findUserByUsername(username).get();    // 상세조회에 이용 
		return new UserDetailsImpl(principal);    // UserDetailsImpl 생성할때 검색한 유저 엔티티를 인자로 넘겨줌 
	}

}
