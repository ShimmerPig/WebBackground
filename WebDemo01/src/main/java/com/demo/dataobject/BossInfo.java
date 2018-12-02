package com.demo.dataobject;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class BossInfo {
	//id是从1开始的
	@Id
	@GeneratedValue
	private Integer bossId;
	private String bossShopName;
	private String bossPwd;
	private Integer bossTimes;
	private String bossFileName;
	private Integer bossIsDone;
	private Date createTime;
    private Date lastEditTime;
	public Integer getBossId() {
		return bossId;
	}
	public void setBossId(Integer bossId) {
		this.bossId = bossId;
	}
	public String getBossShopName() {
		return bossShopName;
	}
	public void setBossShopName(String bossShopName) {
		this.bossShopName = bossShopName;
	}
	public String getBossPwd() {
		return bossPwd;
	}
	public void setBossPwd(String bossPwd) {
		this.bossPwd = bossPwd;
	}
	public Integer getBossTimes() {
		return bossTimes;
	}
	public void setBossTimes(Integer bossTimes) {
		this.bossTimes = bossTimes;
	}
	public String getBossFileName() {
		return bossFileName;
	}
	public void setBossFileName(String bossFileName) {
		this.bossFileName = bossFileName;
	}
	public Integer getBossIsDone() {
		return bossIsDone;
	}
	public void setBossIsDone(Integer bossIsDone) {
		this.bossIsDone = bossIsDone;
	}
	public Date getCreateTime() {
        return createTime;
	}
	public void setCreateTime(Date createTime) {
	        this.createTime = createTime;
	}
	public Date getLastEditTime() {
	        return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
	        this.lastEditTime = lastEditTime;
	}
	public BossInfo(Integer bossId, String bossShopName, String bossPwd, Integer bossTimes, String bossFileName,
			Integer bossIsDone) {
		super();
		this.bossId = bossId;
		this.bossShopName = bossShopName;
		this.bossPwd = bossPwd;
		this.bossTimes = bossTimes;
		this.bossFileName = bossFileName;
		this.bossIsDone = bossIsDone;
	}
	public BossInfo(String bossShopName, String bossPwd, Integer bossTimes, String bossFileName, Integer bossIsDone) {
		super();
		this.bossShopName = bossShopName;
		this.bossPwd = bossPwd;
		this.bossTimes = bossTimes;
		this.bossFileName = bossFileName;
		this.bossIsDone = bossIsDone;
	}
	public BossInfo() {
		super();
	}
	@Override
	public String toString() {
		return "BossInfo [bossId=" + bossId + ", bossShopName=" + bossShopName + ", bossPwd=" + bossPwd + ", bossTimes="
				+ bossTimes + ", bossFileName=" + bossFileName + ", bossIsDone=" + bossIsDone + "]";
	}

	
}
