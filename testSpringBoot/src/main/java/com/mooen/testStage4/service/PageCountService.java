package com.mooen.testStage4.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooen.testStage4.dao.PageCountDao;
import com.mooen.testStage4.domain.PageCount;

@Service
public class PageCountService {

	@Autowired
	PageCountDao pageCountDao;
	public Map<String,String> getPageCount(){
		Map<String,String> result = new HashMap<String, String>();
		List<PageCount> pageCounts = pageCountDao.getPageCount();
		for (PageCount pageCount : pageCounts) {
			result.put(pageCount.getData_type(), pageCount.getData_val());
		}
		return result;
	}
}
