<%@page import="com.cyc.cms.domain.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
		<link href="bootstrap-3.3.7/css/font-awesome.min.css" rel="stylesheet" />
		<script src="bootstrap-3.3.7/js/jquery.js"></script>
		<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript">
	        $(document).ready(function(){
	            $(".delete").click(function(e){
	            	e.preventDefault();
	                var content = $(this).parent().parent().find("td:eq(1)").text();
	                var flag = confirm("确定要删除 " + content + " 的信息吗？");
	                if(flag) {
	                	window.location.href = $(this).attr("href");
	                }
	            });
	            
	            $("li.disabled").children("a").click(function(e) {
	            	e.preventDefault();
	            	alert($(this).data("tip"));
	            });
	        });
		</script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Query Page</title>
	</head>
	<body style="overflow-x:hidden;">
		<div class="container" style="width:900px;">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-*" style="text-align:center;"><h4><i class="icon icon-search"></i>Query Page</h4></div>
				<div class="col-md-1"></div>
			</div>
			
			<div class="row">
				<div class="col-md-1">	
				</div>
				<div class="col-md-10">
					
							<table class="table table-hover table-bordered table-striped" style="margin:auto;">
								<tr>
									<th>Cid</th>
									<th>Cname</th>
									<th>Gender</th>
									<th>Birthday</th>
									<th>Ceilphone</th>
									<th>Email</th>
									<th>Operate</th>
								</tr>
								
								<c:forEach items="${pb.beanList}" var="customer" varStatus="vst">
									<tr>
										<td>${vst.index + (pb.pc - 1) * pb.ps + 1}</td>
										<td>${customer.cname}</td>
										<td><c:if test="${customer.gender eq 'male'}">男</c:if><c:if test="${customer.gender eq 'female'}">女</c:if></td>
										<td>${customer.birthday}</td>
										<td>${customer.ceilphone}</td>
										<td>${customer.email}</td>
										<td>
											<a href='<c:url value="CustomerServlet?method=preEdit&cid=${customer.cid}" />'><i class="icon icon-edit"></i></a>&nbsp;&nbsp;
											<a href='<c:url value="CustomerServlet?method=delete&cid=${customer.cid}" />' class="delete"><i class="icon icon-trash"></i></a>
										</td>
									</tr>
								</c:forEach>
							</table>
				</div>
				<div class="col-md-1">
					
				</div>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<ul class="pagination col-md-8">
				    <c:choose>
				    	<%-- 若总页数不足10页 --%>
				    	<c:when test="${pb.tp <= 10}">
				    		<c:set var="begin" value="1" />
				    		<c:set var="end" value="${pb.tp}" />
				    	</c:when>
				    	<%-- 头溢出和尾溢出 --%>
				    	<c:otherwise>
				    		<c:set var="begin" value="${pb.pc - 5}" />
				    		<c:set var="end" value="${pb.pc + 4}" />
				    		
				    		<c:if test="${begin < 1}">
				    			<c:set var="begin" value="1" />
				    		    <c:set var="end" value="10" />
				    		</c:if>
				    		<c:if test="${end > pb.tp}">
				    			<c:set var="begin" value="${pb.tp - 9}" />
				    		    <c:set var="end" value="${pb.tp}" />
				    		</c:if>
				    	</c:otherwise>
				    </c:choose>
				    <li><a href="CustomerServlet?method=findAll&pc=1">First</a></li>
				    <li <c:if test="${pb.pc <= 1}">class="disabled"</c:if>><a href="CustomerServlet?method=findAll&pc=${pb.pc-1}" data-tip="已经是第一页">&laquo;</a></li>
				    
				    <c:forEach var="i" begin="${begin}" end="${end}">
    					<li <c:if test="${i eq pb.pc}">class="active"</c:if>><a href="CustomerServlet?method=findAll&pc=${i}">${i}</a></li>
				    </c:forEach>
				    
				    <li <c:if test="${pb.pc >= pb.tp}">class="disabled"</c:if>><a href="CustomerServlet?method=findAll&pc=${pb.pc+1}" data-tip="已经是最后一页">&raquo;</a></li>
				    
				    <li><a href="CustomerServlet?method=findAll&pc=${pb.tp}">End</a></li>
			
				</ul>
				<div class="col-md-2"></div>
				
			</div>
		</div>
	</body>
</html>