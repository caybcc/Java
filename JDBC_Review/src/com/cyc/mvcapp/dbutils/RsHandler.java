package com.cyc.mvcapp.dbutils;

import java.sql.ResultSet;

/**
 * �����ѽ����ת������Ҫת��������
 * @author cyc
 * @param <T>
 */
public interface RsHandler<T> {
	public T handler(ResultSet rs);
}
