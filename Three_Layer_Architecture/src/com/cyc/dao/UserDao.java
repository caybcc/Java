package com.cyc.dao;

import com.cyc.domain.User;

public class UserDao {
	public User findUser() {
		return new User("Jack", "123456");
	}
}
