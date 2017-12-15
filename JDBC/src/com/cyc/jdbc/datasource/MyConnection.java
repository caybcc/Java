/**
 * 
 */
package com.cyc.jdbc.datasource;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import javax.sql.DataSource;

/**
 * @author cyc
 *
 */
public class MyConnection implements Connection {

	private Connection realConnection;
	private MyDataSource2 dataSource;
	
	/**
	 * 
	 */
	public MyConnection(Connection realConnection, MyDataSource2 dataSource) {
		// TODO Auto-generated constructor stub
		this.realConnection = realConnection;
		this.dataSource = dataSource;
	}

	/* (non-Javadoc)
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#unwrap(java.lang.Class)
	 */
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return this.realConnection.unwrap(iface);
	}

	/* (non-Javadoc)
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#isWrapperFor(java.lang.Class)
	 */
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		
		return false;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#createStatement()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#createStatement()
	 */
	@Override
	public Statement createStatement() throws SQLException {
		// TODO Auto-generated method stub
		
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareStatement(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#prepareStatement(java.lang.String)
	 */
	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareCall(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#prepareCall(java.lang.String)
	 */
	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#nativeSQL(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#nativeSQL(java.lang.String)
	 */
	@Override
	public String nativeSQL(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setAutoCommit(boolean)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#setAutoCommit(boolean)
	 */
	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getAutoCommit()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#getAutoCommit()
	 */
	@Override
	public boolean getAutoCommit() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#commit()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#commit()
	 */
	@Override
	public void commit() throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#rollback()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#rollback()
	 */
	@Override
	public void rollback() throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#close()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#close()
	 */
	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		this.dataSource.connectionsPool.addLast(this);
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#isClosed()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#isClosed()
	 */
	@Override
	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getMetaData()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#getMetaData()
	 */
	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setReadOnly(boolean)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#setReadOnly(boolean)
	 */
	@Override
	public void setReadOnly(boolean readOnly) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#isReadOnly()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#isReadOnly()
	 */
	@Override
	public boolean isReadOnly() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setCatalog(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#setCatalog(java.lang.String)
	 */
	@Override
	public void setCatalog(String catalog) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getCatalog()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#getCatalog()
	 */
	@Override
	public String getCatalog() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setTransactionIsolation(int)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#setTransactionIsolation(int)
	 */
	@Override
	public void setTransactionIsolation(int level) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getTransactionIsolation()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#getTransactionIsolation()
	 */
	@Override
	public int getTransactionIsolation() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getWarnings()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#getWarnings()
	 */
	@Override
	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#clearWarnings()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#clearWarnings()
	 */
	@Override
	public void clearWarnings() throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#createStatement(int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#createStatement(int, int)
	 */
	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#prepareStatement(java.lang.String, int, int)
	 */
	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareCall(java.lang.String, int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#prepareCall(java.lang.String, int, int)
	 */
	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getTypeMap()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#getTypeMap()
	 */
	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setTypeMap(java.util.Map)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#setTypeMap(java.util.Map)
	 */
	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setHoldability(int)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#setHoldability(int)
	 */
	@Override
	public void setHoldability(int holdability) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getHoldability()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#getHoldability()
	 */
	@Override
	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setSavepoint()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#setSavepoint()
	 */
	@Override
	public Savepoint setSavepoint() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setSavepoint(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#setSavepoint(java.lang.String)
	 */
	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#rollback(java.sql.Savepoint)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#rollback(java.sql.Savepoint)
	 */
	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#releaseSavepoint(java.sql.Savepoint)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#releaseSavepoint(java.sql.Savepoint)
	 */
	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#createStatement(int, int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#createStatement(int, int, int)
	 */
	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#prepareStatement(java.lang.String, int, int, int)
	 */
	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareCall(java.lang.String, int, int, int)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#prepareCall(java.lang.String, int, int, int)
	 */
	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#prepareStatement(java.lang.String, int)
	 */
	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int[])
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#prepareStatement(java.lang.String, int[])
	 */
	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#prepareStatement(java.lang.String, java.lang.String[])
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#prepareStatement(java.lang.String, java.lang.String[])
	 */
	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#createClob()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#createClob()
	 */
	@Override
	public Clob createClob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#createBlob()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#createBlob()
	 */
	@Override
	public Blob createBlob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#createNClob()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#createNClob()
	 */
	@Override
	public NClob createNClob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#createSQLXML()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#createSQLXML()
	 */
	@Override
	public SQLXML createSQLXML() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#isValid(int)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#isValid(int)
	 */
	@Override
	public boolean isValid(int timeout) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setClientInfo(java.lang.String, java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#setClientInfo(java.lang.String, java.lang.String)
	 */
	@Override
	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setClientInfo(java.util.Properties)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#setClientInfo(java.util.Properties)
	 */
	@Override
	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getClientInfo(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#getClientInfo(java.lang.String)
	 */
	@Override
	public String getClientInfo(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getClientInfo()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#getClientInfo()
	 */
	@Override
	public Properties getClientInfo() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#createArrayOf(java.lang.String, java.lang.Object[])
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#createArrayOf(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#createStruct(java.lang.String, java.lang.Object[])
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#createStruct(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setSchema(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#setSchema(java.lang.String)
	 */
	@Override
	public void setSchema(String schema) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getSchema()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#getSchema()
	 */
	@Override
	public String getSchema() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#abort(java.util.concurrent.Executor)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#abort(java.util.concurrent.Executor)
	 */
	@Override
	public void abort(Executor executor) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#setNetworkTimeout(java.util.concurrent.Executor, int)
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#setNetworkTimeout(java.util.concurrent.Executor, int)
	 */
	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.sql.Connection#getNetworkTimeout()
	 */
	/* (non-Javadoc)
	 * @see com.cyc.jdbc.datasource.Connection#getNetworkTimeout()
	 */
	@Override
	public int getNetworkTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
