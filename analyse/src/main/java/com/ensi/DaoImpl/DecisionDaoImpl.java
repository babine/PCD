package com.ensi.DaoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ensi.Dao.DecisionDao;
import com.ensi.Model.AnalyseDecisionIvestissement;

@Repository
public class DecisionDaoImpl implements DecisionDao,Serializable{

	private static final long SerialVersionUID=1L;
	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AnalyseDecisionIvestissement> getAllAnalyseDecisionIvestissement(){
		List<AnalyseDecisionIvestissement> listAnalyseDecisionInvestissement=new ArrayList();
		listAnalyseDecisionInvestissement=(List<AnalyseDecisionIvestissement>)em
				.createQuery("from AnalyseDecisionIvestissement").getResultList();
		return listAnalyseDecisionInvestissement;
				
	}

	public void insertIntoAnalyseDecisionIvestissement(int annee) {
		String query="";
		em.createNativeQuery(query).executeUpdate();
	}

}
