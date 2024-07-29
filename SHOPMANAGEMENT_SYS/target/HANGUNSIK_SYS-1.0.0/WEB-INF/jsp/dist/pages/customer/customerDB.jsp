<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>한건식 | 고객DB</title><!--begin::Primary Meta Tags-->
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
    
    <script type="text/javascript" src="<c:url value='/js/plugins/jquery.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/customerDB/customerDB.js'/>"></script>
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
							<h1 class="m-0">고객DB</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">고객DB</li>
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
									<h3 class="card-title">고객DB ( 115건 )</h3>
									<div class="card-tools">
										<div class="btn-group float-left" style="width: 400px; margin-right: 10px; margin-top: 2px;">
											<button type="button" class="btn btn-height btn-default float-left" style="margin-right: 5px; padding-top: 3px;">
												<i class="fa fa-comments"></i>
												문자전송
											</button>
											<button type="button" class="btn btn-height btn-default float-left" style="margin-right: 5px; padding-top: 3px;">
												<i class="fa fa-download"></i>
												다운로드
											</button>
											<div class="btn-group float-left" style="margin-left: 5px; margin-right: 5px;">
												<select style="width: 150px; height: 30px;">
													<option>고객명</option>
													<option>고객ID</option>
													<option>전화번호</option>
												</select>
											</div>
										</div>	
										<div class="input-group input-group-sm float-left" style="width: 200px; margin-top: 1px;">
											<input type="text" name="table_search" class="form-control float-right" placeholder="Search">
											<div class="input-group-append">
												<button type="submit" class="btn btn-default">
													<i class="fas fa-search"></i>
												</button>
											</div>
										</div>
										<div class="btn-group float-left" style="width: 80px; margin-left: 10px; margin-right: 10px; margin-top: 2px;">
											<select style="width: 120px;height: 30px;">
												<option>전체</option>
												<option>VVIP</option>
												<option>VIP</option>
												<option>Family</option>
												<option>첫주문</option>
											</select>
										</div>
										<div class="float-left" style="width: 130px; margin-left: 20px;">1-50 / 200
											<div class="btn-group">
												<button type="button" class="btn btn-default btn-sm">
													<i class="fas fa-chevron-left"></i>
												</button>
												<button type="button" class="btn btn-default btn-sm">
													<i class="fas fa-chevron-right"></i>
												</button>
											</div>
										</div>
									</div>	
								</div>
								<div class="card-body p-0" style="margin: 10px;">
									<table class="table table-bordered table-hover dataTable dtr-inline">
										<thead>
											<tr>
												<th><input type="checkbox" id="checkboxPrimary1" class="check-group" checked="checked"></th>
												<th>고객명</th>
												<th>고객ID</th>
												<th>전화번호</th>
												<th>주요주문상품</th>
												<th>총 주문</th>
												<th>총 주문금액</th>
												<th>최종주문</th>
												<th>등급</th>
												<th>선택</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input type="checkbox" id="checkboxPrimary1" class="check-group" checked="checked"></td>
												<td>여강동</td>
												<td>cu_001</td>
												<td>000-000-0000</td>
												<td>매실/배</td>
												<td>10 건</td>
												<td>250,000 원</td>
												<td>2024-08-25</td>
												<td>VVIP</td>
												<td>
													<button type="button" class="btn btn-info btn-xs float-left" style="width: 50px; margin-right: 5px;">
														정보
													</button>
													<button type="button" class="btn btn-warning btn-xs float-left" style="width: 50px; margin-right: 5px;">
														수정
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														삭제
													</button>
												</td>	
											</tr>
											<tr>
												<td><input type="checkbox" id="checkboxPrimary1" class="check-group" checked="checked"></td>
												<td>여강동</td>
												<td>cu_001</td>
												<td>000-000-0000</td>
												<td>매실/배</td>
												<td>10 건</td>
												<td>250,000 원</td>
												<td>2024-08-25</td>
												<td>VVIP</td>
												<td>
													<button type="button" class="btn btn-info btn-xs float-left" style="width: 50px; margin-right: 5px;">
														정보
													</button>
													<button type="button" class="btn btn-warning btn-xs float-left" style="width: 50px; margin-right: 5px;">
														수정
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														삭제
													</button>
												</td>	
											</tr>
											<tr>
												<td><input type="checkbox" id="checkboxPrimary1" class="check-group" checked="checked"></td>
												<td>여강동</td>
												<td>cu_001</td>
												<td>000-000-0000</td>
												<td>매실/배</td>
												<td>10 건</td>
												<td>250,000 원</td>
												<td>2024-08-25</td>
												<td>VVIP</td>
												<td>
													<button type="button" class="btn btn-info btn-xs float-left" style="width: 50px; margin-right: 5px;">
														정보
													</button>
													<button type="button" class="btn btn-warning btn-xs float-left" style="width: 50px; margin-right: 5px;">
														수정
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														삭제
													</button>
												</td>	
											</tr>
											<tr>
												<td><input type="checkbox" id="checkboxPrimary1" class="check-group" checked="checked"></td>
												<td>여강동</td>
												<td>cu_001</td>
												<td>000-000-0000</td>
												<td>매실/배</td>
												<td>10 건</td>
												<td>250,000 원</td>
												<td>2024-08-25</td>
												<td>VIP</td>
												<td>
													<button type="button" class="btn btn-info btn-xs float-left" style="width: 50px; margin-right: 5px;">
														정보
													</button>
													<button type="button" class="btn btn-warning btn-xs float-left" style="width: 50px; margin-right: 5px;">
														수정
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														삭제
													</button>
												</td>
											</tr>
											<tr>
												<td><input type="checkbox" id="checkboxPrimary1" class="check-group" checked="checked"></td>
												<td>여강동</td>
												<td>cu_001</td>
												<td>000-000-0000</td>
												<td>매실/배</td>
												<td>10 건</td>
												<td>250,000 원</td>
												<td>2024-08-25</td>
												<td>Family</td>
												<td>
													<button type="button" class="btn btn-info btn-xs float-left" style="width: 50px; margin-right: 5px;">
														정보
													</button>
													<button type="button" class="btn btn-warning btn-xs float-left" style="width: 50px; margin-right: 5px;">
														수정
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														삭제
													</button>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>	
						<div class="col-md-6">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">고객 정보</h3>
									<div class="card-tools">
										<span class="badge badge-info" style="font-size: 15px;">VVIP</span>
									</div>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label for="exampleInputEmail1">고객ID</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>	
										<div class="col-md-4">
											<div class="form-group">
												<label for="exampleInputEmail1">고객명</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>	
										<div class="col-md-4">
											<div class="form-group">
												<label for="exampleInputEmail1">전화번호</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="exampleInputEmail1">이메일</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="exampleInputEmail1">총 주문금액(원)</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>	
										<div class="col-md-12">
											<div class="form-group">
												<label for="exampleInputEmail1">주소</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>		
										<div class="col-md-6">
											<div class="form-group">
												<label for="exampleInputEmail1">주요주문상품</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>		
										<div class="col-md-6">
											<div class="form-group">
												<label for="exampleInputEmail1">최종주문</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>	
										<div class="col-md-3">
											<div class="form-group">
												<label for="exampleInputEmail1">주문(건)</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>	
										<div class="col-md-3">
											<div class="form-group">
												<label for="exampleInputEmail1">반품(건)</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>	
										<div class="col-md-3">
											<div class="form-group">
												<label for="exampleInputEmail1">교환(건)</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>	
										<div class="col-md-3">
											<div class="form-group">
												<label for="exampleInputEmail1">취소(건)</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>	
									</div>	
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="col-md-12">
									<div class="card">
										<div class="card-header">
											<h3 class="card-title">전체 고객 주문</h3>
										</div>	
										<div class="card-body">
											<div class="row">
												<div class="col-md-6">
													<div class="row">
														<div class="col-md-8">
															<div class="chart-responsive">
																<div class="chartjs-size-monitor">
																	<div class="chartjs-size-monitor-expand">
																		<div class=""></div>
																	</div>
																	<div class="chartjs-size-monitor-shrink">
																		<div class=""></div>
																	</div>
																</div>
																<canvas id="customerDBRankChart" height="126" width="252" style="display: block; width: 252px; height: 126px;" class="chartjs-render-monitor"></canvas>
															</div>
														</div>
														<div class="col-md-4">
															<ul class="chart-legend clearfix">
																<li><i class="far fa-circle text-danger"></i> 매실</li>
																<li><i class="far fa-circle text-success"></i> 배</li>
																<li><i class="far fa-circle text-warning"></i> 대봉감</li>
																<li><i class="far fa-circle text-info"></i> 수박</li>
															</ul>
														</div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="row">
														<div class="col-md-8">
															<div class="chart-responsive">
																<div class="chartjs-size-monitor">
																	<div class="chartjs-size-monitor-expand">
																		<div class=""></div>
																	</div>
																	<div class="chartjs-size-monitor-shrink">
																		<div class=""></div>
																	</div>
																</div>
																<canvas id="customerDBOrderChart" height="126" width="252" style="display: block; width: 252px; height: 126px;" class="chartjs-render-monitor"></canvas>
															</div>
														</div>
														<div class="col-md-4">
															<ul class="chart-legend clearfix">
																<li><i class="far fa-circle text-danger"></i> VVIP</li>
																<li><i class="far fa-circle text-success"></i> VIP</li>
																<li><i class="far fa-circle text-warning"></i> Family</li>
																<li><i class="far fa-circle text-info"></i> 첫주문</li>
															</ul>
														</div>
													</div>	
												</div>	
											</div>
										</div>
									</div>
								</div>	
								<div class="col-md-12">	
									<div class="card">
										<div class="card-header border-transparent">
											<h3 class="card-title">전체 고객 주문수</h3>
										</div>
										<div class="card-body p-0">
											<div class="col-md-12">
												<canvas id="sellChart" class="chartjs-render-monitor" width="720" height="250" style="display: block; width: 720px; height: 250px;"></canvas>
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