package com.mooen.testStage4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooen.testStage4.dao.WordCloudDao;
import com.mooen.testStage4.domain.WordCloud;

@Service
public class WordCloudService {
	
	@Autowired
	WordCloudDao wordCloudDao;
	
	public List<WordCloud> getWordCloudDao(int x){
		return wordCloudDao.getWordCloudDao(x);
	}
}
