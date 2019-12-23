package cn.edut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/springmvc")
public class HelloController {

	
	//加路径，
	@RequestMapping("/hello")
	public String testHello() {
		System.out.println("Hello Springmvc...");
		return "home" ; 
	}
}
