package com.cyc.rl.service;

import com.cyc.rl.dao.UserDao;
import com.cyc.rl.domain.User;
import com.cyc.rl.factory.DaoFactory;

public class UserService {
	private UserDao userDao = DaoFactory.getUserDao();
	
	/**
	 * ע�Ṧ��
	 * @throws UserException
	 */
	public void regist(User user) throws UserException {
		
		User _user = userDao.findByUsername(user.getUsername());
		
		if (_user != null) {
			throw new UserException("�û���" + _user.getUsername() + "�ѱ�ע�ᣡ");
		}
		
		userDao.add(user);
	}
	
	/**
	 * ��¼����
	 * @throws UserException
	 */
	public User login(User user) throws UserException {
		
		User _user = userDao.findByUsername(user.getUsername());
		
		if (_user == null) {
			throw new UserException("�û������ڣ�");
		}
		
		if (!user.getPassword().equals(_user.getPassword())) {
			throw new UserException("�������");
		}
		
		return _user;
	}
	
}
