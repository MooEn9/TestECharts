package com.mooen.testStage4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mooen.testStage4.domain.OtherInnerPageType;

@Mapper
public interface OtherInnerPageTypeDao {
	@Select("select * from other_innert_type")
	public List<OtherInnerPageType> getOtherInnerPageType();
}
