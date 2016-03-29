package com.ensi.DaoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ensi.Dao.UserDao;
import com.ensi.Model.Role;
import com.ensi.Model.User;

@Repository
public class UserDaoImpl implements UserDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
    private User user; 

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void saveUser(User u) {

        	 em.persist(u);
         
     }
	@Override
	public User findByUsername(String username) {
		
		return (User)em
				.createQuery("FROM User where username=:log")
				.setParameter("log", username).getSingleResult();
	}
	
	public List<User> getAllUsers(){
		List<User> listUtilisateurs = new ArrayList();
		listUtilisateurs =(List<User>) em
		.createQuery("from User").getResultList();
		
		return listUtilisateurs;
		
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		em.merge(u);
	}

	@Override
	public void deleteUser(User u) {
		List <Role> roles = new ArrayList();
		User userToDelete=em.find(User.class,  u.getIdUser());
		userToDelete.setRoles(roles);
		em.merge(userToDelete);
	    em.createQuery("DELETE  FROM User us where us.idUser =:id")
	    .setParameter("id", u.getIdUser()).executeUpdate();
		}
	

	
}