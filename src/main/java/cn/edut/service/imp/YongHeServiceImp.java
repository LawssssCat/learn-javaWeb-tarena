package cn.edut.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.edut.jdbc.YongHeDao;
import cn.edut.pojo.Empolyee;
import cn.edut.service.YongHeService;

@Service("YongHeService")
public class YongHeServiceImp implements YongHeService{

	@Autowired
	private YongHeDao yongHeDao  ;  
	
	@Override
	public List<Empolyee> getAllEmployee() {
		return yongHeDao.getAllEmployee();
	}
	
}
