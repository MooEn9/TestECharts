package com.mooen.testStage4.domain;

import java.math.BigInteger;

public class MonthCount {
	private String page_type;
	private BigInteger count_num;
	private String yearmonth;
	private Integer id;
	public String getPage_type() {
		return page_type;
	}
	public void setPage_type(String page_type) {
		this.page_type = page_type;
	}
	public BigInteger getCount_num() {
		return count_num;
	}
	public void setCount_num(BigInteger count_num) {
		this.count_num = count_num;
	}
	public String getYearmonth() {
		return yearmonth;
	}
	public void setYearmonth(String yearmonth) {
		this.yearmonth = yearmonth;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
