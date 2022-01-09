package com.br.bestiary.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.bestiary.Exception.ControllerException;
import com.br.bestiary.model.Beast;
import com.br.bestiary.service.BestiaryService;
import com.br.bestiary.util.MessangerErrorEnum;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")
public class BestiaryController {

	@Autowired
	private BestiaryService service;

	@PostMapping
	@Operation(summary = "Create new Beast")
	public ResponseEntity<Beast> save(@RequestBody Beast beast) {
		Beast beastByName = service.getByName(beast.getName());
		if (beastByName != null) {
			throw new ControllerException(HttpStatus.INTERNAL_SERVER_ERROR, MessangerErrorEnum.REPEATED.getMessenger());
		} else {
			service.save(beast);
			return new ResponseEntity<>(beast, HttpStatus.OK);
		}

	}

	@PutMapping(path = "/{id}")
	@Operation(summary = "Update beast")
	public ResponseEntity<Beast> update(@RequestBody Beast beast, @PathVariable Integer id) {
		return service.findById(id).map(b -> {
			b.setName(beast.getName());
			b.setClasse(beast.getClasse());
			b.setOcurrence(beast.getOcurrence());
			b.setImmunity(beast.getImmunity());
			b.setSusceptibility(beast.getSusceptibility());
			b.setTactics(beast.getTactics());
			b.setAlchemy(beast.getAlchemy());
			Beast newBeast = service.save(b);
			return ResponseEntity.ok().body(newBeast);
		}).orElse(ResponseEntity.notFound().build());

	}

	@GetMapping
	@Operation(summary = "Find all beasts")
	public ResponseEntity<List<Beast>> getAll() {
		List<Beast> list = new ArrayList<Beast>();
		list = service.getAll();
		if (list.size() == 0) {
			throw new ControllerException(HttpStatus.NOT_FOUND, MessangerErrorEnum.EMPTY.getMessenger());
		} else {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	}

	@GetMapping(path = "/getID/{id}")
	@Operation(summary = "Find beast by ID")
	public ResponseEntity<Optional<Beast>> getById(@PathVariable Integer id) {
		Optional<Beast> beast = service.findById(id);

		if (beast == null) {
			throw new ControllerException(HttpStatus.INTERNAL_SERVER_ERROR, MessangerErrorEnum.NOTFOUND.getMessenger());
		} else {
			return new ResponseEntity<Optional<Beast>>(beast, HttpStatus.OK);
		}
	}

	@GetMapping(path = "/getName/{name}")
	@Operation(summary = "Find beast by name")
	public ResponseEntity<Beast> getByName(@PathVariable String name) {
		Beast beast = service.getByName(name);

		if (beast == null) {
			throw new ControllerException(HttpStatus.INTERNAL_SERVER_ERROR, MessangerErrorEnum.NOTFOUND.getMessenger());
		} else {
			return new ResponseEntity<Beast>(beast, HttpStatus.OK);
		}
	}

	@DeleteMapping(path = "/{id}")
	@Operation(summary = "Delete beast by ID")
	public ResponseEntity<Beast> deleteByID(@PathVariable Integer id) {
		service.deleteByID(id);
		return new ResponseEntity<Beast>(HttpStatus.OK);
	}

}
