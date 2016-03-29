package com.ensi.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensi.Dao.DecisionDao;
import com.ensi.Model.AnalyseDecisionIvestissement;
import com.ensi.service.DecisionService;

@Service
@Transactional
public class DecisionServiceImpl implements DecisionService,Serializable {

	private static final long serialVersionUID=1L;

	@Autowired
	DecisionDao decisionDao;
	public List<AnalyseDecisionIvestissement> getAllAnalyseDecisionIvestissement(){
		return decisionDao.getAllAnalyseDecisionIvestissement();
	}
	public void insertIntoAnalyseDecisionIvestissement(int annee){
		decisionDao.insertIntoAnalyseDecisionIvestissement(annee);
	}
}
