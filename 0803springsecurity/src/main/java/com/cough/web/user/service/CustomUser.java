package com.cough.web.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUser implements UserDetails {
	
	private MemberVO member;
	
	public CustomUser(MemberVO member) {
		this.member=member;
	}
	
	public MemberVO getMemberInfo() {
		return this.member;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority>auth=new ArrayList<>();
		auth.add(new SimpleGrantedAuthority(member.getRole()));
		return auth;
		
//		권한이 여러개이면 반복문으로 돌려야햄
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.member.getPwd();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.member.getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
