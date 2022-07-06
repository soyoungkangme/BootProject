package com.fastcampus.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.Users;


// DAO와 동일 
//myBatis에서 SQL 작성하는 클래스
// 구현페이스 안만듦 (인터페이스간 상속은 extends) 


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {     // <엔티티 클래스, 식별자 변수의 타입>	
	
	// SELECT * FROM user WHERE username = ?1;
	Optional<Users> findUserByUsername(String username);
	
}

