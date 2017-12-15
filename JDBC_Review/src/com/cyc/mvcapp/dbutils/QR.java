package com.cyc.mvcapp.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * Ä£Äâdbutils jar°ü
 * @author cyc
 *
 * @param <T>
 */
public class QR<T> {
	
	private DataSource dataSource;
	
	public QR() {
		
	}

	public QR(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int update(String sql, Object...args) {
		Connection conn = null;
		PreparedStatement psmt = null;
		int affected_row = 0;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			initParams(psmt, args);
			affected_row = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}	
		
		return affected_row;
	}
	
	private void initParams(PreparedStatement psmt, Object...args) throws SQLException {
		for (int i = 0; i < args.length; i++) {
			psmt.setObject(i+1, args[i]);
		}
	}
	
	public T query(String sql, RsHandler<T> rh, Object...args) {
		Connection conn = null;
		PreparedStatement psmt = null;
		T result = null;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			initParams(psmt, args);
			ResultSet rs = psmt.executeQuery();
			result = rh.handler(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}	
		
		return result;
	}

}
