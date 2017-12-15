package com.cyc.rl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cyc.rl.dao.UserDao;
import com.cyc.rl.domain.User;
import com.cyc.rl.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User findByUsername(String username) {
		User user = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = JdbcUtils.getConnection();
			String sql = "SELECT id, username, password, birthday FROM user WHERE username = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, username);
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(new Date(rs.getDate("birthday").getTime()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (conn != null) {
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
		
		return user;
	}

	@Override
	public void add(User user) {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = JdbcUtils.getConnection();
			String sql = "INSERT INTO user(username, password, birthday) VALUES(?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUsername());
			psmt.setString(2, user.getPassword());
			psmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			psmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (conn != null) {
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
	}
	
}