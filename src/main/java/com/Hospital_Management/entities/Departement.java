package com.Hospital_Management.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Departement implements Serializable {

	
	
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_dep;
	private String name_dep;
	private String description;
	

	public Departement() {
		
	}

	public Departement(String name_dep,String description) {
		
		this.name_dep = name_dep;
		this.description=description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName_dep() {
		return name_dep;
	}

	public void setName_dep(String name_dep) {
		this.name_dep = name_dep;
	}

	


	public Long getId_dep() {
		return id_dep;
	}

	public void setId_dep(Long id_dep) {
		this.id_dep = id_dep;
	}

	
	@Override
	public String toString() {
		//return "Departement [id_dep=" + id_dep + ", name_dep=" + name_dep + ", description=" + description + "]";
	return this.getName_dep();
	}
	
	
	
	
}
