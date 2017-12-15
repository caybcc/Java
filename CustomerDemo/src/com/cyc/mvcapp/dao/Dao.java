package com.cyc.mvcapp.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cyc.mvcapp.utils.DBUtils;

public class Dao<T> {
	private QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz;
	
	/**
	 * ��Ҫȷ��clazz
	 */
	@SuppressWarnings("unchecked")
	public Dao() {
		//�ɵõ������ Class�õ����� �����͵��Ǹ����͡�
		Type superClass = getClass().getGenericSuperclass();
		
		//���ж��ǲ����Ǹ�����
		if (superClass instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType)superClass;
			
			//��ȡ�����ķ��͵Ĳ���
			Type[] typeArgs = parameterizedType.getActualTypeArguments();
			
			if (typeArgs != null && typeArgs.length > 0) {
				if (typeArgs[0] instanceof Class) {
					clazz = (Class<T>)typeArgs[0];
				}
			}
		}
	}
	
	/**
	 * ��ѯ������ĳһ���ֶε�ֵ
	 * @param sql
	 * @param args
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <E> E getForValue(String sql, Object...args) {
		Connection conn = null;
		
		try {
			conn = DBUtils.getConnection();
			return (E)queryRunner.query(conn, sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.releaseConnection(conn);
		}
		
		return null;
		
	}
	
	/**
	 * ��ѯ������T ����Ӧ�� List
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql, Object...args){
		Connection conn = null;
		
		try {
			conn = DBUtils.getConnection();
			return queryRunner.query(conn, sql, new BeanListHandler<T>(clazz), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.releaseConnection(conn);
		}
		
		return null;
		
	}
	
	/**
	 * ��ѯ,����һ��T ��ʵ�������
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql, Object...args) {
		Connection conn = null;
		
		try {
			conn = DBUtils.getConnection();
			return queryRunner.query(conn, sql, new BeanHandler<T>(clazz), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.releaseConnection(conn);
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param sql
	 * @param args
	 * @return 
	 */
	public int update(String sql, Object...args) {
		Connection conn = null;
		
		try {
			conn = DBUtils.getConnection();
			return queryRunner.update(conn, sql, args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.releaseConnection(conn);
		}
		
		return 0;
	}
	
}
