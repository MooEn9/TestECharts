package com.mooen.testStage4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mooen.testStage4.domain.OtherPageType;

@Mapper
public interface OtherPageTypeDao {
	@Select("Select * from other_page_type") 
	public List<OtherPageType> getOtherPageType();
}
