package com.ensi.Dao;

import java.util.List;

import com.ensi.Model.DonneesDecision;

public interface Data6Dao {
	public void saveDonneesDecision(DonneesDecision dd);


	public List<DonneesDecision> getAllDonneesDecision();
}
