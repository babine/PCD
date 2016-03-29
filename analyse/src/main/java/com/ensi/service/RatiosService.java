package com.ensi.service;
import java.util.List;
import com.ensi.Model.AnalyseRatios;

public interface RatiosService {
			
	public List<AnalyseRatios> getAllAnalyseRatios();
		public void insertIntoAnalyseRatios(int annee);
}
