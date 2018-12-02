package com.demo.service;

import java.util.List;

import com.demo.dataobject.CustomerInfo;

//customer层的service
public interface CustomerService {
	CustomerInfo findOne(Integer customerId);
	List<CustomerInfo>findAll();
	CustomerInfo save(CustomerInfo customerInfo);
}
