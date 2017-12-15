package com.cyc.mvcapp.testdao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import com.cyc.mvcapp.utils.JdbcUtils;

public class AccountDao {
	public int update(String name, double money) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "UPDATE account SET balance = balance + ? WHERE name like ?";
		Object[] params = {money, name};
		
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
		
		int affected_row = qr.update(conn, sql, params);
		JdbcUtils.releaseConnection(conn);
		
		return affected_row;
	}
	
}
