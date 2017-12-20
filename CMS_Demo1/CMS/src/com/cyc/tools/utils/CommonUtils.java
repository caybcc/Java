package com.cyc.tools.utils;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

public class CommonUtils {
	
	/**
	 * 生成不重复的32位长度的大写字符
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-","").toUpperCase();
	}
	
	public static <T> T toBean(Map map, Class<T> clazz) {
		T bean = null;
		try {
			bean = clazz.newInstance();
			BeanUtils.populate(bean, map);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		return bean;
		
	}
}
