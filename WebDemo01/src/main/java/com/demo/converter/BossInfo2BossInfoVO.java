package com.demo.converter;

import com.demo.VO.BossInfoVO;
import com.demo.dataobject.BossInfo;

//将数据库层的BossInfo对象转换成前端使用的VO对象
public class BossInfo2BossInfoVO {
	public static BossInfoVO converter(BossInfo boss) {
		BossInfoVO vo=new BossInfoVO();
		vo.setBossShopName(boss.getBossShopName());
		vo.setBossTimes(boss.getBossTimes());
		return vo;
	}
}
