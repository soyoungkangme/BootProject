package com.fastcampus.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.User;


// DAO + Mapper 와 동일 (CRUD 기능 제공) 
// 인터페이스간 상속은 extends
// 구현페이스는 스프링이 자동 제공 


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {     // <엔티티 클래스, 식별자 변수의 타입>	
	
	Optional<User> findUserByUsername(String username);    // (SELECT * FROM user WHERE username = ?;)
	// 쿼리 메소드(find + 엔티티 이름 + By + 변수 이름) : 특정 변수로 객체 검색
	// select SQL 자동 생성 
	// 제너릭의 엔티티 기본으로 사용하기 때문에 엔티티 이름 생략 가능 (findByUsername())
	
}

