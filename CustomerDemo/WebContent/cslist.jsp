<%@page import="com.cyc.mvcapp.entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
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
	        });
		</script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Query Page</title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-*" style="text-align:center;"><h1>Query Page</h1></div>
				<div class="col-md-1"></div>
			</div>
			<br />
			<div class="row" style="padding-bottom:36px;">
				<div class="col-md-1"></div>
				<div class="col-md-10" style="padding-left:6%;">
					<form action="query.do" class="form-inline" role="form">
						<div class="form-group">
							<label for="name" class="control-label">Name</label>
							<input type="text" class="form-control" name="name" />
						</div>
						&nbsp;
						<div class="form-group">
							<label for="address" class="control-label">Address</label>
							<input type="text" class="form-control" name="address" />
						</div>
						&nbsp;
						<div class="form-group">
							<label for="phone" class="control-label">Phone</label>
							<input type="text" class="form-control" name="phone"/>
						</div>
						&nbsp;
						<div class="form-group">
							<label for="" class="sr-only">Query</label>
							<input type="submit" class="form-control btn btn-primary" />
						</div>
					</form>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row">
				<div class="col-md-1">	
				</div>
				<div class="col-md-10">
					<c:choose>
						<c:when test="${ customers != null and customers.size() != 0 }">
							<table class="table table-hover table-bordered table-striped" style="margin:auto;">
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Address</th>
									<th>Phone</th>
									<th>Update/Delete</th>
								</tr>
								<c:forEach items="${ customers }" var="customer"  >
									<tr>
										<td>${ customer.id }</td>
										<td>${ customer.name }</td>
										<td>${ customer.address }</td>
										<td>${ customer.phone }</td>
										<td>
											<a href='modifyCustomer.do?id=<c:out value="${customer.id }" />'>Update</a>&nbsp;&nbsp;
											<a href='delete.do?id=<c:out value="${customer.id }" />' class="delete">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</table>
							<div style="text-align:center;">
								<ul class="pagination">
									<li><a href="#">&laquo;</a></li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#">&raquo;</a></li>
								</ul>
							</div>
						</c:when>
						<c:otherwise>
							<h1 style="font-size:32px;text-align:center;">Not Found</h1>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="col-md-1">
					
				</div>
			</div>
		</div>
	</body>
</html>