<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
		<link href="bootstrap-3.3.7/css/font-awesome.min.css" rel="stylesheet" />		
		<script src="bootstrap-3.3.7/js/jquery.js"></script>
		<script src="bootstrap-3.3.7/js/jquery.validate.min.js"></script>
		<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--指定本页面的超链接和表单链接提供target属性 -->
		<base target="down" />
		<title>Customer Opt</title>
	</head>
	<body>
		<div class="container">
			<h3 style="text-align:center"><i class="icon icon-sitemap"></i>Customer Relation Manager</h3>
			<div class="row">
				<div class="col-md-12" style="text-align:center;">
					<img src="images/client.png" class="img-thumbnail" style="width:90px;height:80px;" alt="" />
				</div>
				<div class="row">
					<div class="col-md-12" style="text-align:center;padding-top:12px;">
						<a href="index.jsp" class="btn btn-info">&nbsp;<i class="icon icon-home"></i>home&nbsp;&nbsp;</a>&nbsp;&nbsp;
						<a href="add.jsp" class="btn btn-primary">&nbsp;<i class="icon icon-plus"></i>add&nbsp;&nbsp;</a>&nbsp;&nbsp;
						<a href="CustomerServlet?method=findAll" class="btn btn-success"><i class="icon icon-search"></i>query</a>&nbsp;&nbsp;
						<a href="aslist.jsp" class="btn btn-danger"><i class="icon icon-fire"></i>advanced search</a>&nbsp;&nbsp;
					</div>
				</div>
			</div>
		</div>
	</body>
</html>