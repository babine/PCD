package com.ensi.Dao;

import java.util.List;

import com.ensi.Model.ActifNonCourant;

public interface DataDao {
	public void saveActifNonCourant(ActifNonCourant anc);
	public void updateActifNonCourant(ActifNonCourant anc);
	public void deleteActifNonCourant(ActifNonCourant anc);

	public List<ActifNonCourant> getAllActifNonCourant();
	ActifNonCourant findByAnnee(int annee);
}
