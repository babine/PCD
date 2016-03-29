package com.ensi.Dao;

import java.util.List;

import com.ensi.Model.AnalyseDecisionIvestissement;


public interface DecisionDao {
	public List<AnalyseDecisionIvestissement> getAllAnalyseDecisionIvestissement();
	public void insertIntoAnalyseDecisionIvestissement(int annee);
}
