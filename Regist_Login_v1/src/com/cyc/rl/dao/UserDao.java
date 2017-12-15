package com.cyc.rl.dao;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import com.cyc.rl.domain.User;
import com.cyc.rl.utils.Dom4jUtils;

public class UserDao {
	private String path = "F:\\Java\\WorkSpace-JavaEE\\Regist_Login\\users.xml";
	
	/**
	 * 按用户名查询用户
	 * @param username
	 * @return Object
	 */
	public User findByUsername(String username) {
		/**
		 * 1.得到Document
		 * 2.xpath查询
		 * 3.校验结果是否为null,如果为null,返回null
		 * 4.如果不为null,需要把Element封装到User对象当中
		 */
		User user = null;
		Dom4jUtils.setXMLPath(path);
		Document document = Dom4jUtils.getDocument();
		
		List<Node> nodes = document.selectNodes("//user[@username='" + username + "']");
		
		for (Node node : nodes) {
			Element ele = (Element)node;
			if (ele != null) {
				user = new User();
				String attrUsername = ele.attributeValue("username");
				String attrPassword = ele.attributeValue("password");
				
				user.setPassword(attrPassword);
				user.setUsername(attrUsername);
			}
		}	
		
		return user;
	}
	

	/**
	 * 添加用户
	 * @param user
	 */
	public void add(User user) {
		/**
		 * 1.得到Document
		 * 2.通过Document得到root元素
		 * 3.使用参数user,转成Element元素
		 * 4.把element添加到root元素当中
		 * 5.保存Document
		 */
		Dom4jUtils.setXMLPath(path);
		Document document = Dom4jUtils.getDocument();
		Element root = document.getRootElement();
		
		Element userEle = root.addElement("user");
		userEle.addAttribute("username", user.getUsername());
		userEle.addAttribute("password", user.getPassword());
		/*userEle.attributes().get(0).setValue("Carl");
		userEle.attributes().get(1).setValue("32345");*/
		
		Dom4jUtils.write2Xml(document);
	}
	
}
