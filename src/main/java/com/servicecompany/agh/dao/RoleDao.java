package com.servicecompany.agh.dao;

import com.servicecompany.agh.employees.Role;

import java.util.Collection;
import java.util.Optional;

public interface RoleDao {

    Collection<Role> getAllRoles();

    Optional<Role> getRoleById(int id);


}
