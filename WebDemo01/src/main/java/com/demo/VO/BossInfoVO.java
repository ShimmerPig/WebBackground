package com.demo.VO;

import com.fasterxml.jackson.annotation.JsonProperty;

//返回给前端的boss对象
public class BossInfoVO {
	// 商店名称
	@JsonProperty("name")
	private String bossShopName;
	// 提交后显示这是第几次提交（“xx商家,第x次提交成功”）
	@JsonProperty("times")
	private Integer bossTimes;
	
	public BossInfoVO(String bossShopName, Integer bossTimes) {
		super();
		this.bossShopName = bossShopName;
		this.bossTimes = bossTimes;
	}

	public BossInfoVO() {
		super();
	}

	public String getBossShopName() {
		return bossShopName;
	}

	public void setBossShopName(String bossShopName) {
		this.bossShopName = bossShopName;
	}

	public Integer getBossTimes() {
		return bossTimes;
	}

	public void setBossTimes(Integer bossTimes) {
		this.bossTimes = bossTimes;
	}



}
