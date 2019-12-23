package com.edut.authority;

public class Authority {
	private String name ; 
	private String url ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Authority [name=" + name + ", url=" + url + "]";
	}
	public Authority(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	public Authority() {
		super();
	} 
	
	
}
