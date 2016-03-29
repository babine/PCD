package com.ensi.Dao;

import java.util.List;

import com.ensi.Model.DonneesEffetDeLevier;

public interface Data5Dao {
	public void saveEffetDeLevier(DonneesEffetDeLevier del);
	public void updateEffetDeLevier(DonneesEffetDeLevier del);
	public void deleteEffetDeLevier(DonneesEffetDeLevier del);

	public List<DonneesEffetDeLevier> getAllDonneesEffetDeLevier();
}
