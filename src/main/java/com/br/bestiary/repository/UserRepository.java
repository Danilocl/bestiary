package com.br.bestiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.br.bestiary.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Transactional(readOnly = true)
	User findByEmail(String email);
}
