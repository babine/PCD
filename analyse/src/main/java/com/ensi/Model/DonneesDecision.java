package com.ensi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="donneesdecision")
public class DonneesDecision implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
    private int annee;
    private int duree;
    private double investissementInitial;
    private double depencesDecaisses;
    private double tauxImpositionBenefice;
    
    
    
    
    
    
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "annee")
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	@Column(name = "duree")
    public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	@Column(name = "investissementInitial")
	public double getInvestissementInitial() {
		return investissementInitial;
	}
	public void setInvestissementInitial(double investissementInitial) {
		this.investissementInitial = investissementInitial;
	}
	
	@Column(name = "depencesDecaisses")
	public double getDepencesDecaisses() {
		return depencesDecaisses;
	}
	public void setDepencesDecaisses(double depencesDecaisses) {
		this.depencesDecaisses = depencesDecaisses;
	}
	
	@Column(name = "tauxImpositionBenefice")
	public double getTauxImpositionBenefice() {
		return tauxImpositionBenefice;
	}
	public void setTauxImpositionBenefice(double tauxImpositionBenefice) {
		this.tauxImpositionBenefice = tauxImpositionBenefice;
	}

}
