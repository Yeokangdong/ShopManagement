<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>한건식 | 상품 등록</title><!--begin::Primary Meta Tags-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="title" content="AdminLTE v4 | Dashboard">
    <meta name="author" content="ColorlibHQ">
    <meta name="description" content="AdminLTE is a Free Bootstrap 5 Admin Dashboard, 30 example pages using Vanilla JS.">
    <meta name="keywords" content="bootstrap 5, bootstrap, bootstrap 5 admin dashboard, bootstrap 5 dashboard, bootstrap 5 charts, bootstrap 5 calendar, bootstrap 5 datepicker, bootstrap 5 tables, bootstrap 5 datatable, vanilla js datatable, colorlibhq, colorlibhq dashboard, colorlibhq admin dashboard"><!--end::Primary Meta Tags--><!--begin::Fonts-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fontsource/source-sans-3@5.0.12/index.css" integrity="sha256-tXJfXfp6Ewt1ilPzLDtQnJV4hclT9XuaZUKyUvmyr+Q=" crossorigin="anonymous"><!--end::Fonts--><!--begin::Third Party Plugin(OverlayScrollbars)-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/overlayscrollbars@2.3.0/styles/overlayscrollbars.min.css" integrity="sha256-dSokZseQNT08wYEWiz5iLI8QPlKxG+TswNRD8k35cpg=" crossorigin="anonymous"><!--end::Third Party Plugin(OverlayScrollbars)--><!--begin::Third Party Plugin(Bootstrap Icons)-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.min.css" integrity="sha256-Qsx5lrStHZyR9REqhUF8iQt73X06c8LGIUPzpOhwRrI=" crossorigin="anonymous"><!--end::Third Party Plugin(Bootstrap Icons)--><!--begin::Required Plugin(AdminLTE)-->
    <link rel="stylesheet" href="<c:url value='/css/all.min.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/dark-mode.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/OverlayScrollbars.min.css"'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/adminlte.min.css?v=3.2.0'/>"/><!--end::Required Plugin(AdminLTE)--><!-- apexcharts -->
    
    <script type="text/javascript" src="<c:url value='/js/plugins/jquery.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/main.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/plugins/chart.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/bootstrap.bundle.min.js'/>"></script>
</head> <!--end::Head--> <!--begin::Body-->

<body class="dark-mode sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed text-sm" style="height: auto;">
	<div class="wrapper">
		<div class="preloader flex-column justify-content-center align-items-center" style="height: 0px;">
			<img class="animation__wobble" src="dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60" style="display: none;">
		</div>
		
		<!-- 헤더 -->
		<jsp:include page="../include/header.jsp"></jsp:include>
		
		<!-- 좌측메뉴-->
		<jsp:include page="../include/left.jsp"></jsp:include>
		<div class="content-wrapper" style="min-height: 896px;">
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">카테고리(품목)/스토어</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">카테고리(품목)/스토어</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
	
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-6">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">카테고리(품목)/스토어</h3>
								</div>
								<div class="card-body">
									<div class="row">	
										<div class="col-sm-5">
											<div class="form-group">
												<label for="exampleInputEmail1">카테고리</label>
												<div class="input-group">
													<input type="text" class="form-control" placeholder="예시)야채류">
													<button type="button" class="btn btn-success float-right" style="width: 100px; margin-left: 5px;">
														저장
													</button>
												</div>
											</div>	
										</div>
										<div class="col-md-7">
											<div class="form-group">
												<label for="exampleInputEmail1">품목</label>
												<div class="input-group">
													<select style="width: 120px;height: 38px;">
														<option>농산물</option>
														<option>수산물</option>
														<option>축산물</option>
														<option>가공식품</option>
														<option>기타식품</option>
													</select>
													<input type="text" class="form-control" placeholder="예시)고사리">
													<button type="button" class="btn btn-success float-right" style="width: 100px; margin-left: 5px;">
														저장
													</button>
												</div>
											</div>
										</div>
									</div>
								</div>		
							</div>
						</div>
						<div class="col-md-6">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">스토어/수수료(%)</h3>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-md-7">
											<div class="form-group">
												<label for="exampleInputEmail1">스토어</label>
												<div class="input-group">
													<select style="width: 120px;height: 38px;">
														<option>쿠팡</option>
														<option>11번가</option>
														<option>이베이</option>
														<option>지마켓</option>
														<option>ssg.com</option>
														<option>티몬</option>
													</select>
													<input type="text" class="form-control" placeholder="예시)(주)쿠팡">
												</div>
											</div>
										</div>
										<div class="col-md-5">
											<div class="form-group">
												<label for="exampleInputEmail1">스토어 수수료(%)</label>
												<div class="input-group">
													<input type="text" class="form-control" placeholder="예시)13.5%">
													<button type="button" class="btn btn-success float-right" style="width: 100px; margin-left: 5px;">
														저장
													</button>
												</div>
											</div>
										</div>
									</div>
								</div>		
							</div>
						</div>				
					</div>
				</div>
			</section>
		</div>
		<jsp:include page="../include/footer.jsp"></jsp:include>
	</div>
</body>
</html>