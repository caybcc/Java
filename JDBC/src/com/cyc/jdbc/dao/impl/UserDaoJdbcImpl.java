package com.cyc.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cyc.jdbc.dao.DaoException;
import com.cyc.jdbc.dao.UserDao;
import com.cyc.jdbc.domain.User;
import com.cyc.jdbc.test.JdbcUtils;

public class UserDaoJdbcImpl implements UserDao {

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();
			
			//3. �������
			String sql = "INSERT INTO user(name, birthday, money) VALUES(?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setDate(2, new java.sql.Date(user.getBirthday().getTime()));
			ps.setFloat(3, user.getMoney());
			//4. ִ�����
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
//			throw new RuntimeException(e);//�ܴ���ʹ������ܾ;ͺ���
			throw new DaoException(e.getMessage(), e);//��֤�ӿ�û�б���Ⱦ
		} finally {
			//6.�ͷ�����
			JdbcUtils.releaseResource(rs, ps, conn);
		}
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();
			
			//3. �������
			String sql = "SELECT id, name, birthday, money FROM user WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			//4. ִ�����
			rs = ps.executeQuery();
			while(rs.next()) {
				user = mappingUser(rs);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
//					throw new RuntimeException(e);//�ܴ���ʹ������ܾ;ͺ���
			throw new DaoException(e.getMessage(), e);//��֤�ӿ�û�б���Ⱦ
		} finally {
			//6.�ͷ�����
			JdbcUtils.releaseResource(rs, ps, conn);
		}

		return user;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();
			
			//3. �������
			String sql = "UPDATE user SET name = ?, birthday = ?, money = ? WHERE id = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setDate(2, new java.sql.Date(user.getBirthday().getTime()));
			ps.setFloat(3, user.getMoney());
			ps.setInt(4, user.getId());
			//4. ִ�����
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
//			throw new RuntimeException(e);//�ܴ���ʹ������ܾ;ͺ���
			throw new DaoException(e.getMessage(), e);//��֤�ӿ�û�б���Ⱦ
		} finally {
			//6.�ͷ�����
			JdbcUtils.releaseResource(rs, ps, conn);
		}
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();
			
			//3. �������
			String sql = "DELETE FROM user WHERE id = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user.getId());
			//4. ִ�����
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e.getMessage(), e);
		} finally {
			//6.�ͷ�����
			JdbcUtils.releaseResource(rs, ps, conn);
		}
		
	}

	@Override
	public User findUse(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			//2. ��ȡ����
			conn = JdbcUtils.getConnection();
			
			//3. �������
			String sql = "SELECT id, name, birthday, money FROM user WHERE name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			//4. ִ�����
			rs = ps.executeQuery();
			while(rs.next()) {
				user = mappingUser(rs);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
//					throw new RuntimeException(e);//�ܴ���ʹ������ܾ;ͺ���
			throw new DaoException(e.getMessage(), e);//��֤�ӿ�û�б���Ⱦ
		} finally {
			//6.�ͷ�����
			JdbcUtils.releaseResource(rs, ps, conn);
		}
		
		return user;
	}

	private User mappingUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setBirthday(rs.getDate("birthday"));
		user.setMoney(rs.getFloat("money"));
		return user;
	}
	

}
