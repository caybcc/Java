package com.cyc.jdbc.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class OtherAPI {

	@Test
	public void testUpdate() throws SQLException {
		Retrive();
	}
	
	public void Retrive() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//2. 获取连接
			conn = JdbcUtils.getConnection();
			
			//3. 创建语句--第一个参数可以感知数据的变化
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//4. 执行语句
			rs = stmt.executeQuery("SELECT id, name, birthday, money FROM user WHERE id < 5");
			
			//5. 获取数据
			
			while(rs.next()) {
				System.out.println(rs.getObject("id") + "\t" 
						+ rs.getObject("name") + 
						"\t" + rs.getObject("birthday") + "\t" + 
						rs.getObject("money"));
				/*String name = rs.getString("name");//有的API对这个getXX方法获取数据只能用一次，最好第一次获取时保存到变量当中
				if ("Maria".equals(name)) {
					rs.updateFloat("money", 1f);
					rs.updateRow();
				}*/
				
			}
			
		} finally {
			//6.释放连接
			JdbcUtils.releaseResource(rs, stmt, conn);
		}
	}

}
