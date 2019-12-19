package cn.edut.day33;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.edut.pojo.Empolyee;

public class TestMybatis2 {
	private static  SqlSession session  = null ; 
	static {
		try {
			InputStream in  = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
			session = build.openSession() ; 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 练习2：新增员工信息：刘德华 歌手 888
	 */
	@Test
	public void testInsert() {
		
		//执行sql语句，返回执行结果
		
		int rows = session.update("EmpMapper.insert") ;
		
		//提交事务（默认不提交）
		session.commit();
		
		System.out.println("影响行数："+ rows);
	}
	
	/**
	 * 练习3：修改员工信息，将刘德华的 job改为 演员 salary 改为88888 
	 */
	@Test
	public void testUpdate() {
		int rows = session.update("EmpMapper.update" ) ; 
		
		session.commit();
		System.out.println("影响行数："+rows);
	}
	
	
	/**
	 * 练习5：查询name 为 刘德华 的员工信息
	 */
	@Test
	public void testFindById() {
		
		String name = "刘德华";
		List<Empolyee> list = session.selectList("EmpMapper.findByName", name) ; 
		for (Empolyee e : list) {
			System.out.println(e);
		}
	}
	/**
	 * 练习4：删除name为 刘德华 的记录
	 */
	@Test
	public void testDelete() {
		int rows = session.update("EmpMapper.delete");
		session.commit();
		System.out.println("影响行数："+rows);
	}
	
	
	/**
	 * Employee 封装 值
	 * 练习：新增员工信息：张飞 Java开发工程师 15000
	 */
	@Test
	public void testInsert2() {
		Object parameter = new Empolyee(null , "张飞" , "Java开发工程师" , 15000.0);
		int rows  = session.insert("EmpMapper.insert2", parameter ) ; 
		session.commit() ;
		System.out.println("影响行数："+rows);
	}
	
	/**
	 * Map 封装 值
	 * 练习：修改员工信息：张飞  架构师 25000
	 */
	@Test
	public void testUpdate2() {
		//将要传递的参数封装到 map 集合中  
		Map<String , String> parameter = new HashMap<>() ; 
		parameter.put("name", "张飞");
		parameter.put("job" , "架构师")  ; 
		parameter.put("salary", "25000") ;
		
		int rows = session.insert("EmpMapper.update2" , parameter ) ; 
		
		session.commit() ;
		System.out.println("影响行数："+rows);
		
		
	}
	
	/**
	 * 练习：删除 emp 表中指定 name 的员工信息
	 */
	@Test
	public void testDelete2() {
		Map<String , String> parameter = new HashMap<>() ; 
		
		parameter.put("name" , "张飞");
		
		int rows  = session.delete("EmpMapper.delete2", parameter) ;
		session.commit(); 
		System.out.println("影响行数："+rows);
	}
	
	
	/**
	 * 测试：获取session
	 */
	@Test
	public void testGetSession() {
		System.out.println(session);
	}
	
	
	
	/* =================== ${}占位符  ====================== */
	/*
	 * #{} 占位符是为值进行占位，大部分情况下都是使用#{}占位符
	 * #{} 占位符低沉就是 jdbc 中的问号(?)占位符
	 * 
	 * ${} 占位符是为SQL片段进行占位，通过${}占位符传递过去的参数
	 * 会直接拼接到SQL语句中，因此可能会**出现SQL注入攻击**等问题
	 */
	
	/* 练习9:动态指定要查询的列
	 * []编号 []姓名 []职业 []薪水 
	 */
	@Test
	public void testFindSomeCols() {
		String statement = "EmpMapper.findSomeCols" ;
		Map<String, String> map = new HashMap<>();
		String cols = "  name , job " ; 
		map.put("cols", cols); 
		List<Object> list = session.selectList(statement , map);
		
		for (Object o : list) {
			System.out.println(o);
		}
	}
	
	
	
	
	/* =================== 模糊查询  ======================== */
	/*
	 * 练习10：根据name模糊查询emp表
	 * 使用 ${} 占位符进行占位
	 * select * from emp where name like '%#{name}%';
	 */
	@Test
	public void testFindByNameLike() {
		
		String statement =  "EmpMapper.findByNameLike1";
		Map<String,String> parameter = new HashMap<>();
		parameter.put("name", "刘") ; 
		List<Empolyee> list = session.selectList(statement, parameter);
		for (Empolyee e : list) {
			System.out.println(e);
		}
		
	}
	/*
	 * 练习11：根据name模糊查询emp表
	 * 使用 #{} 占位符进行占位
	 * select * from emp where name like %'刘'%;
	 */
	@Test
	public void testFindByNameLike2() {
		String statement = "EmpMapper.findByNameLike2";
		Map<String , String > parameter = new HashMap<>() ;
		
		parameter.put("name", "%刘%");
		
		List<Empolyee> list = session.selectList(statement, parameter);
		for (Empolyee empolyee : list) {
			System.out.println(empolyee);
		}
	}
	
}
