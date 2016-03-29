package com.ensi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PassifNonCourant")
public class PassifNonCourant implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private int annee;
	private int id;
	private float capitalSocial;
	private float reserves;
	private float autreCapitaux;
	private float resultatReporte;
	private float resultatExercice;
	private float emprunts;
	private float provisions;
	private float autresPassifsFinanciers;
	
    public float sommePassifNonCourant(){
		
		float temp=emprunts+provisions+autresPassifsFinanciers;
		return temp;
	};
	
	public float sommeCapitalPropre(){
		float temp=capitalSocial+reserves+autreCapitaux+resultatReporte+resultatExercice;
		return temp;
	};
	public float sommeCapitalPermanent(){
		return sommePassifNonCourant()+sommeCapitalPropre();
	}
	
	public PassifNonCourant() {
		super();
	}

	public PassifNonCourant(int annee, float capitalSocial, float reserves,
			float autreCapitaux, float resultatReporte, float resultatExercice,
			float emprunts, float provisions, float autresPassifsFinanciers) {
		super();
		this.annee = annee;
		this.capitalSocial = capitalSocial;
		this.reserves = reserves;
		this.autreCapitaux = autreCapitaux;
		this.resultatReporte = resultatReporte;
		this.resultatExercice = resultatExercice;
		this.emprunts = emprunts;
		this.provisions = provisions;
		this.autresPassifsFinanciers = autresPassifsFinanciers;
	}

	@Column(name = "capitalSocial", length = 50)
	public float getCapitalSocial() {
		return capitalSocial;
	}

	public void setCapitalSocial(float capitalSocial) {
		this.capitalSocial = capitalSocial;
	}

	@Column(name = "reserves", length = 50)
	public float getReserves() {
		return reserves;
	}

	public void setReserves(float réserves) {
		reserves = réserves;
	}

	@Column(name = "autresCapiteauxPropres", length = 50)
	public float getAutreCapitaux() {
		return autreCapitaux;
	}

	public void setAutreCapitaux(float autreCapitaux) {
		this.autreCapitaux = autreCapitaux;
	}

	@Column(name = "resultatReporte", length = 50)
	public float getResultatReporte() {
		return resultatReporte;
	}

	public void setResultatReporte(float résultatReporte) {
		resultatReporte = résultatReporte;
	}

	@Column(name = "resultatExercice", length = 50)
	public float getResultatExercice() {
		return resultatExercice;
	}

	public void setResultatExercice(float résultatExercice) {
		resultatExercice = résultatExercice;
	}

	@Column(name = "emprunts", length = 50)
	public float getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(float emprunts) {
		this.emprunts = emprunts;
	}

	@Column(name = "provisions", length = 50)
	public float getProvisions() {
		return provisions;
	}

	public void setProvisions(float provisions) {
		this.provisions = provisions;
	}

	@Column(name = "autresPassifsFinanciers", length = 50)
	public float getAutresPassifsFinanciers() {
		return autresPassifsFinanciers;
	}

	public void setAutresPassifsFinanciers(float autresPassifsFinanciers) {
		this.autresPassifsFinanciers = autresPassifsFinanciers;
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