package com.cyc.xml.dom4j;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Demo1 {
	public void read() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("book.xml");
		Element root = document.getRootElement();
		
		/*for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
			Element element = it.next();
			for (Iterator<Element> it1 = element.elementIterator("bookname"); it1.hasNext();) {
				Element element1 = it1.next();
				if ("MySQL从删库到跑路".equals(element1.getText())) {
					System.out.println(element1.getParent().elementIterator("bookname").next().getText());
					System.out.println(element1.getParent().elementIterator("author").next().getText());
					System.out.println(element1.getParent().elementIterator("price").next().getText());
					break;
				}
			}
		}*/
		
		Element book = root.elements("book").get(1);
		String bookname = book.element("bookname").getText();
		String author = book.elementText("author");
		String price = book.elementText("price");
		
		System.out.println("bookname:" + bookname + ", author:" + author + ", price" + price);
	}
	
	public void readAttr() throws DocumentException {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read("book.xml");
		Element root = document.getRootElement();

		Element book = root.elements("book").get(1);
		String bookname = book.element("bookname").getText();
		String type = book.element("bookname").attributeValue("type");
		
		System.out.println("bookname:" + bookname + ", type:" + type);
	}
	
	public void addNode() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("book.xml");
		Element root = document.getRootElement();
		Element book = root.element("book");
		book.addElement("price").setText("119");
		
		/*try {
			XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("book.xml"), "UTF-8"));
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		OutputFormat format = OutputFormat.createCompactFormat();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("book.xml"), format);
//		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("book.xml"), "UTF-8"), format);right
//		XMLWriter writer = new XMLWriter(new FileWriter("book.xml"), format);Encoding error(gb2312->utf-8)底层是字符流FileWriter默认查系统码表gb2312， 除非这个方法可以自己定义码表UTF-8
		writer.write(document);
		writer.close();
	}
	
	public void addNode1() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("book.xml");
		Element root = document.getRootElement();
		Element book = root.element("book");
		
		List<Element> list = book.elements();
		
		Element price = DocumentHelper.createElement("price");
		price.setText("119");
		
		list.add(2, price);
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("book.xml"), format);
//		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("book.xml"), "UTF-8"), format);right
//		XMLWriter writer = new XMLWriter(new FileWriter("book.xml"), format);Encoding error(gb2312->utf-8)底层是字符流FileWriter默认查系统码表gb2312， 除非这个方法可以自己定义码表UTF-8
		writer.write(document);
		writer.close();
	}
	
	
	
	public void deleteNode() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("book.xml");
		Element root = document.getRootElement();
		Element book = root.element("book");
		
		Element price = book.element("price");
		price.getParent().remove(price);
		
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("book.xml"), format);
//		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("book.xml"), "UTF-8"), format);right
//		XMLWriter writer = new XMLWriter(new FileWriter("book.xml"), format);Encoding error(gb2312->utf-8)底层是字符流FileWriter默认查系统码表gb2312， 除非这个方法可以自己定义码表UTF-8
		writer.write(document);
		writer.close();
		
	}
	
public void update() throws Exception {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read("book.xml");
		Element root = document.getRootElement();

		root.elements("book").get(1).element("author").setText("李默");
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("book.xml"), format);
//		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("book.xml"), "UTF-8"), format);right
//		XMLWriter writer = new XMLWriter(new FileWriter("book.xml"), format);Encoding error(gb2312->utf-8)底层是字符流FileWriter默认查系统码表gb2312， 除非这个方法可以自己定义码表UTF-8
		writer.write(document);
		writer.close();
	}
	
	@Test
	public void test() throws Exception {
		update();
	}
}
