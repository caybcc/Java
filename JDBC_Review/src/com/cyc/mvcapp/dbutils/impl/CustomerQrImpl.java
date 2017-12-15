package com.cyc.mvcapp.dbutils.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.cyc.mvcapp.dbutils.QR;
import com.cyc.mvcapp.dbutils.RsHandler;
import com.cyc.mvcapp.entity.Customer;
import com.cyc.mvcapp.utils.JdbcUtils;

public class CustomerQrImpl {

	public void addCustomer(Customer cs) {
		QR<Customer> qr = new QR<>(JdbcUtils.getDataSource());
		String sql = "INSERT INTO customer(id, name, address, phone) VALUES(null, ?, ?, ?)";
		Object[] args = {cs.getName(), cs.getAddress(), cs.getPhone()};
		
		qr.update(sql, args);
	}
	
	public Customer findCustomerById(int id) {
		QR<Customer> qr = new QR<>(JdbcUtils.getDataSource());
		String sql = "SELECT * FROM Customer WHERE id = ?";
		Customer cs = null;
		RsHandler<Customer> rh = new RsHandler<Customer>() {

			@Override
			public Customer handler(ResultSet rs) {
				// TODO Auto-generated method stub
				Customer customer = null;
				try {
					if (rs.next()) {
						customer = new Customer();
						customer.setName(rs.getString("name"));
						customer.setAddress(rs.getString("address"));
						customer.setPhone(rs.getString("phone"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return customer;
			}
		};
		cs = qr.query(sql, rh, id);
		return cs;
	}

	@Test
	public void test() throws SQLException {
		/*Customer cs = new Customer();
		cs.setAddress("三里屯");
		cs.setName("Kark");
		cs.setPhone("18159876543");
		
		addCustomer(cs);*/
		
		/*Customer cs = findCustomerById(1);
		System.out.println(cs.getName());*/
		
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		/*String sql = "SELECT * FROM customer WHERE id = ?";
		Object param = 1;
		//javabean内的属性必须和表里面的字段一致
		Customer cs = qr.query(sql, new BeanHandler<>(Customer.class), param);
		System.out.println(cs.getName());*/
		
		/*String sql = "SELECT * FROM customer";
		List<Customer> list = qr.query(sql, new BeanListHandler<Customer>(Customer.class));
		System.out.println(list);*/
		
		/*String sql = "SELECT * FROM customer WHERE id = ?";
		Object param = 1;
		Map<String, Object> map = qr.query(sql, new MapHandler(), param);
		System.out.println(map);*/
		
		/*String sql = "SELECT * FROM customer";
		List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
		System.out.println(list);*/
		/**
		 * Integer,Long,BigInteger
		 * 因为不同的数据库包的数据类型不同
		 */
		String sql = "SELECT COUNT(*) FROM customer";
		Number object = (Number)qr.query(sql, new ScalarHandler<>());
		int c = object.intValue();
		System.out.println(c);
	}
}
