<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm sinh viên</title>
	<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="Template/Backend/assets/css/bootstrap.min.css" />
		
		<link rel="stylesheet" href="Template/Backend/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

 		<link rel="stylesheet" href="Template/Backend/font/font-awesome.min.css" />
 		
		<!-- ace styles -->
		<link rel="stylesheet" href="Template/Backend/assets/css/ace.min.css" />

		
		<link rel="stylesheet" href="Template/Backend/assets/css/ace-rtl.min.css" />
		
		<script type="text/javascript">
		function Validate() {
			var memberdiem=document.myform.memberdiem.value;
			var membername=document.myform.membername.value;
			var memberpass=document.myform.memberpass.value;
			if ( membername == "" || memberpass == "")
			{
				alert("Yêu cầu không bỏ trống bất kì thông tin nào");
				return false;
				
			}
			else 
			{
				if (memberpass.length < 6)
				{
					document.getElementById("errormemberpass").innerHTML = "Độ dài pass >= 6";
					return false;
				}
				if(parseInt(memberdiem) <0 || parseInt(memberdiem) >100){
					document.getElementById("errormemberdiem").innerHTML = "Điểm phải thuộc từ 0 đến 100";
					return false;
				}
			}	
		}
		
		</script>
</head>
</head>
<body>
<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2">
						
							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i>
												Thêm sinh viên
											</h4>

											<div class="space-6"></div>

											<form name="myform" action="AddController" method="post" onsubmit="return Validate()">
												<fieldset>
													<label class="block clearfix" style="color: red">
														<%= request.getAttribute("msgAdd")!= null ? request.getAttribute("msgAdd"): "" %>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="Tên sinh viên" name="membername" />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>
													<label class="block clearfix" id="errormembername">
														
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="Điểm sinh viên" name="memberdiem"/>
															<i class="ace-icon fa fa-magic"></i>
														</span>
													</label>
													<label class="block clearfix" id="errormemberdiem">
														
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="Mật khẩu" name="memberpass"/>
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>
													<label class="block clearfix" id="errormemberpass">
														
													</label>

													<div class="space"></div>

													<div class="clearfix">
														

														<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110">Thêm mới</span>
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

										

											<div class="space-6"></div>

											
										</div><!-- /.widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="AdminFwd"  class="forgot-password-link">
													<i class="ace-icon fa fa-arrow-left"></i>
													Trở về trang chủ
												</a>
											</div>

											
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.login-box -->

								
								

						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->

</body>
</html>