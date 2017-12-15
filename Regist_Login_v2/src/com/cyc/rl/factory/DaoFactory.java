package com.cyc.rl.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.cyc.rl.dao.UserDao;

public class DaoFactory {
	
	private static Properties props;
	
	static {
		InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("daoconfig.properties");
		props = new Properties();
		try {
			props.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public static UserDao getUserDao() {
		
		String daoClassName = props.getProperty("com.cyc.rl.dao.UserDao");
		UserDao userDao;
		//通过反射创建实现类对象
		
		try {
			Class clazz = Class.forName(daoClassName);
			userDao = (UserDao)clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage(), e);
		}
		
		return userDao;
	}
}
