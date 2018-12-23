package com.mooen.testStage4.domain;

import java.math.BigInteger;

public class OtherPageType {
	private Integer id;
	private BigInteger count_num;
	private String page_type;
	private Long weights;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigInteger getCount_num() {
		return count_num;
	}
	public void setCount_num(BigInteger count_num) {
		this.count_num = count_num;
	}
	public String getPage_type() {
		return page_type;
	}
	public void setPage_type(String page_type) {
		this.page_type = page_type;
	}
	public Long getWeights() {
		return weights;
	}
	public void setWeights(Long weights) {
		this.weights = weights;
	}

}
