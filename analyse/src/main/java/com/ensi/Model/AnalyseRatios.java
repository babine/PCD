package com.ensi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AnalyseRatios")
public class AnalyseRatios implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
    private int annee;
	private float degreLiquidite; 
	private float liquiditeGenerale; 
	private float liquiditeReduite; 
	private float liquiditeImmediate; 
	private float solvabiliteGenerale;
	private float autonomieDecisionnelle;

	private ActifNonCourant anc=new ActifNonCourant();
	private PassifNonCourant pnc=new PassifNonCourant();
	private ActifCourant ac=new ActifCourant();
	private PassifCourant pc=new PassifCourant();
	
	public float sommeActif(){
		return ac.sommeActifCourant()+anc.sommeActifNonCourant();
	}
	public float sommePassif(){
		return pc.sommePassifCourant()+pnc.sommePassifNonCourant();
	}
	public float degreLiquidite(){
		degreLiquidite=ac.sommeActifCourant()/sommeActif();
		return degreLiquidite;
	}
	public float liquiditeGenerale(){
		liquiditeGenerale=ac.sommeActifCourant()/pc.sommePassifCourant();
		return liquiditeGenerale;
	}
	public float liquiditeReduite(){
		liquiditeReduite=ac.sommeActifCourant()-ac.getStocks()/pc.sommePassifCourant();
		return liquiditeReduite;
	}
	public float liquiditeImmediate(){
		liquiditeImmediate=ac.getLiquidites()/pc.sommePassifCourant();
		return liquiditeImmediate;
	}
	public float solvabiliteGenerale(){
		solvabiliteGenerale=sommeActif()/sommePassif();
		return solvabiliteGenerale;
	}
	public float autonomieDecisionnelle(){
		autonomieDecisionnelle=pnc.sommePassifNonCourant()/pnc.sommeCapitalPropre();
		return autonomieDecisionnelle;
	}

	public AnalyseRatios() {
		super();
	}
	public AnalyseRatios(int annee, float degreLiquidite,
			float liquiditeGenerale, float liquiditeReduite,
			float liquiditeImmediate, float solvabiliteGenerale,
			float autonomieDecisionnelle, ActifNonCourant anc,
			PassifNonCourant pnc, ActifCourant ac, PassifCourant pc) {
		super();
		this.annee = annee;
		this.degreLiquidite = degreLiquidite;
		this.liquiditeGenerale = liquiditeGenerale;
		this.liquiditeReduite = liquiditeReduite;
		this.liquiditeImmediate = liquiditeImmediate;
		this.solvabiliteGenerale = solvabiliteGenerale;
		this.autonomieDecisionnelle = autonomieDecisionnelle;
		this.anc = anc;
		this.pnc = pnc;
		this.ac = ac;
		this.pc = pc;
	}
	@Column(name = "degreLiquidite", length = 50)
	public float getDegreLiquidite() {
		return degreLiquidite;
	}
	public void setDegreLiquidite(float dL) {
		degreLiquidite = dL;
	}
	@Column(name = "liquiditeGenerale", length = 50)
	public float getLiquiditeGenerale() {
		return liquiditeGenerale;
	}
	public void setLiquiditeGenerale(float lG) {
		liquiditeGenerale = lG;
	}
	@Column(name = "liquiditeReduite", length = 50)
	public float getLiquiditeReduite() {
		return liquiditeReduite;
	}
	public void setLiquiditeReduite(float lR) {
		liquiditeReduite = lR;
	}
	@Column(name = "liquiditeImmediate", length = 50)
	public float getLiquiditeImmediate() {
		return liquiditeImmediate;
	}
	public void setLiquiditeImmediate(float lI) {
		liquiditeImmediate = lI;
	}
	@Column(name = "solvabiliteGenerale", length = 50)
	public float getSolvabiliteGenerale() {
		return solvabiliteGenerale;
	}
	public void setSolvabiliteGenerale(float solvabiliteGenerale) {
		this.solvabiliteGenerale = solvabiliteGenerale;
	}
	@Column(name = "autonomieDecisionnelle", length = 50)
	public float getAutonomieDecisionnelle() {
		return autonomieDecisionnelle;
	}
	public void setAutonomieDecisionnelle(float aD) {
		autonomieDecisionnelle = aD;
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
}
