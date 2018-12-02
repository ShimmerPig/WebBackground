package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dataobject.CustomerInfo;
import com.demo.repository.CustomerRepository;
import com.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public CustomerInfo findOne(Integer customerId) {
		return repository.findById(customerId).get();
	}

	@Override
	public List<CustomerInfo> findAll() {
		return repository.findAll();
	}

	@Override
	public CustomerInfo save(CustomerInfo customerInfo) {
		return repository.save(customerInfo);
	}

}
