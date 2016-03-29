package com.ensi.service;
import java.util.List;
import com.ensi.Model.ActifCourant;

public interface Data2Service {

	public void saveActifCourant(ActifCourant ac);
	public void updateActifCourant(ActifCourant ac);
	public void deleteActifCourant(ActifCourant ac);

	public List<ActifCourant> getAllActifCourant();
	}
