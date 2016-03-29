package com.ensi.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="analyseeffetdelevier")
public class AnalyseEffetDeLevier implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
    private int annee;
    private double coutVariable;
    private double coutFixe;
    private double capitalInvesti;
    private double chiffreAffaire;
    private double beneficeAvanInteretEtImpot;
    private double beneficeAvantImpot;
    private double beneficeNet;
    private double tauxRentabiliteEconomique;
    private double tauxRentabiliteFinanciere;
    private double effetDeLevier;
    private double coefficientEffetDeLevier;
    private double productionPointMort;
    private double productionPourBenefice;
    private double chiffreAffaireCritique;

    
    private DonneesEffetDeLevier del=new DonneesEffetDeLevier();
    private PassifNonCourant pnc=new PassifNonCourant();
   
    
    public double capitalPropre=pnc.sommeCapitalPropre();
    public double emprunts=pnc.getEmprunts();

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "annee", length = 50)
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}


    public double coutVariable(){
    	 coutVariable=del.getQuantiteDeProduction()*del.getCoutVariableUnitaire();
    	 return coutVariable;
    }

    public double coutFixe(){
    	coutFixe= del.getCoutFixeExploitation()+del.getCoutFixeHorsExploitation();
    	return coutFixe;
    }

    public double capitalInvesti(){
    	 capitalInvesti=capitalPropre+del.getCapitalEtranger();
    	 return capitalInvesti;
    }
   

    public double chiffreAffaire(){
    	 chiffreAffaire=del.getQuantiteDeProduction()*del.getPrixUnitaire();
    	 return chiffreAffaire;
    }

    
    public double beneficeAvanInteretEtImpot(){
    	 beneficeAvanInteretEtImpot=chiffreAffaire()-del.getCoutFixeExploitation();
    	 return beneficeAvanInteretEtImpot;
    }
    
    
    public double beneficeAvantImpot(){
    	 beneficeAvantImpot=beneficeAvanInteretEtImpot()-del.getCoutFixeHorsExploitation();
    	 return beneficeAvantImpot;
    }
    
    
    public double beneficeNet(){
    	 beneficeNet=beneficeAvantImpot()-(0.3*beneficeAvantImpot());
    	 return beneficeNet;
    }
    
    
    public double tauxRentabiliteEconomique(){
    	 tauxRentabiliteEconomique=beneficeAvantImpot()/capitalInvesti();
    	 return tauxRentabiliteEconomique;
    }
    
    
    public double tauxRentabiliteFinanciere(){
    	 tauxRentabiliteFinanciere=beneficeNet()/capitalPropre;
    	 return tauxRentabiliteFinanciere;
    }
    
 
    
    public double effetDeLevier(){
    	double ratioEndettement=del.getDettesFinancieres()/capitalPropre;
    	 effetDeLevier=tauxRentabiliteEconomique()+(tauxRentabiliteEconomique()-emprunts)*ratioEndettement;
    	 return effetDeLevier;
    }
    
    
    public double coefficientEffetDeLevier(){
    	 coefficientEffetDeLevier=beneficeAvanInteretEtImpot()/beneficeAvantImpot();
    	 return coefficientEffetDeLevier;
    }
    
    
    public double productionPointMort(){
     productionPointMort=(del.getCoutFixeExploitation()+del.getCoutFixeHorsExploitation())/(del.getPrixUnitaire()-del.getCoutVariableUnitaire());
    	return productionPointMort;
    }

    public double productionPourBenefice(){
		productionPourBenefice=(del.getCoutFixeExploitation()+del.getCoutFixeHorsExploitation()+del.getBeneficeVoulu())/(del.getPrixUnitaire()-del.getCoutVariableUnitaire());
    	return productionPourBenefice;
    }

    public double chiffreAffaireCritique(){
    	 chiffreAffaireCritique=coutFixe()+coutVariable();
    	 return chiffreAffaireCritique;
    }
   
    
    
    
    
	@Column(name = "coutVariable", length = 50)
	public double getCoutVariable() {
		return coutVariable;
	}
	public void setCoutVariable(double coutVariable) {
		this.coutVariable = coutVariable;
	}
	
	
	@Column(name = "coutFixe", length = 50)
	public double getCoutFixe() {
		return coutFixe;
	}
	public void setCoutFixe(double coutFixe) {
		this.coutFixe = coutFixe;
	}
	
	
	@Column(name = "capitalInvesti", length = 50)
	public double getCapitalInvesti() {
		return capitalInvesti;
	}
	public void setCapitalInvesti(double capitalInvesti) {
		this.capitalInvesti = capitalInvesti;
	}
	
	
	@Column(name = "chiffreAffaire", length = 50)
	public double getChiffreAffaire() {
		return chiffreAffaire;
	}
	public void setChiffreAffaire(double chiffreAffaire) {
		this.chiffreAffaire = chiffreAffaire;
	}
	
	
	@Column(name = "beneficeAvantInteretEtImpot")
	public double getBeneficeAvanInteretEtImpot() {
		return beneficeAvanInteretEtImpot;
	}
	public void setBeneficeAvanInteretEtImpot(double beneficeAvanInteretEtImpot) {
		this.beneficeAvanInteretEtImpot = beneficeAvanInteretEtImpot;
	}
	
	
	@Column(name = "beneficeAvantImpot")
	public double getBeneficeAvantImpot() {
		return beneficeAvantImpot;
	}
	public void setBeneficeAvantImpot(double beneficeAvantImpot) {
		this.beneficeAvantImpot = beneficeAvantImpot;
	}
	
	
	@Column(name = "beneficeNet")
	public double getBeneficeNet() {
		return beneficeNet;
	}
	public void setBeneficeNet(double beneficeNet) {
		this.beneficeNet = beneficeNet;
	}
	
	@Column(name = "tauxRentabiliteEconomique")
	public double getTauxRentabiliteEconomique() {
		return tauxRentabiliteEconomique;
	}
	public void setTauxRentabiliteEconomique(double tauxRentabiliteEconomique) {
		this.tauxRentabiliteEconomique = tauxRentabiliteEconomique;
	}
	
	@Column(name = "tauxRentabiliteFinanciere")
	public double getTauxRentabiliteFinanciere() {
		return tauxRentabiliteFinanciere;
	}
	public void setTauxRentabiliteFinanciere(double tauxRentabiliteFinanciere) {
		this.tauxRentabiliteFinanciere = tauxRentabiliteFinanciere;
	}
	
	
	@Column(name = "effetDeLevier")
	public double getEffetDeLevier() {
		return effetDeLevier;
	}
	public void setEffetDeLevier(double effetDeLevier) {
		this.effetDeLevier = effetDeLevier;
	}
	
	@Column(name = "coefficientEffetDeLevier")
	public double getCoefficientEffetDeLevier() {
		return coefficientEffetDeLevier;
	}
	public void setCoefficientEffetDeLevier(double coefficientEffetDeLevier) {
		this.coefficientEffetDeLevier = coefficientEffetDeLevier;
	}
	
	@Column(name = "productionPointMort")
	public double getProductionPointMort() {
		return productionPointMort;
	}
	public void setProductionPointMort(double productionPointMort) {
		this.productionPointMort = productionPointMort;
	}
	
	@Column(name = "productionPourBenefice")
	public double getProductionPourBenefice() {
		return productionPourBenefice;
	}
	public void setProductionPourBenefice(double productionPourBenefice) {
		this.productionPourBenefice = productionPourBenefice;
	}
	
	@Column(name = "chiffreAffaireCritique")
	public double getChiffreAffaireCritique() {
		return chiffreAffaireCritique;
	}
	public void setChiffreAffaireCritique(double chiffreAffaireCritique) {
		this.chiffreAffaireCritique = chiffreAffaireCritique;
	}
	
	
	
	public AnalyseEffetDeLevier(int id, int annee, double coutVariable,
			double coutFixe, double capitalInvesti, double chiffreAffaire,
			double beneficeAvanInteretEtImpot, double beneficeAvantImpot,
			double beneficeNet, double tauxRentabiliteEconomique,
			double tauxRentabiliteFinanciere,
			double effetDeLevier, double coefficientEffetDeLevier,
			double productionPointMort, double productionPourBenefice,
			double chiffreAffaireCritique, DonneesEffetDeLevier del,
			PassifNonCourant pnc, double capitalPropre, double emprunts) {
		super();
		this.id = id;
		this.annee = annee;
		this.coutVariable = coutVariable;
		this.coutFixe = coutFixe;
		this.capitalInvesti = capitalInvesti;
		this.chiffreAffaire = chiffreAffaire;
		this.beneficeAvanInteretEtImpot = beneficeAvanInteretEtImpot;
		this.beneficeAvantImpot = beneficeAvantImpot;
		this.beneficeNet = beneficeNet;
		this.tauxRentabiliteEconomique = tauxRentabiliteEconomique;
		this.tauxRentabiliteFinanciere = tauxRentabiliteFinanciere;
		this.effetDeLevier = effetDeLevier;
		this.coefficientEffetDeLevier = coefficientEffetDeLevier;
		this.productionPointMort = productionPointMort;
		this.productionPourBenefice = productionPourBenefice;
		this.chiffreAffaireCritique = chiffreAffaireCritique;
		this.del = del;
		this.pnc = pnc;
		this.capitalPropre = capitalPropre;
		this.emprunts = emprunts;
	}
	public AnalyseEffetDeLevier(int id, int annee, double coutVariable,
			double coutFixe, double capitalInvesti, double chiffreAffaire,
			double beneficeAvanInteretEtImpot, double beneficeAvantImpot,
			double beneficeNet, double tauxRentabiliteEconomique,
			double tauxRentabiliteFinanciere, 
			double effetDeLevier, double coefficientEffetDeLevier,
			double productionPointMort, double productionPourBenefice,
			double chiffreAffaireCritique) {
		super();
		this.id = id;
		this.annee = annee;
		this.coutVariable = coutVariable;
		this.coutFixe = coutFixe;
		this.capitalInvesti = capitalInvesti;
		this.chiffreAffaire = chiffreAffaire;
		this.beneficeAvanInteretEtImpot = beneficeAvanInteretEtImpot;
		this.beneficeAvantImpot = beneficeAvantImpot;
		this.beneficeNet = beneficeNet;
		this.tauxRentabiliteEconomique = tauxRentabiliteEconomique;
		this.tauxRentabiliteFinanciere = tauxRentabiliteFinanciere;
		this.effetDeLevier = effetDeLevier;
		this.coefficientEffetDeLevier = coefficientEffetDeLevier;
		this.productionPointMort = productionPointMort;
		this.productionPourBenefice = productionPourBenefice;
		this.chiffreAffaireCritique = chiffreAffaireCritique;
	}
	public AnalyseEffetDeLevier() {
		super();
	}
		
}
