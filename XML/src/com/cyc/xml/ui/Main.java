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
		System.out.println("���ѧ����a����ɾ��ѧ����d��������ѧ����f�����˳���e��");
		
		System.out.println("�������������:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String type = "";
		while((type = br.readLine()) != null)
		try {
			
			if ("a".equals(type)) {
				System.out.println("������ѧ��������");
				String name = br.readLine();
				System.out.println("������ѧ��׼��֤�ţ�");
				String examid = br.readLine(); 
				System.out.println("������ѧ�����֤�ţ�");
				String idcard = br.readLine();
				System.out.println("������ѧ�����ڵأ�");
				String location = br.readLine();
				System.out.println("������ѧ���ɼ���");
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
				System.out.println("������Ҫɾ����ѧ������:");
				String name = br.readLine();
				
				try {
					StudentDao dao = new StudentDao();
					dao.delete(name);
					System.out.println("ɾ���ɹ���");
				} catch (Exception e) {
					// TODO: handle exception
					throw new StudentDaoException("Ҫɾ�����û������ڣ�");
				}
				
			} else if("f".equals(type)) {
				System.out.println("������ѧ��׼��֤�ţ�");
				String examid = br.readLine(); 
				StudentDao dao = new StudentDao();
				Student s = dao.find(examid);
				System.out.println("������" + s.getName());
				System.out.println("סַ��" + s.getLocation());
				System.out.println("�ɼ���" + s.getGrade());
			} else if ("e".equals(type)) {
				System.exit(0);
			} else {
				System.out.println("��֧�����Ĳ�����");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�Բ����������!");
		}
		
	}

}
