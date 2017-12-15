<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.entity.Items"%>
<%@page import="java.util.Set"%>
<%@page import="com.entity.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
<style>
    div#header {
   		margin-left: 20%; 
    }
   
    div#header div, div#header h1 {
    	float: left;
    }
    
    div#header h1 {
    	margin-left: 10%;
    	font-style: italic;
    }
    
	div.wrap {
		margin-left: 20%;
		clear: both;
	}
    div#crumbs{
    	margin: auto;
    	padding: auto;
    }
	div#crumbs strong, div#crumbs span {
		font-weight: 400;
		font-size: 12px;
		text-align: left;
	}
	div#empty {
		padding: 88px 0 100px 156px;
    	background: url(images/cart-demo.png) no-repeat 40px 86px;
    	position: relative;
    	
	}
	
	div#empty a{
		font-size: 12px;
		text-decoration: none;
	}
	
	table.tb1 {
		border-collapse: separate;
		width: 70%;
		border-spacing: 0px 4px
	}
	
	table.tb1 tr.goods {
		border: 1px solid #ccc;
		background: #fcfcfc;
		border-spacing: 10px;
	}
	
	table.tb1 tr.goods td span a {
		vertical-align: top;
		font-size: 12px;
		color: black;
		text-decoration: none;
	}
	
	table.tb1 tr.goods td span a:hover {
		color: #f40;
		text-decoration: underline;
	}
	
	table.tb1 tr.goods td{
		text-align: center;
		padding-top: 12px;
		padding-bottom: 12px;
	}
	
	table.tb1 tr th {
		font-size: 12px;
		color: #3c3c3c;
		padding-top: 12px;
		padding-bottom: 12px;
	}
	
	span.goods_price {
		color: #3c3c3c;
    	font-weight: 700;
    	font-family: Verdana,Tahoma,arial;
    	font-size: 13px;
	}
	
	span.goods_total_price {
		font-style: normal;
		color: #f40;
   		font-weight: 700;
   		font-size: 13px;
	}
	
	a.delete {
		font-size: 12px;
		color: black;
		text-decoration: none;
	}
	
	a.delete:hover {
		text-decoration: underline;
		color: #f40;
	}
	
	span.all_selected {
		font-size: 12px;
	}
	
	em.num {
		color: #f40;
	    font-weight: 700;
	    font-size: 18px;
	    font-family: tohoma,arial;
	}
	
	em.cal {
		font-weight: 700;
    	font-size: 22px;
    	color: #f40;
    	font-family: tohoma,arial;
	}
	
	table.tb2 {
		width: 70%;
		background-color: #e5e5e5;
		padding: 0px;
		margin: 0px;
		border-collapse:collapse;
		height: 50px;
	}
	
	
	
	table.tb2 tr td {
		vertical-align: middle;
		height: 10px;
	}
	
	table.tb2 tr td span {
		font-size: 12px;
		vertical-align: middle;
	}
	
	
	a.submit_btn {
		background: #B0B0B0;
	    color: #fff;
	    border-left: 1px solid #e7e7e7;
	    width: 119px;
	    cursor: not-allowed;
	    text-decoration: none;
	    text-align: center;
    	font-family: 'Lantinghei SC','Microsoft Yahei';
    	font-size: 20px;
    	display: block;
    	height: 50px;
    	line-height: 50px;
    	width: 100%;
	}
	
	span.sp {
		display: block;
	}
</style>
</head>
<body>
	<div id="header">
		<div><img src="images/logo.png" alt="" /></div>
		<h1><span>Happy Shopping</span></h1>
	</div>
	<div class="wrap">
		<div id="crumbs">
			<strong>您的位置：</strong><span><a href="index.jsp">首页</a></span> > <span>我的购物车</span>
		</div>
<%
  	if(session.getAttribute("cart") != null){
%>
		<div>
			<table class="tb1">
				<tr>
					<th>&nbsp;&nbsp;</th>
					<th>商品信息</th>
					<th>单价</th>
					<th>数量</th>
					<th>金额</th>
					<th>操作</th>
				</tr>
				<%
					Cart cart = (Cart)session.getAttribute("cart");
					HashMap<Items, Integer> goods = cart.getGoods();
					Set<Items> items = goods.keySet();
					Iterator<Items> itemsIterator = items.iterator();
					while(itemsIterator.hasNext()) {
						Items item = itemsIterator.next();
				%>
				<tr class="goods">
					<td width="5%"><input type="checkbox" name="items" /></td>
					<td width="30%"><img src="images/<%=item.getPicture() %>" width="80px" height="80px" /><span><a href="details.jsp?id=<%=item.getId()%>"><%=item.getName() %></a></span></td>
					<td width="20%"><span class="goods_price">￥<%=item.getPrice() %></span></td>
					<td width="20%"><span style="font-size: 12px;"><%=goods.get(item) %></span></td>
					<td width="15%"><span class="goods_total_price">￥<%=item.getPrice()*goods.get(item) %></span></td>
					<td width="10%"><a class="delete" href="cart.do?action=delete&id=<%=item.getId()%>">删除</a></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
		<div class="bar-wrap">
			<table class="tb2">
				<tr>
					<td><input type="checkbox" name="items" /><span class="all_selected">全选</span></td>
					<td><span><a class="delete" href="/cart.do?action=delete">删除</a></span></td>
					<td width="40%"><span class="sp"></span></td>
					<td align="right" width="16%"><span>已选商品<em class="num">0</em>件</span></td>
					<td align="right"><span>合计：<em class="cal">0.00</em></span></td>
					<td width="15%"><a class="submit_btn">结算</a></td>
				</tr>
			</table>
		</div>
<%
  	} else {
%>		<div id="empty">
			<h2 style="font: 700 14px / 20px arial;">您的购物车还是空的，赶紧行动吧！</h2>
			<a href="index.jsp">商品列表</a>
		</div>
<%
  	}
%>
	</div>
</body>
</html>