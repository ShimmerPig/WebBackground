package com.demo.converter;

import com.demo.VO.CustomerVO;
import com.demo.dataobject.CustomerInfo;

public class CustomerInfo2CustomerVO {
	public static CustomerVO converter(CustomerInfo customer) {
		CustomerVO vo=new CustomerVO();
		vo.setCustomerName(customer.getCustomerName());
		return vo;
	}
}
