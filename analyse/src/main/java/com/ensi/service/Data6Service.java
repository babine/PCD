package com.ensi.service;

import java.util.List;

import com.ensi.Model.DonneesDecision;

public interface Data6Service {
	public void saveDonneesDecision(DonneesDecision dd);


	public List<DonneesDecision> getAllDonneesDecision();
}
