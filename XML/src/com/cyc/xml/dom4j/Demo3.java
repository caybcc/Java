package com.cyc.xml.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Demo3 {
	public void testUser(String username, String password) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("user.xml");
		
		Node node = document.selectSingleNode("//user[@username='" + username + "' and @password='" + password + "']");
		
		if (node == null) {
			System.out.println("用户名或密码错误!");
		} else {
			System.out.println("登录成功!");
		}
	}
	@Test
	public void test() throws Exception {
		testUser("carl", "13579");
	}
}
