package com.ensi.DaoImpl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ensi.Dao.RoleDao;
import com.ensi.Model.Role;

@Repository
public class RoleDaoImpl implements RoleDao,Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	
	
	

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void saveRole(Role r) {
		em.persist(r);
		
	}

	@Override
	public void updateRole(Role r) {
    em.merge(r);
		
	}

	@Override
	public void deleteRole(Role r) {
		// TODO Auto-generated method stub
		em.remove(r);
	}

	@Override
	public Role getRoleById(int id) {
		return 	(Role)em.find(Role.class,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRoles() {
		return 	em.createQuery("from Role").getResultList();
	}

}
