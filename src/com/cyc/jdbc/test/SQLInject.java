package com.cyc.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
// SQLע��---�������ݿ������������
public class SQLInject {

	public SQLInject() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void test() throws SQLException {
		
		Retrive("Maria");//Ԥ�������ִ�����ɴδ���ʱ��ִ��Ч�ʲſ��ܸ�����ͨ����
		
		Retrive2("Maria");
		
//		Retrive("'or 1 or'");
	}

	public void Retrive(String name) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;//���������ַ�
		ResultSet rs = null;
		String sql = "SELECT id, name, birthday, money FROM user WHERE name = ?";
		try {
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();//���ʱ
			
			//3. �������
			ps = conn.prepareStatement(sql);
			ps.setObject(1, name);
			//4. ִ�����
			long start = System.currentTimeMillis();
			rs = ps.executeQuery();//PreparedStatement�ӿڼ̳���Statement
//			rs = ps.executeQuery(sql);//�����ӵ��õ���Statement��executeQuery�ķ���
			long end = System.currentTimeMillis();
			System.out.println((end - start) + "ms");
			
			//5. ��ȡ����
			System.out.println(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("id") + "\t" 
						+ rs.getString("name") + 
						"\t" + rs.getDate("birthday") + "\t" + 
						rs.getFloat("money"));
			}
			
		} finally {
			//6.�ͷ�����
			JdbcUtils.releaseResource(rs, ps, conn);
		}
	}
	public void Retrive2(String name) throws SQLException {
		Connection conn = null;
		Statement stmt = null;//���������ַ�
		ResultSet rs = null;
		String sql = "SELECT id, name, birthday, money FROM user WHERE name = '" + name + "'";
		try {
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();
			
			//3. �������
			stmt = conn.createStatement();
			
			//4. ִ�����
			long start = System.currentTimeMillis();
			rs = stmt.executeQuery(sql);//PreparedStatement�ӿڼ̳���Statement
			long end = System.currentTimeMillis();
			System.out.println((end - start) + "ms");
			
			//5. ��ȡ����
			System.out.println(sql);
			while(rs.next()) {
				System.out.println(rs.getObject("id") + "\t" 
						+ rs.getObject("name") + 
						"\t" + rs.getObject("birthday") + "\t" + 
						rs.getObject("money"));
			}
			
		} finally {
			//6.�ͷ�����
			JdbcUtils.releaseResource(rs, stmt, conn);
		}
	}
	
}
