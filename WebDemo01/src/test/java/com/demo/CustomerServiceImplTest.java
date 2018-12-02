package com.demo;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.dataobject.CustomerInfo;
import com.demo.service.impl.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {

	@Autowired
	private CustomerServiceImpl service;
	@Test
	public void save() {
		CustomerInfo customer=new CustomerInfo("Mr.Pig", "123", 1, "1.1");
		CustomerInfo result=service.save(customer);
		assertNotNull(result);
	}
	@Test
	public void findOne() {
		CustomerInfo customer=service.findOne(7);
		assertNotNull(customer);
	}
	
	@Test
	public void findAll() {
		List<CustomerInfo>customerInfoList=service.findAll();
		assertNotEquals(0, customerInfoList.size());
	}
	

}
