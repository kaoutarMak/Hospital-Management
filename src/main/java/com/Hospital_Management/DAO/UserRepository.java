package com.Hospital_Management.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hospital_Management.controller.dto.UserRegistrationModel;
import com.Hospital_Management.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByUsername(String username);

	UserRegistrationModel save(UserRegistrationModel userRegistrationModel);
    
}

