package com.cyc.jdbc.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

//可滚动的结果集
public class ScrollerTest {
	
	@Test
	public void testScroller() throws SQLException {
		scroll();
	}
	
	public void scroll() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//2. 获取连接
			conn = JdbcUtils.getConnection();
			
			//3. 创建语句--可滚动设置参数，并发当前仅仅可读
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			//4. 执行语句
			rs = stmt.executeQuery("SELECT id, name, birthday, money FROM user");
			
			//5. 获取数据
			
//			while(rs.next()) {
//				System.out.println(rs.getObject("id") + "\t" 
//						+ rs.getObject("name") + 
//						"\t" + rs.getObject("birthday") + "\t" + 
//						rs.getObject("money"));
//			}
//			
//			rs.absolute(3);
//			if (rs.previous()) {
//				System.out.println(rs.getObject("id") + "\t" 
//						+ rs.getObject("name") + 
//						"\t" + rs.getObject("birthday") + "\t" + 
//						rs.getObject("money"));
//			}
			
			//用于分页（效率低下：把所有数据先放在内存里面，MySQL支持分页limit一般其他数据库不支持分页）
			
			int i = 0;
			rs.absolute(150);//limit 150 10
			while(rs.next() && i < 10) {
				i++;
				System.out.println(rs.getObject("id") + "\t" 
				+ rs.getObject("name") + 
				"\t" + rs.getObject("birthday") + "\t" + 
				rs.getObject("money"));
				
			}
			
		} finally {
			//6.释放连接
			JdbcUtils.releaseResource(rs, stmt, conn);
		}
	}

}
