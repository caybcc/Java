package com.cyc.mvcapp.dbutils;

import java.sql.ResultSet;

/**
 * 用来把结果集转换成需要转化的类型
 * @author cyc
 * @param <T>
 */
public interface RsHandler<T> {
	public T handler(ResultSet rs);
}
