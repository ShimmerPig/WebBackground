package com.demo;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.dataobject.BossInfo;
import com.demo.service.impl.BossInfoServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BossInfoServiceImplTest {

	@Autowired
	private BossInfoServiceImpl bossInfoService;
	
	@Test
	public void findOne() {
		BossInfo bossInfo=bossInfoService.findOne(1);
		assertNotNull(bossInfo);
	}
	
	@Test
	public void findAll() {
		List<BossInfo>bossInfolist=bossInfoService.findAll();
		assertNotEquals(0,bossInfolist.size());
	}
	
	@Test
	public void save() {
		BossInfo bossInfo=new BossInfo("fuck u","126",1, "1.1", 0);
		BossInfo result=bossInfoService.save(bossInfo);
		assertNotNull(result);
	}
	
}
