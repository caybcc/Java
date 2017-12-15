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
			//1. ע������
			Class.forName(driver);
			//2. ��ȡ����
			conn = DriverManager.getConnection(url, user, password);
			
			//3. �������
			stmt = conn.createStatement();
			
			//4. ִ�����
			rs = stmt.executeQuery("SELECT * FROM user");
			
			//5. ��ȡ����
			
			while(rs.next()) {
				System.out.println(rs.getObject("id") + "\t" + rs.getObject("name") + "\t" + rs.getObject("birthday") + "\t" + rs.getObject("money"));
			}
			
		} finally {
			//6.�ͷ�����
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
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();
			
			//3. �������
			stmt = conn.createStatement();
			
			//4. ִ�����
			rs = stmt.executeQuery("SELECT * FROM user");
			
			//5. ��ȡ����
			
			while(rs.next()) {
				System.out.println(rs.getObject("id") + "\t" + rs.getObject("name") + "\t" + rs.getObject("birthday") + "\t" + rs.getObject("money"));
			}
			
		} finally {
			//6.�ͷ�����
			JdbcUtils.releaseResource(rs, stmt, conn);
		}
	}
	public static void template2() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		JdbcUtilsSingle jus = JdbcUtilsSingle.getInstance();
		try {
			//2. ��ȡ����
			conn = jus.getConnection();
			
			//3. �������
			stmt = conn.createStatement();
			
			//4. ִ�����
			rs = stmt.executeQuery("SELECT * FROM user");
			
			//5. ��ȡ����
			
			while(rs.next()) {
				System.out.println(rs.getObject("id") + "\t" + rs.getObject("name") + "\t" + rs.getObject("birthday") + "\t" + rs.getObject("money"));
			}
			
		} finally {
			//6.�ͷ�����
			jus.releaseResource(rs, stmt, conn);
		}
	}
	
	public static void testJdbc() throws SQLException {
		//1. ע������(����ע����---�ײ�������һ������������һ��Vector drivers����)
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());//�ɶ���ǿ--������ʵע�������Σ���̬�����һ�Σ�����newһ�Σ�---������һ����ɾ���ͻᷢ������ʧ��--�������ַ�ʽ�򲻻�
//		Class.forName("com.mysql.jdbc.Driver");--����Driver�ֽ����ļ�(�������),�˿̻�ִ�о�̬�����(�������ע������ɲ鿴Driver��)--����ʹ�����ַ�ʽ--����Ծ������(����jar��)��������������������
		//ѹ����mysql-connector-java-5.1.45.tar\mysql-connector-java-5.1.45\src\com\mysql\jdbc���ҵ�Driver.java
//		System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");������ð�ŷָ�������
		//2. ��ȡ���ӣ�DriverManager����ȥ����Vector Drivers �е�Ԫ�ؿ��Ƿ�����������ݿ⣩
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "123456");
		
		if (conn != null) {
			System.out.println("���ݿ����ӳɹ�!");
		} else {
			System.out.println("���ݿ�����ʧ��!");
			return ;
		}
		
		//3. ������䣨Statement����SQL���ͽ������ݣ�
		Statement stmt = conn.createStatement();
		
		//4. ִ�����
		ResultSet rs = stmt.executeQuery("SELECT * FROM user");
		
		//5. ��ȡ����
		while(rs.next()) {
			System.out.println(rs.getObject("id") + "\t" + rs.getObject("name") + "\t" + rs.getObject("birthday") + "\t" + rs.getObject("money"));
		}
		
		//6. �ر�����
		rs.close();
		stmt.close();
		conn.close();
	}

}
