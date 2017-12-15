package com.cyc.rl.dao;

import com.cyc.rl.domain.User;

public interface UserDao {
	public void add(User user);
	
	public User findByUsername(String username);
}
