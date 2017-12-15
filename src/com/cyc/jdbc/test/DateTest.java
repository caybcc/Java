package com.cyc.jdbc.test;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class DateTest {

	@Test
	public void test() throws SQLException {
//		System.out.println(Create("John", new Date(), 556.0f));
		Date d = Retrive(5);
		System.out.println(d);
	}
	
	public int Create(String name, Date birthday, float money) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		int affectRows = 0;
		try {
			//2. 获取连接
			conn = JdbcUtils.getConnection();
			
			//3. 创建语句
			sql = "INSERT INTO user(name, birthday, money) VALUES(?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDate(2, new java.sql.Date(birthday.getTime()));//把java.util.Date转化为java.sql.Date
			ps.setFloat(3, money);
			
			//4. 执行语句
			
			affectRows = ps.executeUpdate();//不能加入sql参数因为这样会直接调用statement.executeUpdate()直接把带通配符的语句送到数据库
			
		} finally {
			//6.释放连接
			JdbcUtils.releaseResource(rs, ps, conn);
		}
		
		return affectRows;
	}
	
	public Date Retrive(int id) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Date birthday = null;
		
		try {
			//2. 获取连接
			conn = JdbcUtils.getConnection();
			
			//3. 创建语句
			stmt = conn.createStatement();
			
			//4. 执行语句
			rs = stmt.executeQuery("SELECT id, name, birthday, money FROM user WHERE id = " + id);
			
			//5. 获取数据
			
			while(rs.next()) {
				birthday = rs.getDate("birthday");//java.sql.date -> 父类java.util.date可行--java.sql.date的输出通过toString方法做了日期格式化的工作
//				birthday = new Date(rs.getDate("birthday").getTime());//也行
			}
			
		} finally {
			//6.释放连接
			JdbcUtils.releaseResource(rs, stmt, conn);
		}
		
		return birthday;
	}

}
