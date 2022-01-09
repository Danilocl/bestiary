package com.br.bestiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.bestiary.model.Beast;

public interface BestiaryRepository extends JpaRepository<Beast, Integer> {

	Beast getByName(String name);

	void deleteByName(String name);
}
