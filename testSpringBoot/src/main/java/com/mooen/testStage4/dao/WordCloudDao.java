package com.mooen.testStage4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mooen.testStage4.domain.WordCloud;

@Mapper
public interface WordCloudDao {
	@Select("SELECT * FROM key_word ORDER BY val desc limit #{x}")
	public List<WordCloud> getWordCloudDao(@Param("x")int x);
}
