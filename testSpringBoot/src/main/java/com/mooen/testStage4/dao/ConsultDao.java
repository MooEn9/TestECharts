package com.mooen.testStage4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mooen.testStage4.domain.Consult;

@Mapper
public interface ConsultDao {
	@Select("select * from consult")
	public List<Consult> getConsult();
}
