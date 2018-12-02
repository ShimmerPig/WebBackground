package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.dataobject.BossInfo;
import com.demo.repository.BossInfoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BossInfoRepositoryTest {
	@Autowired
	private BossInfoRepository repository;
	
	@Test
	public void findOneTest() {
		BossInfo bossInfo=repository.findById(1).get();
		System.out.println(bossInfo.toString());
	}
	
	@Test
	public void saveTest() {
		BossInfo bossInfo=new BossInfo();
		bossInfo.setBossId(1);
		bossInfo.setBossFileName("1.1");
		bossInfo.setBossIsDone(0);
		bossInfo.setBossPwd("123");
		bossInfo.setBossShopName("PigPig Shop");
		bossInfo.setBossTimes(1);
		repository.save(bossInfo);
	}
}
