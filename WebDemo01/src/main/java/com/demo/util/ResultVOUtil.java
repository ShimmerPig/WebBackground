package com.demo.util;

import com.demo.VO.ResultVO;

//否将返回结果封装成一个工具类
public class ResultVOUtil {

	//传入的object是要放入data中的内容
	public static ResultVO success(Object object) {
		ResultVO resultVO=new ResultVO();
		resultVO.setData(object);
		resultVO.setCode(0);
		resultVO.setMsg("成功");
		return resultVO;
	}
	
	public static ResultVO success() {
		return success(null);
	}
	
	public static ResultVO error(Integer code,String msg) {
		ResultVO resultVO=new ResultVO();
		resultVO.setCode(code);
		resultVO.setMsg(msg);
		return resultVO;
	}
}
