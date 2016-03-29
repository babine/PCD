package com.ensi.service;

import java.util.List;

import com.ensi.Model.AnalyseBilan;

public interface BilanService {

	public AnalyseBilan getAnalyseBilan(int annee);
	public List<AnalyseBilan> getAllAnalyseBilan();
	public void insertIntoAnalyseBilan(int annee);
}
