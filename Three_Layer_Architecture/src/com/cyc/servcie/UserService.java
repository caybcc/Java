package com.cyc.servcie;

import com.cyc.dao.UserDao;
import com.cyc.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public User find() {
		return userDao.findUser();
	}
}
