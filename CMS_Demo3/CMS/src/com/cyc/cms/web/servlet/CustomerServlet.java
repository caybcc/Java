package com.cyc.cms.web.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyc.cms.domain.Customer;
import com.cyc.cms.domain.PageBean;
import com.cyc.cms.service.CustomerService;
import com.cyc.tools.servlet.BaseServlet;
import com.cyc.tools.utils.CommonUtils;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerService cs = new CustomerService();
       
	/**
	 * 添加客户
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer c = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		
		c.setCid(CommonUtils.uuid());
		
		cs.add(c);
		
		request.setAttribute("msg", "Congratuations! Add new customer successfully");
		
		return "f:/msg.jsp";
	}
	
	/**
	 * 查询所有客户
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到当前页
		int pc = getPc(request);
		
		//每页6行纪录
		int ps = 6;
		
		PageBean<Customer> pb = cs.findAll(pc, ps);
		
		request.setAttribute("pb", pb);
		
		return "f:/cslist.jsp";
	}
	
	private int getPc(HttpServletRequest request) {
		String value = request.getParameter("pc");
		if (value == null || value.trim().isEmpty()) {
			return 1;
		}
		return Integer.parseInt(value);
	}
	
	/**
	 * 根据cid显示相应的客户信息在表单页面当中
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String preEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cid = request.getParameter("cid");
		Customer customer = cs.load(cid);
		
		request.setAttribute("customer", customer);
		
		return "f:/update.jsp";
	}
	
	/**
	 * 处理修改客户的表单数据
	 * @param request
	 * @param response
	 * @return String
	 * @throws ServletException
	 * @throws IOException
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer c = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		c.setCname(new String(request.getParameter("cname").getBytes("ISO-8859-1"),"utf8"));
		cs.edit(c);
		
		request.setAttribute("msg", "Congratuations! edit old customer successfully");
		
		return "f:/msg.jsp";
	}
	
	/**
	 * 删除客户
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		cs.delete(cid);
		
		request.setAttribute("msg", "Congratuations! delete old customer successfully");
		
		return "f:/msg.jsp";
	}
	
	/**
	 * 根据条件查找客户数据信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		criteria = encoding(criteria);
		//得到当前页
		int pc = getPc(request);
		
		//每4行纪录
		int ps = 4;
		
		PageBean<Customer> pb = cs.query(criteria, pc, ps);
		pb.setUrl(getUrl(request));
		
		request.setAttribute("pb", pb);
		
		return "f:/aslist.jsp";
	}
	
	
	private String getUrl(HttpServletRequest request) {
		String servletPath = request.getServletPath();
		String contextPath = request.getContextPath();
		String queryPath = request.getQueryString();
		
		//不让保存上次的pc的值，直接在aslist.jsp当中添加
		if (queryPath.contains("&pc=")) {
			int index = queryPath.lastIndexOf("&pc=");
			queryPath = queryPath.substring(0, index);
		}
		
		return contextPath + servletPath + "?" + queryPath;
	}
	
	//处理GET方法编码问题
	private Customer encoding(Customer criteria) throws UnsupportedEncodingException {
		String cname = criteria.getCname();
		if (cname != null && !cname.trim().isEmpty()) {
			criteria.setCname(new String(cname.getBytes("ISO-8859-1"),"utf8"));
		}

		String gender = criteria.getGender();
		if (gender != null && !gender.trim().isEmpty()) {
			criteria.setGender(new String(gender.getBytes("ISO-8859-1"),"utf8"));
		}

		String ceilphone = criteria.getCeilphone();
		if (ceilphone != null && !ceilphone.trim().isEmpty()) {
			criteria.setCeilphone(new String(ceilphone.getBytes("ISO-8859-1"),"utf8"));
		}
		
		return criteria;
		
	}
}