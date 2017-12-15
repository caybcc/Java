package com.cyc.mvcapp.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 * ��д����connection�����ķ���
 * ������еķ����Լ��������ӵ����⣬������Ӵ���
 * �õ�JdbcUtils.getConnection(),�������������ӣ���������ͨ����
 * JdbcUtils.releaseConnection(),������ͨ���ӣ���ر�
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
		 * 1.��ȡ����
		 * 2.���ø��෽��
		 * 3.�ͷ�����
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
