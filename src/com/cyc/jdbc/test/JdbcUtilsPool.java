package com.cyc.jdbc.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cyc.jdbc.datasource.MyDataSource2;

/**
 * 2017-08-09
 * @author cyc
 * ��ֹ�̳�
 */
public final class JdbcUtilsPool {
	
	private static MyDataSource2 mds = null;
	

	private JdbcUtilsPool() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			mds = new MyDataSource2();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return mds.getConnection();
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
//				mds.releaseConnection(conn);
				//Ϊ�����û�ϰ����conn.close
				try {
					conn.close();//����Ļ���ʵ���õ���MyConnection��Close����
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
