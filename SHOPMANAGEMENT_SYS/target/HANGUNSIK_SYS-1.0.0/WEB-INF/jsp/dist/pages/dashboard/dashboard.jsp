<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>한건식 | 종합정보</title><!--begin::Primary Meta Tags-->
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
    <link rel="stylesheet" href="https://code.highcharts.com/dashboards/css/dashboards.css"/>
    <link rel="stylesheet" href="<c:url value='/css/fullcalendar.css'/>"/>
    
    <script type="text/javascript" src="<c:url value='/js/plugins/jquery.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/plugins/chart.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/bootstrap.bundle.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/dashboard/dashboard.js'/>"></script>
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
		
		<!-- 종합정보 -->
		<div class="content-wrapper" style="min-height: 896px;">
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">종합정보</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">종합정보</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
	
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12 col-sm-6 col-md-3">
							<div class="info-box">
								<span class="info-box-icon bg-info elevation-1"><i class="fas fa-won-sign"></i></span>
								<div class="info-box-content">
									<span class="info-box-text">신규주문</span>
									<span class="info-box-number">150건</span>
								</div>
							</div>
						</div>
						<div class="col-12 col-sm-6 col-md-3">
							<div class="info-box mb-3">
								<span class="info-box-icon bg-success elevation-1"><i class="fa fa-gift"></i></span>
								<div class="info-box-content">
									<span class="info-box-text">배송준비</span>
									<span class="info-box-number">100 건</span>
								</div>
							</div>
						</div>
						<div class="clearfix hidden-md-up"></div>
						<div class="col-12 col-sm-6 col-md-3">
							<div class="info-box mb-3">
								<span class="info-box-icon bg-success elevation-1"><i class="fas fa-truck"></i></span>
								<div class="info-box-content">
									<span class="info-box-text">배송중</span>
									<span class="info-box-number">20건</span>
								</div>
							</div>
						</div>
						<div class="col-12 col-sm-6 col-md-3">
							<div class="info-box mb-3">
								<span class="info-box-icon bg-warning elevation-1"><i class="fa fa-flag-checkered"></i></span>
								<div class="info-box-content">
									<span class="info-box-text">배송완료</span>
									<span class="info-box-number">80건</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-12 col-sm-6 col-md-3">
							<div class="info-box">
								<span class="info-box-icon bg-danger elevation-1"><i class="fa fa-ban"></i></span>
								<div class="info-box-content">
									<span class="info-box-text">취소요청</span>
									<span class="info-box-number">2건</span>
								</div>
							</div>
						</div>
						<div class="col-12 col-sm-6 col-md-3">
							<div class="info-box mb-3">
								<span class="info-box-icon bg-danger elevation-1"><i class="fas fa-box"></i></span>
								<div class="info-box-content">
									<span class="info-box-text">반품요청</span>
									<span class="info-box-number">1건</span>
								</div>
							</div>
						</div>
						<div class="clearfix hidden-md-up"></div>
						<div class="col-12 col-sm-6 col-md-3">
							<div class="info-box mb-3">
								<span class="info-box-icon bg-info elevation-1"><i class="fa fa-phone"></i></span>
								<div class="info-box-content">
									<span class="info-box-text">교환요청</span>
									<span class="info-box-number">3건</span>
								</div>
							</div>
						</div>
						<div class="col-12 col-sm-6 col-md-3">
							<div class="info-box mb-3">
								<span class="info-box-icon bg-warning elevation-1"><i class="fa fa-comments-dollar"></i></span>
								<div class="info-box-content">
									<span class="info-box-text">상품문의</span>
									<span class="info-box-number">59건</span>
								</div>
							</div>
						</div>
					</div>
					
					<!-- 매출통계 -->
					<div class="row">
						<div class="col-md-6">
							<div class="row">
								<div class="col-md-6">
									<div class="card">
										<div class="card-header border-transparent">
											<h3 class="card-title">매출/순익(천원)</h3>
										</div>
										<div class="card-body p-0">
											<canvas id="salesLineChart" class="chartjs-render-monitor"></canvas>
										</div>
									</div>	
								</div>
								<div class="col-md-6">
									<div class="card">
										<div class="card-header border-transparent">
											<h3 class="card-title">주문(건)</h3>
										</div>
										<div class="card-body p-0">
											<canvas id="orderBarChart" class="chartjs-render-monitor"></canvas>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="card">
										<div class="card-header border-transparent">
											<h3 class="card-title">매출(천원)</h3>
										</div>
										<div class="card-body p-0">
											<canvas id="salesBarChart" class="chartjs-render-monitor"></canvas>
										</div>
									</div>	
								</div>
								<div class="col-md-6">
									<div class="card">
										<div class="card-header border-transparent">
											<h3 class="card-title">순익(천원)</h3>
										</div>
										<div class="card-body p-0">
											<canvas id="profitBarChart" class="chartjs-render-monitor"></canvas>
										</div>
									</div>
								</div>
							</div>			
						</div>
						<div class="col-md-6">
							<div class="card">
								<div class="card-header border-transparent">
									<h3 class="card-title">매출/순익</h3>
								</div>
								<div class="card-body p-0">
									<table class="table m-0">
										<thead>
											<tr>
												<th>일자</th>
												<th>총매출</th>
												<th>매출</th>
												<th>순익</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>2024-06-16</td>
												<td>1,500,000 원</td>
												<td>500,000 원</td>
												<td>100,000 원</td>
											</tr>
											<tr>
												<td>2024-06-15</td>
												<td>1,800,000 원</td>
												<td>400,000 원</td>
												<td>500,000 원</td>
											</tr>
											<tr>
												<td>2024-06-14</td>
												<td>1,900,000 원</td>
												<td>200,000 원</td>
												<td>500,000 원</td>
											</tr>
											<tr>
												<td>2024-06-13</td>
												<td>2,500,000 원</td>
												<td>500,000 원</td>
												<td>100,000 원</td>
											</tr>
											<tr>
												<td>2024-06-12</td>
												<td>3,100,000 원</td>
												<td>300,000 원</td>
												<td>100,000 원</td>
											</tr>
											<tr>
												<td>2024-06-11</td>
												<td>32,00,000 원</td>
												<td>600,000 원</td>
												<td>270,000 원</td>
											</tr>
											<tr>
												<td>2024-06-10</td>
												<td>33,00,000 원</td>
												<td>500,000 원</td>
												<td>210,000 원</td>
											</tr>
											<tr style="color: #28a745;">
												<td>합계</td>
												<td>33,00,000 원</td>
												<td>500,000 원</td>
												<td>210,000 원</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="card-footer">
									<div class="row">
										<div class="col-sm-3 col-6">
											<div class="description-block border-right">
												<span class="description-percentage text-success"><i class="fas fa-caret-up"></i> 20%</span>
												<h5 class="description-header">20,000,235</h5>
												<span class="description-text">7일간 매출</span>
											</div>
										</div>
										<div class="col-sm-3 col-6">
											<div class="description-block border-right">
												<span class="description-percentage text-danger"><i class="fas fa-caret-down"></i> 18%</span>
												<h5 class="description-header">20,000,235</h5>
												<span class="description-text">7일간 순익</span>
											</div>
										</div>
										<div class="col-sm-3 col-6">
											<div class="description-block border-right">
												<span class="description-percentage text-success"><i class="fas fa-caret-up"></i> 17%</span>
												<h5 class="description-header">20,000,235</h5>
												<span class="description-text">6월 매출</span>
											</div>
										</div>
										<div class="col-sm-3 col-6">
											<div class="description-block">
												<span class="description-percentage text-warning"><i class="fas fa-caret-left"></i> 0%</span>
												<h5 class="description-header">20,000,235</h5>
												<span class="description-text">6월 순익</span>
											</div>
										</div>
									</div>
								</div>
							</div>	
						</div>
					</div>
					
					<!-- 외주업체 판매순위 -->
					<div class="row">
						<div class="col-md-6">
							<div class="card">
								<div class="card-header border-transparent">
									<h3 class="card-title">외주 업체 판매 순위</h3>
								</div>
								<div class="card-body p-0">
									<table class="table m-0">
										<thead>
											<tr>
												<th>순위</th>
												<th>업체</th>
												<th>실시간 판매누적</th>
												<th>판매건수</th>
												<th>환불금액</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>1</td>
												<td>파파야</td>
												<td>40,000,000 원</td>
												<td>1200 건</td>
												<td>210,000 원</td>
												<td>
													<a href="#" class="text-muted">
													<i class="fas fa-search"></i>
													</a>
												</td>
											</tr>
											<tr>
												<td>2</td>
												<td>(주)슬로푸두</td>
												<td>40,000,000 원</td>
												<td>1200 건</td>
												<td>210,000 원</td>
												<td>
													<a href="#" class="text-muted">
													<i class="fas fa-search"></i>
													</a>
												</td>
											</tr>
											<tr>
												<td>3</td>
												<td>(주)가을향기</td>
												<td>40,000,000 원</td>
												<td>1200 건</td>
												<td>210,000 원</td>
												<td>
													<a href="#" class="text-muted">
													<i class="fas fa-search"></i>
													</a>
												</td>
											</tr>
											<tr>
												<td>4</td>
												<td>섬진강캐첩</td>
												<td>40,000,000 원</td>
												<td>1200 건</td>
												<td>210,000 원</td>
												<td>
													<a href="#" class="text-muted">
													<i class="fas fa-search"></i>
													</a>
												</td>
											</tr>
											<tr>
												<td>5</td>
												<td>강동참다래매실농원</td>
												<td>40,000,000 원</td>
												<td>1200 건</td>
												<td>210,000 원</td>
												<td>
													<a href="#" class="text-muted">
													<i class="fas fa-search"></i>
													</a>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					
						<!-- 상품 판매 상태 -->
						<div class="col-md-6">
							<div class="card">
								<div class="card-header border-transparent">
									<h3 class="card-title">상품</h3>
								</div>
								<div class="card-body p-0">
									<table class="table m-0">
										<thead>
											<tr>
												<th style="width: 100px">상품</th>
												<th></th>
												<th style="width: 100px">개수</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>전체</td>
												<td></td>
												<td><button type="button" class="btn btn-block btn-primary btn-sm">120개</button></td>
											</tr>
											<tr>
												<td>판매중</td>
												<td style="vertical-align: middle;">
													<div class="progress progress-xs">
														<div class="progress-bar progress-bar-danger" style="width: 80%;"></div>
													</div>
												</td>
												<td><button type="button" class="btn btn-block btn-success btn-sm">100개</button></td>
											</tr>
											<tr>
												<td>품절</td>
												<td style="vertical-align: middle;">
													<div class="progress progress-xs">
														<div class="progress-bar progress-bar-danger" style="width: 20%;"></div>
													</div>
												</td>
												<td><button type="button" class="btn btn-block btn-danger btn-sm">22개</button></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>	
						</div>	
						
						<!-- 상품 판매 상태 -->
						<div class="col-md-6">
							<div class="card">
								<div class="card-header border-transparent">
									<h3 class="card-title">상품</h3>
								</div>
								<div class="card-body p-0">
									<table class="table table-striped table-valign-middle">
										<thead>
											<tr>
												<th class="" style="width: 10%;"></th>
												<th class="sort" style="min-width: 200px; width: 30%;">상품</th>
												<th class="sort" style="width: 15%;">판매가</th>
												<th class="sort" style="width: 10%;">주문</th>
												<th class="text-end sort" style="width: 15%;">총 판매금액</th>
												<th class="text-end sort" style="width: 15%;">순이익</th>
												<th class="" style="width: 5%;"></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>
													<a class="rounded-2 border border-translucent d-inline-block" href="/apps/e-commerce/customer/product-details" style="border-radius: 50%; background: white;">
														<img  src="<c:url value='/assets/img/product/maesil.jpg'/>" alt="" width="30" height="30" style="border-radius: 50%; background: white;">
													</a>
												</td>
												<td>참매실 15kg 특대</td>
												<td>20,000 원</td>
												<td>22 건</td>
												<td>440,000 원</td>
												<td>
													100,000 원
												</td>
												<td>
													<a href="#" class="text-muted">
													<i class="fas fa-search"></i>
													</a>
												</td>
											</tr>
											<tr>
												<td>
													<a class="rounded-2 border border-translucent d-inline-block" href="/apps/e-commerce/customer/product-details" style="border-radius: 50%; background: white;">
														<img  src="<c:url value='/assets/img/product/maesil.jpg'/>" alt="" width="30" height="30" style="border-radius: 50%; background: white;">
													</a>
												</td>
												<td>참매실 15kg 특대</td>
												<td>20,000 원</td>
												<td>22 건</td>
												<td>440,000 원</td>
												<td>
													100,000 원
												</td>
												<td>
													<a href="#" class="text-muted">
													<i class="fas fa-search"></i>
													</a>
												</td>
											</tr>
											<tr>
												<td>
													<a class="rounded-2 border border-translucent d-inline-block" href="/apps/e-commerce/customer/product-details" style="border-radius: 50%; background: white;">
														<img  src="<c:url value='/assets/img/product/maesil.jpg'/>" alt="" width="30" height="30" style="border-radius: 50%; background: white;">
													</a>
												</td>
												<td>참매실 15kg 특대</td>
												<td>20,000 원</td>
												<td>22 건</td>
												<td>440,000 원</td>
												<td>
													100,000 원
												</td>
												<td>
													<a href="#" class="text-muted">
													<i class="fas fa-search"></i>
													</a>
												</td>
											</tr>
											<tr>
												<td>
													<a class="rounded-2 border border-translucent d-inline-block" href="/apps/e-commerce/customer/product-details" style="border-radius: 50%; background: white;">
														<img  src="<c:url value='/assets/img/product/maesil.jpg'/>" alt="" width="30" height="30" style="border-radius: 50%; background: white;">
													</a>
												</td>
												<td>참매실 15kg 특대</td>
												<td>20,000 원</td>
												<td>22 건</td>
												<td>440,000 원</td>
												<td>
													100,000 원
												</td>
												<td>
													<a href="#" class="text-muted">
													<i class="fas fa-search"></i>
													</a>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<!-- 상품 판매 상태 -->
						<div class="col-md-6">
							<div class="card">
								<div class="card-header border-transparent">
									<h3 class="card-title">메모</h3>
									<div class="card-tools">
										<div class="btn-group float-left" style="margin-top: 2px;">
											<select style="width: 100px; height: 35px; margin-right: 5px;">
												<option>1월</option>
												<option>2월</option>
												<option>3월</option>
											</select>
											<button type="button" class="btn btn-success btn-xs float-right" style="width: 100px;">
												저장
											</button>
										</div>
									</div>
								</div>
								<div class="card-body p-0" style="margin: 10px;">
									<textarea class="form-control" rows="10" placeholder="Enter ...">1월에 악양 딸기 판매준비 수박 준비하고 한라봉 팔고
									</textarea>
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