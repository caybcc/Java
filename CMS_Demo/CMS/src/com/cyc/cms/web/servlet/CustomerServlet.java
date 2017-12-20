package com.cyc.cms.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyc.cms.domain.Customer;
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
	 * ��ӿͻ�
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
	 * ��ѯ���пͻ�
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("customers", cs.findAll());
		
		return "f:/cslist.jsp";
	}
	
	/**
	 * ����cid��ʾ��Ӧ�Ŀͻ���Ϣ�ڱ�ҳ�浱��
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
	 * �����޸Ŀͻ��ı�����
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
	 * ɾ���ͻ�
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
	 * �����������ҿͻ�������Ϣ
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		
		List<Customer> customers = cs.query(criteria);
		
		request.setAttribute("customers", customers);
		
		return "f:/aslist.jsp";
	}
	
}