package com.br.bestiary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Beast {

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@Column(name = "class")
	private String classe;

	@Column
	private String ocurrence;
	
	@Column
	private String immunity;

	@Column
	private String susceptibility;

	@Column
	private String tactics;

	@Column
	private String alchemy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getOcurrence() {
		return ocurrence;
	}

	public void setOcurrence(String ocurrence) {
		this.ocurrence = ocurrence;
	}

	public String getImmunity() {
		return immunity;
	}

	public void setImmunity(String immunity) {
		this.immunity = immunity;
	}

	public String getSusceptibility() {
		return susceptibility;
	}

	public void setSusceptibility(String susceptibility) {
		this.susceptibility = susceptibility;
	}

	public String getTactics() {
		return tactics;
	}

	public void setTactics(String tactics) {
		this.tactics = tactics;
	}

	public String getAlchemy() {
		return alchemy;
	}

	public void setAlchemy(String alchemy) {
		this.alchemy = alchemy;
	}

}
