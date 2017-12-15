package com.cyc.xml.mode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySaxHandler extends DefaultHandler {
	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private String content;

	//当解析到开始标签是触发
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if ("article".equals(qName)) {
			System.out.println("\r\nfind a article, It's category is " +attributes.getValue("category") + ".");
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if ("title".equals(qName)) {
			System.out.println("Title: " + qName);
		} else if ("author".equals(qName)) {
			System.out.println("Author: " + content);
		} else if ("email".equals(qName)) {
			System.out.println("Email: " + content);
		} else if ("body".equals(qName)) {
			System.out.println("Date: " + content);
		}
	}

	//事件发生时元素当中的字符
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		content = new String(ch, start, length);
	}
	
	
}
