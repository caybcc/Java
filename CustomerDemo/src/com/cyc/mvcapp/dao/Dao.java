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
	 * 需要确定clazz
	 */
	@SuppressWarnings("unchecked")
	public Dao() {
		//由得到子类的 Class得到父类 带泛型的那个类型。
		Type superClass = getClass().getGenericSuperclass();
		
		//先判断是不是那个类型
		if (superClass instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType)superClass;
			
			//获取真正的泛型的参数
			Type[] typeArgs = parameterizedType.getActualTypeArguments();
			
			if (typeArgs != null && typeArgs.length > 0) {
				if (typeArgs[0] instanceof Class) {
					clazz = (Class<T>)typeArgs[0];
				}
			}
		}
	}
	
	/**
	 * 查询，返回某一个字段的值
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
	 * 查询，返回T 所对应的 List
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
	 * 查询,返回一个T 的实体类对象
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
