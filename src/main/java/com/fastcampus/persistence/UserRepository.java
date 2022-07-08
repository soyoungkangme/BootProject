package com.fastcampus.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.User;


// DAO + Mapper 와 동일 (CRUD 기능 제공) 
// 구현페이스 안만듦 (인터페이스간 상속은 extends)  


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {     // <엔티티 클래스, 식별자 변수의 타입>	
	
	/*
	// SELECT * FROM user WHERE username = ?1;
	Optional<User> findUserByUsername(String username);
	*/
	
}

