package com.mooen.testStage4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mooen.testStage4.domain.PageAlexa;

@Mapper
public interface PageAlexaDao {
	@Select("select * from page_alexa order by counter")
	public List<PageAlexa> getPageAlexa();
}
