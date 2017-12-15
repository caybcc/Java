package com.cyc.jdbc.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class OtherAPI {

	@Test
	public void testUpdate() throws SQLException {
		Retrive();
	}
	
	public void Retrive() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();
			
			//3. �������--��һ���������Ը�֪���ݵı仯
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//4. ִ�����
			rs = stmt.executeQuery("SELECT id, name, birthday, money FROM user WHERE id < 5");
			
			//5. ��ȡ����
			
			while(rs.next()) {
				System.out.println(rs.getObject("id") + "\t" 
						+ rs.getObject("name") + 
						"\t" + rs.getObject("birthday") + "\t" + 
						rs.getObject("money"));
				/*String name = rs.getString("name");//�е�API�����getXX������ȡ����ֻ����һ�Σ���õ�һ�λ�ȡʱ���浽��������
				if ("Maria".equals(name)) {
					rs.updateFloat("money", 1f);
					rs.updateRow();
				}*/
				
			}
			
		} finally {
			//6.�ͷ�����
			JdbcUtils.releaseResource(rs, stmt, conn);
		}
	}

}
