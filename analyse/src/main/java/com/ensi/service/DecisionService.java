package com.ensi.service;

import java.util.List;

import com.ensi.Model.AnalyseDecisionIvestissement;

public interface DecisionService {
	public List<AnalyseDecisionIvestissement> getAllAnalyseDecisionIvestissement();
	public void insertIntoAnalyseDecisionIvestissement(int annee);
}
