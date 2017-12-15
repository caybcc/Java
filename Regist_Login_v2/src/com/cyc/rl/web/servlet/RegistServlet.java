package com.cyc.rl.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyc.rl.domain.User;
import com.cyc.rl.service.UserException;
import com.cyc.rl.service.UserService;
import com.cyc.rl.utils.CommonUtils;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		UserService userService = new UserService();
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		
		Map<String, String> errors = new HashMap<>();
		
		String username = form.getUsername();
		if (username == null || username.trim().isEmpty()) {
			errors.put("username", "�û�������Ϊ�գ�");
		} else if(username.length() < 3 || username.length() > 15) {
			errors.put("username", "�û������ȱ�����3-15֮�䣡");
		}
		
		String password = form.getPassword();
		if (password == null || password.trim().isEmpty()) {
			errors.put("password", "���벻��Ϊ�գ�");
		} else if(password.length() < 6 || password.length() > 15) {
			errors.put("password", "���볤�ȱ�����6-15֮�䣡");
		}
		
		String sess_vcode = (String) request.getSession().getAttribute("sess_vcode");
		String verifyCode = form.getVerifyCode();
		
		if (verifyCode == null || verifyCode.trim().isEmpty()) {
			errors.put("verifyCode", "��֤�벻��Ϊ�գ�");
		} else if(verifyCode.length() != 4) {
			errors.put("verifyCode", "��֤�볤�ȱ�����4λ��");
		} else if (!verifyCode.equalsIgnoreCase(sess_vcode)) {
			errors.put("verifyCode", "��֤�����");
		}
		
		if (errors != null && errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.setAttribute("user", form);
			request.getRequestDispatcher("regist.jsp").forward(request, response);
			return ;
		}
		
		try {
			userService.regist(form);
			String message = "<h1>ע��ɹ���</h1><a href='" + request.getContextPath() + "/login.jsp'>�����¼</a>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			request.setAttribute("message", e.getMessage());
			request.setAttribute("user", form);
			request.getRequestDispatcher("regist.jsp").forward(request, response);
		}
		
	}

}
