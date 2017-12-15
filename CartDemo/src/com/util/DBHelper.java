package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接MySQL数据库工具类
 * @author Administrator
 * @date 2017年08月01日
 */
public class DBHelper {
	//数据库驱动程序
	private static final String driver = "com.mysql.jdbc.Driver";
	//连接数据库的URL地址
	private static final String url = "jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8";
	
	//数据库用户名和密码
	private static final String username = "caybcc";
	private static final String password = "123456";
	
	
	private static Connection conn = null;
	
	//静态代码块负责加载驱动
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//单例模式返回数据库连接对象
	
	public static Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		
		return conn;
	}
	
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/*public static void main(String[] args) {
		//测试数据库是否连接正常
		Connection conn = DBHelper.getConnection();
		if (conn != null) {
			System.out.println("数据库连接正常!");
		} else {
			System.out.println("数据库连接失败！");
		}
	}*/
}
