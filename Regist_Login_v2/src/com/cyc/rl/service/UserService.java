package com.cyc.rl.service;

import com.cyc.rl.dao.UserDao;
import com.cyc.rl.domain.User;
import com.cyc.rl.factory.DaoFactory;

public class UserService {
	private UserDao userDao = DaoFactory.getUserDao();
	
	/**
	 * 注册功能
	 * @throws UserException
	 */
	public void regist(User user) throws UserException {
		
		User _user = userDao.findByUsername(user.getUsername());
		
		if (_user != null) {
			throw new UserException("用户名" + _user.getUsername() + "已被注册！");
		}
		
		userDao.add(user);
	}
	
	/**
	 * 登录功能
	 * @throws UserException
	 */
	public User login(User user) throws UserException {
		
		User _user = userDao.findByUsername(user.getUsername());
		
		if (_user == null) {
			throw new UserException("用户不存在！");
		}
		
		if (!user.getPassword().equals(_user.getPassword())) {
			throw new UserException("密码错误！");
		}
		
		return _user;
	}
	
}
