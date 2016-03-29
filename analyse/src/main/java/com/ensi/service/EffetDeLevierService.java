package com.ensi.service;

import java.util.List;

import com.ensi.Model.AnalyseEffetDeLevier;

public interface EffetDeLevierService {

	public List<AnalyseEffetDeLevier> getAllAnalyseEffetDeLevier();
	public void insertIntoAnalyseEffetDeLevier(int annee);
}
