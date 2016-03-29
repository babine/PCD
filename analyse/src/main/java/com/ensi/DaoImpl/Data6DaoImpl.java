package com.ensi.DaoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ensi.Dao.Data6Dao;
import com.ensi.Model.DonneesDecision;

@Repository
public class Data6DaoImpl implements Data6Dao, Serializable {


	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;


	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void saveDonneesDecision(DonneesDecision dd) {

        	 em.persist(dd);
         
     }

	@SuppressWarnings("unchecked")
	@Override
	public List<DonneesDecision> getAllDonneesDecision() {
		List<DonneesDecision> listDonneesDecision = new ArrayList();
		listDonneesDecision =(List<DonneesDecision>) em
		.createQuery("from DonneesDecision").getResultList();
		
		return listDonneesDecision;
	}
	
}
