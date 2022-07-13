package com.fastcampus.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.User;


// DAO + Mapper 와 동일 (CRUD 기능 제공) 
// 인터페이스간 상속은 extends
// 구현페이스는 스프링이 자동 제공 


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {     // <엔티티 클래스, 식별자 변수의 타입>	
	
	/*
	// SELECT * FROM user WHERE username = ?;
	Optional<User> findUserByUsername(String username);
	*/
	
}

