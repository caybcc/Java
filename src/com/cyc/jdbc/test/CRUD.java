package com.cyc.jdbc.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class CRUD {

	public CRUD() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void test() throws SQLException { 
//		Retrive();
//		Update();
//		Delete();
//		Retrive();
//		System.out.println(Create());
		/*ResultSet rs = Retrive1();//应为连接关闭操作先执行进而resultset也关闭了导致数据无法获取
		
		while(rs.next()) {
			System.out.println(rs.getObject("id") + "\t" 
					+ rs.getObject("name") + 
					"\t" + rs.getObject("birthday") + "\t" + 
					rs.getObject("money"));
		}*/
		
		
		
	}
	
	public int Create() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int affectRows = 0;
		try {
			//2. 获取连接
			conn = JdbcUtils.getConnection();
			
			//3. 创建语句
			stmt = conn.createStatement();
			
			//4. 执行语句
			String sql = "INSERT INTO user(name, birthday, money) VALUES('Maria', '1999-07-27', 456)";
			affectRows = stmt.executeUpdate(sql);
			
		} finally {
			//6.释放连接
			JdbcUtils.releaseResource(rs, stmt, conn);
		}
		
		return affectRows;
	}
	
	public void Retrive() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//2. 获取连接
			conn = JdbcUtils.getConnection();
			
			//3. 创建语句
			stmt = conn.createStatement();
			
			//4. 执行语句
			rs = stmt.executeQuery("SELECT id, name, birthday, money FROM user");
			
			//5. 获取数据
			
			while(rs.next()) {
				System.out.println(rs.getObject("id") + "\t" 
						+ rs.getObject("name") + 
						"\t" + rs.getObject("birthday") + "\t" + 
						rs.getObject("money"));
			}
			
		} finally {
			//6.释放连接
			JdbcUtils.releaseResource(rs, stmt, conn);
		}
	}
	
	public int Update() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int affectRows = 0;
		try {
			//2. 获取连接
			conn = JdbcUtils.getConnection();
			
			//3. 创建语句
			stmt = conn.createStatement();
			
			//4. 执行语句
			String sql = "UPDATE user SET name = 'Nick', birthday = '1998-07-27', money = 456 WHERE id = 1";
			affectRows = stmt.executeUpdate(sql);
			
		} finally {
			//6.释放连接
			JdbcUtils.releaseResource(rs, stmt, conn);
		}
		
		return affectRows;
	}
	
	public int Delete() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int affectRows = 0;
		try {
			//2. 获取连接
			conn = JdbcUtils.getConnection();
			
			//3. 创建语句
			stmt = conn.createStatement();
			
			//4. 执行语句
			String sql = "DELETE FROM user WHERE id = 5";
			affectRows = stmt.executeUpdate(sql);
			
		} finally {
			//6.释放连接
			JdbcUtils.releaseResource(rs, stmt, conn);
		}
		
		return affectRows;
	}
	
	//ERROR!
	/*public ResultSet Retrive1() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//2. 获取连接
			conn = JdbcUtils.getConnection();
			
			//3. 创建语句
			stmt = conn.createStatement();
			
			//4. 执行语句
			rs = stmt.executeQuery("SELECT id, name, birthday, money FROM user");
			
			//5. 获取数据
			
			while(rs.next()) {
				System.out.println(rs.getObject("id") + "\t" 
						+ rs.getObject("name") + 
						"\t" + rs.getObject("birthday") + "\t" + 
						rs.getObject("money"));
			}
			
			return rs;
			
		} finally {
			//6.释放连接
			JdbcUtils.releaseResource(null, stmt, conn);
		}
	}
	*/
}
