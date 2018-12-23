package com.mooen.testStage4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooen.testStage4.dao.PageAlexaDao;
import com.mooen.testStage4.domain.PageAlexa;

@Service
public class PageAlexaService {
	@Autowired
	PageAlexaDao pageAlexaDao;
	
	public List<PageAlexa> getPageAlexa(){
		return pageAlexaDao.getPageAlexa();
	}
}
