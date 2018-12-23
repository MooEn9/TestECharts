package com.mooen.testStage4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import com.mooen.testStage4.domain.NoTargetUser;

@Mapper
public interface NoTargetUserDao {
	
	@Select("select * from notarget_user")
	public List<NoTargetUser> getNoTargetUser();

}
