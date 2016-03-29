package com.ensi.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AnalyseDecisionIvestissement")
public class AnalyseDecisionIvestissement implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
    private double tauxActualisation;
    
    private DonneesDecision dd=new DonneesDecision();
    private AnalyseEffetDeLevier el=new AnalyseEffetDeLevier();
    private ActifNonCourant anc=new ActifNonCourant();
	

	public AnalyseDecisionIvestissement() {
		super();
		// TODO Auto-generated constructor stub
	}



    
    @Id
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="tauxActualisation")
	public double getTauxActualisation() {
		return tauxActualisation;
	}
	public void setTauxActualisation(double tauxActualisation) {
		this.tauxActualisation = tauxActualisation;
	}

	
    //public double calculInvestissementInitial(){
    //	investissementInitial=anc.sommeActifNonCourant()+accroissementBFRE;
    //	return investissementInitial;
    //}
    public double calculCashFlowBrut(int periode){
    	return el.beneficeAvanInteretEtImpot()-dd.getDepencesDecaisses();
    }
    public double calculCashFlowNet(int periode){
    	return calculCashFlowBrut(periode)-el.beneficeAvantImpot()*dd.getTauxImpositionBenefice();
    }
    
    public double calculVAN(){
    	double som=0;
    			for(int i=0;i<dd.getDuree();i++){
    				som=som+(calculCashFlowNet(i)/Math.pow(1+tauxActualisation,i));
    			}
    	return som-dd.getInvestissementInitial();
    }
   
}
