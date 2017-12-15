package com.cyc.domain;

/**
 * 把取得数据存储到这个对象当中
 * 
 * @author cyc
 *
 */
public class User {
	private String username = null;
	private String password = null;

	public User() {

	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
