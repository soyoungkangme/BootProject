package com.fastcampus.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.Post;


// DAO + Mapper 와 동일 (CRUD 기능 제공) 
// 구현페이스 안만듦 (인터페이스간 상속은 extends)  


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> { 	
	
}

