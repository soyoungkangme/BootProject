package com.fastcampus.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.User;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;    // xml에 등록한 MyBatis 스타터에 들어있는 객체가 자동설정에 의해 메모리에 로딩됙고 yml에서 멤버변수값 변경   
	
	// 회원가입 
	public void insertUser(User user) { 
		mybatis.insert("insertUser", user);    // SQL, 디비에 넘기고 고객에 보낼 객체 
	}   // 의존성 주입하여 메서드 사용 
	
	// 사용자 목록 조회 
	public List<User> getUserList() {
		return mybatis.selectList("getUserList");    // 상세조회 selectOne() 
	}

}

