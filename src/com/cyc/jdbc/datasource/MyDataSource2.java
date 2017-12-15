package com.cyc.jdbc.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * 2017-12-02
 * @author cyc
 *
 */
public class MyDataSource2 {
	private static  String url = "jdbc:mysql:///jdbc?generateSimpleParameterMetadata=true";
	private static String username = "root";
	private static String password = "123456";
	
	private static int initCount = 5;
	private static int maxCount = 10;
	int currentCount = 0;//当前连接数量
	
	LinkedList<Connection> connectionsPool = new LinkedList<>();
	
	public MyDataSource2() {
		for (int i = 0; i < initCount; i++) {
			try {
				this.connectionsPool.addLast(createConnection());
				this.currentCount++;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e.getMessage(), e);
			}
		}
	}
	
	private Connection createConnection() throws SQLException {
		Connection realConn = DriverManager.getConnection(url, username, password);
		Connection myConnection = new MyConnection(realConn, this);
		return myConnection;
	}
	
	public Connection getConnection() throws SQLException {
		//保证每一个线程只得到一个线程
		synchronized (connectionsPool) {
			if(this.connectionsPool.size() > 0)
				return connectionsPool.removeFirst();
			if (this.currentCount < maxCount) {
				this.currentCount++;
				return this.createConnection();
			}
			
			throw new SQLException("连接数量已经达到上限！");
		}
		
	}
	
	public void releaseConnection(Connection conn) {
			connectionsPool.addLast(conn);
	}
}
