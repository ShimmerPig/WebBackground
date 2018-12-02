package com.demo.dataobject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class CustomerInfo {
	@Id
	@GeneratedValue
	private Integer customerId;
	private String customerName;
	private String customerPwd;
	private Integer customerTimes;
	private String customerFileName;
	private Date createTime;
	private Date lastEditTime;
	public CustomerInfo(String customerName, String customerPwd, Integer customerTimes, String customerFileName) {
		super();
		this.customerName = customerName;
		this.customerPwd = customerPwd;
		this.customerTimes = customerTimes;
		this.customerFileName = customerFileName;
	}
	public CustomerInfo(Integer customerId, String customerName, String customerPwd, Integer customerTimes,
			String customerFileName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPwd = customerPwd;
		this.customerTimes = customerTimes;
		this.customerFileName = customerFileName;
	}
	public CustomerInfo() {
		super();
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPwd() {
		return customerPwd;
	}
	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}
	public Integer getCustomerTimes() {
		return customerTimes;
	}
	public void setCustomerTimes(Integer customerTimes) {
		this.customerTimes = customerTimes;
	}
	public String getCustomerFileName() {
		return customerFileName;
	}
	public void setCustomerFileName(String customerFileName) {
		this.customerFileName = customerFileName;
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
	
	
}
