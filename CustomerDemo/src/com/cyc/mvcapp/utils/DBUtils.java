package com.cyc.mvcapp.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtils {
    
    /**
     * 释放链接
     * @param connection
     */
    public static void releaseConnection(Connection connection){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    
    private static ComboPooledDataSource dataSource=null;
    
    static{
        //只被创建一次
        dataSource=new ComboPooledDataSource("mvcapp");  // myc3p0 一定要与配置文件中的名字一样
    }
        
    /**
     * 返回数据源的一个Connection 对象
     * @return
     * @throws Exception 
     */
    public static Connection getConnection() {
        try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }    
    
}