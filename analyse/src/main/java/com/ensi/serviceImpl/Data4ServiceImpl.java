package com.ensi.serviceImpl;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensi.Dao.Data4Dao;
import com.ensi.Model.PassifCourant;
import com.ensi.service.Data4Service;

@Service
@Transactional
public class Data4ServiceImpl implements Data4Service,Serializable {

		private static final long serialVersionUID = 1L;

		@Autowired
		private Data4Dao data4Dao;
		
		public void savePassifCourant(PassifCourant ac) {
			data4Dao.savePassifCourant(ac);	
			
		}
		public List<PassifCourant> getAllPassifCourant(){
			
			return 
			data4Dao.getAllPassifCourant();
			
		}
		@Override
		public void updatePassifCourant(PassifCourant pc) {
			// TODO Auto-generated method stub
			data4Dao.updatePassifCourant(pc);
		}
		@Override
		public void deletePassifCourant(PassifCourant ac) {
			// TODO Auto-generated method stub
			data4Dao.deletePassifCourant(ac);
		}
	}