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
	 * ���û�����ѯ�û�
	 * @param username
	 * @return Object
	 */
	public User findByUsername(String username) {
		/**
		 * 1.�õ�Document
		 * 2.xpath��ѯ
		 * 3.У�����Ƿ�Ϊnull,���Ϊnull,����null
		 * 4.�����Ϊnull,��Ҫ��Element��װ��User������
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
	 * ����û�
	 * @param user
	 */
	public void add(User user) {
		/**
		 * 1.�õ�Document
		 * 2.ͨ��Document�õ�rootԪ��
		 * 3.ʹ�ò���user,ת��ElementԪ��
		 * 4.��element��ӵ�rootԪ�ص���
		 * 5.����Document
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
