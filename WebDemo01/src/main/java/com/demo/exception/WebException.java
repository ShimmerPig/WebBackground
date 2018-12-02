package com.demo.exception;

import com.demo.myEnum.ResultEnum;

//异常类
public class WebException extends RuntimeException{
	private Integer code;
	public WebException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code=resultEnum.getCode();
	}
	public WebException(Integer code,String message) {
		super(message);
		this.code=code;
	}
}
