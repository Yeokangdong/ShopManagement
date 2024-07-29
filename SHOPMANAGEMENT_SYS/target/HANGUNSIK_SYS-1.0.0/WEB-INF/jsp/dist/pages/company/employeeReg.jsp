<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>한건식 | 업체 등록/수정</title><!--begin::Primary Meta Tags-->
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
    <script type="text/javascript" src="<c:url value='/js/plugins/chart.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/bootstrap.bundle.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/company/company.js'/>"></script>
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
							<h1 class="m-0">직원 등록/수정</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">직원 등록/수정</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
	
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-7">
							<div class="card">
								<div class="card-header border-transparent">
									<h3 class="card-title">직원 ( 3건 )</h3>
									<div class="card-tools">
										<div class="btn-group float-left" style="margin-top: 2px; margin-left: 5px;">
											<select style="width: 200px; height: 35px;">
												<option>(주)자연향기</option>
												<option>김정문의 섬진강재첩</option>
												<option>하동참다래매실농원</option>
												<option>(주)슬로푸드</option>
											</select>
										</div>
									</div>
								</div>
								<div class="card-body p-0" style="margin: 10px;">
									<table class="table table-bordered table-hover dataTable dtr-inline">
										<thead>
											<tr>
												<th>#</th>
												<th>업체명</th>
												<th>직원명</th>
												<th>담당</th>
												<th>전화번호</th>
												<th>이메일</th>
												<th style="width: 150px;">선택</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>1</td>
												<td>파파야</td>
												<td>여강동</td>
												<td>공장장</td>
												<td>000-000-0000</td>
												<td>durkdehd@gmail.com</td>
												<td>
													<button type="button" class="btn btn-danger btn-xs float-right" style="width: 50px; margin-right: 5px;">
														삭제
													</button>
													<button type="button" class="btn btn-warning btn-xs float-right" style="width: 50px; margin-right: 5px;">
														수정
													</button>
												</td>	
											</tr>
											<tr>
												<td>2</td>
												<td>파파야</td>
												<td>여강동</td>
												<td>공장장</td>
												<td>000-000-0000</td>
												<td>durkdehd@gmail.com</td>
												<td>
													<button type="button" class="btn btn-danger btn-xs float-right" style="width: 50px; margin-right: 5px;">
														삭제
													</button>
													<button type="button" class="btn btn-warning btn-xs float-right" style="width: 50px; margin-right: 5px;">
														수정
													</button>
												</td>
											</tr>
											<tr>
												<td>3</td>
												<td>파파야</td>
												<td>여강동</td>
												<td>공장장</td>
												<td>000-000-0000</td>
												<td>durkdehd@gmail.com</td>
												<td>
													<button type="button" class="btn btn-danger btn-xs float-right" style="width: 50px; margin-right: 5px;">
														삭제
													</button>
													<button type="button" class="btn btn-warning btn-xs float-right" style="width: 50px; margin-right: 5px;">
														수정
													</button>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="col-md-5">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">직원 등록/수정</h3>
								</div>
								<div class="card-body">
									<div class="row">	
										<div class="col-md-4">	
											<div class="form-group">
												<label for="exampleInputEmail1">직원명</label>
												<input type="text" class="form-control" id="exampleInputEmail1" placeholder="예시)정현성">
											</div>										
										</div>	
										<div class="col-md-4">
											<div class="form-group">
												<label for="exampleInputEmail1">담당</label>
												<input type="text" class="form-control" id="exampleInputEmail1" placeholder="예시)C/S">
											</div>
										</div>
										<div class="col-md-4">	
											<div class="form-group">
												<label for="exampleInputEmail1">전화번호</label>
												<input type="text" class="form-control" id="exampleInputEmail1" placeholder="예시)010-0000-0000">
											</div>										
										</div>	
										<div class="col-md-4">
											<div class="form-group">
												<label for="exampleInputEmail1">이메일</label>
												<input type="text" class="form-control" id="exampleInputEmail1" placeholder="예시)abc@gmail.com">
											</div>
										</div>	
									</div>
								</div>
								<div class="card-footer clearfix">
									<button type="button" class="btn btn-success btn-xs float-right" style="width: 100px;">
										<i class="ion ion-ios-refresh-empty"></i>저장
									</button>
									<button type="button" class="btn btn-default btn-xs float-right" style="width: 100px; margin-right: 5px;">
										<i class="fa fa-rotate"></i>
										초기화
									</button>
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