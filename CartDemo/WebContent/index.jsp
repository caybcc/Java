<%@ page import="com.entity.Items" %>
<%@ page import="com.dao.ItemsDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表页面</title>
<style>
	body {
		text-align: center;
	}
	
	div {
		padding-left: 5%;
		padding-right: 5%;
	}
	
	ul, li {
		list-style-type:none;
		float:left;
	}
	
	ul li {
		margin-bottom: 1%;
	}
	
	div h2 {
		display: inline;
	}
	
	span a, li a {
		text-decoration: none;
	}
	
	a img {
		border-color: #e5e5e5;
	}
	
	a img:hover {
		border-color: red;
	}
</style>
</head>

<body>
	<div>
		<h2>商品展示</h2>
		<ul>
		<%
			ItemsDAO itemsDao = new ItemsDAO(); 
		    ArrayList<Items> list = itemsDao.getAllItems();
		    if(list != null && list.size() > 0) {
		    	for(int i = 0; i < list.size(); i++) {
		    		Items item = list.get(i);
		    	
		%>
			<li>
				<a href="details.jsp?id=<%=item.getId() %>">
					<img src="images/<%=item.getPicture() %>" border="1" />
				</a>
				<br />
				<span><a href="details.jsp?id=<%=item.getId() %>"><%=item.getName() %></a></span>
				<br />
				<span>产地：<%=item.getCity() %>&nbsp;&nbsp;价格：￥<%=item.getPrice() %></span>
			</li>
		
		<%
		    	}
		    }
		%>
		</ul>
	</div>
	
	
</body>
</html>