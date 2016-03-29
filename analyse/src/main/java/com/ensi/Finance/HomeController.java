package com.ensi.Finance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ensi.Model.ActifCourant;
import com.ensi.Model.ActifNonCourant;
import com.ensi.Model.AnalyseBilan;
import com.ensi.Model.AnalyseDecisionIvestissement;
import com.ensi.Model.AnalyseEffetDeLevier;
import com.ensi.Model.AnalyseRatios;
import com.ensi.Model.DonneesDecision;
import com.ensi.Model.DonneesEffetDeLevier;
import com.ensi.Model.PassifCourant;
import com.ensi.Model.PassifNonCourant;
import com.ensi.Model.User;
import com.ensi.service.BilanService;
import com.ensi.service.Data2Service;
import com.ensi.service.Data3Service;
import com.ensi.service.Data4Service;
import com.ensi.service.Data5Service;
import com.ensi.service.Data6Service;
import com.ensi.service.DataService;
import com.ensi.service.DecisionService;
import com.ensi.service.EffetDeLevierService;
import com.ensi.service.RatiosService;
import com.ensi.service.UserService;


@Controller

public class HomeController {

	

	@Autowired
	private UserService userservice;
	@Autowired
	private DataService dataservice;
	@Autowired
	private Data2Service data2service;
	@Autowired
	private Data3Service data3service;
	@Autowired
	private Data4Service data4service;
	@Autowired
	private Data5Service data5service;
	@Autowired 
	private Data6Service data6service;
	@Autowired
	private RatiosService ratiosservice;
	@Autowired
	private BilanService bilanservice;
	@Autowired
	private EffetDeLevierService effetdelevierservice;
	@Autowired
	private DecisionService decisionservice;
	
	
	//--------------------- Getters AND Setters------------------------------//
	public DecisionService getDecisionservice() {
		return decisionservice;
	}


	public void setDecisionservice(DecisionService decisionservice) {
		this.decisionservice = decisionservice;
	}


	public RatiosService getRatiosservice() {
		return ratiosservice;
	}


	public void setRatiosservice(RatiosService ratiosservice) {
		this.ratiosservice = ratiosservice;
	}


	public EffetDeLevierService getEffetdelevierservice() {
		return effetdelevierservice;
	}


	public void setEffetdelevierservice(EffetDeLevierService effetdelevierservice) {
		this.effetdelevierservice = effetdelevierservice;
	}


	public BilanService getBilanservice() {
		return bilanservice;
	}


	public void setBilanservice(BilanService bilanservice) {
		this.bilanservice = bilanservice;
	}


	public Data2Service getData2service() {
		return data2service;
	}


	public void setData2service(Data2Service data2service) {
		this.data2service = data2service;
	}


	public Data3Service getData3service() {
		return data3service;
	}


	public void setData3service(Data3Service data3service) {
		this.data3service = data3service;
	}


	public Data4Service getData4service() {
		return data4service;
	}


	public void setData4service(Data4Service data4service) {
		this.data4service = data4service;
	}

	public Data5Service getData5service() {
		return data5service;
	}


	public void setData5service(Data5Service data5service) {
		this.data5service = data5service;
	}

	public Data6Service getData6service() {
		return data6service;
	}


	public void setData6service(Data6Service data6service) {
		this.data6service = data6service;
	}

	
	public UserService getUserservice() {
		return userservice;
	}


	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}


	public DataService getDataservice() {
		return dataservice;
	}


	public void setDataservice(DataService dataservice) {
		this.dataservice = dataservice;
	}


	//-------------------------------------------------------------------------//
	@RequestMapping(value = "/home")
	 public String homePage(Model model) {

		        Set<String> roles = AuthorityUtils
		                .authorityListToSet(SecurityContextHolder.getContext()
		                        .getAuthentication().getAuthorities());
		        Authentication authentication = SecurityContextHolder.getContext()
						.getAuthentication();
		        Collection collectionRole=authentication.getAuthorities();
					
		        if (roles.contains("ROLE_ADMIN")){ 
		            return ("home");}
		         if(roles.contains("ROLE_Personel")){
		        return  ("homePersonnel");}
		        	  if(roles.contains("ROLE_Directeur")){
			        return ("homeDirector");}
		        	 if (roles == null) 
		        		 return ("Fail");
                       return "home";
		    }
	

	@RequestMapping(value = "/homePersonel")
	public String homePersonel(Model model) {
		return "homePersonnel";
	}
	@RequestMapping(value = "/homeDirector")
	public String homeDirecteur(Model model) {
		return "homeDirector";
	}
	
	@RequestMapping(value = "/login")
	public String userIndex2(Model model) {
		return "index";
	}

	/*--------------------------------*/
	
	@RequestMapping(value = "/GestionDonnées")
	public String GestionDonnées(Model model) {
		return "GestionDonnées";
	}
	@RequestMapping(value = "/GestionAnalyses")
	public String GestionAnalyse(Model model) {
		return "GestionAnalyse";
	}
	
	@RequestMapping(value = "/GestionUtilisateurs")
	public String GestionUtilisateur(Model model) {
		return "GestionUtilisateur";
	}
	
	@RequestMapping(value = "/GestionRapports")
	public String GestionRapport(Model model) {
		return "GestionRapport";
	}
	
