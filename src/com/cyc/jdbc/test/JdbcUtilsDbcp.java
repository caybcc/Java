package com.cyc.jdbc.test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 * 2017-08-09
 * @author cyc
 * ½ûÖ¹¼Ì³Ð
 */
public final class JdbcUtilsDbcp {
	
	private static DataSource ds = null;
	private static Connection conn;
	

	private JdbcUtilsDbcp() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();
//			prop.setProperty("driverClassName", "com.mysql.jdbc.Driver");
//			mds = new MyDataSource2();
			InputStream in = JdbcUtilsDbcp.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			prop.load(in);
			ds = BasicDataSourceFactory.createDataSource(prop); 
			conn = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return conn;
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
