package com.cyc.xml.dom4j.test;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import com.cyc.xml.dom4j.dao.BookDao;
import com.cyc.xml.dom4j.domain.Book;

public class TestDemo {
	@Test
	public void test() throws ParseException {
		/*Book book = new Book();
		book.setAuthor("���");
		book.setDate(new SimpleDateFormat("yy-mm-dd").parse("2017-09-03"));
		book.setPrice("88.99");
		book.setTitle("ʫ��ʫѡ");
		
		new BookDao().addBook(book);*/
//		new BookDao().delBook("ʫ��ʫѡ");
		List<Book> list = new BookDao().findAllBook();
		System.out.println(list);
	}
	
	
}
