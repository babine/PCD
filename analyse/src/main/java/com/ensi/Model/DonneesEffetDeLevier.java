package com.ensi.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="donneeseffetdelevier")
public class DonneesEffetDeLevier implements java.io.Serializable {
	
		private static final long serialVersionUID = 1L;
		private int id;
	    private int annee;
	    private double coutFixeExploitation;
	    private double coutFixeHorsExploitation;
	    
	    private double coutVariableUnitaire;
	    private double prixUnitaire;
	    
	    private double capitalEtranger;
	    
	    private double quantiteDeProduction;
	    
	    private double dettesFinancieres;
	    private double beneficeVoulu;
	   
	  
	    
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
		
		@Column(name = "coutFixeExploitation", length = 50)
		public double getCoutFixeExploitation() {
			return coutFixeExploitation;
		}
		public void setCoutFixeExploitation(double coutFixeExploitation) {
			this.coutFixeExploitation = coutFixeExploitation;
		}
		
		@Column(name = "coutFixeHorsExploitation", length = 50)
		public double getCoutFixeHorsExploitation() {
			return coutFixeHorsExploitation;
		}
		public void setCoutFixeHorsExploitation(double coutFixeHorsExploitation) {
			this.coutFixeHorsExploitation = coutFixeHorsExploitation;
		}
		
		@Column(name = "coutVariableUnitaire", length = 50)
		public double getCoutVariableUnitaire() {
			return coutVariableUnitaire;
		}
		public void setCoutVariableUnitaire(double coutVariableUnitaire) {
			this.coutVariableUnitaire = coutVariableUnitaire;
		}
		
		@Column(name = "prixUnitaire", length = 50)
		public double getPrixUnitaire() {
			return prixUnitaire;
		}
		public void setPrixUnitaire(double prixUnitaire) {
			this.prixUnitaire = prixUnitaire;
		}
		
		
		@Column(name = "capitalEtranger", length = 50)
		public double getCapitalEtranger() {
			return capitalEtranger;
		}
		public void setCapitalEtranger(double capitalEtranger) {
			this.capitalEtranger = capitalEtranger;
		}
		
		@Column(name = "quantiteDeProduction", length = 50)
		public double getQuantiteDeProduction() {
			return quantiteDeProduction;
		}
		public void setQuantiteDeProduction(double quantiteDeProduction) {
			this.quantiteDeProduction = quantiteDeProduction;
		}
		
		@Column(name = "dettesFinancieres", length = 50)
		public double getDettesFinancieres() {
			return dettesFinancieres;
		}
		public void setDettesFinancieres(double dettesFinancieres) {
			this.dettesFinancieres = dettesFinancieres;
		}
		
		@Column(name = "beneficeVoulu", length = 50)
		public double getBeneficeVoulu() {
			return beneficeVoulu;
		}
		public void setBeneficeVoulu(double benefice) {
			this.beneficeVoulu = benefice;
		}
		public DonneesEffetDeLevier(int annee, double coutFixeExploitation,
				double coutFixeHorsExploitation, double coutVariableUnitaire,
				double prixUnitaire, double capitalEtranger,
				double quantiteDeProduction, double dettesFinancieres) {
			super();
			this.annee = annee;
			this.coutFixeExploitation = coutFixeExploitation;
			this.coutFixeHorsExploitation = coutFixeHorsExploitation;
			this.coutVariableUnitaire = coutVariableUnitaire;
			this.prixUnitaire = prixUnitaire;
			this.capitalEtranger = capitalEtranger;
			this.quantiteDeProduction = quantiteDeProduction;
			this.dettesFinancieres = dettesFinancieres;
		}
		public DonneesEffetDeLevier() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		//-------------- Constructeurs-----------//
	

}
