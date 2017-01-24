package com.flipflopclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flipflopclass.model.VerificationToken;


public interface TokenRepository extends JpaRepository<VerificationToken,Long>{
		
	public VerificationToken findByToken(String token);
		
}
