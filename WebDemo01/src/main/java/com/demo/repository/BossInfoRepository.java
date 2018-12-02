package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dataobject.BossInfo;

//boss对象的dao层--用来对数据库进行操作
public interface BossInfoRepository extends JpaRepository<BossInfo, Integer>{
	
}
