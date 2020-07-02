package com.Hospital_Management.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;






@Entity
public class Doctor implements Serializable{

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_doc;
	private String f_namedoc,l_namedoc,email;
	private int phone,age;
	private String sex,adress;
	private String picture;
	private String biography,etude_degree;
	
	@OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_dep")
	private Departement departement;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "doctor")
    private Set<Appointment> appointments;
	
	@OneToOne //(optional = false)
    @JoinColumn(name = "week_schedule_id", referencedColumnName = "id")
    private WeekSchedule weekSchedule;
	public Doctor() {
		
	}

public Doctor(User user) {
		this.user=user;
		
	}
	public Doctor(String f_namedoc, String l_namedoc, String email, int phone,int age, String sex, String adress,
			String picture, String biography, String etude_degree) {
		
		this.f_namedoc = f_namedoc;
		this.l_namedoc = l_namedoc;
		this.email = email;
		this.phone = phone;
		this.age=age;
		this.sex = sex;
		this.adress = adress;
		this.picture = picture;
		this.biography = biography;
		this.etude_degree = etude_degree;
	}

	
	public Long getId_doc() {
		return id_doc;
	}

	
	public void setId_doc(Long id_doc) {
		this.id_doc = id_doc;
	}

	public String getF_namedoc() {
		return f_namedoc;
	}

	public void setF_namedoc(String f_namedoc) {
		this.f_namedoc = f_namedoc;
	}

	public String getL_namedoc() {
		return l_namedoc;
	}

	public void setL_namedoc(String l_namedoc) {
		this.l_namedoc = l_namedoc;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getEtude_degree() {
		return etude_degree;
	}

	public void setEtude_degree(String etude_degree) {
		this.etude_degree = etude_degree;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}



	public WeekSchedule getWeekSchedule() {
		return weekSchedule;
	}

	public void setWeekSchedule(WeekSchedule weekSchedule) {
		this.weekSchedule = weekSchedule;
	}

	@Override
	public String toString() {
		return "Doctor [id_doc=" + id_doc + ", f_namedoc=" + f_namedoc + ", l_namedoc=" + l_namedoc + ", email=" + email
				+ ", phone=" + phone + ", age=" + age + ", sex=" + sex + ", adress=" + adress + ", picture=" + picture
				+ ", biography=" + biography + ", etude_degree=" + etude_degree + ", user=" + user + ", departement="
				+ departement + ", appointments=" + appointments + ", weekSchedule=" + weekSchedule + "]";
	}

	

	
	
}

