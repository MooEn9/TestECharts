package com.mooen.testStage4.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooen.testStage4.dao.MonthCountDao;

@Service
public class MonthCountService {
	@Autowired
	MonthCountDao monthCountDao;
	
	public List<MonthCount> getMonthCount(){
		return monthCountDao.getMonthCount();
	}
}
