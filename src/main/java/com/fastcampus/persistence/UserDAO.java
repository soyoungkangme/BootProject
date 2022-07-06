package com.fastcampus.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.Users;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;    // 자동설정 클래스로 메모리에 뜸 (내가 안만듦) 
	
	public void insertUser(Users user) {
		mybatis.insert("insertUser", user);
	}
	
	public List<Users> getUserList() {
		return mybatis.selectList("getUserList");
	}

}
