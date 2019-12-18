package cn.edut.jdbc.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.edut.jdbc.YongHeDao;
import cn.edut.pojo.Empolyee;

@Repository("YongHeDao")
public class YongHeDaoImp implements YongHeDao {
	
	@Autowired
	private  JdbcTemplate jdbcTemplate  ;   
	
	@Override
	public List<Empolyee> getAllEmployee() {
		String sql = "Select id , name , job , salary from emp ";
		RowMapper<Empolyee> rowMapper = new BeanPropertyRowMapper<>(Empolyee.class)  ;
		return  jdbcTemplate.query(sql , rowMapper ) ; 
	}

}
