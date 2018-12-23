package com.mooen.testStage4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooen.testStage4.dao.ConsultDao;
import com.mooen.testStage4.domain.Consult;

@Service
public class ConsultService {
	@Autowired
	ConsultDao consultDao;
	
	public List<Consult> getConsult(){
		return consultDao.getConsult();
	}
}
