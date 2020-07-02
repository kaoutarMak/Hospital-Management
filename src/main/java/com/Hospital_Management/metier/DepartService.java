package com.Hospital_Management.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hospital_Management.DAO.DeparteRepository;
import com.Hospital_Management.entities.Departement;

@Service
@Transactional
public class DepartService {

	
	@Autowired
	private DeparteRepository deprepo;

	public List<Departement> listDepart() {
		return deprepo.findAll();

	}

	public void saveDepart(Departement departement) {
		
		deprepo.save(departement);
	}
	
	
	public Departement get(Long id) {
		return deprepo.findById(id).get();
		}
		
	public void delete(Long id) {
		deprepo.deleteById(id);
}
}