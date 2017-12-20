package com.cyc.tools.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		// TODO Auto-generated method stub
		String methodName = req.getParameter("method");
		
		if (methodName == null || methodName.isEmpty()) {
			throw new RuntimeException("��û�д���Method�������޷���ȷ��������Ҫ�ķ�����");
		}
		
		//����ʵ��
		Class clazz = this.getClass();
		Method method;
		try {
			//getDeclaredMethod���Ե�������Ȩ�����η������ķ���
			method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
		}  catch (Exception e) {
			throw new RuntimeException("��Ҫ���õķ�����" + methodName + "(HttpServletRequest request, HttpServletResponse response)������!");
		}
		
		try {
			String result = (String) method.invoke(this, req, resp);
			
			if (result == null || result.isEmpty()) {
				return ;
			}

			if (result.contains(":")) {
				int index = result.indexOf(":");
				String prefix = result.substring(0, index);
				String endfix = result.substring(index + 1);
				
				if (prefix.equalsIgnoreCase("r")) {
					resp.sendRedirect(endfix);
				} else if (prefix.equalsIgnoreCase("f")) {
					req.getRequestDispatcher(endfix).forward(req, resp);
				} else {
					throw new RuntimeException("��ָ���Ĳ�����Ч��");
				}
				
			} else {
				//û��ð��Ĭ��ת��
				req.getRequestDispatcher(result).forward(req, resp);
			}
			
		} catch (Exception e) {
			System.out.println("�����õķ�����" + methodName + "(HttpServletRequest request, HttpServletResponse response)���ڲ��׳����쳣��");
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
