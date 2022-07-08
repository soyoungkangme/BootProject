package com.fastcampus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fastcampus.domain.User;
import com.fastcampus.persistence.UserDAO;



// UserDAO 테스트 


@SpringBootTest
class UserDAOTest {
	
	@Autowired
	private UserDAO userDAO;

	@Test
	void userTest() {
		User user = new User();
		user.setId(7);    // primary key 이기 때문에 테스트 할때마다 값 바꿔줘야함 
		user.setUsername("kangnang");
		user.setPassword("1234");
		user.setEmail("kangnang@gmail.com");
		
		int beforeSize = userDAO.getUserList().size();
		userDAO.insertUser(user);
		int afterSize = userDAO.getUserList().size();
		assertEquals(beforeSize + 1, afterSize);    // expect, result 같으면 테스트 통과 
	}

}
