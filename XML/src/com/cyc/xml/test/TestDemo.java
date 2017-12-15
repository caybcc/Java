package com.cyc.xml.test;

import org.junit.Test;

import com.cyc.xml.dao.StudentDao;
import com.cyc.xml.domain.Student;

public class TestDemo {
	@Test
	public void testAdd() {
		StudentDao dao = new StudentDao();
		Student s = new Student();
		s.setExamid("555");
		s.setGrade(89);
		s.setIdcard("666");
		s.setLocation("海南");
		s.setName("小东");
		dao.add(s);
	}
	
	@Test
	public void testFind() {
		StudentDao dao = new StudentDao();
		String examid = "555";
		Student s = dao.find(examid);
		System.out.println(s.getName());
	}
	
	@Test
	public void testDelete() {
		StudentDao dao = new StudentDao();
		String name = "小东";
		dao.delete(name);
	}
}
