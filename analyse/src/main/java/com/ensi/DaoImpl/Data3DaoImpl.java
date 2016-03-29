package com.ensi.DaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ensi.Dao.Data3Dao;
import com.ensi.Model.ActifNonCourant;
import com.ensi.Model.PassifNonCourant;

@Repository
public class Data3DaoImpl implements Data3Dao, Serializable{


		private static final long serialVersionUID = 1L;
		
		@PersistenceContext
		private EntityManager em;


		public EntityManager getEm() {
			return em;
		}

		public void setEm(EntityManager em) {
			this.em = em;
		}

		public void savePassifNonCourant(PassifNonCourant pnc) {

	        	 em.persist(pnc);
	         
	     }
		@Override
		public PassifNonCourant findByAnnee(int annee) {
			return (PassifNonCourant)em
					.createQuery("from passifnoncourant where annee=:log")
					.setParameter("log", annee).getSingleResult();
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public List<PassifNonCourant> getAllPassifNonCourant(){
			List<PassifNonCourant> listPassifNonCourant = new ArrayList();
			listPassifNonCourant =(List<PassifNonCourant>) em
			.createQuery("from PassifNonCourant").getResultList();
			
			return listPassifNonCourant;
			
		}

		@Override
		public void updatePassifNonCourant(PassifNonCourant pnc) {
			// TODO Auto-generated method stub
			em.merge(pnc);
		}

		@Override
		public void deletePassifNonCourant(PassifNonCourant pnc) {
			PassifNonCourant pncToDelete=em.find(PassifNonCourant.class,pnc.getId());
			em.merge(pncToDelete);
			em.createQuery("DELETE FROM PassifNonCourant pncs WHERE pncs.id =:id")
			.setParameter("id", pnc.getId()).executeUpdate();

		}
		

	}
	

