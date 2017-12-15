package com.cyc.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyc.mvcapp.dao.CriteriaCustomer;
import com.cyc.mvcapp.dao.CustomerDao;
import com.cyc.mvcapp.dao.impl.CustomerDaoImpl;
import com.cyc.mvcapp.entity.Customer;

/**
 * Servlet implementation class CustomerServlet
 */

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerDao customerDao = new CustomerDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1、获取servletPath
		String servletPath = request.getServletPath();
		//System.out.println(servletPath);  //得到的是  /addCustomer.do
		
		//2、去除 / 和 .do ,得到 addCustomer 这样的字符串
		String methodName = servletPath.substring(1);
		if (methodName.indexOf('?') == -1) {
			methodName = methodName.substring(0, methodName.length()-3);
		}  else {
			int index = methodName.indexOf('?');
			methodName = methodName.substring(0, index - 3);
		}
		
		
//		System.out.println(methodName);  // 得到的是 addCustomer
		
		//3、利用反射，根据获取的 方法名，获取对应的方法。
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			
			//4、利用反射调用对应的方法  
			method.invoke(this, request, response);
			
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			//可以有一些响应
			response.sendRedirect("error.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
		
	}

	@SuppressWarnings("unused")
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		//1.获取ID
		String idStr = request.getParameter("id");
		System.out.println(idStr);
		int id = 0;
		
		//3. 页面重定向
		try {
			id = Integer.parseInt(idStr);
			
			//2. 调用CustomerDao的delete方法
			customerDao.delete(id);
			
			response.sendRedirect("/MVC_Demo1/query.do");
			return ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unused")
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取模糊查询的请求参数
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		System.out.println(name);
		//2. 把请求参数封装为 CriteriaCustomer 对象
		CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
		
		//3. 再调用CustomerDao 的 getForListWithCriteriaCustomer() 方法
		
		List<Customer> customers = customerDao.getForListWithCriteriaCustomer(cc);
		
		//调用CustomerDao 的 getAll() 方法 查询。
//		List<Customer> customers = customerDao.getAll();
		
		//4、把查询到的结果集放入 request 中
		request.setAttribute("customers", customers);
		
		//5.请求转发
		request.getRequestDispatcher("/cslist.jsp").forward(request, response);
	}
	
	@SuppressWarnings("unused")
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//1、需要添加客户的数据
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		if(name == null || name == "") {
		  response.sendRedirect("add.jsp");
		} else {
			//2. 把请求参数封装为 CriteriaCustomer 对象
			Customer cc = new Customer(null, name, address, phone);
			
			//3. 再调用CustomerDao 的 getForListWithCriteriaCustomer() 方法
			
			int affected_rows = customerDao.save(cc);
			String Message = "";
			String Link = "index.jsp";
			
			if(affected_rows == 0) {
				Message += "Add New Customer Failed!";
				request.setAttribute("Message", Message);
				request.setAttribute("Link", Link);
				request.getRequestDispatcher("/fail.jsp").forward(request, response);
			} else {
				Message += "Add New Customer Successfully!";
				request.setAttribute("Message", Message);
				request.setAttribute("Link", Link);
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			}
			
		}
		
		return ;
	}
	
	@SuppressWarnings("unused")
	private void modifyCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//1、需要添加客户的数据
		String idStr = request.getParameter("id");
		
		if (idStr != null) {
			int id = Integer.parseInt(idStr);
			//2. 再调用CustomerDao 的 get() 方法
			
			Customer customer = customerDao.get(id);
			
			request.setAttribute("customer", customer);
			
			request.getRequestDispatcher("/update.jsp").forward(request, response);
		} else {
			int cid = Integer.parseInt(request.getParameter("cid"));
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String Message = "";
			String Link = "query.do";
			if(name == "") {
				Message += "Update Customer Failed!";
			} else {
				//2. 把请求参数封装为 CriteriaCustomer 对象
				Customer cc = new Customer(cid, name, address, phone);
				
				//3. 再调用CustomerDao 的 getForListWithCriteriaCustomer() 方法
				
				int affected_rows = customerDao.modify(cc);
				
				if(affected_rows == 0) {
					Message += "Update Customer Failed!";
				} else {
					Message += "Update Customer Successfully!";
					request.setAttribute("Link", Link);
					request.setAttribute("Message", Message);
					request.getRequestDispatcher("/success.jsp").forward(request, response);
					return ;
				}
				
			}
			
			request.setAttribute("Message", Message);
			request.setAttribute("Link", Link);
			request.getRequestDispatcher("/fail.jsp").forward(request, response);
			return ;
		}
		
	}
	
}
