package com.ensi.DaoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ensi.Dao.EffetDeLevierDao;
import com.ensi.Model.AnalyseEffetDeLevier;

@Repository
public class EffetDeLevierDaoImpl implements EffetDeLevierDao,Serializable{
	
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
	public List<AnalyseEffetDeLevier> getAllAnalyseEffetDeLevier(){
		List<AnalyseEffetDeLevier> listAnalyseEffetDeLevier=new ArrayList();
		listAnalyseEffetDeLevier=(List<AnalyseEffetDeLevier>)em.createQuery("from AnalyseEffetDeLevier").getResultList();
		return listAnalyseEffetDeLevier;
				
	}

	public void insertIntoAnalyseEffetDeLevier(int annee) {

String query="insert into analyseeffetdelevier(id,annee,beneficeavantinteretetimpot,beneficeavantimpot,beneficenet,capitalinvesti,"
		+ "chiffreaffaire,chiffreaffairecritique,coefficienteffetdelevier,coutfixe,coutvariable,effetdelevier,"
		+ "productionpointmort,productionpourbenefice,tauxrentabiliteeconomique,tauxrentabilitefinanciere)(select "
        + "((select count(*) from analyseeffetdelevier)+1) as id,"
        + "t_del.annee as annee,"
        + "((t_del.quantitedeproduction*t_del.prixunitaire)-(t_del.coutfixeexploitation)) as beneficeavantinteretetimpot,"

		+ "((t_del.quantitedeproduction*t_del.prixunitaire)-(t_del.coutfixeexploitation)-(t_del.coutfixehorsexploitation))"
		+ "as beneficeavantimpot,"

		+ "((t_del.quantitedeproduction*t_del.prixunitaire)-(t_del.coutfixeexploitation + t_del.coutfixehorsexploitation)-"
		+ "(0.3*((t_del.quantitedeproduction*t_del.prixunitaire)-(t_del.coutfixeexploitation + t_del.coutfixehorsexploitation))))"
		+ "as beneficenet,"

		+ "( t_pnc.capitalsocial+t_pnc.reserves+t_pnc.autrescapiteauxpropres+t_pnc.resultatreporte+t_pnc.resultatexercice+t_del.capitaletranger) as capitalinvesti,"

		+ "(t_del.quantitedeproduction*t_del.prixunitaire) as chiffreaffaire,"

		+ "((t_del.coutfixeexploitation+t_del.coutfixehorsexploitation)+(t_del.quantitedeproduction*t_del.coutvariableunitaire)) as chiffreaffairecritique,"

		+ "(((t_del.quantitedeproduction*t_del.prixunitaire)-(t_del.coutfixeexploitation))/((t_del.quantitedeproduction*t_del.prixunitaire)-"
		+ "(t_del.coutfixeexploitation)-(t_del.coutfixehorsexploitation))) as coefficienteffetdelevier,"

		+ "(t_del.coutfixeexploitation+t_del.coutfixehorsexploitation) as coutfixe,"

		+ "(t_del.quantitedeproduction*t_del.coutvariableunitaire) as coutvariable,"

		+ "((((t_del.quantitedeproduction*t_del.prixunitaire)-(t_del.coutfixeexploitation)-(t_del.coutfixehorsexploitation))/"
		+ "( t_pnc.capitalsocial+t_pnc.reserves+t_pnc.autrescapiteauxpropres+t_pnc.resultatreporte+t_pnc.resultatexercice+"
		+ "t_del.capitaletranger))+((((t_del.quantitedeproduction*t_del.prixunitaire)-(t_del.coutfixeexploitation)-(t_del.coutfixehorsexploitation))/"
		+ "( t_pnc.capitalsocial+t_pnc.reserves+t_pnc.autrescapiteauxpropres+t_pnc.resultatreporte+t_pnc.resultatexercice+"
		+ "t_del.capitaletranger))-t_pnc.emprunts)*(t_del.dettesfinancieres/(t_pnc.capitalsocial+t_pnc.reserves+t_pnc.autrescapiteauxpropres+"
		+ "t_pnc.resultatreporte+t_pnc.resultatexercice ))) as effetdelevier,"
		
		+ "((t_del.coutfixeexploitation+t_del.coutfixehorsexploitation)/(t_del.prixunitaire-t_del.coutvariableunitaire)) as productionpointmort,"
		+ "((t_del.coutfixeexploitation+t_del.coutfixehorsexploitation+t_del.beneficevoulu)/(t_del.prixunitaire-t_del.coutvariableunitaire)) as productionpourbenefice,"

		+ "(((t_del.quantitedeproduction*t_del.prixunitaire)-(t_del.coutfixeexploitation)-(t_del.coutfixehorsexploitation))/"
		+ "(t_pnc.capitalsocial+t_pnc.reserves+t_pnc.autrescapiteauxpropres+t_pnc.resultatreporte+t_pnc.resultatexercice+t_del.capitaletranger))"
		+ "as tauxrentabiliteeconomique,"

		+ "(((t_del.quantitedeproduction*t_del.prixunitaire)-(t_del.coutfixeexploitation + t_del.coutfixehorsexploitation)-"
		+ "(0.3*((t_del.quantitedeproduction*t_del.prixunitaire)-(t_del.coutfixeexploitation + t_del.coutfixehorsexploitation))))/"
		+ "(t_pnc.capitalsocial+t_pnc.reserves+t_pnc.autrescapiteauxpropres+t_pnc.resultatreporte+t_pnc.resultatexercice )) as tauxrentabilitefinanciere"
		+ " from donneeseffetdelevier t_del,passifnoncourant t_pnc where t_del.annee"
		+ "='"
		+ annee
		+ "' and t_pnc.annee='"
		+ annee
		+ "')";
				em.createQuery("delete from AnalyseEffetDeLevier").executeUpdate();
				em.createNativeQuery(query).executeUpdate();
	} 
	
}
	

