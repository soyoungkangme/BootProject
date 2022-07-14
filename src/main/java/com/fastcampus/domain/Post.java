package com.fastcampus.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;    // javax.persistence = JPA 

import org.hibernate.annotations.CreationTimestamp;    // 얘만 JPA 아니고 hibernate가 제공 

import lombok.Data;


// 


@Data
@Entity  
public class Post {
	
	    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
	   
	    @Column(nullable = false, length = 100)
		private String title;
	    
	    @Lob    // 아주 긴 GB 규모의 문자데이터 저장 가능한 설정 (썸머노트는 html 태그가 통째로 저장되므로) 
	    @Column(nullable = false)
		private String content;
	    
	    @CreationTimestamp    
	    private Timestamp createDate;
	    
	    // 포스트 : 회원 = N : 1 
		@ManyToOne(fetch = FetchType.LAZY)    // <-> 디폴트 EAGER 
		@JoinColumn(name = "USER_ID")    // FK 
	    private User user;
	}


