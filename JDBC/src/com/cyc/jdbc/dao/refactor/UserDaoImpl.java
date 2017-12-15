package com.cyc.jdbc.dao.refactor;

import java.sql.ResultSet;
import com.cyc.jdbc.dao.DaoException;
import com.cyc.jdbc.domain.User;

public class UserDaoImpl extends AbstractDao  {
	public void addUser(User user) {
		String sql = "INSERT INTO user(name, birthday, money) VALUES(?, ?, ?)";
		Object[] args = {user.getName(), user.getBirthday(), user.getMoney()};
		super.updateUser(sql, args);
	}
	
	public void deleteUser(User user) {
		String sql = "DELETE FROM user WHERE id = ?";
		Object[] args = {user.getId()};
		super.updateUser(sql, args);
	}
	
	public void updateUser(User user) {
		String sql = "UPDATE user SET name = ?, birthday = ?, money = ? WHERE id = ?";
		Object[] args = {user.getName(), new java.sql.Date(user.getBirthday().getTime()), user.getMoney(), user.getId()};
		super.updateUser(sql, args);
	}
	
	public User getUser(int userId) {
		
		String sql = "SELECT id, name, birthday, money FROM user WHERE id = ?";
		Object[] args = {userId};
		User user = (User)super.find(sql, args);
		return user;
	}
	
	public User findUser(String username, String password) {
		
		String sql = "SELECT id, name, birthday, money FROM user WHERE name = ?";
		Object[] args = {username};
		User user = (User)super.find(sql, args);
		return user;
	}

	@Override
	protected Object rowMapper(ResultSet rs) {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setBirthday(rs.getDate("birthday"));
			user.setMoney(rs.getFloat("money"));
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e.getMessage(), e);
		}
		
		return user;
	}
	
	
}