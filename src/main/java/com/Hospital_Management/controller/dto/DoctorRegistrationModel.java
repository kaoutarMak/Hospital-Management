package com.Hospital_Management.controller.dto;


import com.Hospital_Management.customValidation.BGTelephone;
import com.Hospital_Management.customValidation.IsPasswordsMatching;
import com.Hospital_Management.customValidation.PasswordConfirmable;
import com.fasterxml.jackson.annotation.JsonFormat;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;


@IsPasswordsMatching
public class DoctorRegistrationModel implements PasswordConfirmable {
    @NotBlank(message = "Invalid email address")
    @Email(message = "Invalid email address")
    private String email;

    @Size(min = 5, message = "Username too short")
    private String username;

    @Size(min = 5, message = "Password too short")
    private String password;

    private String confirmPassword;

    @Size(min = 5, message = "First name too short")
    private String f_namedoc;

    @Size(min = 5, message = "Last name too short")
    private String l_namedoc;

    @BGTelephone
    private String phone;

    @NotBlank(message = "Invalid gender.")
    @Pattern(regexp = "^(MALE|FEMALE)$", message = "Invalid gender.")
    private String sex;

    @Size(max = 256, message = "Invalid address length")
    private String address;
    
	private int age;
	
    @NotBlank
	private String biography;
	@NotBlank
	private String etude_degree;

    private String picture;
    private Long departement;
private long weekschedule;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Long getDepartement() {
		return departement;
	}

	public void setDepartement(Long departement) {
		this.departement = departement;
	}

	public long getWeekschedule() {
		return weekschedule;
	}

	public void setWeekschedule(long weekschedule) {
		this.weekschedule = weekschedule;
	}

   
}
