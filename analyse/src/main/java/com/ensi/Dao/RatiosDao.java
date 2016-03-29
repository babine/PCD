package com.ensi.Dao;

import java.util.List;

import com.ensi.Model.AnalyseRatios;


public interface RatiosDao {
	public List<AnalyseRatios> getAllAnalyseRatios();
	public void insertIntoAnalyseRatios(int annee);
}
