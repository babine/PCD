package com.ensi.Dao;

import java.util.List;

import com.ensi.Model.PassifCourant;

public interface Data4Dao {
	public void savePassifCourant(PassifCourant pc);
	public void updatePassifCourant(PassifCourant pc);
	public void deletePassifCourant(PassifCourant pc);

	public List<PassifCourant> getAllPassifCourant();
	PassifCourant findByAnnee(int annee);
}
