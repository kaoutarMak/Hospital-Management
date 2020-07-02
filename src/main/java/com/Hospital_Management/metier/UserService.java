package com.Hospital_Management.metier;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Hospital_Management.controller.dto.UserRegistrationModel;
import com.Hospital_Management.entities.User;



public interface UserService extends UserDetailsService {

	User register(UserRegistrationModel registrationModel);

   // boolean updatePassword(ChangePasswordModel changePasswordModel);
}