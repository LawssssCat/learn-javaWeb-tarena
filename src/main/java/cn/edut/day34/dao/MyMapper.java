package cn.edut.day34.dao;

import java.util.List;

import cn.edut.pojo.Empolyee;

//全路径 = 包名.类名
public interface MyMapper {
	
	/* 1. 查询所有员工信息 */
	public  List<Empolyee>  findAll() ;
	
	public void insert(Empolyee employee);
	
	public void update(Empolyee employee); 
}
