package com.edut.authority;

import java.util.List;

public class User {
	private String name ; 
	private List<Authority> authorities ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", authorities=" + authorities + "]";
	}
	public User(String name, List<Authority> authorities) {
		super();
		this.name = name;
		this.authorities = authorities;
	}
	public User() {
		super();
	} 
	
	
}
