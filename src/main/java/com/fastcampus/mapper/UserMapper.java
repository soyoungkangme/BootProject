package com.fastcampus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.fastcampus.domain.User;


//mapper.xml 설정 대신하는 인터페이스 (구현클래스는 스프링부트가 자동 생성)


@Mapper
public interface UserMapper {    
	
	@Insert("INSERT INTO USERS(ID, USERNAME, PASSWORD, EMAIL) VALUES((SELECT NVL(MAX(ID), 0) + 1 FROM USERS), #{username}, #{password}, #{email})")
	public void insertUser(User user);    // MyBatis에서는 어노테이션의 아이디로 SQL 사용했지만 스프링부트는 메서드 이름으로 사용 
	
	@Update("UPDATE USERS PASSWORD = #{password}, EMAIL = #{email} WHERE ID = #{id}")
	public void updateUser(User user);
	
	@Delete("DELETE USERS WHERE ID = #{id}")
	public void deleteUser(User user);
	
	@Select("SELECT * FROM USERS WHERE USERNAME = #{username}")
	public User getUser(User user);

	@Select("SELECT * FROM USERS ORDER BY USERNAME DESC")
	public List<User> getUserList();

}