package com.Hospital_Management.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Analyses implements Serializable {

	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_analyse;
	private Date date_analyse;
	private String assignement;
	@ManyToOne
	@JoinColumn(name = "id_prescrip")
	private Prescription prescription;
	public Analyses() {
		
	}

	public Analyses(Date date_analyse, String assignement) {
		super();
		this.date_analyse = date_analyse;
		this.assignement = assignement;
	}

	public Date getDate_analyse() {
		return date_analyse;
	}

	public void setDate_analyse(Date date_analyse) {
		this.date_analyse = date_analyse;
	}

	public String getAssignement() {
		return assignement;
	}

	public void setAssignement(String assignement) {
		this.assignement = assignement;
	}

	public int getId_analyse() {
		return id_analyse;
	}
	
	
	
	
}
