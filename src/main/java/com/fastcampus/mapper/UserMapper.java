package com.fastcampus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.fastcampus.domain.Users;

@Mapper
public interface UserMapper {    // mapper.xml 설정 대신하는 클래스 (구현클래스는 스프링부트가 만들어줌)
	
	@Insert("INSERT INTO USERS(ID, USERNAME, PASSWORD, EMAIL) VALUES((SELECT NVL(MAX(ID), 0) + 1 FROM USER), #{username}, #{password}, #{email})")
	public void insertUser(Users user);
	
	@Update("UPDATE USERS PASSWORD = #{password}, EMAIL = #{email} WHERE ID = #{id}")
	public void updateUser(Users user);
	
	@Delete("DELETE USERS WHERE ID = #{id}")
	public void deleteUser(Users user);
	
	@Select("SELECT * FROM USERS WHERE USERNAME = #{username}")
	public Users getUser(Users user);

	@Select("SELECT * FROM USERS ORDER BY USERNAME DESC")
	public List<Users> getUserList();

}