package com.ensi.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensi.Dao.BilanDao;
import com.ensi.Model.AnalyseBilan;
import com.ensi.service.BilanService;
@Service
@Transactional
public class BilanServiceImpl implements BilanService,Serializable{
	
	private static final long serialVersionUID=1L;
	@Autowired
	BilanDao bilanDao;

	public AnalyseBilan getAnalyseBilan(int annee){
		return
		bilanDao.getAnalyseBilan(annee);
	}
	public List<AnalyseBilan> getAllAnalyseBilan(){
		return
		bilanDao.getAllAnalyseBilan();
	}
	
	public void insertIntoAnalyseBilan(int  annee) {
		
		bilanDao.insertIntoAnalyseBilan(annee);
	}

}
