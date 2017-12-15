package com.cyc.mvcapp.testdemo;

import java.sql.SQLException;

import org.junit.Test;

import com.cyc.mvcapp.testdao.AccountDao;
import com.cyc.mvcapp.utils.JdbcUtils;

public class TestDemo1 {
	private AccountDao dao = new AccountDao();
	
	@Test
	public void serviceMethod() {
		
		try {
			JdbcUtils.beginTransaction();
			dao.update("yi", -1);
			dao.update("jia", 1);
			JdbcUtils.commitTransaction();
		} catch (Exception e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
