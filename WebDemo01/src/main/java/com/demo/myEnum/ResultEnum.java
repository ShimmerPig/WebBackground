package com.demo.myEnum;

//存放错误时的枚举类型
//返回给前端使用的
public enum ResultEnum {
	BOSS_NOT_EXIST(2,"商家不存在"),
	CUSTOMER_NOT_EXIST(3,"顾客不存在"),
	;
	private Integer code;
	private String message;
	public Integer getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
