package com.cough.web.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cough.web.user.mapper.UserMapper;
import com.cough.web.user.service.CustomUser;
import com.cough.web.user.service.MemberVO;
@Component("userDetailService")
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	UserMapper umapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo=umapper.getMember(username);
		
		return vo==null?null:new CustomUser(vo);
	}

}
