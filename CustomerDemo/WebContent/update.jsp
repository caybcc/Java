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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Form Data</title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-4"></div>
			    <div class="col-md-5" style="text-align:center;padding-top:25px;">
			    		<h1 style="text-align:left;">Modify Customer Info</h1><br /><br />
						<form action="modifyCustomer.do" class="form-horizontal form">
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">
									name
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="name" style="width:240px;" value='<c:out value="${customer.name }" />'  />
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">
									address
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="address"  style="width:240px;" value='<c:out value="${customer.address }" />' />
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">
									phone
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="phone" style="width:240px;" value='<c:out value="${customer.phone }" />' />
									<input type="hidden" name="cid" value="<c:out value="${customer.id }" />" />
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</label>
								<div class="col-sm-10" style="text-align:left;">
									<input type="submit" class="btn btn-primary" id="query" value="Modify Customer"  style="width:150px;" />
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-3"></div>
				</div>
			</div>
	</body>
</html>