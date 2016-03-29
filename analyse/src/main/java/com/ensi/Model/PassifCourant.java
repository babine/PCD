package com.ensi.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PassifCourant")
public class PassifCourant implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;	

	private int annee;	
	private float detteFournisseurs;
	private float detteFiscales;
	private float detteSalaries;
	private float diversePassifCourant;
	private float concourBancaire;


	@Column(name = "concourBancaire", length = 50)
    public float getConcourBancaire() {
		return concourBancaire;
	}

	public void setConcourBancaire(float concourBancaire) {
		this.concourBancaire = concourBancaire;
	}

	public float sommePassifCourant(){
		
		float temp=detteFournisseurs+detteFiscales+detteSalaries+diversePassifCourant;
		return temp;
	};
	
	public float exploitationPC(){
		return detteFournisseurs+detteFiscales;
	}
	public float horsExploitationPC(){
		return detteSalaries+diversePassifCourant;
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
	
	public PassifCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PassifCourant(int id,int annee, float detteFournisseurs,
			float detteFiscales, float detteSalaries, float diversePassifCourant) {
		super();
		this.id=id;
		this.annee = annee;
		this.detteFournisseurs = detteFournisseurs;
		this.detteFiscales = detteFiscales;
		this.detteSalaries = detteSalaries;
		this.diversePassifCourant = diversePassifCourant;
	}

	public PassifCourant(int annee) {
		super();
		this.annee = annee;
	}
	
	@Column(name = "detteFournisseurs", length = 50)
	public float getDetteFournisseurs() {
		return detteFournisseurs;
	}

	public void setDetteFournisseurs(float detteFournisseurs) {
		this.detteFournisseurs = detteFournisseurs;
	}

	@Column(name = "detteFiscales", length = 50)
	public float getDetteFiscales() {
		return detteFiscales;
	}

	public void setDetteFiscales(float detteFiscales) {
		this.detteFiscales = detteFiscales;
	}

	@Column(name = "detteSalaries", length = 50)
	public float getDetteSalaries() {
		return detteSalaries;
	}

	public void setDetteSalaries(float detteSalaries) {
		this.detteSalaries = detteSalaries;
	}

	@Column(name = "diversePassifCourant", length = 50)
	public float getDiversePassifCourant() {
		return diversePassifCourant;
	}

	public void setDiversePassifCourant(float diversePassifCourant) {
		this.diversePassifCourant = diversePassifCourant;
	}


}
