<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>한건식</title><!--begin::Primary Meta Tags-->
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
							<h1 class="m-0">주문 내역</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">주문 내역</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
	
			<section class="content">
				<div class="container-fluid">	
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header border-transparent">
									<h3 class="card-title">주문 내역 ( 10건 )</h3>
									<div class="card-tools">
										<div class="btn-group float-left" style="width: 400px; margin-right: 10px; margin-top: 2px;">
											<button type="button" class="btn btn-height btn-default float-left" style="margin-right: 5px; padding-top: 3px;">
												<i class="fa fa-download"></i>
												다운로드
											</button>
											<button type="button" class="btn btn-height btn-default float-left" style="margin-right: 5px; padding-top: 3px;">
												<i class="fa fa-file-excel"></i>
												주문입력
											</button>
											<select style="width: 150px; height: 30px;">
												<option>운송장번호</option>
												<option>받는분 성명</option>
												<option>받는분 전화번호</option>
												<option>보내는분 성명</option>
												<option>보내는분 전화번호</option>
											</select>
										</div>
										<div class="input-group input-group-sm float-left" style="width: 200px; margin-top: 1px;">
											<input type="text" name="table_search" class="form-control float-right" placeholder="Search">
											<div class="input-group-append">
												<button type="submit" class="btn btn-default">
													<i class="fas fa-search"></i>
												</button>
											</div>
										</div>
									</div>	
								</div>
								<div class="card-body p-0" style="margin: 10px;">
									<table class="table table-bordered table-hover dataTable dtr-inline">
										<thead>
											<tr>
												<th>#</th>
												<th>받는분 성명</th>
												<th>받는분 전화번호</th>
												<th>받는분 주소</th>
												<th>보내는분 성명</th>
												<th>보내는분 전화번호</th>
												<th>보내는분 주소</th>
												<th>품목명</th>
												<th>택배사</th>
												<th>송장번호</th>
												<th style="width: 100px">상태</th>
												<th>주문일</th>
												<th>배송발송일</th>
												<th style="width: 180px">선택</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>1</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길</td>
												<td>한건식</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길 CJ대한통운 하동대리점</td>
												<td>매실 10kg 특대</td>
												<td>CJ대한통운</td>
												<td><input class="form-control" style="width: 160px; font-weight: bold;" value="6861-7768-9766"></td>
												<td><span style="color: #3498db; font-weight: bold;">배송중</span></td>
												<td>2024-08-12 15:00</td>
												<td>2024-08-13 16:00</td>
												<td>
													<button type="button" class="btn btn-success btn-xs float-left" style="width: 80px; margin-right: 5px;">
														상품추적
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														반품
													</button>
												</td>	
											</tr>
											<tr>
												<td>2</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길</td>
												<td>한건식</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길 CJ대한통운 하동대리점</td>
												<td>매실 10kg 특대</td>
												<td>CJ대한통운</td>
												<td><input class="form-control" style="width: 160px; font-weight: bold;" value="6861-7768-9766"></td>
												<td><span style="color: #3498db; font-weight: bold;">배송중</span></td>
												<td>2024-08-12 15:00</td>
												<td>2024-08-13 16:00</td>
												<td>
													<button type="button" class="btn btn-success btn-xs float-left" style="width: 80px; margin-right: 5px;">
														상품추적
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														반품
													</button>
												</td>	
											</tr>
											<tr>
												<td>3</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길</td>
												<td>한건식</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길 CJ대한통운 하동대리점</td>
												<td>매실 10kg 특대</td>
												<td>CJ대한통운</td>
												<td><input class="form-control" style="width: 160px; font-weight: bold;" value="6861-7768-9766"></td>
												<td><span style="color: #3498db; font-weight: bold;">배송중</span></td>
												<td>2024-08-12 15:00</td>
												<td>2024-08-13 16:00</td>
												<td>
													<button type="button" class="btn btn-success btn-xs float-left" style="width: 80px; margin-right: 5px;">
														상품추적
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														반품
													</button>
												</td>	
											</tr>
											<tr>
												<td>4</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길</td>
												<td>한건식</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길 CJ대한통운 하동대리점</td>
												<td>매실 10kg 특대</td>
												<td>CJ대한통운</td>
												<td><input class="form-control" style="width: 160px; font-weight: bold;" value="6861-7768-9766"></td>
												<td><span style="color: #3498db; font-weight: bold;">배송중</span></td>
												<td>2024-08-12 15:00</td>
												<td>2024-08-13 16:00</td>
												<td>
													<button type="button" class="btn btn-success btn-xs float-left" style="width: 80px; margin-right: 5px;">
														상품추적
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														반품
													</button>
												</td>	
											</tr>
											<tr>
												<td>5</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길</td>
												<td>한건식</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길 CJ대한통운 하동대리점</td>
												<td>매실 10kg 특대</td>
												<td>CJ대한통운</td>
												<td><input class="form-control" style="width: 160px; font-weight: bold;" value="6861-7768-9766"></td>
												<td><span style="color: #3498db; font-weight: bold;">배송중</span></td>
												<td>2024-08-12 15:00</td>
												<td>2024-08-13 16:00</td>
												<td>
													<button type="button" class="btn btn-success btn-xs float-left" style="width: 80px; margin-right: 5px;">
														상품추적
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														반품
													</button>
												</td>	
											</tr>
											<tr>
												<td>6</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길</td>
												<td>한건식</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길 CJ대한통운 하동대리점</td>
												<td>매실 10kg 특대</td>
												<td>CJ대한통운</td>
												<td><input class="form-control" style="width: 160px; font-weight: bold;" value="6861-7768-9766"></td>
												<td><span style="color: #3498db; font-weight: bold;">배송중</span></td>
												<td>2024-08-12 15:00</td>
												<td>2024-08-13 16:00</td>
												<td>
													<button type="button" class="btn btn-success btn-xs float-left" style="width: 80px; margin-right: 5px;">
														상품추적
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														반품
													</button>
												</td>	
											</tr>
											<tr>
												<td>7</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길</td>
												<td>한건식</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길 CJ대한통운 하동대리점</td>
												<td>매실 10kg 특대</td>
												<td>CJ대한통운</td>
												<td><input class="form-control" style="width: 160px; font-weight: bold;" value="6861-7768-9766"></td>
												<td><span style="color: #3498db; font-weight: bold;">배송중</span></td>
												<td>2024-08-12 15:00</td>
												<td>2024-08-13 16:00</td>
												<td>
													<button type="button" class="btn btn-success btn-xs float-left" style="width: 80px; margin-right: 5px;">
														상품추적
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														반품
													</button>
												</td>	
											</tr>
											<tr>
												<td>8</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길</td>
												<td>한건식</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길 CJ대한통운 하동대리점</td>
												<td>매실 10kg 특대</td>
												<td></td>
												<td><span style="font-weight: bold;"></span></td>
												<td>발송대기</td>
												<td>2024-08-12 15:00</td>
												<td></td>
												<td>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														취소
													</button>
												</td>	
											</tr>
											<tr>
												<td>9</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길</td>
												<td>맛나요리</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길 CJ대한통운 하동대리점</td>
												<td>재첩</td>
												<td></td>
												<td><span style="color: #3498db; font-weight: bold;"></span></td>
												<td>발송대기</td>
												<td>2024-08-12 15:00</td>
												<td></td>
												<td>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														취소
													</button>
												</td>	
											</tr>
											<tr>
												<td>10</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길</td>
												<td>맛나요리</td>
												<td>010-123-1234</td>
												<td>경남 하동군 하동읍 화심길 CJ대한통운 하동대리점</td>
												<td>재첩</td>
												<td></td>
												<td><span style="color: #3498db; font-weight: bold;"></span></td>
												<td>발송대기</td>
												<td>2024-08-12 15:00</td>
												<td></td>
												<td>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														취소
													</button>
												</td>	
											</tr>
										</tbody>
									</table>
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