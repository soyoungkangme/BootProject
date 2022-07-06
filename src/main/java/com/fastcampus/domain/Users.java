package com.fastcampus.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;    // 얘만 JPA 아니고 hibernate 이용 

import lombok.Data;

/*
DROP TABLE USER;

CREATE TABLE USER (
	ID 		NUMBER(5) 	PRIMARY KEY,
	USERNAME 	VARCHAR2(30),
	PASSWORD 	VARCHAR2(100),
	EMAIL 	VARCHAR2(30)
);
 */



/*
JPA - ORM의 표준 
 */



@Data
@Table(name = "USERS")    // 변수와 컬럼을 자동 매핑 (name 없으면 테이블이름 클래스이름으로 자동)   // 매핑되는 테이블 이름 
@Entity    // 테이블과 매핑되는 클래스 
public class Users {
	    @Id    // primary key 컬럼과 매핑되는 변수 (식별자 변수) 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)    // 1부터 시작하여 자동으로 1씩 값 증가하도록 설정 
		private int id; 
	   
	    @Column(nullable = false, length = 50, unique = true)    // SQL  컬럼 설정 
		private String username; 
	    
	    @Column(length = 50)
		private String password; 
	    
	    @Column(nullable = false, length = 100)
		private String email; 
	    
	    private String role;
	    
	    @CreationTimestamp    // 현재 시간 정보 자동 설정됨 
	    private Timestamp createDate;
	}


