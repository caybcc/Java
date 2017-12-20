package com.cyc.cms.service;

import java.util.List;

import com.cyc.cms.dao.CustomerDao;
import com.cyc.cms.domain.Customer;
import com.cyc.cms.domain.PageBean;

public class CustomerService {
	CustomerDao cDao = new CustomerDao();
	
	/**
	 * 添加业务
	 * @param c
	 */
	public void add(Customer c) {
		cDao.add(c);
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Customer> findAll(){
		return cDao.findAll();
	}
	
	
	/**
	 * 根据id查找客户
	 * @param cid
	 * @return
	 */
	public Customer load(String cid) {
		return cDao.load(cid);
	}

	public void edit(Customer c) {
		// TODO Auto-generated method stub
		cDao.edit(c);
	}

	public void delete(String cid) {
		cDao.delete(cid);
	}

	public List<Customer> query(Customer criteria) {
		return cDao.query(criteria);
	}

	public PageBean<Customer> findAll(int pc, int ps) {
		// TODO Auto-generated method stub
		return cDao.findAll(pc, ps);
	}
}