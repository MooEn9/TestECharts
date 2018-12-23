package com.mooen.testStage4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooen.testStage4.dao.PageTypeDao;
import com.mooen.testStage4.domain.PageType;

@Service
public class PageTypeService {
	@Autowired
	PageTypeDao pageTypeDao;
	
	public List<PageType> getPageType() {
		return pageTypeDao.getPageType();
	}
}
