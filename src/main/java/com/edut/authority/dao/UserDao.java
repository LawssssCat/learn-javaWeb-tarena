package com.edut.authority.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edut.authority.Authority;
import com.edut.authority.User;

public class UserDao {
	private static AuthorityDao authorityDao  ;
	private static Map<String, User> users ; 
	
	
	static {
		authorityDao = new AuthorityDao() ; 
		users = new HashMap<String, User>() ;
		
		//插入用户1
		String username1 = "AAA" ; 
		List<Authority> authorities1 = new ArrayList<>()  ;
		authorities1.add(authorityDao.getAuthority("Article-1")) ; 
		authorities1.add(authorityDao.getAuthority("Article-2")) ; 
		users.put(username1, new User(username1, authorities1)) ;
		
		//插入用户2
		String username2 = "BBB" ; 
		List<Authority> authorities2 = new ArrayList<>()  ;
		authorities2.add(authorityDao.getAuthority("Article-3")) ; 
		authorities2.add(authorityDao.getAuthority("Article-4")) ; 
		users.put(username2, new User(username2, authorities2)) ; 
	}
	
	public User getUser(String username) {
		return users.get(username) ; 
	}
	
	public void updateAuthority(String username , List<Authority> authorities) {
		users.get(username).setAuthorities(authorities); 
	}
	
}
