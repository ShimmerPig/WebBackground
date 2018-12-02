package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dataobject.BossInfo;
import com.demo.repository.BossInfoRepository;
import com.demo.service.BossInfoService;

//service层的实现类
@Service
public class BossInfoServiceImpl implements BossInfoService{

	//引入dao层
	@Autowired
	private BossInfoRepository repository;
	
	@Override
	public BossInfo findOne(Integer bossId) {
		return repository.findById(bossId).get();
	}

	@Override
	public List<BossInfo> findAll() {
		return repository.findAll();
	}

	@Override
	public BossInfo save(BossInfo bossInfo) {
		return repository.save(bossInfo);
	}
	
}
