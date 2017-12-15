package com.cyc.xml.mode;

import java.io.File;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;

import org.w3c.dom.Document;

public class DomDemo {
	public static void DomTest() {
		File xmlFile = new File("article.xml");
		
		//声明一个DocumentBuilderFactory对象，通过单利模式创建
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		//声明一个DocumentBuilder对象
		try {
			
			db = dbf.newDocumentBuilder();//取得默认builder
			
			Document document = db.parse(xmlFile);//解析文件
			
			
			//获取根元素
			
			Element rootElement = document.getDocumentElement();
			System.out.println("Root Element: " + rootElement.getNodeName());
			
			//获取根元素下面的子节点
			
			NodeList childNodes = rootElement.getChildNodes();
			
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node node = childNodes.item(i);
				
				if ("article".equals(node.getNodeName())) {
					System.out.println("\r\nfind a article, It's category is " + node.getAttributes().getNamedItem("category").getNodeValue());
					
					NodeList nodeDetail = node.getChildNodes();
					
					for (int j = 0; j < nodeDetail.getLength(); j++) {
						Node detail = nodeDetail.item(j);
						
						if ("title".equals(detail.getNodeName())) {
							System.out.println("Title: " + detail.getTextContent());
						} else if("author".equals(detail.getNodeName())) {
							System.out.println("author: " + detail.getTextContent());
						} else if("email".equals(detail.getNodeName())) {
							System.out.println("email: " + detail.getTextContent());
						} else if("date".equals(detail.getNodeName())) {
							System.out.println("date: " + detail.getTextContent());
						}
					}
				}
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
