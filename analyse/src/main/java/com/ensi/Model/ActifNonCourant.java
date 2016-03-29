package com.ensi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ActifNonCourant")
public class ActifNonCourant implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int annee;
	private float immIncorporelles;
	private float immCorporelles;
	private float immFinancieres;
	
	public float sommeActifNonCourant(){
		
		float temp=immIncorporelles+immCorporelles+immFinancieres;
		return temp;
	};
	
	@Id
    @GeneratedValue
    public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	@Column(name = "Annee", length = 50)
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	public ActifNonCourant(int annee, float immIncorporelles,
			float immCorporelles, float immFinancieres) {
		super();
		this.annee = annee;
		this.immIncorporelles = immIncorporelles;
		this.immCorporelles = immCorporelles;
		this.immFinancieres = immFinancieres;
	}

	public ActifNonCourant(int id,int annee,float immIncorporelles, float immCorporelles,
			float immFinancieres) {
		super();
		this.id=id;
		this.annee=annee;
		this.immIncorporelles = immIncorporelles;
		this.immCorporelles = immCorporelles;
		this.immFinancieres = immFinancieres;
	}
	public ActifNonCourant() {
		super();
	}
	
	@Column(name = "Immobilisations_Incorporelles", length = 50)
	public float getImmIncorporelles() {
		return immIncorporelles;
	}
	public void setImmIncorporelles(float immIncorporelles) {
		this.immIncorporelles = immIncorporelles;
	}
	
	@Column(name = "Immobilisations_Corporelles", length = 50)
	public float getImmCorporelles() {
		return immCorporelles;
	}
	public void setImmCorporelles(float immCorporelles) {
		this.immCorporelles = immCorporelles;
	}
	
	@Column(name = "Immobilisations_Financieres", length = 50)
	public float getImmFinancieres() {
		return immFinancieres;
	}
	public void setImmFinancieres(float immFinancieres) {
		this.immFinancieres = immFinancieres;
	}
}