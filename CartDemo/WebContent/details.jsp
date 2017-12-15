<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ItemsDAO"%>
<%@page import="com.entity.Items"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
      String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情页面</title>
<script type="text/javascript" src="scripts/jquery.min.js"></script>  
<script type="text/javascript" src="scripts/lhgcore.lhgdialog.min.js"></script>
<script type="text/javascript" src="scripts/lhgdialog.min.js?t=self&s=areo_blue"></script>
<script type="text/javascript">
 
  function selflog_show(id) {
	  var api = $.dialog({title: '购买结果！', width:360, height: 200, cover: true});
	  $.ajax({
		  type:"POST",
		  url:'cart.do?action=buynow',
		  data: {"id":id, "num": parseInt(document.getElementById("number").value)},
		  success:function(data) {
			  api.content(data);
		  },
		  cache: false
	  });
  }
  
  function selflog_add(id) {
	  var api = $.dialog({title: '添加结果！', width:360, height: 200, cover: true});
	  $.ajax({
		  type:"POST",
		  url:'cart.do?action=add',
		  data: {"id":id, "num": parseInt(document.getElementById("number").value)},
		  success:function(data) {
			  api.content(data);
		  },
		  cache: false
	  });
  }
  //商品数量增加
  function add() {
	  var num = parseInt(document.getElementById("number").value);
	  if (num < 100) {
		  document.getElementById("number").value = ++num;
	  }
  }
  //商品数量减少
  function sub() {
	  var num = parseInt(document.getElementById("number").value);
	  if (num > 1) {
		  document.getElementById("number").value = --num;
	  }
  }
</script>
<style>

body h2 {
	text-align: center;
}

div.tb-wrap {
	width: 1200px;
}

div.tb-wrap div.left {
	margin-top: 2.5%;
	margin-left: 8%;
	width: 25%;
	height: 90%;
	float: left;
	
}

div.left span img {
	border: 1px solid #e5e5e5;
}

div.tb-wrap div.right {
	margin-top: 2.5%;
	width: 48%;
	height: 90%;
	float: left;
}

div.tb-wrap div.history_goods {
	float: right;
	margin-top: -2%;
	
}

div.banner {
	width: 1200px;
	text-align: left;
	padding-bottom: 8px;
	margin-left: 8%;
}

div.ad {
	padding-bottom: 8px;
}

span.shop_name {
	font-size: 16px;
	font-weight: 700;
	line-height: 32px;
	font-family: "microsoft yahei";
}

span.shop_price {
	color: #999;
	font-size: 12px;
	text-align: left;
	width: 69px;
	padding-right: 30px;
}

span.shop_price_number {
	color: #FF0036;
	font-size: 24px;
	font-weight: bolder;
	vertical-align: middle;
}

span.shop_city {
	font-family: tahoma, arial, \5FAE\8F6F\96C5\9ED1, sans-serif;
	font-size: 12px;
}

span input {
	font-size: 12px;
	margin: 0;
	height: 26px;
	border: 1px solid #a7a6ac;
	width: 36px;
	background-position: -406px -41px;
	color: #666;
}

span.mui-amount-increase {
	margin-bottom: 3px;
}

span.mui-amount-increase, span.mui-amount-decrease {
	width: 16px;
	height: 12px;
	overflow: hidden;
	border: 1px solid #a7a6ab;
	display: block;
	font-family: tm-detail-font;
	line-height: 12px;
	font-size: 16px;
	cursor: pointer;
	text-align: center;
	text-vertical: middle;
}

span.amount-btn {
	display: inline-block;
	vertical-align: middle;
}

div.tb-btn-sku {
    margin-right: 10px;
    float: left;
}

div.tb-btn-sku a {
    margin-right: 0;
    float: left;
    overflow: hidden;
    position: relative;
    width: 172px;
    background-color: #ffeded;
    border: 1px solid #FF0036;
    color: #FF0036;
    font-family: 'Microsoft Yahei';
}

div.tb-btn-sku a {
    height: 38px;
    line-height: 38px;
    text-align: center;
    font-size: 16px;
    text-decoration: none;
}

div.div.tb-btn-basket img {
	text-vertical: middle;
}
div.tb-btn-basket a{
	background-color: #fc0036;
    border: 1px solid #ff0036;
    color: #fff;
}

