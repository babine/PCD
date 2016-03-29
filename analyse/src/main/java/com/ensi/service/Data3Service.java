package com.ensi.service;
import java.util.List;
import com.ensi.Model.PassifNonCourant;

public interface Data3Service {

	public void savePassifNonCourant(PassifNonCourant anc);
	public void updatePassifNonCourant(PassifNonCourant anc);
	public void deletePassifNonCourant(PassifNonCourant anc);

	public List<PassifNonCourant> getAllPassifNonCourant();
	}
