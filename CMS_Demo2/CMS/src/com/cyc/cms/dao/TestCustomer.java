package com.cyc.cms.dao;

import org.junit.Test;

import com.cyc.cms.domain.Customer;
import com.cyc.tools.utils.CommonUtils;

public class TestCustomer {
	private CustomerDao customerDao = new CustomerDao();
	
	@Test
	public void batchAddCustomer() {
		Customer customer = null;
		String[] prefix = {"18", "15", "13"};
		String[] endfix = {"qq.com", "gmail.com", "163.com", "yhoo.com", "sina.com", "outlook.com"};
		for (int i = 1; i <= 200; i++) {
			customer = new Customer();
			customer.setCid(CommonUtils.uuid());
			customer.setCname("csmt_" + cString(i));
			customer.setGender((i % 2 == 0)? "male" : "female");
			customer.setBirthday("199" + (int)Math.floor(Math.random() * 9) + 
					"-" + cString((int)Math.floor(Math.random() * 12)) + "-" + cString((int)Math.floor(Math.random() * 28)));
			customer.setCeilphone(prefix[(int) Math.floor(Math.random() * 2)] + (10000000 + (int)Math.floor(Math.random() * 9999999)));
			customer.setEmail(((int)Math.floor(9999 * Math.random()) + 10000) + "@" + endfix[(int) Math.floor(Math.random() * 5)]);
			customerDao.add(customer);
		}
	}
	
	public String cString(int num) {
		return (num < 10) ? ("0" + num) : ("" + num);
	}
}