div.banner strong, div.banner a, div.banner span {
	font-size: 12px;
	font-familly:tahoma,arial,'Hiragino Sans GB','\5b8b\4f53',sans-serif;
    font-weight: 400;
    text-decoration: none;
}



div.history_goods ul, div.history_goods li {
	list-style: none;
}

div.history_goods li {
	width: 160px;
	text-align: cenetr;
	vertical-align: middle;
	border: 1px solid #e5e5e5;
	margin-bottom: 4px;
}

div.history_goods li span {
	display: block;
	text-align: center;
	font-size: 12px;
}

div.history_goods li img {
	width: 140px;
	height: 140px;
}

div.history_goods p {
	font-size: 12px;
	text-align: center;
}
</style>
</head>
<body>

	<h2>商品详情页</h2>
	<%
		ItemsDAO itemDao = new ItemsDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		Items item = itemDao.getItemsById(id);
		if(item != null)
	%>
	<div class="banner">
		<strong>您的位置: </strong><a href="index.jsp">首页</a> > <span>商品详情</span>
	</div>
	<div class="tb-wrap">
		<div class="left">
			<span> <img src="images/<%=item.getPicture() %>" />
			</span>
		</div>
		<div class="right">
			<div>
				<span class="shop_name"><%=item.getName() %></span>
			</div>
			<div>
				<span class="shop_price">价格</span><span class="shop_price_number">￥<%=item.getPrice() %></span>
			</div>
			<div class="ad">
				<span class="shop_price">产地</span>&nbsp;<span class="shop_city"><%=item.getCity() %></span>
			</div>
			<div>
				<span class="shop_price">数量</span> <span class="btn-wrap"> <input id="number"
					type="text" class="tb-text mui-amount-input" value="1"
					maxlength="8" title="请输入购买量" /> <span class="amount-btn"> <span
						class="mui-amount-increase" onclick="add();">+</span> <span
						class="mui-amount-decrease" onclick="sub();">-</span>
				</span> <span class="shop_price">件</span>
				</span>
			</div>
			<br />
			<div>
				<div class="tb-btn-buy tb-btn-sku">
					<a id="J_LinkBuy" href="javascript:selflog_show(<%=item.getId() %>)" title="点击此按钮，到下一步确认购买信息。" >立即购买</a>
				</div>

				<div class="tb-btn-basket tb-btn-sku">
					<a href="javascript:selflog_add(<%=item.getId() %>)" rel="nofollow" id="J_LinkBasket"><img style="vertical-align:middle;" src="images/cart.png" /><span style="vertical-align:middle">加入购物车</span></a>
				</div>
				
				<div class="tb-btn-basket tb-btn-sku">
					<a href="cart.do?action=show" rel="nofollow" id="J_LinkBasket"><img style="vertical-align:middle;" src="images/cart_full.png" /><span style="vertical-align:middle">购物车详情</span></a>
				</div>
			</div>
		</div>
		<%
			String list = "";
			//从客户端获取Cookies集合
			Cookie[] cookies = request.getCookies();
			
			//遍历Cookies集合
			if(cookies != null && cookies.length > 0) {
				for(Cookie cookie:cookies) {
					if (cookie.getName().equals("ListViewCookie")) {
						list = cookie.getValue();
					}
				}
			}
			
			//追加商品编号
			list += request.getParameter("id") + ",";
			
			//若浏览器记录超过1000条，清零
			String[] arr = list.split(",");
			if (arr != null && arr.length > 0) {
				if (arr.length >= 1000) {
					list= "";
				}
			}
			
			Cookie cookie = new Cookie("ListViewCookie", list);
			response.addCookie(cookie);
		%>
	
		<div class="history_goods">
		  <p>您浏览过的商品：</p>
		  <div>
		    <ul>
		    <%
		    LinkedHashSet<Items> itemList = itemDao.getViewList(list);
		   		if(itemList != null && itemList.size() > 0) {
		   			System.out.println("itemlist.size = " + itemList.size());
		   			for(Items i:itemList) {
		    %>
		    	<li>
		    	   <span><img src="images/<%=i.getPicture() %>" /></span>
		    	   <span><a href="?id=<%=i.getId()%>"><%=i.getName() %></a></span>
		    	   <span>产地：<%=i.getCity() %></span>
		    	   <span>价格：￥<%=i.getPrice() %></span>
		    	</li>
		    <%
		   			}
		   		}
		    %>
		    </ul>
		  </div>
		</div>
	</div>
	
</body>
</html>