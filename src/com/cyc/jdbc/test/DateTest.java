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
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();
			
			//3. �������
			sql = "INSERT INTO user(name, birthday, money) VALUES(?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDate(2, new java.sql.Date(birthday.getTime()));//��java.util.Dateת��Ϊjava.sql.Date
			ps.setFloat(3, money);
			
			//4. ִ�����
			
			affectRows = ps.executeUpdate();//���ܼ���sql������Ϊ������ֱ�ӵ���statement.executeUpdate()ֱ�ӰѴ�ͨ���������͵����ݿ�
			
		} finally {
			//6.�ͷ�����
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
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();
			
			//3. �������
			stmt = conn.createStatement();
			
			//4. ִ�����
			rs = stmt.executeQuery("SELECT id, name, birthday, money FROM user WHERE id = " + id);
			
			//5. ��ȡ����
			
			while(rs.next()) {
				birthday = rs.getDate("birthday");//java.sql.date -> ����java.util.date����--java.sql.date�����ͨ��toString�����������ڸ�ʽ���Ĺ���
//				birthday = new Date(rs.getDate("birthday").getTime());//Ҳ��
			}
			
		} finally {
			//6.�ͷ�����
			JdbcUtils.releaseResource(rs, stmt, conn);
		}
		
		return birthday;
	}

}
