package com.ensi.Dao;

import java.util.List;

import com.ensi.Model.AnalyseEffetDeLevier;

public interface EffetDeLevierDao {
	public List<AnalyseEffetDeLevier> getAllAnalyseEffetDeLevier();
	public void insertIntoAnalyseEffetDeLevier(int annee);
}
