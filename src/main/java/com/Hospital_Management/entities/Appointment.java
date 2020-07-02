package com.Hospital_Management.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointment implements Serializable {


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_appoint;
	private Date date_appoint;
	//private Time time;
	private String symptoms;
	
    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "id_doc")
    private Doctor doctor;
    
	public Appointment() {
		
	}

	public Appointment(Date date_appoint,String symptoms) {
		
		this.date_appoint = date_appoint;
		//this.time = time;
		this.symptoms=symptoms;
	}

	public int getId_appoint() {
		return id_appoint;
	}

	

	/*
	 * public Time getTime() { return time; }
	 * 
	 * public void setTime(Time time) { this.time = time; }
	 */

	public Date getDate_appoint() {
		return date_appoint;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public void setDate_appoint(Date date_appoint) {
		this.date_appoint = date_appoint;
	}
	
	
	
	
	
	
}
