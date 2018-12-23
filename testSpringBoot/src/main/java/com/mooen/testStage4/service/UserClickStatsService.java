package com.mooen.testStage4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooen.testStage4.dao.UserClickStatsDao;
import com.mooen.testStage4.domain.UserClickStats;

@Service
public class UserClickStatsService {
	@Autowired
	UserClickStatsDao userClickStatsDao;
	
	public List<UserClickStats> getUserClickStats(){
		return userClickStatsDao.getUserClickStats();
	}
}
