package com.cyc.mvcapp.dao;

import java.util.List;

import com.cyc.mvcapp.entity.Customer;

public interface CustomerDao {
	
	/**
	 * 模糊查询 返回满足条件的List
	 * @param cc ：封装了查询条件
	 * @return
	 */
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);
	
	/**
	 * 查询 返回 List
	 * @return
	 */
	public List<Customer> getAll();
	
	/**
	 * 修改
	 * @param customer
	 */
	public int save(Customer customer);
	
	/**
	 * 修改
	 * @param customer
	 */
	public int modify(Customer customer);
	
	/**
	 * 修改 更新时候的查询（根据id）显示
	 * @param id
	 */
	public Customer get(Integer id);
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 返回和name 相同的记录数
	 * @param name
	 * @return
	 */
	public long getCountWithName(String name);
	
}
