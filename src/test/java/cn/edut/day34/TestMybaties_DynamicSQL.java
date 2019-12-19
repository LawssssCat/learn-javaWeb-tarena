package cn.edut.day34;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.RowSet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.edut.pojo.Empolyee;

public class TestMybaties_DynamicSQL {
	private SqlSession session = null ; 
	{
		try {
			InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(config);
			session = build.openSession() ; 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	/*=====================  动态SQL元素  ===================*/
	/*
	 * if元素
	 * where元素
	 * set元素
	 * foreach元素 : 可以对参数数组或集合进行遍历，拼接出所需要的SQL片段
	 *    update emp set salary = salary+2000
	 *    where id in(1,2,3,4,5,6) 
	 */
	/*
	 * 练习：根据员工的薪资查询员工信息
	 * 薪资： 	[3000]	-	[   ]
	 * 		[min]	-	[max] 
	 */
	@Test
	public void testFindInRange() {
		int min = 0 ; 
		int max = 99999999; 
		
		String statement = "EmpMapper.findInRange";
		Map<String ,Integer> parameter  = new HashMap<>() ; 
		parameter.put("min", min) ; 
		parameter.put("max", max) ; 
		List<Empolyee> list = session.selectList(statement , parameter);
		for (Empolyee e : list) {
			System.out.println(e);
		}
	}
	
	
	/**
	 * 练习：根据参数传递与否，修改员工信息
	 */
	@Test
	public void testUpdateByArgs() {
		String statement = "EmpMapper.updateByArgs";
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("id", "1") ; 
		parameter.put("name", "null") ;
		parameter.put("job", null) ;
		parameter.put("salary", 1) ;
		int rows = session.update(statement, parameter) ;
		session.commit();
		
		System.out.println("影响行数："+rows);
		testFindInRange();
		
	}
	
	/**
	 * 练习14: 批量更新emp表中员工薪资
	 * foreach元素：可以对参数数组或集合进行遍历，拼接出所需要的SQL片段
	 *    update emp set salary = salary+2000
	 *    where id in(1,2,3,4,5,6) 
	 */
	@Test
	public void testUpdateBatch() {
		Integer[] ids = {1,3,5,7,9,11} ; 
		String statement = "EmpMapper.updateBatch";
		
		Map<String , Object> map = new HashMap<>() ; 
		map.put("a", ids) ;
		
		int rows = session.update(statement, map);
		session.commit();
		System.out.println("影响行数："+rows);
		testFindInRange() ;
	}
	
	/**
	 * 批量删除
	 */
	@Test
	public void testDeleteBatch() {
		Integer[] ids = {1,3,5,7,9,11} ; 
 
		String statement = "EmpMapper.deleteBatch" ;
		int rows = session.delete(statement  , Arrays.asList(ids) ) ;
		session.commit();
		System.out.println("影响行数："+rows);
		testFindInRange() ;
		
	}
	
	
	public void testInsertBatch() {
		Map<String, Object> map = new HashMap<>() ;
		//TODO
		//map.put(key, value)
	}
	
	public void testUpdateBatchWihtArgs() {
		//TODO
	}
	
	
	
	@Test
	public void testConn() {
		System.out.println("session : "+session);
	}
	
}
