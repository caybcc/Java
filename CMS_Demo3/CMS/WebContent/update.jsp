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
		<link href="bootstrap-3.3.7/css/jquery-ui.min.css" rel="stylesheet" />
		<script src="bootstrap-3.3.7/js/jquery.js"></script>
		<script src="bootstrap-3.3.7/js/jquery-ui.min.js"></script>
		<script src="bootstrap-3.3.7/js/jquery.validate.min.js"></script>
		<script src="bootstrap-3.3.7/js/messages_zh.min.js"></script>
		<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
		<title>Form Data</title>
		<style>
			label.error {
				color: red !important;
				float: left;
			}
			input[type=text], input[type=email] {
				width: 186px;
			}
			
			div.tip {
				line-height: 30px;
			}
		</style>
		<script>
		$().ready(function() {
			// 在键盘按下并释放及提交后验证提交表单
			  $("#add_form").validate({
			    rules: {
			      cname: {
			        required: true,
			        minlength: 2
			      },
			      email: {
			        required: true,
			        email: true
			      }
			    },
			    messages: {
			      
			      cname: {
			        required: "请输入用户名",
			        minlength: "用户名必需由两个字母组成"
			      },
			      email: {
			    	required: "请输入邮箱",
			    	email: "请输入一个正确的邮箱"  
			      }
			    },
			    
			    errorPlacement:function(error,element) {  
			        error.appendTo(element.parent().next("div"));
			   	}
			    
			  });
			  $( "#datepicker" ).datepicker({
				  dateFormat: "yy-mm-dd"
			  });
			});
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-4"></div>
			    <div class="col-md-5" style="text-align:center;padding-top:25px;">
			    	    <div class="row">
			    	    	<h4 class="col-md-1"></h4>
			    	    	<h4 class="col-md-6"><i class="icon icon-edit"></i>Update Old Customer</h4>
			    	    </div>
			    	    <br />
						<form id="add_form" action="CustomerServlet" class="form-horizontal form">
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">
									name
								</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" name="cname" value="${customer.cname}" />
								</div>
								<div class="col-sm-5 tip"></div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">
									gender
								</label>
								<div class="col-sm-5" style="text-align:left;">
									<label class="radio-inline">
								        <input type="radio" name="gender"  value="male" <c:if test="${customer.gender eq 'male' }" >checked="checked"</c:if>> <i class="icon icon-male"  style="color:blue;font-size: 20px;"></i>
								    </label>
								    <label class="radio-inline">
								        <input type="radio" name="gender" value="female" <c:if test="${customer.gender eq 'female' }" >checked="checked"</c:if>> <i class="icon icon-female fa-2x" style="color:red;font-size: 20px;" ></i>
								    </label>
								</div>
								<div class="col-sm-5 tip"></div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">
									birthday
								</label>
								<div class="col-sm-10">
									<input type="text" id="datepicker" class="form-control"  name="birthday" value="${customer.birthday}" />
								</div>
								<div class="col-sm-5 tip"></div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">
									ceilphone
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="ceilphone" value="${customer.ceilphone}" />
								</div>
								<div class="col-sm-5 tip"></div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">
									email
								</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" name="email" value="${customer.email}" />
									<input type="hidden" name="cid" value="${customer.cid}" />
									<input type="hidden" name="method" value="edit" />
								</div>
								<div class="col-sm-5 tip"></div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</label>
								<div class="col-sm-10" style="text-align:left;">
									<input type="submit" class="btn btn-primary" id="query" value="add"  style="width:56px;" />
									<a href="index.jsp" class="btn btn-primary" style="width:64px;text-align: center;">return</a>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-3"></div>
				</div>
			</div>
	</body>
</html>