package com.cyc.xml.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.cyc.xml.dao.StudentDao;
import com.cyc.xml.dao.StudentDaoException;
import com.cyc.xml.domain.Student;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("添加学生（a）、删除学生（d）、查找学生（f）、退出（e）");
		
		System.out.println("请输入操作类型:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String type = "";
		while((type = br.readLine()) != null)
		try {
			
			if ("a".equals(type)) {
				System.out.println("请输入学生姓名：");
				String name = br.readLine();
				System.out.println("请输入学生准考证号：");
				String examid = br.readLine(); 
				System.out.println("请输入学生身份证号：");
				String idcard = br.readLine();
				System.out.println("请输入学生所在地：");
				String location = br.readLine();
				System.out.println("请输入学生成绩：");
				String grade = br.readLine();
				
				Student s = new Student();
				s.setExamid(examid);
				s.setGrade(Double.parseDouble(grade));
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setName(name);
			
				StudentDao dao = new StudentDao();
				dao.add(s);
			} else if("d".equals(type)) {
				System.out.println("请输入要删除的学生姓名:");
				String name = br.readLine();
				
				try {
					StudentDao dao = new StudentDao();
					dao.delete(name);
					System.out.println("删除成功！");
				} catch (Exception e) {
					// TODO: handle exception
					throw new StudentDaoException("要删除的用户不存在！");
				}
				
			} else if("f".equals(type)) {
				System.out.println("请输入学生准考证号：");
				String examid = br.readLine(); 
				StudentDao dao = new StudentDao();
				Student s = dao.find(examid);
				System.out.println("姓名：" + s.getName());
				System.out.println("住址：" + s.getLocation());
				System.out.println("成绩：" + s.getGrade());
			} else if ("e".equals(type)) {
				System.exit(0);
			} else {
				System.out.println("不支持您的操作！");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("对不起，输入错误!");
		}
		
	}

}
