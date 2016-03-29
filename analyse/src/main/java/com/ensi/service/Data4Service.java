package com.ensi.service;
import java.util.List;
import com.ensi.Model.PassifCourant;

public interface Data4Service {

	public void savePassifCourant(PassifCourant anc);
	public void updatePassifCourant(PassifCourant anc);
	public void deletePassifCourant(PassifCourant anc);

	public List<PassifCourant> getAllPassifCourant();
	}
