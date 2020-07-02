package com.Hospital_Management.entities;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Patient implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_patient;

	private String f_name;
	private String l_name;
	private String email;
	private int phone;
	private int age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_birth;
	private String sex;
	private String adress;
	private String city;

	@OneToOne(optional = false)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patient")
	private Collection<Appointment> appointment;

	public Patient() {
	}

	public Patient(Long id_patient, String f_name, String l_name, String email, int phone, int age, Date date_birth,
			String sex, String adress, String city, User user, Collection<Appointment> appointment) {
		super();
		this.id_patient = id_patient;
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.date_birth = date_birth;
		this.sex = sex;
		this.adress = adress;
		this.city = city;
		this.user = user;
		this.appointment = appointment;
	}

	public Long getId_patient() {
		return id_patient;
	}

	public void setId_patient(Long id_patient) {
		this.id_patient = id_patient;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDate_birth() {
		return date_birth;
	}

	public void setDate_birth(Date date_birth) {
		this.date_birth = date_birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(Collection<Appointment> appointment) {
		this.appointment = appointment;
	}

	
}
