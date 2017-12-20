package com.cyc.cms.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cyc.cms.domain.Customer;
import com.cyc.tools.txqr.TxQueryRunner;

public class CustomerDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 添加客户
	 * 
	 * @param c
	 */

	public void add(Customer c) {
		String sql = "INSERT INTO t_customer VALUES(?, ?, ?, ?, ?, ?)";
		Object[] params = { c.getCid(), c.getCname(), c.getGender(), c.getBirthday(), c.getCeilphone(), c.getEmail() };

		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}

	/**
	 * 查询所有客户
	 * 
	 * @return
	 */
	public List<Customer> findAll() {
		String sql = "SELECT * FROM t_customer";
		List<Customer> customers = null;

		try {
			customers = qr.query(sql, new BeanListHandler<Customer>(Customer.class));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		return customers;
	}

	/**
	 * 根据cid查找用户
	 * 
	 * @param cid
	 * @return
	 */
	public Customer load(String cid) {

		String sql = "SELECT * FROM t_customer WHERE cid = ?";
		Customer customer = null;

		try {
			customer = qr.query(sql, new BeanHandler<Customer>(Customer.class), cid);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		return customer;

	}

	public void edit(Customer c) {

		String sql = "UPDATE t_customer SET cname = ?, gender = ?, birthday = ?, ceilphone = ?, email = ? WHERE cid = ?";
		Object[] params = { c.getCname(), c.getGender(), c.getBirthday(), c.getCeilphone(), c.getEmail(), c.getCid() };

		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public void delete(String cid) {
		String sql = "DELETE FROM t_customer WHERE cid = ?";

		try {
			qr.update(sql, cid);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public List<Customer> query(Customer criteria) {
		StringBuilder sql = new StringBuilder("SELECT * FROM t_customer WHERE 1 = 1");
		List<Object> params = new ArrayList<>();
		String cname = criteria.getCname();
		if (cname != null && !cname.trim().isEmpty()) {
			sql.append(" AND cname LIKE ? ");
			params.add("%" + cname + "%");
		}

		String gender = criteria.getGender();
		if (gender != null && !gender.trim().isEmpty()) {
			sql.append(" AND gender = ? ");
			params.add(gender);
		}

		String ceilphone = criteria.getCeilphone();
		if (ceilphone != null && !ceilphone.trim().isEmpty()) {
			sql.append(" AND ceilphone LIKE ? ");
			params.add("%" + ceilphone + "%");
		}
		List<Customer> customers = null;

		try {
			customers = qr.query(sql.toString(), new BeanListHandler<Customer>(Customer.class), params.toArray());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		return customers;
	}
}
