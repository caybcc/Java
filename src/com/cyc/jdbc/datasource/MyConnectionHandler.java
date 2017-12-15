package com.cyc.jdbc.datasource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class MyConnectionHandler implements InvocationHandler {
	
	private Connection realConnection = null;
	private Connection wrapedConnection = null;
	private MyDataSource3 mds = null;
	private int maxUseCount = 10;
	private int currentCount =0;
	
	public MyConnectionHandler(MyDataSource3 mds) {
		// TODO Auto-generated constructor stub
		this.mds = mds;
	}
	
	Connection bind(Connection realConnection) {
		this.realConnection = realConnection;
		//从内存里面载入MyConnectionHandler这个类(运行时产生的类)这个类实现了Connection.class接口,只要一调用Connection接口的方法就会触发本类MyConnectionHandler调用这个接口指定的方法
		this.wrapedConnection = (Connection)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] {Connection.class}, this);
		return wrapedConnection;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		if ("close".equals(method.getName())) {
			this.currentCount++;
			if (this.currentCount < this.maxUseCount) {
				this.mds.connectionsPool.addLast(this.wrapedConnection);
			} else {
				this.realConnection.close();
				this.mds.currentCount--;
			}
		}
		return method.invoke(this.realConnection, args);
	}
	
}
