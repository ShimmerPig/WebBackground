package com.demo.VO;

import com.fasterxml.jackson.annotation.JsonProperty;

//返回给前端使用的VO对象
public class CustomerVO {
	//顾客的name
	//前端显示“xx反馈提交成功~”
	@JsonProperty("name")
	private String customerName;

	public CustomerVO(String customerName) {
		super();
		this.customerName = customerName;
	}

	public CustomerVO() {
		super();
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
