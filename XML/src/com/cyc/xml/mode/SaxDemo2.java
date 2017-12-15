package com.cyc.xml.mode;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.cyc.xml.bean.Article;

public class SaxDemo2 {
	public static void testSax() throws ParserConfigurationException, SAXException, IOException {
		//1.创建解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//2.获取解析器
		SAXParser sp = factory.newSAXParser();
		
		sp.parse(new File("article.xml"), new BeanListHandler());
	}
}

//得到xml文档所有内容
class BeanListHandler extends DefaultHandler {
	
	private static List<Article> list = new ArrayList<>();
	private String content;
	private Article article;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		// TODO Auto-generated method stub
		if ("article".equals(qName)) {
			article = new Article();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		if ("title".equals(qName)) {
			article.setTitle(content);
		} else if ("author".equals(qName)) {
			article.setAhtuor(content);
		} else if ("email".equals(qName)) {
			article.setEmail(content);
		} else if ("date".equals(qName)) {
			try {
				article.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(content));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if("article".equals(qName)) {
			list.add(article);
			article = null;
		}
		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		content = new String(ch, start, length);
	}
	
	public static List<Article> getList() {
		return list;
	}
}
