package com.cyc.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 2017-08-09
 * @author cyc
 */
public class JdbcUtilsSingle {
	
	private String url = "jdbc:mysql:///jdbc";
	private String user = "root";
	private String password = "123456";
	
	
	private JdbcUtilsSingle() {
		// TODO Auto-generated constructor stub
	}
	
//	private static JdbcUtilsSingle single = new JdbcUtilsSingle();
	private static JdbcUtilsSingle single = null;
	
	//这样子调用会每次加锁（同步方法）
	/*public static synchronized JdbcUtilsSingle getInstance() {
//		return single;
		if (!(single instanceof JdbcUtilsSingle)) {
			single = new JdbcUtilsSingle();
		}
		
		return single;
	}*/
	
	//保证不会每次调用都加锁以下代码要在jdk1.5以上没有问题
	public static JdbcUtilsSingle getInstance() {
//		return single;
		if (single == null) {//以下只会第一次加锁因为，single只会第一次为空
			synchronized (JdbcUtils.class) {
				if (single == null) {//为了保证只实例化一次
					single = new JdbcUtilsSingle();
				}
			}
		}
		
		return single;
	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	public void releaseResource(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				// TODO: handle finally clause
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
