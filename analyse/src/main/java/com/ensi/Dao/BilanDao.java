package com.ensi.Dao;

import java.util.List;

import com.ensi.Model.AnalyseBilan;

public interface BilanDao {

	public AnalyseBilan getAnalyseBilan(int annee);
	public List<AnalyseBilan> getAllAnalyseBilan();

	public void insertIntoAnalyseBilan(int annee);
}
