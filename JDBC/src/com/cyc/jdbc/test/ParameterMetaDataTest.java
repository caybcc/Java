package com.cyc.jdbc.test;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ParameterMetaDataTest {

	@Test
	public void testPMD() throws SQLException {
		
//		retrive("SELECT * FROM user WHERE name = ? AND money > ?", new Object[] {"Maria", 0f});
//		Map<String, Object> map = retrive1("SELECT id, name, birthday, money FROM user");
//		System.out.println(map);
		List<Map<String, Object>> list = retrive2("SELECT id, name, birthday, money FROM user WHERE id < 5");
		System.out.println(list);
	}

	public void retrive(String sql, Object[] params) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;//���������ַ�
		ResultSet rs = null;
		try {
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();//���ʱ
			
			//3. �������
			ps = conn.prepareStatement(sql);
			
			ParameterMetaData pmd = ps.getParameterMetaData();
			
			int count = pmd.getParameterCount();
			for (int i = 1; i <= count; i++) {
				/*System.out.print(pmd.getParameterClassName(i) + "\t");
				System.out.print(pmd.getParameterType(i) + "\t");
				System.out.println(pmd.getParameterTypeName(i));*/
				ps.setObject(i, params[i - 1]);//�ɶ��Բ�̫�ã�����Ը�
			}
			
			//4. ִ�����
			rs = ps.executeQuery();
			
			//5. ��ȡ����
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
	
	public static Map<String, Object> retrive1(String sql) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;//���������ַ�
		ResultSet rs = null;
		try {
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();//���ʱ
			
			//3. �������
			ps = conn.prepareStatement(sql);
			
			//4. ִ�����
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			String[] columns = new String[count];
			for (int i = 1; i <= count; i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
				System.out.print(rsmd.getColumnTypeName(i) + "\t");
				System.out.println(rsmd.getColumnLabel(i));
				columns[i-1] = rsmd.getColumnName(i);
			}
			
			Map<String, Object> data = null;
			
			//5. ��ȡ����
			if(rs.next()) {
				data = new HashMap<String, Object>();
				for (int i = 0; i < columns.length; i++) {
					data.put(columns[i], rs.getObject(columns[i]));
				}
				System.out.println(rs.getInt("id") + "\t" 
						+ rs.getString("name") + 
						"\t" + rs.getDate("birthday") + "\t" + 
						rs.getFloat("money"));//����Ҫȥ��������Щ�ֶ��Ҳ���
			}
			
			return data;
		} finally {
			//6.�ͷ�����
			JdbcUtils.releaseResource(rs, ps, conn);
		}
	}
	public static List<Map<String, Object>> retrive2(String sql) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;//���������ַ�
		ResultSet rs = null;
		try {
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();//���ʱ
			
			//3. �������
			ps = conn.prepareStatement(sql);
			
			//4. ִ�����
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			String[] columns = new String[count];
			for (int i = 1; i <= count; i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
				System.out.print(rsmd.getColumnTypeName(i) + "\t");
				System.out.println(rsmd.getColumnLabel(i));
				columns[i-1] = rsmd.getColumnName(i);
			}
			
			List<Map<String, Object>> list = new ArrayList<>();
			
			Map<String, Object> data = null;
			
			//5. ��ȡ����
			while(rs.next()) {
				data = new HashMap<String, Object>();
				for (int i = 0; i < columns.length; i++) {
					data.put(columns[i], rs.getObject(columns[i]));
				}
				list.add(data);
				System.out.println(rs.getInt("id") + "\t" 
						+ rs.getString("name") + 
						"\t" + rs.getDate("birthday") + "\t" + 
						rs.getFloat("money"));//����Ҫȥ��������Щ�ֶ��Ҳ���
			}
			
			return list;
		} finally {
			//6.�ͷ�����
			JdbcUtils.releaseResource(rs, ps, conn);
		}
	}
}
