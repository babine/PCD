package com.ensi.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensi.Dao.EffetDeLevierDao;
import com.ensi.Model.AnalyseEffetDeLevier;
import com.ensi.service.EffetDeLevierService;

@Service
@Transactional
public class EffetDeLevierServiceImpl implements EffetDeLevierService,Serializable{
	
	
	private static final long serialVersionUID=1L;

	@Autowired
	EffetDeLevierDao effetDeLevierDao;
	public List<AnalyseEffetDeLevier> getAllAnalyseEffetDeLevier(){
		return effetDeLevierDao.getAllAnalyseEffetDeLevier();
	}
	public void insertIntoAnalyseEffetDeLevier(int annee){
		effetDeLevierDao.insertIntoAnalyseEffetDeLevier(annee);
	}
}
