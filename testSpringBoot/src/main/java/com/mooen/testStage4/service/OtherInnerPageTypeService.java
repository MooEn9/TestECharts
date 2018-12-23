package com.mooen.testStage4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooen.testStage4.dao.OtherInnerPageTypeDao;
import com.mooen.testStage4.domain.OtherInnerPageType;

@Service
public class OtherInnerPageTypeService {
	@Autowired
	OtherInnerPageTypeDao otherInnerPageTypeDao;
	
	public List<OtherInnerPageType> getOtherInnerPageType(){
		return otherInnerPageTypeDao.getOtherInnerPageType();
	}
}
