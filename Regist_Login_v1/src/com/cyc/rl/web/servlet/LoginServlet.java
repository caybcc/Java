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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		UserService userService = new UserService();
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		
		Map<String, String> errors = new HashMap<>();
		
		String username = form.getUsername();
		if (username == null || username.trim().isEmpty()) {
			errors.put("username", "用户名不能为空！");
		} else if(username.length() < 3 || username.length() > 15) {
			errors.put("username", "用户名长度必须在3-15之间！");
		}
		
		String password = form.getPassword();
		if (password == null || password.trim().isEmpty()) {
			errors.put("password", "密码不能为空！");
		} else if(password.length() < 6 || password.length() > 15) {
			errors.put("password", "密码长度必须在6-15之间！");
		}
		
		String sess_vcode = (String) request.getSession().getAttribute("sess_vcode");
		String verifyCode = form.getVerifyCode();
		
		if (verifyCode == null || verifyCode.trim().isEmpty()) {
			errors.put("verifyCode", "验证码不能为空！");
		} else if(verifyCode.length() != 4) {
			errors.put("verifyCode", "验证码长度必须是4位！");
		} else if (!verifyCode.equalsIgnoreCase(sess_vcode)) {
			errors.put("verifyCode", "验证码错误！");
		}
		
		if (errors != null && errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.setAttribute("user", form);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return ;
		}
		
		try {
			User user = userService.login(form);
			
			request.getSession().setAttribute("sessUser", user);
			response.sendRedirect(request.getContextPath() + "/welcome.jsp");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			request.setAttribute("message", e.getMessage());
			request.setAttribute("user", form);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
