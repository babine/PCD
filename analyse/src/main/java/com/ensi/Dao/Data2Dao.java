package com.ensi.Dao;

import java.util.List;

import com.ensi.Model.ActifCourant;

public interface Data2Dao {
	public void saveActifCourant(ActifCourant ac);
	public void updateActifCourant(ActifCourant ac);
	public void deleteActifCourant(ActifCourant ac);

	public List<ActifCourant> getAllActifCourant();
	ActifCourant findByAnnee(int annee);
}
