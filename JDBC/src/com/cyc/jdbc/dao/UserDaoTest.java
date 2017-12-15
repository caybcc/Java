package com.cyc.jdbc.dao;

import java.util.Date;

import org.junit.Test;

import com.cyc.jdbc.domain.User;

public class UserDaoTest {

	@Test
	public void testUserDao() {
		User user = new User();
		user.setId(5);
		user.setName("Karl");
		user.setBirthday(new Date());
		user.setMoney(456.09f);
		
//		UserDao userDao = new UserDaoJdbcImpl();
		UserDao userDao = DaoFactory.getInstance().getUserDao();
		//userDao.addUser(user);
		
		/*user = userDao.getUser(6);
		System.out.println(user.getId());
		user = userDao.findUse("Carl", null);
		System.out.println(user.getName());*/
		
//		userDao.updateUser(user);
		userDao.deleteUser(user);
		
		
		
		
	}

}
