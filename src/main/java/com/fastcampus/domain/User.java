package com.fastcampus.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;    // javax.persistence = JPA 

import org.hibernate.annotations.CreationTimestamp;    // 얘만 JPA 아니고 hibernate가 제공 

import lombok.Data;


// VO와 동일 


/*
DROP TABLE USER;

CREATE TABLE USER (
	ID 		    NUMBER(5) 	PRIMARY KEY,   // 회원 일련번호 
	USERNAME 	VARCHAR2(30),    // 회원이 만드는 아이디 (중복불가) 
	PASSWORD 	VARCHAR2(100),
	EMAIL 	    VARCHAR2(30)
);
 */


/*
JPA
- 애플리케이션이 java.sql의 JDBC 사용하면 h2, oracle, MySql, .. 변경해도 애플리케이션은 변경 안하듯이
- 애플리케이션이 javax.persistence의 JPA 사용하면 Hibernate, EclipseLink, DataNucleus, .. 변경해도 애플리케이션 안건들임 (ORM의 표준)

ORM
- Hibernate, EclipseLink, DataNucleus, ..
- MyBtis와 마찬가지로 디비연동 한줄
- 자바의 Object와 관계형 디비의 테이블 자동 매핑 -> 개발자가 SQL 안만듦 != MyBtis
  -> 컬럼이 추가 될때마다 수많은 SQL 수정 안해도됨 
 */




@Data
@Table(name = "USERS")    // 매핑되어 생성되는 테이블 이름 선언 (없으면 클래스 이름과 동일)
@Entity    // 테이블과 매핑되는 클래스임을 선언 
public class User {
	
	    @Id    // primary key 컬럼과 매핑되는 변수 (식별자 변수 = primary key)
	    @GeneratedValue(strategy = GenerationType.IDENTITY)    // 1부터 1씩 자동 증가 (변수가 정수형 이여야함) 
		private int id;
	   
	    @Column(nullable = false, length = 50, unique = true)    // null 허용X, 글자수, 중복불가 
		private String username;
	    
	    @Column(length = 50)
		private String password;
	    
	    @Column(nullable = false, length = 100)
		private String email;
	    
	    private String role;    // 권한 
	    
	    @CreationTimestamp    // 현재 시간 정보 자동 세팅 
	    private Timestamp createDate;
	    
//	    @OneToMany    // 한명의 회원이 등록한 포스트 목록 조회 (조인에서 양방향 매핑)
//	    private List<Post> postList = new ArrayList<Post()>;
	}


