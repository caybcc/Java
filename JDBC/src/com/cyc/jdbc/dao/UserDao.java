package com.cyc.jdbc.dao;

import com.cyc.jdbc.domain.User;

public interface UserDao {
	
	public void addUser(User user);
	
	public User getUser(int userId);
	
	public void updateUser(User user); 
	
	public void deleteUser(User user);
	
	public User findUse(String username, String password);
}
