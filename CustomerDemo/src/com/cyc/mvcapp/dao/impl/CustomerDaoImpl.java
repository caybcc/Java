package com.cyc.mvcapp.dao.impl;

import java.util.List;

import com.cyc.mvcapp.dao.CriteriaCustomer;
import com.cyc.mvcapp.dao.CustomerDao;
import com.cyc.mvcapp.dao.Dao;
import com.cyc.mvcapp.entity.Customer;

public class CustomerDaoImpl extends Dao<Customer> implements CustomerDao {

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		// TODO Auto-generated method stub
		String sql = "SELECT id, name, address, phone FROM customer WHERE name LIKE ? AND " + "address LIKE ? AND phone LIKE ?";
		//注意：修改了 CriteriaCustomer 的 getter 方法，使其返回的字符串中有 "%%",
		//若返回值为 null 则返回 "%%" ,若不为 null， 则返回 "% " + 字段本身的值 + " %"
		return getForList(sql, cc.getName(), cc.getAddress(), cc.getPhone());
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROOM customer;";
		return getForList(sql);
	}

	@Override
	public int save(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO customer(name, address, phone) values(?, ?, ?)";
		return update(sql, customer.getName(), customer.getAddress(), customer.getPhone());
	}

	@Override
	public Customer get(Integer id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM customer WHERE id = ?";
		return get(sql, id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM customer WHERE id = ?";
		update(sql, id);
	}

	@Override
	public long getCountWithName(String name) {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(id) FROM customer WHERE name = ?";
		return getForValue(sql, name);
	}

	
	public int modify(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "UPDATE customer SET name = ?, address = ?, phone = ? WHERE id = ?";
		return update(sql, customer.getName(), customer.getAddress(), customer.getPhone(), customer.getId());
	}

}
