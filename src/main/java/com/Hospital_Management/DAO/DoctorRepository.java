package com.Hospital_Management.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hospital_Management.entities.Doctor;



public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	 Doctor findOneByUserId(long userId);

	    //List<Doctor> findAllByOrderByF_NameAscLastName();
}
