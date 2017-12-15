package com.cyc.xml.dom4j.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.cyc.xml.dom4j.domain.Book;
import com.cyc.xml.dom4j.utils.Dom4jUtils;

public class BookDao {
	private static final String PATH = "bookstore.xml";
	
	
	public void addBook(Book book) {
		
		Dom4jUtils.setXMLPath(PATH);
		Document document = Dom4jUtils.getDocument();
		Element root = document.getRootElement();
		Element book_tag = DocumentHelper.createElement("book");
		Element title_tag = DocumentHelper.createElement("title");
		title_tag.setText(book.getTitle());
		Element author_tag = DocumentHelper.createElement("author");
		author_tag.setText(book.getAuthor());
		Element date_tag = DocumentHelper.createElement("date");
		date_tag.setText((new SimpleDateFormat("yyyy-MM-dd")).format(book.getDate()));
		Element price_tag = DocumentHelper.createElement("price");
		price_tag.setText(book.getPrice());
		book_tag.add(title_tag);
		book_tag.add(author_tag);
		book_tag.add(date_tag);
		book_tag.add(price_tag);
		
		root.add(book_tag);
		
		Dom4jUtils.write2Xml(document);
		
	}
	
	public void delBook(String bookname) {
		Dom4jUtils.setXMLPath(PATH);
		Document document = Dom4jUtils.getDocument();
		List<Node> list = document.selectNodes("//title");
		
		for (Node node : list) {
			if(bookname.equals(node.getText())) {
				Element book = node.getParent();
				Element root = book.getParent();
				root.remove(book);
			}
		}
		Dom4jUtils.write2Xml(document);
	}
	
	
	public Book findBookByName(String bookname) throws ParseException {
		Dom4jUtils.setXMLPath(PATH);
		Document document = Dom4jUtils.getDocument();
		List<Node> list = document.selectNodes("//title");
		Book book = null;
		
		for (Node node : list) {
			if(bookname.equals(node.getText())) {
				Element book_tag = node.getParent();
				book = new Book();
				book.setAuthor(book_tag.element("author").getText());
				book.setDate((new SimpleDateFormat("yyyy-MM-dd")).parse(book_tag.element("date").getText()));
				book.setPrice(book_tag.element("price").getText());
				book.setTitle(book_tag.element("title").getText());
			}
		}
		return book;
	}
	
	public List<Book> findAllBook() throws ParseException {
		List<Book> list = new ArrayList<>();
		Book book = null;
		
		Dom4jUtils.setXMLPath(PATH);
		Document document = Dom4jUtils.getDocument();
		List<Node> list_node = document.selectNodes("//book");
		for (Node node : list_node) {
			book = new Book();
			Element book_tag = (Element) node;
			book.setAuthor(book_tag.element("author").getText());
			book.setTitle(book_tag.element("title").getText());
			book.setDate((new SimpleDateFormat("yyyy-MM-dd")).parse(book_tag.element("date").getText()));
			book.setPrice(book_tag.element("price").getText());
			list.add(book);
		}
		return list;
	}
}
