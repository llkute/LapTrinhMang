<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
<link href="Template/Frontend/css/bootstrap.css" rel="stylesheet">
<link href="Template/Frontend/css/bootstrap-responsive.css"
	rel="stylesheet">
<link href="Template/Frontend/css/style.css" rel="stylesheet">


<!-- font -->
<link rel="stylesheet"
	href="Template/Frontend/font/font-awesome.min.css" />

<script src="Template/Frontend/js/jquery-1.js"></script>
<script src="Template/Frontend/js/bootstrap.min.js"></script>
</head>
<body>
	<!--HEADER ROW-->
	<jsp:include page="Header.jsp"></jsp:include>
	<!-- /HEADER ROW -->

	<div class="container">
		<div class="row">
			<div class="span4" style="text-align: center; padding-top: 20px">
				<img src="Img/logo.jpg">
			</div>
			<div class="span8">
				<h1 style="color: Blue; text-align: center;">Bài Thi </h1>
				
				<hr class="star-light">
				<h2>Môn Lập Trình Mạng</h2>
				<p>Sinh viên: Triệu Thị Ly Ly</p>
				<p>Lớp 13TCLC</p>
			</div>
		</div>
	</div>
</body>
</html>