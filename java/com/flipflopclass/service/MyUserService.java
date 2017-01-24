package com.flipflopclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flipflopclass.model.User;
import com.flipflopclass.repository.UserRepository;


@Service
public class MyUserService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findByUsernameAndAuthoritIsNotNull(username);		
		
		UserInfoDetail userDetail = new UserInfoDetail(user);
		
		return userDetail;
	}	
	
}