/* -------------------------------  */
	@RequestMapping(value = "/Ratios")
	public String GestionRatios(Model model) {
		return "GestionRatios";
	}
	@RequestMapping(value = "/EffetDeLevier")
	public String EffetDeLevier(Model model) {
		return "EffetDeLevier";
	}
	@RequestMapping(value = "/Décisions")
	public String GestionDécision(Model model) {
		return "GestionDécision";
	}
	@RequestMapping(value = "/Tri")
	public String TriProjets(Model model) {
		return "TriProjets";
	}
	
	/*-------------------Affichage(user)----------------*/
	
	@RequestMapping(value = "/AffichUtilisateur",
			method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView AffichUtilisateur() {
		ModelAndView model = new ModelAndView("AffichUtilisateur");
		List<User> listUtilisateurs = new ArrayList();
		listUtilisateurs=userservice.getAllUsers();
		model.addObject("listUtilisateurs", listUtilisateurs);
		return model;
	}
	
	/*------------ Affichage (ANC)---------------*/
	
	@RequestMapping(value = "/AffichActifNonCourant",
			method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView AffichActifNonCourant() {
		ModelAndView model = new ModelAndView("AffichActifNonCourant");
		List<ActifNonCourant> listActifNonCourant = new ArrayList();

		listActifNonCourant=dataservice.getAllActifNonCourant();

		model.addObject("listActifNonCourant", listActifNonCourant);

		return model;
	}
	
/*------------ Affichage (AC)---------------*/
	
	@RequestMapping(value = "/AffichActifCourant",
			method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView AffichActifCourant() {
		ModelAndView model = new ModelAndView("AffichActifCourant");
		List<ActifCourant> listActifCourant = new ArrayList();

		listActifCourant=data2service.getAllActifCourant();

		model.addObject("listActifCourant", listActifCourant);

		return model;
	}
	
/*------------ Affichage (PNC)---------------*/
	
	@RequestMapping(value = "/AffichPassifNonCourant",
			method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView AffichPassifNonCourant() {
		ModelAndView model = new ModelAndView("AffichPassifNonCourant");
		List<PassifNonCourant> listPassifNonCourant = new ArrayList();

		listPassifNonCourant=data3service.getAllPassifNonCourant();

		model.addObject("listPassifNonCourant", listPassifNonCourant);

		return model;
	}
	
/*------------ Affichage (PC)---------------*/
	
	@RequestMapping(value = "/AffichPassifCourant",
			method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView AffichPassifCourant() {
		ModelAndView model = new ModelAndView("AffichPassifCourant");
		List<PassifCourant> listPassifCourant = new ArrayList();

		listPassifCourant=data4service.getAllPassifCourant();

		model.addObject("listPassifCourant", listPassifCourant);

		return model;
	}
	
/*------------ Affichage (Analyse des Ratios)---------------*/
	
	@RequestMapping(value = "/ConsultationEtatEntreprise",
			method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView ConsultationEtatEntreprise() {
		ModelAndView model = new ModelAndView("ConsultationEtatEntreprise");
		List<AnalyseRatios> listAnalyseRatios = new ArrayList();
		listAnalyseRatios=ratiosservice.getAllAnalyseRatios();
		model.addObject("listAnalyseRatios", listAnalyseRatios);
		return model;
	}
/*------------ Affichage (Analyse du Bilan)---------------*/
	
	@RequestMapping(value = "/ConsultationAnalyseBilan",   
			method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView ConsultationAnalyseBilan() {
		ModelAndView model = new ModelAndView("ConsultationAnalyseBilan");
		List<AnalyseBilan> listAnalyseBilan = new ArrayList();
		listAnalyseBilan=bilanservice.getAllAnalyseBilan();
		model.addObject("listAnalyseBilan", listAnalyseBilan);
		return model;
	}
	
	
/*------------ Affichage (Analyse effet de levier)---------------*/
	
	@RequestMapping(value = "/ConsultationEffetDeLevier",   
			method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView ConsultationEffetDeLevier() {
		ModelAndView model = new ModelAndView("ConsultationEffetDeLevier");
		List<AnalyseEffetDeLevier> listAnalyseEffetDeLevier = new ArrayList();
		listAnalyseEffetDeLevier=effetdelevierservice.getAllAnalyseEffetDeLevier();
		model.addObject("listAnalyseEffetDeLevier", listAnalyseEffetDeLevier);
		return model;
	}
	
	
/*------------ Affichage (Analyse Decision d'investissement)---------------*/
	
	@RequestMapping(value = "/ConsultationAnalyseDecisionnelle",   
			method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView ConsultationAnalyseDecisionnelle() {
		ModelAndView model = new ModelAndView("ConsultationAnalyseDecisionnelle");
		List<AnalyseDecisionIvestissement> listAnalyseDecisionInvestissement = new ArrayList();
		listAnalyseDecisionInvestissement=decisionservice.getAllAnalyseDecisionIvestissement();
		model.addObject("listAnalyseDecisionInvestissement", listAnalyseDecisionInvestissement);
		return model;
	}
	
	/* ------------------------------*/ 
	
	@RequestMapping(value = "/InsertionDonnees")
	public String InsertionDonnées(Model model) {
		return "InsertionDonnees";
	}
	@RequestMapping(value = "/ModificationDonnees")
	public String ModificationDonnées(Model model) {
		return "ModificationDonnées";
	}
	@RequestMapping(value = "/SuppressionDonnees")
	public String SuppressionDonnées(Model model) {
		return "SuppressionDonnées";
	}
	@RequestMapping(value = "/ConsultationDonnees")
	public String Consultation(Model model) {
		return "Consultation";
	}
	
	
	@RequestMapping(value = "/Bilan")
	public String ConsultationBilan(Model model) {
		return "ConsultationBilan";
	}
	@RequestMapping(value = "/AnalyseBilan")
	public String AnneeAnalyseBilan(Model model) {
		return "choixAnnee";
	}
	@RequestMapping(value = "/Etat")
	public String ConsultationEtatEntreprise(Model model) {
		return "choixAnnee2";
	}
	@RequestMapping(value = "/CashFlow")
	public String ConsultationEffetDeLevier(Model model) {
		return "choixAnnee3";
	}
	@RequestMapping(value = "/Decision")
	public String ConsultationAnalyseDecisionnelle(Model model) {
		return "InsertionDonneesDecision";
	}
	
	/*---------------------------------*/ 
	
	
	@RequestMapping(value = "/fail")
	public String Failure(Model model) {
		return "Fail";
	}
	
	/*-----------------------------------*/
	
	@RequestMapping(value = "/DeleteActifNC")
	public String suppressionANC(Model model) {
		return "deleteANC";
	}
	@RequestMapping(value = "/DeleteActifC")
	public String suppressionAC(Model model) {
		return "deleteAC";
	}
	@RequestMapping(value = "/DeletePassifNC")
	public String suppressionPNC(Model model) {
		return "deletePNC";
	}
	@RequestMapping(value = "/DeletePassifC")
	public String suppressionPC(Model model) {
		return "deletePC";
	}
	
	/*---------------------------------*/
	
	@RequestMapping(value = "/InsertionUtilisateur")
	public String InsertionUtilisateur(Model model) {
		return "InsertionUtilisateur";
	}
	@RequestMapping(value = "/ModificationUtilisateur")
	public String ModificationUtilisateur(Model model) {
		return "ModificationUtilisateur";
	}
	@RequestMapping(value = "/AffichUtilisateur")
	public String AffichageUtilisateur(Model model) {
		return "AffichUtilisateur";
	}
	@RequestMapping(value = "/SuppressionUtilisateur")
	public String SuppressionUtilisateur(Model model) {
		return "SuppressionUtilisateur";
	}
	
	/*------------------------------*/
	
	@RequestMapping(value = "/InsertActifNC")
	public String InsertionActifNC(Model model) {
		return "InsertActifNC";
	}
	@RequestMapping(value = "/InsertPassifNC")
	public String InsertionPassifNC(Model model) {
		return "InsertPassifNC";
	}
	@RequestMapping(value = "/InsertActifC")
	public String InsertionActifC(Model model) {
		return "InsertActifC";
	}
	@RequestMapping(value = "/InsertPassifC")
	public String InsertionPassifC(Model model) {
		return "InsertPassifC";
	}
	@RequestMapping(value = "/InsertEffetDeLevier")
	public String InsertionDonneesEffetDeLevier(Model model) {
		return "InsertionDonneesEffetDelevier";
	}
	
	
	
	
	@RequestMapping(value = "/UpdateActifNC")
	public String ModificationActifNC(Model model) {
		return "updateANC";
	}
	@RequestMapping(value = "/UpdateActifC")
	public String ModificationActifC(Model model) {
		return "updateAC";
	}
	@RequestMapping(value = "/UpdatePassifNC")
	public String ModificationPassifNC(Model model) {
		return "updatePNC";
	}
	@RequestMapping(value = "/UpdatePassifC")
	public String ModificationPassifC(Model model) {
		return "updatePC";
	}
	
	/* -------------------------- Insertion Utilisateur --------*/
	
	@RequestMapping(value = "/insertUser", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody ModelAndView insertUser(
			@RequestParam(value = "nom", required = false) String nom,
			@RequestParam(value = "prenom", required = false) String prenom,
			@RequestParam(value = "pass", required = false) String password,
			@RequestParam(value = "email", required = false) String email) {

		Map<String, Object> model = new HashMap<String, Object>();
		User user = new User();
		user.setUsername(prenom);
		user.setPassword(password);
		user.setLastname(nom);
		user.setEmail(email);

		userservice.saveUser(user);

		return new ModelAndView("GestionUtilisateur", model);
	}
	
	/* ----------------------- Insertion Donnees(ANC) -------------------*/
	
	@RequestMapping(value = "/insertData", method = { RequestMethod.POST,
			RequestMethod.GET })
	public  @ResponseBody ModelAndView insertData(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "annee", required = false) String annee,
			@RequestParam(value = "immobilisationIncorporelles", required = false) String immobilisationIncorporelles,
			@RequestParam(value = "immobilisationCorporelles", required = false) String immobilisationCorporelles,
			@RequestParam(value = "immobilisationFinancieres", required = false) String immobilisationFinancieres) {

		Map<String, Object> model = new HashMap<String, Object>();
		ActifNonCourant anc = new ActifNonCourant();
		anc.setAnnee(Integer.valueOf(annee));
		anc.setImmIncorporelles(Float.parseFloat(immobilisationIncorporelles)); 
		anc.setImmCorporelles(Float.parseFloat(immobilisationCorporelles));
		anc.setImmFinancieres(Float.parseFloat(immobilisationFinancieres));

		dataservice.saveActifNonCourant(anc);

		return new ModelAndView("InsertionDonnees", model);
	}
	
	/*------------------- Insertion (AC)---------------*/
	
	@RequestMapping(value = "/insertData2", method = { RequestMethod.POST,
			RequestMethod.GET })
	public  @ResponseBody ModelAndView insertData2(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "annee", required = false) String annee,
			@RequestParam(value = "stocks", required = false) String stocks,
			@RequestParam(value = "creanceClients", required = false) String creanceClients,
			@RequestParam(value = "creanceDiverses", required = false) String creanceDiverses,
			@RequestParam(value = "placements", required = false) String placements,
			@RequestParam(value = "liquidités", required = false) String liquidités,

			@RequestParam(value = "creanceEtat", required = false) String creanceEtat) {

		Map<String, Object> model = new HashMap<String, Object>();
		ActifCourant ac = new ActifCourant();

		ac.setAnnee(Integer.valueOf(annee));
		ac.setStocks(Float.parseFloat(stocks)); 
		ac.setCreanceClients(Float.parseFloat(creanceClients));
		ac.setCreanceEtat(Float.parseFloat(creanceEtat));
		ac.setCreanceEtat(Float.parseFloat(creanceDiverses));
		ac.setCreanceEtat(Float.parseFloat(placements));
		ac.setCreanceEtat(Float.parseFloat(liquidités));

		data2service.saveActifCourant(ac);

		return new ModelAndView("InsertionDonnees", model);
	}
	
	/*-------------- insertion (PNC)---------------------*/
	
	
	@RequestMapping(value = "/insertData3", method = { RequestMethod.POST,
			RequestMethod.GET })
	public  @ResponseBody ModelAndView insertData3(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "annee", required = false) String annee,
			@RequestParam(value = "capitalSocial", required = false) String capitalSocial,
			@RequestParam(value = "reserve", required = false) String reserve,
			@RequestParam(value = "autreCapitaux", required = false) String autreCapitaux,
			@RequestParam(value = "resultatReporte", required = false) String resultatReporte,
			@RequestParam(value = "resultatExercice", required = false) String resultatExercice,
			@RequestParam(value = "provisions", required = false) String provisions,
			@RequestParam(value = "autresPassifsFinanciers", required = false) String autresPassifsFinanciers,

			@RequestParam(value = "emprunts", required = false) String emprunts) {

		Map<String, Object> model = new HashMap<String, Object>();
		PassifNonCourant pnc = new PassifNonCourant();

		pnc.setAnnee(Integer.valueOf(annee));
		pnc.setCapitalSocial(Float.parseFloat(capitalSocial)); 
		pnc.setAutreCapitaux(Float.parseFloat(autreCapitaux));
		pnc.setResultatReporte(Float.parseFloat(resultatReporte));
		pnc.setResultatExercice(Float.parseFloat(resultatExercice));
		pnc.setEmprunts(Float.parseFloat(emprunts));
		pnc.setProvisions(Float.parseFloat(provisions));
		pnc.setAutresPassifsFinanciers(Float.parseFloat(autresPassifsFinanciers));

		data3service.savePassifNonCourant(pnc);

		return new ModelAndView("InsertionDonnees", model);
	}
	
	
	/*-----------------------Insertion (PC)------------------*/
	
	
	@RequestMapping(value = "/insertData4", method = { RequestMethod.POST,
			RequestMethod.GET })
	public  @ResponseBody ModelAndView insertData4(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "annee", required = false) String annee,
			@RequestParam(value = "detteFournisseurs", required = false) String detteFournisseurs,
			@RequestParam(value = "detteFiscales", required = false) String detteFiscales,
			@RequestParam(value = "detteSalaries", required = false) String detteSalaries,
			@RequestParam(value = "diversesPassifsCourants", required = false) String diversesPassifsCourants,
			@RequestParam(value = "concourBancaire", required = false) String concourBancaire){

		Map<String, Object> model = new HashMap<String, Object>();
		PassifCourant pc = new PassifCourant();

		pc.setAnnee(Integer.valueOf(annee));
		pc.setDetteFournisseurs(Float.parseFloat(detteFournisseurs)); 
		pc.setDetteFiscales(Float.parseFloat(detteFiscales));
		pc.setDetteSalaries(Float.parseFloat(detteSalaries));
		pc.setDiversePassifCourant(Float.parseFloat(diversesPassifsCourants));
		pc.setConcourBancaire(Float.parseFloat(concourBancaire));

		data4service.savePassifCourant(pc);

		return new ModelAndView("InsertionDonnees", model);
	}
	
	
/*-------------- insertion (EffetDeLevier)---------------------*/
	
	
	@RequestMapping(value = "/insertDataEffetLevier", method = { RequestMethod.POST,
			RequestMethod.GET })
	public  @ResponseBody ModelAndView insertDataEffetLevier(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "annee", required = false) String annee,
			@RequestParam(value = "coutFixeExploitation", required = false) String coutFixeExploitation,
			@RequestParam(value = "coutFixeHorsExploitation", required = false) String coutFixeHorsExploitation,
			@RequestParam(value = "coutVariableUnitaire", required = false) String coutVariableUnitaire,
			@RequestParam(value = "prixUnitaire", required = false) String prixUnitaire,
			@RequestParam(value = "capitalEtranger", required = false) String capitalEtranger,
			@RequestParam(value = "quantiteDeProduction", required = false) String quantiteDeProduction,
			@RequestParam(value = "dettesFinancieres", required = false) String dettesFinancieres,
			@RequestParam(value = "beneficeVoulu", required = false) String beneficeVoulu) {

		Map<String, Object> model = new HashMap<String, Object>();
		DonneesEffetDeLevier del = new DonneesEffetDeLevier();

		del.setAnnee(Integer.valueOf(annee));
		del.setCoutFixeExploitation(Float.parseFloat(coutFixeExploitation)); 
		del.setCoutFixeHorsExploitation(Float.parseFloat(coutFixeHorsExploitation)); 
		
		del.setCoutVariableUnitaire(Float.parseFloat(coutVariableUnitaire));
		del.setPrixUnitaire(Float.parseFloat(prixUnitaire));
		del.setCapitalEtranger(Float.parseFloat(capitalEtranger));
		del.setQuantiteDeProduction(Float.parseFloat(quantiteDeProduction));
		del.setDettesFinancieres(Float.parseFloat(dettesFinancieres));
		del.setBeneficeVoulu(Float.parseFloat(beneficeVoulu));

		data5service.saveEffetDeLevier(del);

		return new ModelAndView("InsertionDonnees", model);
	}
	
	
	
/*-----------------------Insertion (choixAnnee)------------------*/
	
	
	@RequestMapping(value = "/insert_choice", method = { RequestMethod.POST,
			RequestMethod.GET })
	public  @ResponseBody ModelAndView insert_choice(
		
			@RequestParam(value = "annee", required = false) String annee){

		bilanservice.insertIntoAnalyseBilan(Integer.valueOf(annee));
		
		ModelAndView model = new ModelAndView("ConsultationAnalyseBilan");
		List<AnalyseBilan> listAnalyseBilan = new ArrayList();
		listAnalyseBilan=bilanservice.getAllAnalyseBilan();	
		model.addObject("listAnalyseBilan", listAnalyseBilan);
		return model;
		
	}
	
	
	
/*-----------------------Insertion (choixAnnee2)------------------*/
	
	
	@RequestMapping(value = "/insert_choice2", method = { RequestMethod.POST,
			RequestMethod.GET })
	public  @ResponseBody ModelAndView insert_choice2(
		
			@RequestParam(value = "annee", required = false) String annee){

		ratiosservice.insertIntoAnalyseRatios(Integer.valueOf(annee));
		
		ModelAndView model = new ModelAndView("ConsultationEtatEntreprise");
		List<AnalyseRatios> listAnalyseRatios = new ArrayList();
		listAnalyseRatios=ratiosservice.getAllAnalyseRatios();	
		model.addObject("listAnalyseRatios", listAnalyseRatios);
		return model;
		
	}
	
	
	
/*-----------------------Insertion (choixAnnee3)------------------*/
	
	
	@RequestMapping(value = "/insert_choice3", method = { RequestMethod.POST,
			RequestMethod.GET })
	public  @ResponseBody ModelAndView insert_choice3(
		
			@RequestParam(value = "annee", required = false) String annee){

		effetdelevierservice.insertIntoAnalyseEffetDeLevier(Integer.valueOf(annee));
		
		ModelAndView model = new ModelAndView("ConsultationEffetDeLevier");
		List<AnalyseEffetDeLevier> listAnalyseEffetDeLevier = new ArrayList();
		listAnalyseEffetDeLevier=effetdelevierservice.getAllAnalyseEffetDeLevier();	
		model.addObject("listAnalyseEffetDeLevier", listAnalyseEffetDeLevier);
		return model;
		
	}
	
	
	
/*-----------------------Insertion (choix4)------------------*/
	
	
	@RequestMapping(value = "/insert_choice4", method = { RequestMethod.POST,
			RequestMethod.GET })
	public  @ResponseBody ModelAndView insert_choice4(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "annee", required = false) String annee,
			@RequestParam(value = "duree", required = false) String duree,
			@RequestParam(value = "investissementInitial", required = false) String investissementInitial,
			@RequestParam(value = "depencesDecaisses", required = false) String depencesDecaisses,
			@RequestParam(value = "tauxImpositionBenefice", required = false) String tauxImpositionBenefice

			){

		Map<String, Object> model = new HashMap<String, Object>();
		DonneesDecision dd = new DonneesDecision();

		dd.setAnnee(Integer.valueOf(annee));
		dd.setDuree(Integer.valueOf(duree)); 
		dd.setInvestissementInitial(Float.parseFloat(investissementInitial)); 
		
		dd.setDepencesDecaisses(Float.parseFloat(depencesDecaisses));
		dd.setTauxImpositionBenefice(Float.parseFloat(tauxImpositionBenefice));


		data6service.saveDonneesDecision(dd);

		//return new ModelAndView("ConsultationAnalyseDecisionnelle", model);
		
		
		decisionservice.insertIntoAnalyseDecisionIvestissement(Integer.valueOf(duree));
		
		ModelAndView model2 = new ModelAndView("ConsultationAnalyseDecisionnelle");
		List<AnalyseDecisionIvestissement> listAnalyseDecisionInvestissement = new ArrayList();
		listAnalyseDecisionInvestissement=decisionservice.getAllAnalyseDecisionIvestissement();
		model2.addObject("listAnalyseDecisionInvestissement", listAnalyseDecisionInvestissement);
		return model2;		
		
	}
	
	
	/* --------------------- Modification Utilisateur -----------------*/
	
	@RequestMapping(value = "/updateUser", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody ModelAndView updateUser(
			@RequestParam(value = "iduser", required = false) String iduser,

			@RequestParam(value = "nom", required = false) String nom,
			@RequestParam(value = "prenom", required = false) String prenom,
			@RequestParam(value = "pass", required = false) String password,
			@RequestParam(value = "email", required = false) String email
		) {

		Map<String, Object> model = new HashMap<String, Object>();
		User user = new User();
		user.setIdUser(Integer.valueOf(iduser));

		user.setUsername(prenom);
		user.setPassword(password);
		user.setLastname(nom);
		user.setEmail(email);

		userservice.updateUser(user);

		return new ModelAndView("GestionUtilisateur", model);
	}
	/*-------------------Modification données (ANC)-----------*/
	
	@RequestMapping(value = "/updateData", method = { RequestMethod.POST,
			RequestMethod.GET })
	public  @ResponseBody ModelAndView updateData(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "annee", required = false) String annee,
			@RequestParam(value = "immobilisationIncorporelles", required = false) String immobilisationIncorporelles,
			@RequestParam(value = "immobilisationCorporelles", required = false) String immobilisationCorporelles,
			@RequestParam(value = "immobilisationFinancieres", required = false) String immobilisationFinancieres) {

		Map<String, Object> model = new HashMap<String, Object>();
		ActifNonCourant anc = new ActifNonCourant();
		anc.setId(Integer.valueOf(id));

		anc.setAnnee(Integer.valueOf(annee));
		anc.setImmIncorporelles(Float.parseFloat(immobilisationIncorporelles)); 
		anc.setImmCorporelles(Float.parseFloat(immobilisationCorporelles));
		anc.setImmFinancieres(Float.parseFloat(immobilisationFinancieres));

		dataservice.updateActifNonCourant(anc);

		return new ModelAndView("ModificationDonnées", model);
	}
	
	
/*-------------------Modification données (AC)-----------*/
	
	@RequestMapping(value = "/updateData2", method = { RequestMethod.POST,
			RequestMethod.GET })
	public  @ResponseBody ModelAndView updateData2(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "annee", required = false) String annee,
			@RequestParam(value = "stocks", required = false) String stocks,
			@RequestParam(value = "creanceClients", required = false) String creanceClients,
			@RequestParam(value = "creanceDiverses", required = false) String creanceDiverses,
			@RequestParam(value = "placements", required = false) String placements,
			@RequestParam(value = "liquidités", required = false) String liquidités,

			@RequestParam(value = "creanceEtat", required = false) String creanceEtat) {

		Map<String, Object> model = new HashMap<String, Object>();
		ActifCourant ac = new ActifCourant();
		ac.setId(Integer.valueOf(id));

		ac.setAnnee(Integer.valueOf(annee));
		ac.setStocks(Float.parseFloat(stocks)); 
		ac.setCreanceClients(Float.parseFloat(creanceClients));
		ac.setCreanceEtat(Float.parseFloat(creanceEtat));
		ac.setCreanceEtat(Float.parseFloat(creanceDiverses));
		ac.setCreanceEtat(Float.parseFloat(placements));
		ac.setCreanceEtat(Float.parseFloat(liquidités));

		data2service.updateActifCourant(ac);

		return new ModelAndView("ModificationDonnées", model);
	}
	
	

	
/*-------------------Modification données (PNC)-----------*/
	
	
	@RequestMapping(value = "/updateData3", method = { RequestMethod.POST,
			RequestMethod.GET })
	public  @ResponseBody ModelAndView updateData3(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "annee", required = false) String annee,
			@RequestParam(value = "capitalSocial", required = false) String capitalSocial,
			@RequestParam(value = "reserve", required = false) String reserve,
			@RequestParam(value = "autreCapitaux", required = false) String autreCapitaux,
			@RequestParam(value = "resultatReporte", required = false) String resultatReporte,
			@RequestParam(value = "resultatExercice", required = false) String resultatExercice,
			@RequestParam(value = "provisions", required = false) String provisions,
			@RequestParam(value = "autresPassifsFinanciers", required = false) String autresPassifsFinanciers,

			@RequestParam(value = "emprunts", required = false) String emprunts) {

		Map<String, Object> model = new HashMap<String, Object>();
		PassifNonCourant pnc = new PassifNonCourant();
		pnc.setId(Integer.valueOf(id));

		pnc.setAnnee(Integer.valueOf(annee));
		pnc.setCapitalSocial(Float.parseFloat(capitalSocial)); 
		pnc.setAutreCapitaux(Float.parseFloat(autreCapitaux));
		pnc.setResultatReporte(Float.parseFloat(resultatReporte));
		pnc.setResultatExercice(Float.parseFloat(resultatExercice));
		pnc.setEmprunts(Float.parseFloat(emprunts));
		pnc.setProvisions(Float.parseFloat(provisions));
		pnc.setAutresPassifsFinanciers(Float.parseFloat(autresPassifsFinanciers));

		data3service.updatePassifNonCourant(pnc);

		return new ModelAndView("ModificationDonnées", model);
	}
	
	
/*-------------------Modification données (PC)-----------*/
	
	
	@RequestMapping(value = "/updateData4", method = { RequestMethod.POST,
			RequestMethod.GET })
	public  @ResponseBody ModelAndView updateData4(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "annee", required = false) String annee,
			@RequestParam(value = "detteFournisseurs", required = false) String detteFournisseurs,
			@RequestParam(value = "detteFiscales", required = false) String detteFiscales,
			@RequestParam(value = "detteSalaries", required = false) String detteSalaries,
			@RequestParam(value = "diversesPassifsCourants", required = false) String diversesPassifsCourants,
			@RequestParam(value = "concourBancaire", required = false) String concourBancaire){

		Map<String, Object> model = new HashMap<String, Object>();
		PassifCourant pc = new PassifCourant();
		
		pc.setId(Integer.valueOf(id));

		pc.setAnnee(Integer.valueOf(annee));
		pc.setDetteFournisseurs(Float.parseFloat(detteFournisseurs)); 
		pc.setDetteFiscales(Float.parseFloat(detteFiscales));
		pc.setDetteSalaries(Float.parseFloat(detteSalaries));
		pc.setDiversePassifCourant(Float.parseFloat(diversesPassifsCourants));
		pc.setConcourBancaire(Float.parseFloat(concourBancaire));

		data4service.updatePassifCourant(pc);

		return new ModelAndView("ModificationDonnées", model);
	}
	
	
	
/* --------------------- Suppression Utilisateur -----------------*/
	
	@RequestMapping(value = "/deleteUser", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody ModelAndView deleteUser(
			@RequestParam(value = "iduser", required = false) String iduser,
			@RequestParam(value = "nom", required = false) String nom,
			@RequestParam(value = "prenom", required = false) String prenom,
			@RequestParam(value = "pass", required = false) String password) {

		Map<String, Object> model = new HashMap<String, Object>();
		User user = new User(); 
		user.setIdUser(Integer.valueOf(iduser));
		user.setUsername(prenom);
		user.setPassword(password);
		user.setLastname(nom);
		userservice.deleteUser(user);

		return new ModelAndView("GestionUtilisateur", model);
	}
	
/* --------------------- Suppression (ANC) -----------------*/
	
	@RequestMapping(value = "/deleteData", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody ModelAndView deleteData(
			@RequestParam(value = "idANC", required = false) String idANC,
			@RequestParam(value = "annee", required = false) String annee) {

		Map<String, Object> model = new HashMap<String, Object>();
		ActifNonCourant anc = new ActifNonCourant(); 
		anc.setId(Integer.valueOf(idANC));
		anc.setAnnee(Integer.valueOf(annee));
		
		dataservice.deleteActifNonCourant(anc);

		return new ModelAndView("GestionDonnées", model);
	}

	
/* --------------------- Suppression (AC) -----------------*/
	
	@RequestMapping(value = "/deleteData2", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody ModelAndView deleteData2(
			@RequestParam(value = "idAC", required = false) String idAC,
			@RequestParam(value = "annee", required = false) String annee) {

		Map<String, Object> model = new HashMap<String, Object>();
		ActifCourant ac = new ActifCourant(); 
		ac.setId(Integer.valueOf(idAC));
		ac.setAnnee(Integer.valueOf(annee));
		
		data2service.deleteActifCourant(ac);

		return new ModelAndView("GestionDonnées", model);
	}
	
/* --------------------- Suppression (PNC) -----------------*/
	
	@RequestMapping(value = "/deleteData3", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody ModelAndView deleteData3(
			@RequestParam(value = "idPNC", required = false) String idPNC,
			@RequestParam(value = "annee", required = false) String annee) {

		Map<String, Object> model = new HashMap<String, Object>();
		PassifNonCourant pnc = new PassifNonCourant(); 
		pnc.setId(Integer.valueOf(idPNC));
		pnc.setAnnee(Integer.valueOf(annee));
		
		data3service.deletePassifNonCourant(pnc);

		return new ModelAndView("GestionDonnées", model);
	}
	
	
/* --------------------- Suppression (PC) -----------------*/
	
	@RequestMapping(value = "/deleteData4", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody ModelAndView deleteData4(
			@RequestParam(value = "idPC", required = false) String idPC,
			@RequestParam(value = "annee", required = false) String annee) {

		Map<String, Object> model = new HashMap<String, Object>();
		PassifCourant pc = new PassifCourant(); 
		pc.setId(Integer.valueOf(idPC));
		pc.setAnnee(Integer.valueOf(annee));
		
		data4service.deletePassifCourant(pc);

		return new ModelAndView("GestionDonnées", model);
	}

}
