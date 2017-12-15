package com.cyc.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Base {

	@Test
	public void test() throws Exception {
//		testJdbc();
//		template1();
		template2();
	}
	
	@Test
	public void testPools() throws SQLException {
		for (int i = 0; i < 11; i++) {
//			Connection conn = JdbcUtilsPool.getConnection();
			Connection conn = JdbcUtilsDbcp.getConnection();
			System.out.println(conn.getClass().getName());
//			JdbcUtilsPool.releaseResource(null, null, conn);
		}
	}
	
	public static void template() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		Connection conn = null;
		String url = "jdbc:mysql:///jdbc";
		String user = "root";
		String password = "123456";
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//1. 注册驱动
			Class.forName(driver);
			//2. 获取连接
			conn = DriverManager.getConnection(url, user, password);
			
			//3. 创建语句
			stmt = conn.createStatement();
			
			//4. 执行语句
			rs = stmt.executeQuery("SELECT * FROM user");
			
			//5. 获取数据
			
			while(rs.next()) {
				System.out.println(rs.getObject("id") + "\t" + rs.getObject("name") + "\t" + rs.getObject("birthday") + "\t" + rs.getObject("money"));
			}
			
		} finally {
			//6.释放连接
			try {
				if (rs != null) {
					rs.close();
				}
			} finally {
				// TODO: handle finally clause
				try {
					if (stmt != null) {
						stmt.close();
					}
				} finally {
					// TODO: handle finally clause
					conn.close();
				}
			}
		}
	}
	public static void template1() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//2. 获取连接
			conn = JdbcUtils.getConnection();
			
			//3. 创建语句
			stmt = conn.createStatement();
			
			//4. 执行语句
			rs = stmt.executeQuery("SELECT * FROM user");
			
			//5. 获取数据
			
			while(rs.next()) {
				System.out.println(rs.getObject("id") + "\t" + rs.getObject("name") + "\t" + rs.getObject("birthday") + "\t" + rs.getObject("money"));
			}
			
		} finally {
			//6.释放连接
			JdbcUtils.releaseResource(rs, stmt, conn);
		}
	}
	public static void template2() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		JdbcUtilsSingle jus = JdbcUtilsSingle.getInstance();
		try {
			//2. 获取连接
			conn = jus.getConnection();
			
			//3. 创建语句
			stmt = conn.createStatement();
			
			//4. 执行语句
			rs = stmt.executeQuery("SELECT * FROM user");
			
			//5. 获取数据
			
			while(rs.next()) {
				System.out.println(rs.getObject("id") + "\t" + rs.getObject("name") + "\t" + rs.getObject("birthday") + "\t" + rs.getObject("money"));
			}
			
		} finally {
			//6.释放连接
			jus.releaseResource(rs, stmt, conn);
		}
	}
	
	public static void testJdbc() throws SQLException {
		//1. 注册驱动(可以注册多个---底层操作会把一个个驱动放入一个Vector drivers当中)
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());//可读性强--但是其实注册了两次（静态代码块一次，这里new一次）---驱动包一旦被删掉就会发生编译失败--以下两种方式则不会
//		Class.forName("com.mysql.jdbc.Driver");--载入Driver字节码文件(到虚拟机),此刻会执行静态代码块(里面会有注册操作可查看Driver类)--建议使用这种方式--不会对具体的类(驱动jar包)产生依赖，不产生垃圾
		//压缩包mysql-connector-java-5.1.45.tar\mysql-connector-java-5.1.45\src\com\mysql\jdbc下找到Driver.java
//		System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");可以用冒号分格多个驱动
		//2. 获取连接（DriverManager挨个去访问Vector Drivers 中的元素看是否可以连接数据库）
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "123456");
		
		if (conn != null) {
			System.out.println("数据库连接成功!");
		} else {
			System.out.println("数据库连接失败!");
			return ;
		}
		
		//3. 创建语句（Statement传递SQL语句和接受数据）
		Statement stmt = conn.createStatement();
		
		//4. 执行语句
		ResultSet rs = stmt.executeQuery("SELECT * FROM user");
		
		//5. 获取数据
		while(rs.next()) {
			System.out.println(rs.getObject("id") + "\t" + rs.getObject("name") + "\t" + rs.getObject("birthday") + "\t" + rs.getObject("money"));
		}
		
		//6. 关闭连接
		rs.close();
		stmt.close();
		conn.close();
	}

}
