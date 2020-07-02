package com.Hospital_Management.metier;




import com.Hospital_Management.entities.Role;



public interface RoleService {

	Role getDefaultRole();

    Role getRoleByAuthority(String authority);
}
