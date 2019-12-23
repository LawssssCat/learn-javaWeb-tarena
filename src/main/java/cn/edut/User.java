package cn.edut;

import java.util.Arrays;

public class User {
	private String name ; 
	private String addr ; 
	private Integer age ;
	
	private String username ; 
	private String pwd ; 
	private String[] like  ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String[] getLike() {
		return like;
	}
	public void setLike(String[] like) {
		this.like = like;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", addr=" + addr + ", age=" + age + ", username=" + username + ", pwd=" + pwd
				+ ", like=" + Arrays.toString(like) + "]";
	} 
	
	
	
}
