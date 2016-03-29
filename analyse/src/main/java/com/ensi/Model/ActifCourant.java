package com.ensi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ActifCourant") 
public class ActifCourant implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int annee;
	private float stocks;
	private float creanceClients;
	private float creanceEtat;
	private float creanceDiverses;
	private float placements;
	private float liquidites;
	

	
    public float sommeActifCourant(){
		
		float temp=stocks+creanceClients+creanceEtat+creanceDiverses+placements+liquidites;
		return temp;
	};
	
	public float exploitationAC(){
		return stocks+creanceClients;
	}
	
	public float horsExploitationAC(){
		return creanceClients+creanceEtat+placements;
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
	@Column(name = "stock", length = 50)
	public float getStocks() {
		return this.stocks;
	}
	public void setStocks(float stocks) {
		this.stocks = stocks;
	}
	
	@Column(name = "creanceClients", length = 50)
	public float getCreanceClients() {
		return creanceClients;
	}
	public void setCreanceClients(float creanceClients) {
		this.creanceClients = creanceClients;
	}
	
	@Column(name = "creanceEtat", length = 50)
	public float getCreanceEtat() {
		return creanceClients;
	}
	public void setCreanceEtat(float creanceEtat) {
		creanceClients = creanceEtat;
	}
	
	@Column(name = "creanceDiverses", length = 45)
	public float getCreanceDiverses() {
		return creanceEtat;
	}
	public void setCreanceDiverses(float creanceDiverses) {
		creanceEtat = creanceDiverses;
	}
	
	@Column(name = "placements", length = 45)
	public float getPlacements() {
		return placements;
	}
	public void setPlacements(float placements) {
		this.placements = placements;
	}
	
	@Column(name = "liquidites", length = 45)
	public float getLiquidites() {
		return liquidites;
	}
	public void setLiquidites(float liquidites) {
		this.liquidites = liquidites;
	}
	public ActifCourant(int annee,float stocks, float creanceClients, float creanceEtat,
			float creanceDiverses, float placements, float liquidites) {
		super();
		this.annee=annee;
		this.stocks = stocks;
		this.creanceClients = creanceClients;
		this.creanceClients = creanceEtat;
		this.creanceEtat = creanceDiverses;
		this.placements = placements;
		this.liquidites = liquidites;
	}
	public ActifCourant() {
		super();		
	}
	public ActifCourant(int annee) {
		super();
		this.annee = annee;
	}
	
	

}
