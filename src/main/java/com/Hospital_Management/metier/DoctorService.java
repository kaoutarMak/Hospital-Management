package com.Hospital_Management.metier;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Hospital_Management.controller.dto.DoctorRegistrationModel;
import com.Hospital_Management.entities.Doctor;


public interface DoctorService {

	void create(DoctorRegistrationModel registrationModel);
	public List<Doctor> listDoctors();
		

    void save(Doctor doctor);  

    Doctor getById(long id);
    
    Doctor getByUserId(long userId);
    
    Page<Doctor> getAll(Pageable pageable);
	void delete(Long id);
}
