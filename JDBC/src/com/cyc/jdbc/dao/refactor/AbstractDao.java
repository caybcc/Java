package com.cyc.jdbc.dao.refactor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cyc.jdbc.dao.DaoException;
import com.cyc.jdbc.test.JdbcUtils;

public abstract class AbstractDao {
	public Object find(String sql, Object[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Object object = null;
		try {
			//2. 获取连接
			conn = JdbcUtils.getConnection();
			
			//3. 创建语句
			ps = conn.prepareStatement(sql);
			
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			//4. 执行语句
			rs = ps.executeQuery();
			
			while(rs.next()) {
				object = rowMapper(rs);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
//					throw new RuntimeException(e);//能处理就处理，不能就就忽略
			throw new DaoException(e.getMessage(), e);//保证接口没有被污染
		} finally {
			//6.释放连接
			JdbcUtils.releaseResource(rs, ps, conn);
		}

		return object;
	}
	
	abstract protected Object rowMapper(ResultSet rs);
	
	public int updateUser(String sql, Object[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2. 获取连接
			conn = JdbcUtils.getConnection();
			
			//3. 创建语句
			ps = conn.prepareStatement(sql);
			
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			//4. 执行语句
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
//			throw new RuntimeException(e);//能处理就处理，不能就就忽略
			throw new DaoException(e.getMessage(), e);//保证接口没有被污染
		} finally {
			//6.释放连接
			JdbcUtils.releaseResource(rs, ps, conn);
		}
	}
}
