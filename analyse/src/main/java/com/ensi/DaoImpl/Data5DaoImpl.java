package com.ensi.DaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ensi.Dao.Data5Dao;
import com.ensi.Model.DonneesEffetDeLevier;
@Repository
public class Data5DaoImpl implements Data5Dao, Serializable{
	

			private static final long serialVersionUID = 1L;
			
			@PersistenceContext
			private EntityManager em;


			public EntityManager getEm() {
				return em;
			}

			public void setEm(EntityManager em) {
				this.em = em;
			}

			public void saveEffetDeLevier(DonneesEffetDeLevier del) {

		        	 em.persist(del);
		         
		     }
			
			
			@SuppressWarnings("unchecked")
			@Override
			public  List<DonneesEffetDeLevier> getAllDonneesEffetDeLevier(){
				List<DonneesEffetDeLevier> listDonneesEffetDeLevier = new ArrayList();
				listDonneesEffetDeLevier =(List<DonneesEffetDeLevier>) em
				.createQuery("from DonneesEffetDeLevier").getResultList();
				
				return listDonneesEffetDeLevier;
				
			}

			@Override
			public void updateEffetDeLevier(DonneesEffetDeLevier del) {
				// TODO Auto-generated method stub
				em.merge(del);
			}

			@Override
			public void deleteEffetDeLevier(DonneesEffetDeLevier del) {
				DonneesEffetDeLevier delToDelete=em.find(DonneesEffetDeLevier.class,del.getId());
				em.merge(delToDelete);
				em.createQuery("DELETE FROM PassifCourant dels WHERE dels.id =:id")
				.setParameter("id", del.getId()).executeUpdate();

			}
			

		}
		


