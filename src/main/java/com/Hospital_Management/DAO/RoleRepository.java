package com.Hospital_Management.DAO;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Hospital_Management.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findOneByAuthority(String authority);
}
