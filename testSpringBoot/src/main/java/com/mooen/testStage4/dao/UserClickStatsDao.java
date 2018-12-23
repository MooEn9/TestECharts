package com.mooen.testStage4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mooen.testStage4.domain.UserClickStats;

@Mapper
public interface UserClickStatsDao {
	@Select("select * from user_click_stats")
	public List<UserClickStats> getUserClickStats();
}
