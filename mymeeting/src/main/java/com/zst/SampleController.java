package com.zst;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@EnableAutoConfiguration
@MapperScan("com.zst.mapper")   //����Ŀ�ж�Ӧ��mapper��·�����ؽ���
@ComponentScan("com.zst.controller")
@ComponentScan("com.zst.service")
//@SpringBootApplication
public class SampleController {
	@RequestMapping("/mymaven/home")
	@ResponseBody
	String home(){
		return "hello world! I'm Spring boot. I'm looking forward to the future!";
	}
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(SampleController.class, args);
	}
}
