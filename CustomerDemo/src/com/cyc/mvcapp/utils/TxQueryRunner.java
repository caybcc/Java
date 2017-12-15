package com.cyc.mvcapp.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 * 重写不带connection参数的方法
 * 这个类中的方法自己处理连接的问题，无需外接传递
 * 得到JdbcUtils.getConnection(),可能是事务连接，可能是普通连接
 * JdbcUtils.releaseConnection(),若是普通连接，则关闭
 * @author cyc
 *
 */
public class TxQueryRunner extends QueryRunner {

	/* (non-Javadoc)
	 * @see org.apache.commons.dbutils.QueryRunner#batch(java.lang.String, java.lang.Object[][])
	 */
	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		/**
		 * 1.获取连接
		 * 2.调用父类方法
		 * 3.释放连接
		 */
		
		Connection conn = JdbcUtils.getConnection();
		int[] result = super.batch(conn, sql, params);
		JdbcUtils.releaseConnection(conn);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.dbutils.QueryRunner#execute(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int execute(String sql, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		int result = super.execute(conn, sql, params);
		JdbcUtils.releaseConnection(conn);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.dbutils.QueryRunner#execute(java.lang.String, org.apache.commons.dbutils.ResultSetHandler, java.lang.Object[])
	 */
	@Override
	public <T> List<T> execute(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		List<T> result = super.execute(conn, sql, rsh, params);
		JdbcUtils.releaseConnection(conn);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.dbutils.QueryRunner#insert(java.lang.String, org.apache.commons.dbutils.ResultSetHandler, java.lang.Object[])
	 */
	@Override
	public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		T result = super.insert(conn, sql, rsh, params);
		JdbcUtils.releaseConnection(conn);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.dbutils.QueryRunner#insert(java.lang.String, org.apache.commons.dbutils.ResultSetHandler)
	 */
	@Override
	public <T> T insert(String sql, ResultSetHandler<T> rsh) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		T result = super.insert(conn, sql, rsh);
		JdbcUtils.releaseConnection(conn);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.dbutils.QueryRunner#insertBatch(java.lang.String, org.apache.commons.dbutils.ResultSetHandler, java.lang.Object[][])
	 */
	@Override
	public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		T result = super.insertBatch(conn, sql, rsh, params);
		JdbcUtils.releaseConnection(conn);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.dbutils.QueryRunner#query(java.lang.String, java.lang.Object, org.apache.commons.dbutils.ResultSetHandler)
	 */
	@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		T result = super.query(conn, sql, param, rsh);
		JdbcUtils.releaseConnection(conn);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.dbutils.QueryRunner#query(java.lang.String, java.lang.Object[], org.apache.commons.dbutils.ResultSetHandler)
	 */
	@Override
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		T result = super.query(conn, sql, params, rsh);
		JdbcUtils.releaseConnection(conn);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.dbutils.QueryRunner#query(java.lang.String, org.apache.commons.dbutils.ResultSetHandler, java.lang.Object[])
	 */
	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		T result = super.query(conn, sql, rsh, params);
		JdbcUtils.releaseConnection(conn);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.dbutils.QueryRunner#query(java.lang.String, org.apache.commons.dbutils.ResultSetHandler)
	 */
	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		T result = super.query(conn, sql, rsh);
		JdbcUtils.releaseConnection(conn);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.dbutils.QueryRunner#update(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int update(String sql, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		int result = super.update(conn, sql, params);
		JdbcUtils.releaseConnection(conn);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.dbutils.QueryRunner#update(java.lang.String, java.lang.Object)
	 */
	@Override
	public int update(String sql, Object param) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		int result = super.update(conn, sql, param);
		JdbcUtils.releaseConnection(conn);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.dbutils.QueryRunner#update(java.lang.String)
	 */
	@Override
	public int update(String sql) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtils.getConnection();
		int result = super.update(conn, sql);
		JdbcUtils.releaseConnection(conn);
		return result;
	}
	
}
