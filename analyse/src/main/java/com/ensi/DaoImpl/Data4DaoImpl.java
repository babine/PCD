package com.ensi.DaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ensi.Dao.Data4Dao;
import com.ensi.Model.ActifNonCourant;
import com.ensi.Model.PassifCourant;

@Repository
public class Data4DaoImpl implements Data4Dao, Serializable{


		private static final long serialVersionUID = 1L;
		
		@PersistenceContext
		private EntityManager em;


		public EntityManager getEm() {
			return em;
		}

		public void setEm(EntityManager em) {
			this.em = em;
		}

		public void savePassifCourant(PassifCourant pc) {

	        	 em.persist(pc);
	         
	     }
		@Override
		public PassifCourant findByAnnee(int annee) {
			return (PassifCourant)em
					.createQuery("from PassifCourant where annee=:log")
					.setParameter("log", annee).getSingleResult();
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public List<PassifCourant> getAllPassifCourant(){
			List<PassifCourant> listPassifCourant = new ArrayList();
			listPassifCourant =(List<PassifCourant>) em
			.createQuery("from PassifCourant").getResultList();
			
			return listPassifCourant;
			
		}

		@Override
		public void updatePassifCourant(PassifCourant pc) {
			// TODO Auto-generated method stub
			em.merge(pc);
		}

		@Override
		public void deletePassifCourant(PassifCourant pc) {
			PassifCourant pcToDelete=em.find(PassifCourant.class,pc.getId());
			em.merge(pcToDelete);
			em.createQuery("DELETE FROM PassifCourant pcs WHERE pcs.id =:id")
			.setParameter("id", pc.getId()).executeUpdate();

		}
		

	}
	
