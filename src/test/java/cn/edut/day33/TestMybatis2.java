package cn.edut.day33;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
	
	
	
	
	@Test
	public void testGetSession() {
		System.out.println(session);
	}
	
	
	
}
