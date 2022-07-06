package com.fastcampus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fastcampus.domain.Users;
import com.fastcampus.persistence.UserDAO;

@SpringBootTest
class UserDAOTest {
	
	@Autowired
	private UserDAO userDAO;

	@Test
	void userTest() {
		Users user = new Users();
		user.setId(7);
		user.setUsername("kangnang");
		user.setPassword("1234");
		user.setEmail("kangnang@gmail.com");
		
		int beforeSize = userDAO.getUserList().size();
		userDAO.insertUser(user);
		int afterSize = userDAO.getUserList().size();
		assertEquals(beforeSize + 1, afterSize);
	}

}
