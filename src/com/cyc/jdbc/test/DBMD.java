package com.cyc.jdbc.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.junit.Test;

public class DBMD {

	@Test
	public void dbInfo() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		DatabaseMetaData dbmd = conn.getMetaData();
		System.out.println("DB Product name:" + dbmd.getDatabaseProductName());
		System.out.println("DB Transition:" + dbmd.supportsTransactions());
		JdbcUtils.releaseResource(null, null, conn);
		
	}
}
