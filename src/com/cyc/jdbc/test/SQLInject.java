package com.cyc.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
// SQL注入---交给数据库驱动解决问题
public class SQLInject {

	public SQLInject() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void test() throws SQLException {
		
		Retrive("Maria");//预处理语句执行若干次处理时间执行效率才可能高于普通操作
		
		Retrive2("Maria");
		
//		Retrive("'or 1 or'");
	}

	public void Retrive(String name) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;//过滤特殊字符
		ResultSet rs = null;
		String sql = "SELECT id, name, birthday, money FROM user WHERE name = ?";
		try {
			//2. 获取连接
			conn = JdbcUtils.getConnection();//最耗时
			
			//3. 创建语句
			ps = conn.prepareStatement(sql);
			ps.setObject(1, name);
			//4. 执行语句
			long start = System.currentTimeMillis();
			rs = ps.executeQuery();//PreparedStatement接口继承自Statement
//			rs = ps.executeQuery(sql);//这样子调用的是Statement的executeQuery的方法
			long end = System.currentTimeMillis();
			System.out.println((end - start) + "ms");
			
			//5. 获取数据
			System.out.println(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("id") + "\t" 
						+ rs.getString("name") + 
						"\t" + rs.getDate("birthday") + "\t" + 
						rs.getFloat("money"));
			}
			
		} finally {
			//6.释放连接
			JdbcUtils.releaseResource(rs, ps, conn);
		}
	}
	public void Retrive2(String name) throws SQLException {
		Connection conn = null;
		Statement stmt = null;//过滤特殊字符
		ResultSet rs = null;
		String sql = "SELECT id, name, birthday, money FROM user WHERE name = '" + name + "'";
		try {
			//2. 获取连接
			conn = JdbcUtils.getConnection();
			
			//3. 创建语句
			stmt = conn.createStatement();
			
			//4. 执行语句
			long start = System.currentTimeMillis();
			rs = stmt.executeQuery(sql);//PreparedStatement接口继承自Statement
			long end = System.currentTimeMillis();
			System.out.println((end - start) + "ms");
			
			//5. 获取数据
			System.out.println(sql);
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
	
}
