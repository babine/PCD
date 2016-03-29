package com.ensi.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensi.Dao.Data5Dao;
import com.ensi.Model.DonneesEffetDeLevier;
import com.ensi.service.Data5Service;



@Service
@Transactional
public class Data5ServiceImpl implements Data5Service,Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private Data5Dao data5dao;
	
	
	public void saveEffetDeLevier(DonneesEffetDeLevier del) {

		data5dao.saveEffetDeLevier(del);
	}


	public  List<DonneesEffetDeLevier> getAllDonneesEffetDeLevier(){
		return
		data5dao.getAllDonneesEffetDeLevier();
	}

	@Override
	public void updateEffetDeLevier(DonneesEffetDeLevier del) {
		data5dao.updateEffetDeLevier(del);
	}

	@Override
	public void deleteEffetDeLevier(DonneesEffetDeLevier del) {
		data5dao.deleteEffetDeLevier(del);
	}


}
