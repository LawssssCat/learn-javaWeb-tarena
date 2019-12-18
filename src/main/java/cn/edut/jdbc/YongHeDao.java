package cn.edut.jdbc;

import java.util.List;

import cn.edut.pojo.Empolyee;

public interface YongHeDao {
	/**
	 * 查询所有员工 
	 */
	public List<Empolyee> getAllEmployee()  ; 
}
