package com.cyc.mvcapp.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtils {
    
    /**
     * �ͷ�����
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
        //ֻ������һ��
        dataSource=new ComboPooledDataSource("mvcapp");  // myc3p0 һ��Ҫ�������ļ��е�����һ��
    }
        
    /**
     * ��������Դ��һ��Connection ����
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