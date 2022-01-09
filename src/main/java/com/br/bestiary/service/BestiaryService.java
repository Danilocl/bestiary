package com.br.bestiary.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.bestiary.model.Beast;
import com.br.bestiary.repository.BestiaryRepository;
import com.br.bestiary.util.Utils;

@Service
public class BestiaryService {

	@Autowired
	private BestiaryRepository repository;

	public List<Beast> getAll() {
		List<Beast> list = new ArrayList<Beast>();
		list = repository.findAll();
		return list;
	}

	public Optional<Beast> findById(Integer id) {
		Optional<Beast> beast = repository.findById(id);
		return beast;
	}

	public Beast getByName(String name) {
		String formatName = Utils.capitalize(name);
		Beast beast = repository.getByName(formatName);
		return beast;
	}

	public void deleteByID(Integer id) {
		repository.deleteById(id);
	}

	public Beast save(Beast beast) {
		Beast newBeast = repository.save(beast);
		return newBeast;
	}

}
