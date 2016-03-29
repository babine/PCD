package com.ensi.serviceImpl;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensi.Dao.Data3Dao;
import com.ensi.Model.PassifNonCourant;
import com.ensi.service.Data3Service;

@Service
@Transactional
public class Data3ServiceImpl implements Data3Service,Serializable {

		private static final long serialVersionUID = 1L;

		@Autowired
		private Data3Dao data3Dao;
		
		public void savePassifNonCourant(PassifNonCourant pnc) {
			data3Dao.savePassifNonCourant(pnc);	
			
		}
		public List<PassifNonCourant> getAllPassifNonCourant(){
			
			return 
			data3Dao.getAllPassifNonCourant();
			
		}
		@Override
		public void updatePassifNonCourant(PassifNonCourant pnc) {
			// TODO Auto-generated method stub
			data3Dao.updatePassifNonCourant(pnc);
		}
		@Override
		public void deletePassifNonCourant(PassifNonCourant pnc) {
			// TODO Auto-generated method stub
			data3Dao.deletePassifNonCourant(pnc);
		}
	}
