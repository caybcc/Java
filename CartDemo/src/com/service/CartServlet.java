package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ItemsDAO;
import com.entity.Cart;
import com.entity.Items;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart.do")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String action; //表示购物车动作：add,show, delete
	
	private ItemsDAO iDao = new ItemsDAO();
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("action") != null) {
			this.action = request.getParameter("action");
			
			//添加商品进入购物车
			if (action.equals("show")) {
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			} else if(action.equals("add")) {
				if (addToCart(request, response)) {
					PrintWriter out = response.getWriter();
					int id = Integer.parseInt(request.getParameter("id"));
					int number = Integer.parseInt(request.getParameter("num"));
					ItemsDAO itemsDAO = new ItemsDAO();
					Items item = itemsDAO.getItemsById(id);
					out.println("<h2 style='color:green;'>恭喜您，商品添加成功！</h2>");
					out.println("<p>您加入购物车的商品是:" + item.getName() + "</p>");
					out.println("<p>商品单价:" + item.getPrice() + "</p>");
					out.println("<p>添加数量:" + number + "</p>");
					out.println("<p><a href='cart.jsp'>查看购物车</a></p>");
				}
			} else if(action.equals("delete")) {
				if(deleteFromCart(request, response)) {
					response.sendRedirect("cart.jsp");
				}
			} else if(action.equals("buynow")) {
				PrintWriter out = response.getWriter();
				int id = Integer.parseInt(request.getParameter("id"));
				int number = Integer.parseInt(request.getParameter("num"));
				
				ItemsDAO itemsDAO = new ItemsDAO();
				Items item = itemsDAO.getItemsById(id);
				out.println("<h2 style='color:green;'>恭喜您，购买成功！</h2>");
				out.println("<p>您购买的商品是:" + item.getName() + "</p>");
				out.println("<p>商品单价:" + item.getPrice() + "</p>");
				out.println("<p>购买数量:" + number + "</p>");
				out.println("<p>总共消费: ￥" + (item.getPrice() * number) + "</p>");
				
			}
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		processRequest(request, response);
	}
	
	//添加商品进入购物车
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String number = request.getParameter("num");
		Items item = iDao.getItemsById(Integer.parseInt(id));
		
		//是否是第一次给购物车添加商品，需要给session中创建一个新的购物车对象
		if (request.getSession().getAttribute("cart") == null) {
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		//不是第一次添加进入购物车
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		
		if (cart.addGoodsInCart(item, Integer.parseInt(number))) {
			request.getSession().setAttribute("cart", cart);
			return true;
		} else {
			return false;
		}
	}
	
	//从购物车中删除商品
	private boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		Items item = iDao.getItemsById(Integer.parseInt(id));
		
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart.removeGoodsFromCart(item)) {
			if(cart.getGoods().size() == 0) {
				cart = null;
				request.getSession().setAttribute("cart", cart);
			}
			return true;
		} else {
			return false;
		}
	}

}
