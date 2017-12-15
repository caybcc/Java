package com.cyc.xml.mode;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.cyc.xml.bean.Article;

public class TestMode {
	@Test
	public void test() throws ParserConfigurationException, SAXException, IOException {
//		DomDemo.DomTest();
//		SaxDemo.testSax();
//		SaxDemo1.testSax();
		SaxDemo2.testSax();
		List<Article> list = BeanListHandler.getList();
		for (Article article : list) {
			System.out.println(article.getTitle());
			System.out.println(article.getAhtuor());
			System.out.println(article.getEmail());
			System.out.println(article.getDate());
		}
		
	}
}
