<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ quảng trị</title>
<link href="Template/Frontend/css/bootstrap.css" rel="stylesheet">
<link href="Template/Frontend/css/bootstrap-responsive.css"
	rel="stylesheet">
<link href="Template/Frontend/css/style.css" rel="stylesheet">


<!-- font -->
<link rel="stylesheet"
	href="Template/Frontend/font/font-awesome.min.css" />

<script src="Template/Frontend/js/jquery-1.js"></script>
<script src="Template/Frontend/js/bootstrap.min.js"></script>
<style type="text/css">
	a:link {
    text-decoration: none;
    display: inline-block;
    background-color: #2ECCFA;
    color: #FFFFFF;
    padding: 14px 25px;
	}
	a:hover, a:active {
    background-color: #2E64FE;
	}
</style>
</head>
<body>
	<jsp:include page="../View/Header.jsp"></jsp:include>
	
	<div class="container">
		
		<a href="AddFwd">Thêm sinh viên</a>
		<hr class="star-primary">
		<label class="block clearfix" style="color: red">
			<%= request.getAttribute("msgUpdate")!= null ? request.getAttribute("msgUpdate"): "" %>
		</label>
		<label class="block clearfix" style="color: red">
			<%= request.getAttribute("msgDel")!= null ? request.getAttribute("msgDel"): "" %>
		</label>
		
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2>Thông tin sinh viên</h2>
				<hr class="star-primary">
			</div>
		</div>

		<div class="table-responsive">
			<table class="table table-striped">
			<tr>
				<th>Sinh viên</th>
				<th>Mật khẩu</th>
				<th>Điểm</th>
				<th>Chức năng</th>
				<th>Chức năng</th>
			</tr>
			<c:forEach items="${listAccount}" var="l">
				<tr>
					<td>${l.membername }</td>
					<td>${l.memberpass }</td>
					<td>${l.memberdiem }</td>
					
					<td><a href="UpdateFwd?id=${l.memberid}"   >Nhập điểm</a></td>
					<td><a href="DelFwd?id=${l.memberid}">Xóa sinh viên</a></td>
					
				</tr>
			</c:forEach>
			</table>
	</div>
	</div>
</body>
</html>