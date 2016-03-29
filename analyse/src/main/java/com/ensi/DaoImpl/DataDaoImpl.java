package com.ensi.DaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ensi.Dao.DataDao;
import com.ensi.Model.ActifNonCourant;
import com.ensi.Model.User;

@Repository
public class DataDaoImpl implements DataDao, Serializable{


		private static final long serialVersionUID = 1L;
		
		@PersistenceContext
		private EntityManager em;


		public EntityManager getEm() {
			return em;
		}

		public void setEm(EntityManager em) {
			this.em = em;
		}

		public void saveActifNonCourant(ActifNonCourant anc) {

	        	 em.persist(anc);
	         
	     }
		@Override
		public ActifNonCourant findByAnnee(int annee) {
			return (ActifNonCourant)em
					.createQuery("from actifnoncourant where annee=:log")
					.setParameter("log", annee).getSingleResult();
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public List<ActifNonCourant> getAllActifNonCourant(){
			List<ActifNonCourant> listActifNonCourant = new ArrayList();
			listActifNonCourant =(List<ActifNonCourant>) em
			.createQuery("from ActifNonCourant").getResultList();
			
			return listActifNonCourant;
			
		}

		@Override
		public void updateActifNonCourant(ActifNonCourant anc) {
			// TODO Auto-generated method stub
			em.merge(anc);
		}

		@Override
		public void deleteActifNonCourant(ActifNonCourant anc) {
			ActifNonCourant ancToDelete=em.find(ActifNonCourant.class,anc.getId());
			em.merge(ancToDelete);
			em.createQuery("DELETE FROM ActifNonCourant ancs WHERE ancs.id =:id")
			.setParameter("id", anc.getId()).executeUpdate();

		}
		

	}
	

