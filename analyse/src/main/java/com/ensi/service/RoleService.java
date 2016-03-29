package com.ensi.service;

import java.util.List;

import com.ensi.Model.Role;

public interface RoleService {
	 public void saveRole(Role r);
	 public void updateRole(Role r);
	 public void deleteRole(Role r);
	 public Role getRoleById(int id);
	 public List<Role> getAllRoles();

}
