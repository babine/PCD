package com.ensi.DaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ensi.Dao.Data2Dao;
import com.ensi.Dao.DataDao;
import com.ensi.Model.ActifCourant;
import com.ensi.Model.ActifNonCourant;

@Repository
public class Data2DaoImpl implements Data2Dao, Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;


	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void saveActifCourant(ActifCourant ac) {

        	 em.persist(ac);
         
     }
	@Override
	public ActifCourant findByAnnee(int annee) {
		return (ActifCourant)em
				.createQuery("from actifcourant where annee=:log")
				.setParameter("log", annee).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActifCourant> getAllActifCourant(){
		List<ActifCourant> listActifCourant = new ArrayList();
		listActifCourant =(List<ActifCourant>) em
		.createQuery("from ActifCourant").getResultList();
		
		return listActifCourant;
		
	}

	@Override
	public void updateActifCourant(ActifCourant ac) {
		// TODO Auto-generated method stub
		em.merge(ac);
	}

	@Override
	public void deleteActifCourant(ActifCourant ac) {
		ActifCourant acToDelete=em.find(ActifCourant.class,ac.getId());
		em.merge(acToDelete);
		em.createQuery("DELETE FROM ActifCourant acs WHERE acs.id =:id")
		.setParameter("id", ac.getId()).executeUpdate();

	}
	

}
