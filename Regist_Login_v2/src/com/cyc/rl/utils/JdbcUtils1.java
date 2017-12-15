package com.cyc.rl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils1 {
	
	private static Properties props = null;
	
	static {
		//加载配置文件只执行一次
		InputStream in = JdbcUtils1.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		
		props = new Properties();
		
		try {
			
			props.load(in);
			Class.forName(props.getProperty("driverClassName"));
		} catch (Exception e) {
			
			throw new RuntimeException(e.getMessage(), e);
			
		}
	}
	
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		
		Connection conn = null;

		conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
		
		return conn;
	}
	
	public static void close(PreparedStatement psmt, Connection conn) {
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e.getMessage(), e);
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage(), e);
					}
				}
			}
		}
	}
	
	
}
