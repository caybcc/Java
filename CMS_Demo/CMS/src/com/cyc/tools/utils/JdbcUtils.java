package com.cyc.tools.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	
	private static DataSource ds = null;
	
	//事务专用连接
//	private static Connection conn = null; 
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();//因为连接共享conn，所以在多线程环境下会导致异常发生
	
	static {
		ds = new ComboPooledDataSource("mvcapp");
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = tl.get();//获取当前线程的专用连接
		if (conn != null) {
			return conn;//此刻说明已经调用beginTransaction方法了
		}
		
/*		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}*/
		
		return ds.getConnection();
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	public static void beginTransaction() throws SQLException {
		Connection conn = tl.get();
		if (conn != null) {
			throw new SQLException("事务已经开启，请不要重复开启！");
		}
		conn = getConnection();//给conn赋值表示事务已经开始
		conn.setAutoCommit(false);
		tl.set(conn);//把当前连接保存起来
	}
	
	public static void commitTransaction() throws SQLException {
		Connection conn = tl.get();
		if (conn == null) {
			throw new SQLException("事务还没有开始，不能提交！");
		}
		conn.commit();
		conn.close();
//		conn = null;//表示事务已经结束，下次调用getConnection就不是conn了
		tl.remove();
		
	}
	
	public static void rollbackTransaction() throws SQLException {
		Connection conn = tl.get();
		if (conn == null) {
			throw new SQLException("事务还没有开启，不能回滚！");
		}
		conn.rollback();
		conn.close();
//		conn = null;
		tl.remove();
	}
	
	public static void releaseConnection(Connection connection) throws SQLException {
		Connection conn = tl.get();
		//查看这个连接是否是事务专用的
		//conn==nul说明此刻没有事务，那么connection不是事务专用的
		if (conn == null) {
			connection.close();
		}
		
		//若事务专用连接和参数连接不等，说明参数连接不是事务专用连接
		if (conn != connection) {
			connection.close();
		}
	}
	
	public static void releaseResource(ResultSet rs, Statement stmt, Connection conn) {
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
