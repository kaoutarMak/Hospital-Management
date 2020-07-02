package com.Hospital_Management.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Medical_file implements Serializable{

	/**
	 * 
	 */
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_medicfile;
	private String allergie_alliments,heart_Disease,Diabetic,current_Medication,health_Insurance;
	@ManyToOne
	@JoinColumn(name = "id_patient")
	private Patient patient;
	public Medical_file() {
		
	}

	public Medical_file(String allergie_alliments, String heart_Disease, String diabetic, String current_Medication,
			String health_Insurance) {
		
		this.allergie_alliments = allergie_alliments;
		this.heart_Disease = heart_Disease;
		Diabetic = diabetic;
		this.current_Medication = current_Medication;
		this.health_Insurance = health_Insurance;
	}

	public String getAllergie_alliments() {
		return allergie_alliments;
	}

	public void setAllergie_alliments(String allergie_alliments) {
		this.allergie_alliments = allergie_alliments;
	}

	public String getHeart_Disease() {
		return heart_Disease;
	}

	public void setHeart_Disease(String heart_Disease) {
		this.heart_Disease = heart_Disease;
	}

	public String getDiabetic() {
		return Diabetic;
	}

	public void setDiabetic(String diabetic) {
		Diabetic = diabetic;
	}

	public String getCurrent_Medication() {
		return current_Medication;
	}

	public void setCurrent_Medication(String current_Medication) {
		this.current_Medication = current_Medication;
	}

	public String getHealth_Insurance() {
		return health_Insurance;
	}

	public void setHealth_Insurance(String health_Insurance) {
		this.health_Insurance = health_Insurance;
	}

	public int getId_medicrecord() {
		return id_medicfile;
	}
	
	
	
}
