package com.cyc.mvcapp.testdao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import com.cyc.mvcapp.utils.TxQueryRunner;

public class AccountDao1 {
	public int update(String name, double money) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "UPDATE account SET balance = balance + ? WHERE name like ?";
		Object[] params = {money, name};
		
		int affected_row = qr.update(sql, params);
		
		return affected_row;
	}
	
}
