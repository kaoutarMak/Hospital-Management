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
public class PatientRegistrationModel implements PasswordConfirmable {

    @NotBlank(message = "Invalid email address")
    @Email(message = "Invalid email address")
    private String email;

    @Size(min = 5, message = "Username too short")
    private String username;

    @Size(min = 5, message = "Password too short")
    private String password;

    @NotBlank
    private String confirmPassword;

    @Size(min = 5, message = "First name too short")
    private String firstName;

    @Size(min = 5, message = "Last name too short")
    private String lastName;

    @BGTelephone
    private String phone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "PST")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Invalid date of birth")
    private Date date_birth;

    @NotBlank(message = "Invalid gender.")
    @Pattern(regexp = "^(MALE|FEMALE)$", message = "Invalid gender.")
    private String sex;
    
	private int age;
    @NotBlank
	private String adress;
    @NotBlank
	private String city;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

   
}
