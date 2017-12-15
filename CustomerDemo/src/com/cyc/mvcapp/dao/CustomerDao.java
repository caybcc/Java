package com.cyc.mvcapp.dao;

import java.util.List;

import com.cyc.mvcapp.entity.Customer;

public interface CustomerDao {
	
	/**
	 * ģ����ѯ ��������������List
	 * @param cc ����װ�˲�ѯ����
	 * @return
	 */
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);
	
	/**
	 * ��ѯ ���� List
	 * @return
	 */
	public List<Customer> getAll();
	
	/**
	 * �޸�
	 * @param customer
	 */
	public int save(Customer customer);
	
	/**
	 * �޸�
	 * @param customer
	 */
	public int modify(Customer customer);
	
	/**
	 * �޸� ����ʱ��Ĳ�ѯ������id����ʾ
	 * @param id
	 */
	public Customer get(Integer id);
	
	/**
	 * ɾ��
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * ���غ�name ��ͬ�ļ�¼��
	 * @param name
	 * @return
	 */
	public long getCountWithName(String name);
	
}
