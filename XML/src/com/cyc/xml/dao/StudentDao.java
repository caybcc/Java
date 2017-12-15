package com.cyc.xml.dao;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.w3c.dom.Document;

import com.cyc.xml.domain.Student;
import com.cyc.xml.utils.XmlUtils;

public class StudentDao {
	public void add(Student s) {
		Document document = XmlUtils.getDocument();
		
		//创建学生信息的标签
		Element student_tag = document.createElement("student");
		student_tag.setAttribute("idcard", s.getIdcard());
		student_tag.setAttribute("examid", s.getExamid());
		
		
		Element name = document.createElement("name");
		Element location = document.createElement("location");
		Element grade = document.createElement("grade");
		
		name.setTextContent(s.getName());
		location.setTextContent(s.getLocation());
		grade.setTextContent(s.getGrade() + "");
		
		student_tag.appendChild(name);
		student_tag.appendChild(location);
		student_tag.appendChild(grade);
		
		document.getElementsByTagName("exam").item(0).appendChild(student_tag);
		XmlUtils.write2Xml(document);
	}
	
	public Student find(String examid) {
		
		Student s = null;
		try {
			Document document = XmlUtils.getDocument();
			NodeList list = document.getElementsByTagName("student");
			
			for (int i = 0; i < list.getLength(); i++) {
				Element student = (Element) list.item(i);
				if (examid.equals(student.getAttribute("examid"))) {
					s = new Student();
					s.setExamid(examid);
					s.setIdcard(student.getAttribute("idcard"));
					s.setName(student.getElementsByTagName("name").item(0).getTextContent());
					s.setLocation(student.getElementsByTagName("location").item(0).getTextContent());
					s.setGrade(Double.parseDouble(student.getElementsByTagName("grade").item(0).getTextContent()));
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage(), e);
		}
		return s;
	}
	
	public void delete(String name) {
		try {
			Document document = XmlUtils.getDocument();
			NodeList list = document.getElementsByTagName("name");
			
			for (int i = 0; i < list.getLength(); i++) {
				if (list.item(i).getTextContent().equals(name)) {
					list.item(i).getParentNode().getParentNode().removeChild(list.item(i).getParentNode());
					XmlUtils.write2Xml(document);
					return ;
				}
			}
			throw new StudentDaoException("学生" + name + "不存在!");
		}catch (StudentDaoException e) {
			// TODO: handle exception
			throw e;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
