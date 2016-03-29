package com.ensi.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AnalyseBilan")
public class AnalyseBilan implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private int annee;
	private double fondroulement;
	private double bfre;
	private double bfrhe;
	private double bfr;
	private double tn;
	private ActifCourant ac=new ActifCourant();
	private PassifCourant pc=new PassifCourant();


    
	
	public double calculFR(){
		fondroulement=ac.sommeActifCourant()-pc.sommePassifCourant();
		return fondroulement;
	}
	public double calculBFRE(){
		bfre=ac.exploitationAC()-pc.exploitationPC();
		return bfre;
	}
	public double calculBFRHE(){
		bfr=ac.horsExploitationAC()-pc.horsExploitationPC();
		return bfrhe;
	}
	public double calculBFR(){
		bfr=calculBFRE()+calculBFRHE();
		return bfr;
	}
	public double calculTN(){
		tn=ac.getLiquidites()-pc.getConcourBancaire();
		return tn;
	}
	
	public AnalyseBilan(int annee, double fondRoulement, double bFRE,
			double bFRHE, double bFR, double tN) {
		super();
		this.annee = annee;
		this.fondroulement = fondRoulement;
		this.bfre = bFRE;
		this.bfrhe = bFRHE;
		this.bfr = bFR;
		this.tn = tN;
	}
	
	public AnalyseBilan(int annee) {
		super();
		this.annee = annee;
	}
	
	
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
	@Column(name = "fondroulement", length = 50)
	public double getFondroulement() {
		return fondroulement;
	}
	public void setFondroulement(double fR) {
		fondroulement = fR;
	}
	@Column(name = "bfre", length = 50)
	public double getBfre() {
		return bfre;
	}
	public void setBfre(double bFRE) {
		this.bfre = bFRE;
	}
	@Column(name = "bfrhe", length = 50)
	public double getBfrhe() {
		return bfrhe;
	}
	public void setBfrhe(double bFRHE) {
		this.bfrhe = bFRHE;
	}
	
	@Column(name = "bfr", length = 50)
	public double getBfr() {
		return bfr;
	}
	public void setBfr(double bFR) {
		this.bfr = bFR;
	}
	
	@Column(name = "tn", length = 50)
	public double getTn() {
		return tn;
	}
	public void setTn(double tN) {
		this.tn = tN;
	}
	public AnalyseBilan() {
		super();
	}
	
}
