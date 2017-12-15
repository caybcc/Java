package com.cyc.jdbc.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

//�ɹ����Ľ����
public class ScrollerTest {
	
	@Test
	public void testScroller() throws SQLException {
		scroll();
	}
	
	public void scroll() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();
			
			//3. �������--�ɹ������ò�����������ǰ�����ɶ�
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			//4. ִ�����
			rs = stmt.executeQuery("SELECT id, name, birthday, money FROM user");
			
			//5. ��ȡ����
			
//			while(rs.next()) {
//				System.out.println(rs.getObject("id") + "\t" 
//						+ rs.getObject("name") + 
//						"\t" + rs.getObject("birthday") + "\t" + 
//						rs.getObject("money"));
//			}
//			
//			rs.absolute(3);
//			if (rs.previous()) {
//				System.out.println(rs.getObject("id") + "\t" 
//						+ rs.getObject("name") + 
//						"\t" + rs.getObject("birthday") + "\t" + 
//						rs.getObject("money"));
//			}
			
			//���ڷ�ҳ��Ч�ʵ��£������������ȷ����ڴ����棬MySQL֧�ַ�ҳlimitһ���������ݿⲻ֧�ַ�ҳ��
			
			int i = 0;
			rs.absolute(150);//limit 150 10
			while(rs.next() && i < 10) {
				i++;
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
