package com.cyc.rl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class JdbcUtils {
	
	private static Properties props = null;
	
	static {
		//���������ļ�ִֻ��һ��
		InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		
		props = new Properties();
		
		try {
			
			props.load(in);
			
		} catch (Exception e) {
			
			throw new RuntimeException(e.getMessage(), e);
			
		}
	}
	
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		
		Connection conn = null;

		conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
		
		return conn;
	}
	
	@Test
	public void test() throws ClassNotFoundException, IOException, SQLException {
		if (getConnection() != null) {
			System.out.println("���ݿ����ӳɹ���");
		}
	}
	
}
