package com.edut.authority.dao;

import java.util.HashMap;
import java.util.Map;

import com.edut.authority.Authority;

public class AuthorityDao {
	private  static Map<String, Authority> authorities ; 
	static {
		authorities = new HashMap<String, Authority>() ; 
		authorities.put("Article-1", new Authority("Article-1" , "/article-1.jsp"))	 ; 	
		authorities.put("Article-2", new Authority("Article-2" , "/article-2.jsp"))	 ; 	
		authorities.put("Article-3", new Authority("Article-3" , "/article-3.jsp"))	 ; 	
		authorities.put("Article-4", new Authority("Article-4" , "/article-4.jsp"))	 ; 	
	}
	public  Map<String, Authority> getAllAuthority() {
		return authorities;
	}
	public Authority getAuthority(String authorityName) {
		return authorities.get(authorityName) ; 
	}
}
