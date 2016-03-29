package com.ensi.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensi.Dao.RoleDao;
import com.ensi.Model.Role;
import com.ensi.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService,Serializable {

	
	private static final long serialVersionUID = 1L;
	@Autowired
	private RoleDao roleDao;
	
	
	
	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	

	public void saveRole(Role r) {
	      roleDao.saveRole(r);	
	}

	@Override
	public void updateRole(Role r) {
		roleDao.updateRole(r);
	}

	
	@Override
	public void deleteRole(Role r) {
		roleDao.deleteRole(r);
	}

	@Override
	public Role getRoleById(int id) {
		return roleDao.getRoleById(id);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

}

