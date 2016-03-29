package com.ensi.service;
import java.util.List;

import com.ensi.Model.DonneesEffetDeLevier;

public interface Data5Service {


	public void saveEffetDeLevier(DonneesEffetDeLevier del);
	public void updateEffetDeLevier(DonneesEffetDeLevier del);
	public void deleteEffetDeLevier(DonneesEffetDeLevier del);

	public List<DonneesEffetDeLevier> getAllDonneesEffetDeLevier();
		

}
