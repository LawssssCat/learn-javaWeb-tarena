package cn.edut.controller;

import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edut.User;

@Controller
@RequestMapping("/HelloController")
public class HelloController {

	
	//加路径，
	@RequestMapping("/hello")
	public String testHello() {
		System.out.println("===========  testHello  ===============");
		System.out.println("===========  testHello  ===============");
		System.out.println("===========  testHello  ===============");
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
	
	/**
	 * 2.2. 包装类型参数绑定：
	 * /testParam3?name=赵云&age=22&addr=河北
	 * 如果请求参数过多，如何快熟的接收请求参数的值？
	 */
	@RequestMapping("/testParam3")
	public String testParam3(User u1) {
		System.out.println("===========  testParam3  ===============");
		System.out.println(u1.toString());
		return "home" ;
	}
	
	/**
	 * 2.2 包装类型参数绑定
	 * 	/testParam4?username=关羽&pwd=123&like=骑马&like=耍大刀
	 * 如何使用包装类型接收上面请求参数的值？
	 */ 
	@RequestMapping("/testParam4") 
	public String testParam4(User u) {
		System.out.println("===========  testParam4  ===============");
		System.out.println(u);
		return "home" ; 
	}
	
	/**
	 * 3. 日期类型的参数绑定
	 *  /testParam5?d1=2019-12-23 11:11:11
	 */
	@RequestMapping("/testParam5")
	public String testParam5(Date d1) {
		System.out.println("===========  testParam5  ===============");
		System.out.println(d1.toLocaleString());
		return "home" ; 
	}
	
	/**
	 * 测试请求转发(forward)
	 */
	@RequestMapping("/testForward")
	public String testForward() {
		System.out.println("===========  testForward  ===============");
		System.out.println("===========  testForward  ===============");
		System.out.println("===========  testForward  ===============");
		System.out.println("测试请求转发(forward) ... ");
		return "forward:hello" ; 
	}
	
	/**
	 * 测试请求重定向(redirect)
	 */
	@RequestMapping("/testRedirect")
	public String testRedirect() {
		System.out.println("===========  testRedirect  ===============");
		System.out.println("===========  testRedirect  ===============");
		System.out.println("===========  testRedirect  ===============");
		System.out.println("测试请求重定向(redirect) ... ");
		return "redirect:hello" ; 
	}
	
}
