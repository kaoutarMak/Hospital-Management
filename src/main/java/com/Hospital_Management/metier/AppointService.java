package com.Hospital_Management.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hospital_Management.DAO.AppointRepository;
import com.Hospital_Management.entities.Appointment;

@Service
@Transactional
public class AppointService {

	
	@Autowired
	private AppointRepository apprepo;
	
	
	public List<Appointment> listAppoint() {
		return apprepo.findAll();

	}

	public void saveDepart(Appointment appointment) {
		
		apprepo.save(appointment);
	}
	
	
	public Appointment get(Long id) {
		return apprepo.findById(id).get();
		}
		
	public void delete(Long id) {
		apprepo.deleteById(id);
}
}
