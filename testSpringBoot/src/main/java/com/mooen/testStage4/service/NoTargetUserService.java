package com.mooen.testStage4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooen.testStage4.dao.NoTargetUserDao;
import com.mooen.testStage4.domain.NoTargetUser;

@Service
public class NoTargetUserService {
	@Autowired
	NoTargetUserDao noTargetUserDao;
	
	public List<NoTargetUser> getNoTargetUser(){
		return noTargetUserDao.getNoTargetUser();
	}
	
}
