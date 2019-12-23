package cn.edut.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/HelloController")
public class HelloController {

	
	//加路径，
	@RequestMapping("/hello")
	public String testHello() {
		System.out.println("Hello Springmvc...");
		return "home" ; 
	}
	
	
	
	/**
	 * 2. 简单类型参数绑定：
	 * /testParam2?username=刘备&pwd=123&like=足球&like=篮球
	 * 如何获取请求中的 username ， pwd 和 like 的值？
	 */
	@RequestMapping("/testParam2")
	public String testParam2(String username , String pwd , String[] like) {
		System.out.println("-----  testParam2  ---------");
		System.out.println("username:"+username) ; 
		System.out.println("pwd:"+pwd) ; 
		System.out.println("like:"+Arrays.toString(like));
		return "home" ; 
	}
	
	
}
