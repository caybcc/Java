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
			throw new RuntimeException("您没有传递Method参数，无法正确调用你所要的方法！");
		}
		
		//反射实现
		Class clazz = this.getClass();
		Method method;
		try {
			//getDeclaredMethod可以调用所有权限修饰符声明的方法
			method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
		}  catch (Exception e) {
			throw new RuntimeException("你要调用的方法：" + methodName + "(HttpServletRequest request, HttpServletResponse response)不存在!");
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
					throw new RuntimeException("您指定的操作无效！");
				}
				
			} else {
				//没有冒号默认转发
				req.getRequestDispatcher(result).forward(req, resp);
			}
			
		} catch (Exception e) {
			System.out.println("您调用的方法：" + methodName + "(HttpServletRequest request, HttpServletResponse response)它内部抛出了异常！");
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
