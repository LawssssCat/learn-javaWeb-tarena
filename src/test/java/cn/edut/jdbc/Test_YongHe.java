package cn.edut.jdbc;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.edut.pojo.Empolyee;

public class Test_YongHe {
	private ClassPathXmlApplicationContext ctx = null ; 
	private JdbcTemplate jdbcTemplate = null ;
	private YongHeDao yongHeDao = null ; 
	{
		ctx = new ClassPathXmlApplicationContext(
				"yonghe.xml") ; 
		jdbcTemplate  = ctx.getBean(JdbcTemplate.class) ;
		yongHeDao = ctx.getBean(YongHeDao.class) ; 
	}
	
	
	
	@Test
	public void testGetAllEmployee() {
		List<Empolyee> allEmployee = yongHeDao.getAllEmployee();
		for (Empolyee e : allEmployee) {
			System.out.println(e.toString());
		}
	}
	
	
	@Test
	public void testGetConnection() throws SQLException {
		DataSource ds = ctx.getBean(DataSource.class);
		Connection connection = ds.getConnection();
		System.out.println(connection);
	}
}
