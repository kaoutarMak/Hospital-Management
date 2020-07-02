package com.Hospital_Management.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hospital_Management.entities.Appointment;



public interface AppointRepository extends JpaRepository<Appointment,Long> {

}
