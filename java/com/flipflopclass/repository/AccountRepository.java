package com.flipflopclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flipflopclass.model.Account;
import com.flipflopclass.model.User;



public interface AccountRepository extends JpaRepository<Account,Long>{
		
	public Account findByUser(User user);
	
}
