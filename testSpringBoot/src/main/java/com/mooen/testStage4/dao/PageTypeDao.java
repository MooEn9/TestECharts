package com.mooen.testStage4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mooen.testStage4.domain.PageType;

@Mapper
public interface PageTypeDao {
	@Select("Select * from Page_Type") 
	public List<PageType> getPageType();
}
