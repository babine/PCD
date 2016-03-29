package com.ensi.serviceImpl;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensi.Dao.DataDao;
import com.ensi.Model.ActifNonCourant;
import com.ensi.service.DataService;

@Service
@Transactional
public class DataServiceImpl implements DataService,Serializable {

		private static final long serialVersionUID = 1L;

		@Autowired
		private DataDao dataDao;
		
		public void saveActifNonCourant(ActifNonCourant anc) {
			dataDao.saveActifNonCourant(anc);	
			
		}
		public List<ActifNonCourant> getAllActifNonCourant(){
			
			return 
			dataDao.getAllActifNonCourant();
			
		}
		@Override
		public void updateActifNonCourant(ActifNonCourant anc) {
			// TODO Auto-generated method stub
			dataDao.updateActifNonCourant(anc);
		}
		@Override
		public void deleteActifNonCourant(ActifNonCourant anc) {
			// TODO Auto-generated method stub
			dataDao.deleteActifNonCourant(anc);
		}
	}

