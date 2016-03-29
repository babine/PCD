package com.ensi.DaoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ensi.Dao.BilanDao;
import com.ensi.Model.ActifCourant;
import com.ensi.Model.AnalyseBilan;
import com.ensi.Model.PassifCourant;

@Repository
public class BilanDaoImpl implements BilanDao,Serializable {

	private static final long SerialVersionUID=1L;
	@PersistenceContext
	private EntityManager em;
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	private AnalyseBilan ab;
	
	@Override
	public AnalyseBilan getAnalyseBilan(int annee){
		AnalyseBilan analysebilan=new AnalyseBilan();
		analysebilan=(AnalyseBilan)em
				.createQuery("from AnalyseBilan where annee := " +annee).getSingleResult();
		return analysebilan;
				
	}
	
	@Override
	public List<AnalyseBilan> getAllAnalyseBilan(){
		List<AnalyseBilan> listAnalyseBilan=new ArrayList();
		listAnalyseBilan=(List<AnalyseBilan>)em.createQuery("from AnalyseBilan").getResultList();
		return listAnalyseBilan;
				
	}

	@Override
	public void insertIntoAnalyseBilan(int annee) {

String query="insert into analysebilan "
		+ "(id,annee,fondroulement,bfre,bfrhe,bfr,tn)"
		+ "(select distinct ((select count(*) from analysebilan)+1) as id "
		+ ", t_actif.annee as annee,"
		+ "((t_actif.stock+t_actif.placements+t_actif.liquidites+t_actif.creanceclients+t_actif.creanceetat+t_actif.creancediverses)"
		+ "-(t_passif.dettesalaries+t_passif.dettefournisseurs+t_passif.dettefiscales+t_passif.diversepassifcourant) ) as fondroulement,"
		+ "(t_actif.stock+t_actif.creanceclients)-(t_passif.dettefiscales+t_passif.dettefournisseurs) as bfre,"
		+ "(t_actif.creanceclients+t_actif.creanceetat+t_actif.placements)-"
		+ "(t_passif.dettesalaries+t_passif.diversepassifcourant) as bfrhe,"
		+ " (t_actif.stock+t_actif.creanceclients)-(t_passif.dettefiscales+t_passif.dettefournisseurs)"
		+ " +(t_actif.creanceclients+t_actif.creanceetat+t_actif.placements)-"
		+ "(t_passif.dettesalaries+t_passif.diversepassifcourant)as bfr,"
		+ "(t_actif.liquidites)-(t_passif.concourbancaire) as tn"
		+ " from actifcourant t_actif,passifcourant t_passif  where  t_actif.annee"
		+ " ='"
		+ annee
		+ "' and  t_passif.annee='"
		+ annee
		+ "')";
em.createQuery("delete from AnalyseBilan").executeUpdate();
em.createNativeQuery(query).executeUpdate();
	} 
	
}
