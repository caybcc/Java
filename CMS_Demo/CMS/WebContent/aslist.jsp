<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	        });
		</script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Query Page</title>
	</head>
	<body style="overflow-x:hidden;">
		<div class="container">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-*" style="text-align:center;"><h4><i class="icon icon-fire"></i>Advanced Search</h4></div>
				<div class="col-md-1"></div>
			</div>
			<br />
			<div class="row" style="padding-bottom:36px;">
				<div class="col-md-1"></div>
				<div class="col-md-10" style="padding-left:6%;">
					<form action="<c:url value='/CustomerServlet' />" method="post" class="form-inline" role="form">
						<input type="hidden" name="method" value="query" />
						<div class="form-group">
							<label for="name" class="control-label">Name</label>
							<input type="text" class="form-control" name="cname" />
						</div>
						&nbsp;
						<div class="form-group">
							<label for="" class="col-sm-4 control-label">
									gender
							</label>
							<div class="col-sm-8">
								<label class="radio-inline">
							        <input type="radio" name="gender"  value="male" checked> <i class="icon icon-male"  style="color:blue;font-size: 20px;"></i>
							    </label>
							    <label class="radio-inline">
							        <input type="radio" name="gender" value="female"> <i class="icon icon-female fa-2x" style="color:red;font-size: 20px;" ></i>
							    </label>
							</div>
						</div>
						&nbsp;
						<div class="form-group">
							<label for="phone" class="control-label">Phone</label>
							<input type="text" class="form-control" name="ceilphone"/>
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
						
						<c:if test="${requestScope.customers.size() != 0 && requestScope.customers != null}">
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
								
									<c:forEach items="${requestScope.customers}" var="customer" varStatus="vst">
										<tr>
											<td>${vst.index + 1}</td>
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
					</c:if>
				</div>
				<div class="col-md-1">
					
				</div>
			</div>
		</div>
	</body>
</html>