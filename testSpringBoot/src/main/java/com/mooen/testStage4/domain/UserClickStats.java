package com.mooen.testStage4.domain;

import java.math.BigInteger;

public class UserClickStats {
	private String page_type;
	private BigInteger count;
	private Long user_percentage;
	private Long record_percentage;
	private Integer id;
	public String getPage_type() {
		return page_type;
	}
	public void setPage_type(String page_type) {
		this.page_type = page_type;
	}
	public BigInteger getCount() {
		return count;
	}
	public void setCount(BigInteger count) {
		this.count = count;
	}
	public Long getUser_percentage() {
		return user_percentage;
	}
	public void setUser_percentage(Long user_percentage) {
		this.user_percentage = user_percentage;
	}
	public Long getRecord_percentage() {
		return record_percentage;
	}
	public void setRecord_percentage(Long record_percentage) {
		this.record_percentage = record_percentage;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
