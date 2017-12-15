package com.cyc.jdbc.dao;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	private static UserDao userDao = null;
	private static DaoFactory instance = new DaoFactory();
//	private static UserDao userDao = DaoFactory.getInstance().getUserDao();
	
	private DaoFactory() {
		Properties prop = new Properties();
		InputStream in;
		try {
//			in = new FileInputStream("src/daoconfig.properties");
			in = DaoFactory.class.getClassLoader().getResourceAsStream("daoconfig.properties");
			prop.load(in);
			String userDaoClass = prop.getProperty("userDaoClass");
			userDao = (UserDao)Class.forName(userDaoClass).newInstance();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	public static DaoFactory getInstance() {
		return instance;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

}
