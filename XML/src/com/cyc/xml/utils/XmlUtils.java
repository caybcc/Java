package com.cyc.xml.utils;

import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XmlUtils {
	private static String filename = "exam.xml";
	public static Document getDocument() {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document document= null;
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			document = db.parse(filename);
		} catch(Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage(), e);
		}
		return document;
	}
	
	public static void write2Xml(Document document) {
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			Transformer tf = factory.newTransformer();
			tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream(filename)));
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
