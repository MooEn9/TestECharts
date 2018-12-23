package com.mooen.testStage4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mooen.testStage4.domain.PageCount;

@Mapper
public interface PageCountDao {
	@Select("select * from page_count")
	public List<PageCount> getPageCount();
}
