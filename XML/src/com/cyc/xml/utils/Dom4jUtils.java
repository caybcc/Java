package com.cyc.xml.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class Dom4jUtils {
	private static String PATH;
	
	public static void setXMLPath(String path) {
		Dom4jUtils.PATH = path;
	}
	
	public static Document getDocument() {
		Document document = null;
		
		try {
			
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(PATH);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage(), e);
		}
		
		
		return document;
		
	}
	
	public static void write2Xml(Document document) {
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = null;
		try {
			xmlWriter = new XMLWriter(new OutputStreamWriter(new FileOutputStream(PATH)), format);
			xmlWriter.write(document);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			try {
				xmlWriter.close();
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
	}
}
