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
public class Prescription implements Serializable{


	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_prescrip;
	private Date date_presc;
	private String medicine;
	private int days;
	private String instruction;
	private String Note;
	@ManyToOne
	@JoinColumn (name = "id_appoint")
	private Appointment appointment;
	public Prescription() {
		
	}

	public Prescription(Date date_presc, String medicine, int days, String instruction, String note) {
		super();
		this.date_presc = date_presc;
		this.medicine = medicine;
		this.days = days;
		this.instruction = instruction;
		Note = note;
	}

	public Date getDate_presc() {
		return date_presc;
	}

	public void setDate_presc(Date date_presc) {
		this.date_presc = date_presc;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public int getId_prescrip() {
		return id_prescrip;
	}

	@Override
	public String toString() {
		return "Prescription [id_prescrip=" + id_prescrip + ", date_presc=" + date_presc + ", medicine=" + medicine
				+ ", days=" + days + ", instruction=" + instruction + ", Note=" + Note + "]";
	}
	
	
	
	
}
