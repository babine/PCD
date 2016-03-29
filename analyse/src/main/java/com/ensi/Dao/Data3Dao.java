package com.ensi.Dao;

import java.util.List;

import com.ensi.Model.PassifNonCourant;

public interface Data3Dao {
	public void savePassifNonCourant(PassifNonCourant pnc);
	public void updatePassifNonCourant(PassifNonCourant pnc);
	public void deletePassifNonCourant(PassifNonCourant pnc);

	public List<PassifNonCourant> getAllPassifNonCourant();
	PassifNonCourant findByAnnee(int annee);
}
