package com.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.demo.VO.BossInfoVO;
import com.demo.VO.CustomerVO;
import com.demo.VO.ResultVO;
import com.demo.converter.BossInfo2BossInfoVO;
import com.demo.converter.CustomerInfo2CustomerVO;
import com.demo.dataobject.BossInfo;
import com.demo.dataobject.CustomerInfo;
import com.demo.exception.WebException;
import com.demo.myEnum.ResultEnum;
import com.demo.service.BossInfoService;
import com.demo.service.CustomerService;
import com.demo.service.impl.CustomerServiceImpl;
import com.demo.util.ResultVOUtil;

//这里的初步想法是创建存放商家信息的数据库
//将商家上传的修改建议以商家在数据库中的id，修改的
//次数的形式作为提交的修改文件的文件名保存在数据库中
//这里的商家指的是整个超市的boss


//数据库初步设计：
//boss part：
//boss's id
//boss's name
//boss's password
//'s times 【上传的次数,方便命名】
//boss's uploadFileName 【命名形式：boss'id+times】
//上传的修改文件的name【默认会覆盖，但是可以通过上传的文件名得到之前的修改文件】
//isDone 开发者是否已进行更改
//create time 创建日期
//last change time 最后修改时间

//boss的数据库设计
//CREATE TABLE boss_info(
//boss_id int not null auto_increment,
//boss_shop_name varchar(64) not null,
//boss_pwd varchar(64) not null,
//boss_times int not null,
//boss_file_name varchar(64) not null,
//boss_is_done int not null,
//create_time timestamp NOT NULL DEFAULT current_timestamp,
//last_edit_time timestamp ,
//PRIMARY KEY(boss_id )
//)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



//customer part:
//id
//name
//password
//times 【上传的次数，方便命名】
//反馈的file name 【命名形式：customer'id+times】
//create time 创建日期
//last change time 最后修改时间
//customer的数据库设计
//CREATE TABLE customer_info(
//customer_id int not null auto_increment,
//customer_name varchar(64) not null,
//customer_pwd varchar(64) not null,
//customer_times int not null,
//customer_file_name varchar(64) not null,
//create_time timestamp NOT NULL DEFAULT current_timestamp,
//last_edit_time timestamp ,
//PRIMARY KEY(customer_id )
//)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
//



//处理文件上传的controller
//包括商家的修改意见，以及顾客的反馈意见
@Controller
@RequestMapping("/upload")
public class FileUploadController {
	//上传后的文件需要保存到商家的数据库中,引入service对象
	@Autowired
	private BossInfoService bossInfoService;
	@Autowired
	private CustomerService customerService;
	
	private static final Logger log=LoggerFactory.getLogger(FileUploadController.class);
	//服务器上默认的保存文件的路径
	//考虑到boss不多，所以这里没有对其细分文件夹
	private static final String bossFilePath="C:\\Users\\lenovo\\Desktop\\IndoorAppFile\\boss\\";
	private static final String customerFilePath="C:\\Users\\lenovo\\Desktop\\IndoorAppFile\\customer\\";
	
	//TODO 假装是从前端传递过来的id
	private Integer id=7;
	
	
	//TODO 直接请求“/upload“链接需要判断一下name是否为null
	//为null说明未登录直接跳转到登录页面--最好是前端负责跳转
	//这里因为调试 直接返回上传的index页面
	@GetMapping
	public String index() {
		return "index";
	}
	
	//处理boss的修改文件
	//上传后不管是否成功都返回一个ResultVO对象
	//TODO 这里实际上还要传入一个boss的id，才能在数据库中查找
	//测试阶段不要求传递id【因为这里的前端不知道怎么改动= =】
	@PostMapping("/bossUpload")
	@ResponseBody
	public ResultVO boosUpload(/*@RequestParam("id")Integer id,*/@RequestParam("file")MultipartFile file)throws IOException{
		log.info("[文件类型]-[{}]",file.getContentType());
        log.info("[文件名称]-[{}]",file.getOriginalFilename());
        log.info("[文件大小]-[{}]",file.getSize());
        log.info("toString-[{}]",file.toString());
        log.info("[boss's id]-[{}]",id);
        //通过传入的id在数据库中查找这个boss是否存在；
        //查找存在后，拼接出其上传后的fileName；
        //对其信息进行save操作
        //将其上传文件保存到服务器端
        //通过id从数据库中查询boss
        //保存成功时返回的结果对象
        BossInfo result;
        //保存成功时真正返回给前端的VO对象
        BossInfoVO resultVO;
        //在服务器端要保存的文件名
        String fileName="";
        try {
        	BossInfo boss=bossInfoService.findOne(id);
        	boss.setBossTimes(boss.getBossTimes()+1);
        	//找到了该boss,拼接出其fileName=id+times
        	fileName=""+boss.getBossId()+"."+boss.getBossTimes();
        	boss.setBossFileName(fileName);
        	//默认未完成
        	boss.setBossIsDone(0);
        	log.info("[文件名]-[{}]",fileName);
        	//对信息进行save
        	result=bossInfoService.save(boss);
        	//抓换成返回给前端的VO对象
        	resultVO=BossInfo2BossInfoVO.converter(boss);
        //查询不到对应的boss
        }catch(NoSuchElementException e) {
        	e.printStackTrace();
        	return ResultVOUtil.error(ResultEnum.BOSS_NOT_EXIST.getCode(),
        			ResultEnum.BOSS_NOT_EXIST.getMessage());
        }
        //数据库操作完毕，进行文件读取保存操作
        //将文件写入指定目录中，根据具体开发环境配置
        file.transferTo(new File(bossFilePath+fileName));
        return ResultVOUtil.success(resultVO);
	}
	
	//处理顾客上传的反馈
	//TODO 这里需前端传一个customer的id
	@PostMapping("/customerUpload")
	@ResponseBody
	public ResultVO customerUpload(/*@RequestParam("id")Integer id,*/@RequestParam("file")MultipartFile file)throws IOException{
		log.info("[文件类型]-[{}]",file.getContentType());
        log.info("[文件名称]-[{}]",file.getOriginalFilename());
        log.info("[文件大小]-[{}]",file.getSize());
        log.info("toString-[{}]",file.toString());
        log.info("[customer's id]-[{}]",id);
        
        //保存成功时返回的结果对象
        CustomerInfo result;
        //保存成功时返回给前端的VO对象
        CustomerVO resultVO;
        //在服务器端要保存的文件名
        String fileName="";
        try {
        	CustomerInfo customer=customerService.findOne(id);
        	customer.setCustomerTimes(customer.getCustomerTimes()+1);
        	fileName=""+customer.getCustomerId()+"."+customer.getCustomerTimes();
        	customer.setCustomerFileName(fileName);
        	log.info("[文件名]-[{}]",fileName);
        	result=customerService.save(customer);
        	resultVO=CustomerInfo2CustomerVO.converter(result);
        }catch(NoSuchElementException e) {
        	e.printStackTrace();
        	return ResultVOUtil.error(ResultEnum.CUSTOMER_NOT_EXIST.getCode(), 
        			ResultEnum.CUSTOMER_NOT_EXIST.getMessage());
        }
        file.transferTo(new File(customerFilePath+fileName));
        return ResultVOUtil.success(resultVO);
	}
	
	
}
