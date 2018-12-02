package com.demo.service;

import java.util.List;

import com.demo.dataobject.BossInfo;

//Boss的service层
public interface BossInfoService {
	BossInfo findOne(Integer bossId);
	List<BossInfo>findAll();
	BossInfo save(BossInfo bossInfo);
}
