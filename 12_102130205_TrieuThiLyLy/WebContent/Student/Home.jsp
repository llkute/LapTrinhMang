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
	<jsp:include page="../View/Header.jsp"></jsp:include>
	<!-- /HEADER ROW -->

	<div class="container">
		
		
			<div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Thông tin tài khoản</h2>
                    <hr class="star-primary">
                </div>
            </div>
			<div class="table-responsive">
			<table border="1" class="table">
			<tr>
				<th>Sinh viên</th>
				<th>Mật khẩu</th>
				<th>Điểm</th>
			</tr>
			<c:forEach items="${listAccount}" var="l">
				<tr>
					<td>${l.membername }</td>
					<td>${l.memberpass }</td>
					<td>${l.memberdiem }</td>
				</tr>
			</c:forEach>

		</table>
			</div>
		
		
		
	</div>

</body>
</html>