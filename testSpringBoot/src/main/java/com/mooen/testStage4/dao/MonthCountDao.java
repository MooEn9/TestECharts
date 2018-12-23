package com.mooen.testStage4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mooen.testStage4.domain.MonthCount;

@Mapper
public interface MonthCountDao {
	@Select("select * from month_count")
	public List<MonthCount> getMonthCount();
}
