package cn.edut.day34;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.edut.day34.dao.MyMapper;
import cn.edut.pojo.Empolyee;


/**
 * 测试 mybatis 的 mapper 接口开发
 * 1. 创建一个  mapper 接口(EmpMapper)，接口的(包名+类名)全路径
 * 		和mapper.xml文件的namespace的值要相同。 
 * 2. SQL 标签的id值和对应的接口方法名相同。
 * 3. SQL 标签的参数类型和对应的接口方法的参数类型也要相同。
 * 4. SQL 标签的返回值类型(查询)和接口方法的返回值类型要相同
 * 		(或和接口方法的返回值类型的泛型相同)
 */
public class TestMybaties_InterfaceMapper {
	private SqlSession session = null ; 
	{
		
		try {
			InputStream in = Resources.getResourceAsStream("mybatis-config-mymapper.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in ); 
			session = factory.openSession(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 练习：查询所有员工信息(mapper接口开发)
	 */
	@Test
	public void testFindAll() {
		/* 获取EmpMapper 接口的子类实例
		 * 将 EmpMapper接口的字节码对象传递给getMapper方法，
		 * 框架底层可以根据接口的字节码对象，为接口提供一个匿名实现类
		 * 最后，根据实现类创建一个实例，并返回实例。
		 */
		MyMapper myMapper = session.getMapper(MyMapper.class);
		List<Empolyee> es = myMapper.findAll();
		for (Empolyee e : es) {
			System.out.println(e);
		}
	}
	
	/**
	 * 练习：新增员工信息(mapper接口开发) 韩少云 CEO 10000
	 * 1. 到 mapper.xml中编写要执行的sql
	 * 2. 到mapper接口中编写对应的接口方法
	 * 3. 编写测试方法
	 */
	@Test
	public void testInsert() {
		MyMapper mapper = session.getMapper(MyMapper.class);
		mapper.insert(new Empolyee(null , "aaa" , "jjj" , 1111.1));
		session.commit();
	}
	
	/**
	 * 练习 修改员工信息(mapper接口开发) 马云云 教师 2000
	 */
	@Test
	public void testUpdate()  {
		MyMapper mapper = session.getMapper(MyMapper.class);
		mapper.update(new Empolyee(10 , "null" , "ddd" , 123131412.1));
		session.commit();
		
	}
}
