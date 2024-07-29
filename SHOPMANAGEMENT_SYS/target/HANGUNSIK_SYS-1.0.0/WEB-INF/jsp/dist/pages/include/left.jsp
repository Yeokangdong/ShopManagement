<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>AdminLTE v4 | Dashboard</title><!--begin::Primary Meta Tags-->
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
    <link rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/OverlayScrollbars.min.css"'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/adminlte.min.css?v=3.2.0'/>"/><!--end::Required Plugin(AdminLTE)--><!-- apexcharts -->
    
    <!-- 스크립트 -->
    <script type="text/javascript" src="<c:url value='/js/bootstrap.bundle.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/include/left.js'/>"></script>
</head> <!--end::Head--> <!--begin::Body-->

<body class="dark-mode sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed text-sm" style="height: auto;">
	<!-- 좌측메뉴-->
	<aside class="main-sidebar sidebar-dark-primary elevation-4">
		<a href="index3.html" class="brand-link">
			<img src="<c:url value='/assets/img/logo/logo.png'/>" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="width:30px; height:30px;">
			<span class="brand-text font-weight-light">한건식</span>
		</a>
		<div class="sidebar os-host os-theme-light os-host-overflow os-host-overflow-y os-host-resize-disabled os-host-scrollbar-horizontal-hidden os-host-transition">
			<div class="os-resize-observer-host observed">
				<div class="os-resize-observer" style="left: 0px; right: auto;"></div>
			</div>
			<div class="os-size-auto-observer observed" style="height: calc(100% + 1px); float: left;">
				<div class="os-resize-observer"></div>
			</div>
			<div class="os-content-glue" style="margin: 0px -8px; width: 249px; height: 838px;"></div>
				<div class="os-padding">
					<div class="os-viewport os-viewport-native-scrollbars-invisible" style="overflow-y: scroll;">
						<div class="os-content" style="padding: 0px 8px; height: 100%; width: 100%; top: 10px;">
							<div class="form-inline"></div>
							
							<!-- 통합검색 -->
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">통합검색</button>
									<div class="dropdown-menu" style="">
										<a class="dropdown-item" href="#">수취인명</a>
										<a class="dropdown-item" href="#">업체명</a>
										<a class="dropdown-item" href="#">업체ID</a>
										<a class="dropdown-item" href="#">주문번호</a>
										<a class="dropdown-item" href="#">운송장번호</a>
									</div>
								</div>
								<input type="text" class="form-control">
							</div>
							<div class="form-inline"></div>
							<nav class="mt-2">
								<ul class="nav nav-pills nav-sidebar flex-column nav-flat nav-compact" data-widget="treeview" role="menu" data-accordion="false">
									<li class="nav-item menu-open">
										<a href="#" class="nav-link">
											<img alt="" src="<c:url value='/assets/img/left/product.png'/>" class="img-circle-white"/>
											<p>상품관리</p>
											<i class="right fas fa-angle-left"></i>
										</a>
										<ul class="nav nav-treeview">
											<li class="nav-item">
												<a href="javascript:pageProduct();" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>상품 조회/상세</p>
												</a>
											</li>
											<li class="nav-item">
												<a href="javascript:pageProductReg();" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>상품 등록/수정</p>
												</a>
											</li>
											<li class="nav-item">
												<a href="javascript:pageCategoryReg();" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>카테고리(품목)/스토어</p>
												</a>
											</li>
										</ul>
									</li>
									<li class="nav-item menu-open">
										<a href="#" class="nav-link">
											<img alt="" src="<c:url value='/assets/img/left/company.png'/>" class="img-circle-white"/>
											<p>업체관리</p>
											<i class="right fas fa-angle-left"></i>
										</a>
										<ul class="nav nav-treeview">
											<li class="nav-item">
												<a href="javascript:pageCompany();" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>업체 조회</p>
												</a>
											</li>
											<li class="nav-item">
												<a href="javascript:pageCompanyReg();" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>업체 등록/수정</p>
												</a>
											</li>
											<li class="nav-item">
												<a href="javascript:pageEmployeeReg();" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>직원 등록/수정</p>
												</a>
											</li>
										</ul>
									</li>
									<li class="nav-item menu-open">
										<a href="#" class="nav-link">
											<img alt="" src="<c:url value='/assets/img/left/order.png'/>" class="img-circle-white"/>
											<p>주문 하기</p>
											<i class="right fas fa-angle-left"></i>
										</a>
										<ul class="nav nav-treeview">
											<li class="nav-item">
												<a href="javascript:pageOrder1Reg();" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>다중 주문</p>
												</a>
											</li>
											<li class="nav-item">
												<a href="javascript:pageOrder2Reg();" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>개별 주문</p>
												</a>
											</li>
										</ul>
									</li>
									<li class="nav-item menu-open">
										<a href="#" class="nav-link">
											<img alt="" src="<c:url value='/assets/img/left/sell.png'/>" class="img-circle-white"/>
											<p>판매 관리</p>
											<i class="right fas fa-angle-left"></i>
										</a>
										<ul class="nav nav-treeview">
											<li class="nav-item">
												<a href="javascript:pageOrderInfo();" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>주문 내역</p>
												</a>
											</li>
											<li class="nav-item">
												<a href="javascript:pageOrderCompleteInfo();" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>배송 완료 내역</p>
												</a>
											</li>
											<li class="nav-item">
												<a href="javascript:pageOrderCancelInfo();" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>취소 내역</p>
												</a>
											</li>
											<li class="nav-item">
												<a href="./index2.html" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>반품 관리</p>
												</a>
											</li>
											<li class="nav-item">
												<a href="./index2.html" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>교환 관리</p>
												</a>
											</li>
										</ul>
									</li>
									<li class="nav-item">
										<a href="javascript:pageDeliveryTracking();" class="nav-link">
											<img alt="" src="<c:url value='/assets/img/left/traking.png'/>" class="img-circle-white"/>
											<p>상품 추적</p>
										</a>
									</li>
									<li class="nav-item menu-open">
										<a href="#" class="nav-link">
											<img alt="" src="<c:url value='/assets/img/left/money.png'/>" class="img-circle-white"/>
											<p>정산 관리</p>
											<i class="right fas fa-angle-left"></i>
										</a>
										<ul class="nav nav-treeview">
											<li class="nav-item">
												<a href="./index.html" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>예치금 충전/환급</p>
												</a>
											</li>
											<li class="nav-item">
												<a href="./index2.html" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>정산 내역</p>
												</a>
											</li>
										</ul>
									</li>
									<li class="nav-item">
										<a href="javascript:pageCustomerDB();" class="nav-link">
											<img alt="" src="<c:url value='/assets/img/left/customerDB.png'/>" class="img-circle-white"/>
											<p>고객DB</p>
										</a>
									</li>
									<li class="nav-item">
										<a href="#" class="nav-link">
											<img alt="" src="<c:url value='/assets/img/left/inquiry.png'/>" class="img-circle-white"/>
											<p>문의 관리</p>
										</a>
									</li>
									<li class="nav-item">
										<a href="#" class="nav-link">
											<img alt="" src="<c:url value='/assets/img/left/calc.png'/>" class="img-circle-white"/>
											<p>마진/광고 계산기</p>
										</a>
									</li>
									<li class="nav-item menu-open">
										<a href="#" class="nav-link">
											<img alt="" src="<c:url value='/assets/img/left/catalog.png'/>" class="img-circle-white"/>
											<p>카달로그</p>
											<i class="right fas fa-angle-left"></i>
										</a>
										<ul class="nav nav-treeview">
											<li class="nav-item">
												<a href="./index.html" class="nav-link">
													<i class="far fa-circle nav-icon"></i>
													<p>카달로그 팝업 등록</p>
												</a>
											</li>
										</ul>
									</li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
				<div class="os-scrollbar os-scrollbar-horizontal os-scrollbar-unusable os-scrollbar-auto-hidden"><div class="os-scrollbar-track">
					<div class="os-scrollbar-handle" style="width: 100%; transform: translate(0px, 0px);"></div>
				</div>
			</div>
			<div class="os-scrollbar os-scrollbar-vertical os-scrollbar-auto-hidden">
				<div class="os-scrollbar-track">
					<div class="os-scrollbar-handle" style="height: 65.9308%; transform: translate(0px, 0px);"></div>
				</div>
			</div>
			<div class="os-scrollbar-corner"></div>
		</div>
	</aside>
</body>
</html>