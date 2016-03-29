package com.ensi.service;
import java.util.List;
import com.ensi.Model.ActifNonCourant;

public interface DataService {

	public void saveActifNonCourant(ActifNonCourant anc);
	public void updateActifNonCourant(ActifNonCourant anc);
	public void deleteActifNonCourant(ActifNonCourant anc);

	public List<ActifNonCourant> getAllActifNonCourant();
	}

