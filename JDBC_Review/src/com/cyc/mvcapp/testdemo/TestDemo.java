package com.cyc.mvcapp.testdemo;

import java.lang.reflect.Method;
import java.sql.SQLException;

import org.junit.Test;

import com.cyc.mvcapp.testdao.AccountDao1;
import com.cyc.mvcapp.utils.JdbcUtils;

public class TestDemo {
	private AccountDao1 dao = new AccountDao1();
	
	@Test
	public void serviceMethod() throws Exception {
		
		try {
			JdbcUtils.beginTransaction();
			dao.update("yi", -1);
			if (true) {
				throw new RuntimeException();
			}
			dao.update("jia", 1);
			JdbcUtils.commitTransaction();
		} catch (Exception e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw e;
		}
	}
	
}
