package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dataobject.BossInfo;
import com.demo.dataobject.CustomerInfo;

public interface CustomerRepository extends JpaRepository<CustomerInfo, Integer>{
	
}
