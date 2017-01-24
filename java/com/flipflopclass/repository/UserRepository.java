package com.flipflopclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flipflopclass.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	public User findByUsername(String username);
	public User findByUsernameAndAuthoritIsNotNull(String username);

}
