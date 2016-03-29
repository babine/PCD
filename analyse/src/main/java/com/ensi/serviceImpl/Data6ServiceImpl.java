package com.ensi.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensi.Dao.Data6Dao;
import com.ensi.Model.DonneesDecision;
import com.ensi.service.Data6Service;
@Service
@Transactional
public class Data6ServiceImpl implements Data6Service,Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private Data6Dao data6dao;
	
	
	public void saveDonneesDecision(DonneesDecision dd) {

		data6dao.saveDonneesDecision(dd);
	}


	@Override
	public List<DonneesDecision> getAllDonneesDecision() {
		return data6dao.getAllDonneesDecision();
	}
	
}
