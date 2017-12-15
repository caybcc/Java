package com.cyc.xml.dom4j;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Demo2 {
	public void XpathTest() throws DocumentException {
		SAXReader reader = new SAXReader();
		
		Document document = reader.read(new File("book.xml"));
		Node node = document.selectSingleNode("//author");
		String author = node.getStringValue();
		System.out.println(author);
	}
	
	@Test
	public void test() throws DocumentException {
		XpathTest();
	}
}
