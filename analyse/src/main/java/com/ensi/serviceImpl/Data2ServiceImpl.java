package com.ensi.serviceImpl;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensi.Dao.Data2Dao;
import com.ensi.Model.ActifCourant;
import com.ensi.service.Data2Service;

@Service
@Transactional
public class Data2ServiceImpl implements Data2Service,Serializable {

		private static final long serialVersionUID = 1L;

		@Autowired
		private Data2Dao data2Dao;
		
		public void saveActifCourant(ActifCourant ac) {
			data2Dao.saveActifCourant(ac);	
			
		}
		public List<ActifCourant> getAllActifCourant(){
			
			return 
			data2Dao.getAllActifCourant();
			
		}
		@Override
		public void updateActifCourant(ActifCourant ac) {
			// TODO Auto-generated method stub
			data2Dao.updateActifCourant(ac);
		}
		@Override
		public void deleteActifCourant(ActifCourant ac) {
			// TODO Auto-generated method stub
			data2Dao.deleteActifCourant(ac);
		}
	}
