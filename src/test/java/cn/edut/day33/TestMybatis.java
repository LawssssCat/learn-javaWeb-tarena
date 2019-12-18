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

/**
 * MyBatis快速入门程序
 */
public class TestMybatis {

	/**
	 * 练习1：查询所有员工信息 List<Employee>
	 * @throws IOException 
	 */
	@Test
	public void testFindAll() throws IOException {
		//1. 读取 Mybatis 的核心配置文件(mybatis-config.xml)
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml") ;
		
		//2. 通过配置获取一个SqlSessionFactory对象
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in) ; 
		
		//3. 通过工厂获取一个SqlSession对象
		
		SqlSession session = ssf.openSession(); 
		
		//4. 执行SQL语句(XxxMapper.xml), 返回处理后的结果
		List<Empolyee> list = session.selectList("EmpMapper.findAll");
		
		//5. 输出结果
		for (Empolyee e : list) {
			System.out.println(e);
		}
		
		
	}
}
