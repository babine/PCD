package com.ensi.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensi.Dao.RatiosDao;
import com.ensi.Model.AnalyseRatios;
import com.ensi.service.RatiosService;

@Service
@Transactional
public class RatiosServiceImpl implements RatiosService,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	RatiosDao ratiosDao;
	public List<AnalyseRatios> getAllAnalyseRatios(){
		
		return 
		ratiosDao.getAllAnalyseRatios();
		
	}
	
	public void insertIntoAnalyseRatios(int annee){
		ratiosDao.insertIntoAnalyseRatios(annee);
	}

	
}
