package com.ensi.DaoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ensi.Dao.RatiosDao;
import com.ensi.Model.AnalyseRatios;

@Repository
public class RatiosDaoImpl implements RatiosDao,Serializable{

	private static final long serialVersionUID=1L;
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
	public List<AnalyseRatios> getAllAnalyseRatios(){
		List<AnalyseRatios> listAnalyseRatios=new ArrayList();
		listAnalyseRatios=(List<AnalyseRatios>) em
				.createQuery("from AnalyseRatios").getResultList();
		return listAnalyseRatios;
	}
	
	public void insertIntoAnalyseRatios(int annee){
		String query="insert into analyseratios(id,annee,autonomieDecisionnelle,degreLiquidite,liquiditeGenerale,liquiditeReduite,liquiditeImmediate,solvabiliteGenerale)"
						+"(select distinct ((select count(*) from analyseratios)+1) as id,"
						+" t_ac.annee as annee,"
						+"((t_pnc.emprunts+t_pnc.provisions+t_pnc.autresPassifsFinanciers)/(t_pnc.capitalsocial+t_pnc.reserves+t_pnc.autrescapiteauxpropres+t_pnc.resultatreporte+t_pnc.resultatexercice)) as autonomieDecisionnelle,"
						+"((t_ac.stock+t_ac.creanceclients+t_ac.creanceetat+t_ac.creancediverses+t_ac.placements+t_ac.liquidites)/(t_ac.stock+t_ac.creanceclients+t_ac.creanceetat+t_ac.creancediverses+t_ac.placements+t_ac.liquidites+"
						+"t_anc.immobilisations_incorporelles+t_anc.immobilisations_corporelles+t_anc.immobilisations_financieres)) as degreLiquidite,"
						+"((t_ac.stock+t_ac.creanceclients+t_ac.creanceetat+t_ac.creancediverses+t_ac.placements+t_ac.liquidites)/(t_pc.dettefournisseurs+t_pc.dettefiscales+t_pc.dettesalaries+t_pc.diversepassifcourant)) as liquiditeGenerale,"
						+"((t_ac.creanceclients+t_ac.creanceetat+t_ac.creancediverses+t_ac.placements+t_ac.liquidites)/(t_pc.dettefournisseurs+t_pc.dettefiscales+t_pc.dettesalaries+t_pc.diversepassifcourant)) as liquiditeReduite,"
						+"((t_ac.liquidites)/(t_pc.dettefournisseurs+t_pc.dettefiscales+t_pc.dettesalaries+t_pc.diversepassifcourant)) as liquiditeImmediate,"
						+"(((t_ac.stock+t_ac.creanceclients+t_ac.creanceetat+t_ac.creancediverses+t_ac.placements+t_ac.liquidites)+(t_anc.immobilisations_incorporelles+t_anc.immobilisations_corporelles+t_anc.immobilisations_financieres))"
						+"/((t_pnc.emprunts+t_pnc.provisions+t_pnc.autresPassifsFinanciers)+(t_pc.dettefournisseurs+t_pc.dettefiscales+t_pc.dettesalaries+t_pc.diversepassifcourant))) as solvabiliteGenerale "
						+" from actifcourant t_ac,passifcourant t_pc,actifnoncourant t_anc,passifnoncourant t_pnc where "
						+ "t_ac.annee"
						+ "='"
						+ annee
						+"'and t_pc.annee"
						+ "='"
						+ annee
						+"'and t_anc.annee"
						+ "='"
						+ annee
						+"'and t_pnc.annee"
						+ "='"
						+ annee
						+"')";
				
				em.createQuery("delete from AnalyseRatios").executeUpdate();
				em.createNativeQuery(query).executeUpdate();

	}

}
