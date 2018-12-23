package com.mooen.testStage4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooen.testStage4.dao.OtherPageTypeDao;
import com.mooen.testStage4.domain.OtherPageType;
@Service
public class OtherPageTypeService {
	@Autowired
	OtherPageTypeDao otherPageTypeDao;
	
	public List<OtherPageType> getOtherPageType() {
		return otherPageTypeDao.getOtherPageType();
	}
}
