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
		<title>用户 注册</title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h3 class="text-center"><i class="icon-user"></i>用户注册</h3>
					<hr style="width:36%;" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form action='<c:url value="/RegistServlet" />' method="POST" class="form-horizontal" role="form">
						<div class="form-group">
							<div class="col-sm-4"></div>
							<label for="" class="col-sm-1 control-label">用户名:</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" name="username" value="${user.username }" placeholder="请输入用户名" />
							</div>
							<div class="col-sm-4">
								<p style="color:red;line-height: 28px;"><c:out value="${errors.username }"/></p>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-4"></div>
							<label for="" class="col-sm-1 control-label">密码:</label>
							<div class="col-sm-3">
								<input type="password" class="form-control" value="${user.password }" name="password" placeholder="请输入密码" />
							</div>
							<div class="col-sm-4">
								<p style="color:red;line-height: 28px;"><c:out value="${errors.password }"/></p>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-4"></div>
							<label for="" class="col-sm-1 control-label">验证码:</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" name="verifyCode" value="${user.verifyCode }" placeholder="请输入验证码" />
							</div>
							<div class="col-sm-4">
								<p style="color:red;line-height: 28px;"><c:out value="${errors.verifyCode }"/></p>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-4"></div>
							<label for="" class="col-sm-1 control-label">&nbsp;&nbsp;</label>
							<div class="col-sm-3">
								<img id="vc" src="<c:url value='/VerifyCodeServlet' />" alt="" />
								<a href="JavaScript:void" onclick='document.getElementById("vc").src="VerifyCodeServlet?x="+(new Date().getTime());'>看不清，换一张</a>
							</div>
							<div class="col-sm-*">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-5"></div>
							<div class="col-sm-3">
								<input type="submit" value="注册" class="btn btn-primary" />
								&nbsp;&nbsp;
								<input type="reset" value="重置" class="btn btn-success" />
							</div>
							<div class="col-sm-*">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>