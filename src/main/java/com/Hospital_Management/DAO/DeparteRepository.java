package com.Hospital_Management.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hospital_Management.entities.Departement;



public interface DeparteRepository extends JpaRepository<Departement, Long>{

}
