package com.cyc.jdbc.dao.refactor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cyc.jdbc.dao.DaoException;
import com.cyc.jdbc.test.JdbcUtils;

public abstract class AbstractDao {
	public Object find(String sql, Object[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Object object = null;
		try {
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();
			
			//3. �������
			ps = conn.prepareStatement(sql);
			
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			//4. ִ�����
			rs = ps.executeQuery();
			
			while(rs.next()) {
				object = rowMapper(rs);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
//					throw new RuntimeException(e);//�ܴ���ʹ������ܾ;ͺ���
			throw new DaoException(e.getMessage(), e);//��֤�ӿ�û�б���Ⱦ
		} finally {
			//6.�ͷ�����
			JdbcUtils.releaseResource(rs, ps, conn);
		}

		return object;
	}
	
	abstract protected Object rowMapper(ResultSet rs);
	
	public int updateUser(String sql, Object[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();
			
			//3. �������
			ps = conn.prepareStatement(sql);
			
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			//4. ִ�����
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
//			throw new RuntimeException(e);//�ܴ���ʹ������ܾ;ͺ���
			throw new DaoException(e.getMessage(), e);//��֤�ӿ�û�б���Ⱦ
		} finally {
			//6.�ͷ�����
			JdbcUtils.releaseResource(rs, ps, conn);
		}
	}
}
