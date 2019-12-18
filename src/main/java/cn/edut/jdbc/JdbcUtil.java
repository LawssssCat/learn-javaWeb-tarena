package cn.edut.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {

	/**
	 * 获得连接器
	 */
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/jt_db?characterEncoding=gbk",
				"root",
				"root"
				);
		return conn;
	}

	/**
	 * 关闭传入的连接
	 */
	public static <T extends AutoCloseable> void close(T ... ts) {
		for (T t : ts) {
			if(t!=null) {
				try {
					t.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					t = null; 
				}
			}
		}
		
	}
	
}

