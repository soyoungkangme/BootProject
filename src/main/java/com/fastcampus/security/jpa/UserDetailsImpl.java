package com.fastcampus.security.jpa;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fastcampus.domain.User;

import lombok.Getter;
import lombok.Setter;



// UserRepository (디비연동 최전선) 



@Getter
@Setter
public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;    // 직렬화, 역직렬화, serialId

	
	private User user;    // 엔티티 타입의 참조변수 선언 
	
	public UserDetailsImpl(User user) {    // UserRepository의 쿼리메서드 반환값을 넘겨주면 할당됨 
		this.user = user;
	}
	
	
	// 권한 목록 검색 (User 엔티티가 갖고 있는) 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> roleList = new ArrayList<>();    // 권한 목록 저장할 컬렉션 생성 
		roleList.add(new GrantedAuthority() {    // 권한 설정  
			
			private static final long serialVersionUID = 1L;

			@Override    // 익명 내부 클래스 (메서드 안에서만 사용될 클래스 이므로 객체로 만들지 않음, GrantedAuthority 인터페이스 구현함)
			public String getAuthority() {    // GrantedAuthority 인터페이스의 추상메서드 
				return "ROLE_" + user.getRole();    
			}
		});    
		return roleList;
	}

	@Override
	public String getPassword() {
		return "{noop}" + user.getPassword();    // {noop} = 디비에서 조회한 비번을 사용할때 자동으로 암호화하지 않겠다. for 로그인 성공 
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 계정이 만료됬는지 여부를 리턴 
	@Override
	public boolean isAccountNonExpired() {
		return true;    // 만료 안됐다. (만료된 계정으로 로그인 하면 에러) 
	}

	// 계정이 잠겨있는지 여부를 리턴 
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비민번호가 만료돘는지 여부 리턴 
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정의 활성화 여부 리턴 
	@Override
	public boolean isEnabled() {
		return true;
	}

}
