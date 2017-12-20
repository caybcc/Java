package com.cyc.tools.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	
	private static DataSource ds = null;
	
	//����ר������
//	private static Connection conn = null; 
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();//��Ϊ���ӹ���conn�������ڶ��̻߳����»ᵼ���쳣����
	
	static {
		ds = new ComboPooledDataSource("mvcapp");
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = tl.get();//��ȡ��ǰ�̵߳�ר������
		if (conn != null) {
			return conn;//�˿�˵���Ѿ�����beginTransaction������
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
			throw new SQLException("�����Ѿ��������벻Ҫ�ظ�������");
		}
		conn = getConnection();//��conn��ֵ��ʾ�����Ѿ���ʼ
		conn.setAutoCommit(false);
		tl.set(conn);//�ѵ�ǰ���ӱ�������
	}
	
	public static void commitTransaction() throws SQLException {
		Connection conn = tl.get();
		if (conn == null) {
			throw new SQLException("����û�п�ʼ�������ύ��");
		}
		conn.commit();
		conn.close();
//		conn = null;//��ʾ�����Ѿ��������´ε���getConnection�Ͳ���conn��
		tl.remove();
		
	}
	
	public static void rollbackTransaction() throws SQLException {
		Connection conn = tl.get();
		if (conn == null) {
			throw new SQLException("����û�п��������ܻع���");
		}
		conn.rollback();
		conn.close();
//		conn = null;
		tl.remove();
	}
	
	public static void releaseConnection(Connection connection) throws SQLException {
		Connection conn = tl.get();
		//�鿴��������Ƿ�������ר�õ�
		//conn==nul˵���˿�û��������ôconnection��������ר�õ�
		if (conn == null) {
			connection.close();
		}
		
		//������ר�����ӺͲ������Ӳ��ȣ�˵���������Ӳ�������ר������
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
