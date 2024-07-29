<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>한건식 | 상품 조회</title><!--begin::Primary Meta Tags-->
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
    <script type="text/javascript" src="<c:url value='/js/product/product.js'/>"></script>
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
							<h1 class="m-0">상품 조회</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">상품 조회</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
	
			<section class="content">
				<div class="container-fluid">	
					<div class="row">
						<div class="col-md-12">
							<div class="callout callout-info" style="padding: 10px;">
								<h5><i class="fas fa-info"></i> 과실/과일</h5>
							</div>
						</div>	
						<div class="col-md-3">
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<span class="badge badge-primary" style="width: 100px; height: 25px; font-size: 15px;"><i class="fa fa-exclamation"></i> 판매중</span>
									<div class="text-center">
										<img class="profile-user-img img-fluid img-circle" src="<c:url value='/assets/img/product/maesil.jpg'/>" alt="User profile picture" style="width: 100px; height: 100px;">
									</div>
									<h3 class="profile-username text-center">하동매실</h3>
									<p class="text-muted text-center">제조사 : 하동참다래매실농원</p>
									<ul class="list-group list-group-unbordered mb-3">
										<li class="list-group-item">
											<b>주문기간</b><span class="float-right">2024-06-20 ~ 2024-07-30</span>
										</li>
										<li class="list-group-item">
											<b>판매가</b><span class="float-right">₩42,000원</span>
										</li>
										<li class="list-group-item">
											<b>부가세</b><span class="float-right">면세상품</span>
										</li>
										<li class="list-group-item">
											<b>재고수량</b> <span class="float-right">9,999</span>
										</li>
										<li class="list-group-item">
											<b>택배비</b><span class="float-right">₩4,000원</span>
										</li>
										<li class="list-group-item">
											<div style="height: 80px; overflow-y: auto;">
												<b>하동 지역의 매실은 지리산의 맑은 공기와 섬진강의 맑은 물 등 최상의 자연 조건에서 재배된다. 친환경적으로 재배되고 있으며 다른 지역 매실보다 단단하고 향이 독특하여 전국적으로 지명도가 높아 큰 인기를 얻고 있다.</b>
											</div>
										</li>
									</ul>
									<div class="btn-group" style="width: 100%;">
										<a href="javascript:pageProductDetail();" class="btn btn-primary" style="width: 50%;" ><b>상세보기</b></a>
										<a href="javascript:pageProductDetail();" class="btn btn-warning" style="width: 50%;"><b>수정</b></a>
									</div>	
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<span class="badge badge-danger" style="width: 100px; height: 25px; font-size: 15px;"><i class="fa fa-ban"></i> 판매중지</span>
									<div class="text-center">
										<img class="profile-user-img img-fluid img-circle" src="<c:url value='/assets/img/product/bae.jpg'/>" alt="User profile picture" style="width: 100px; height: 100px;">
									</div>
									<h3 class="profile-username text-center">하동배</h3>
									<p class="text-muted text-center">공급처 : 경원농장</p>
									<ul class="list-group list-group-unbordered mb-3">
										<li class="list-group-item">
											<b>주문기간</b><span class="float-right">상시</span>
										</li>
										<li class="list-group-item">
											<b>판매가</b><span class="float-right">₩42,000원</span>
										</li>
										<li class="list-group-item">
											<b>부가세</b><span class="float-right">면세상품</span>
										</li>
										<li class="list-group-item">
											<b>재고수량</b> <span class="float-right">9,999</span>
										</li>
										<li class="list-group-item">
											<b>택배비</b><span class="float-right">₩4,000원</span>
										</li>
										<li class="list-group-item">
											<div style="height: 80px; overflow-y: auto;">
												<b>하동 지역 배는 지리산 자락 섬진강 변의 사질 양토에서 생산되고 있으며, 무공해 재배로 당도가 높고 연하며, 즙과 비타민이 많다. 향긋한 맛이 일품으로 하동 꿀배로 알려져 있다. 하동 지역 배는 맛을 인증 받아 일본 등 해외로 널리 수출하고 있으며 정부 품질 인증을 획득하였다.</b>
											</div>	
										</li>
									</ul>
									<div class="btn-group" style="width: 100%;">
										<a href="javascript:pageProductDetail();" class="btn btn-primary" style="width: 50%;" ><b>상세보기</b></a>
										<a href="javascript:pageProductDetail();" class="btn btn-warning" style="width: 50%;"><b>수정</b></a>
									</div>	
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<span class="badge badge-primary" style="width: 100px; height: 25px; font-size: 15px;"><i class="fa fa-exclamation"></i> 판매중</span>
									<div class="text-center">
										<img class="profile-user-img img-fluid img-circle" src="<c:url value='/assets/img/product/gam.jpg'/>" alt="User profile picture" style="width: 100px; height: 100px;">
									</div>
									<h3 class="profile-username text-center">악양대봉감</h3>
									<p class="text-muted text-center">공급처 : 악양대봉농원</p>
									<ul class="list-group list-group-unbordered mb-3">
										<li class="list-group-item">
											<b>주문기간</b><span class="float-right">2024-06-20 ~ 2024-07-30</span>
										</li>
										<li class="list-group-item">
											<b>판매가</b><span class="float-right">₩42,000원</span>
										</li>
										<li class="list-group-item">
											<b>부가세</b><span class="float-right">면세상품</span>
										</li>
										<li class="list-group-item">
											<b>재고수량</b> <span class="float-right">9,999</span>
										</li>
										<li class="list-group-item">
											<b>택배비</b><span class="float-right">₩4,000원</span>
										</li>
										<li class="list-group-item">
											<div style="height: 80px; overflow-y: auto;">
												<b>대봉감, (또아리감, 왜감 등 지방에 따라 달리 부른다) 여러 종류가 있으며, 우리 나라 전역에 분포되어 있긴 하나 주로 따뜻한 남쪽 지방에 많다. 감의 껍질을 벗겨 말린 것을 곶감이라 하는데, 이는 수정과의 재료로 쓰인다.</b>
											</div>	
										</li>
									</ul>
									<div class="btn-group" style="width: 100%;">
										<a href="javascript:pageProductDetail();" class="btn btn-primary" style="width: 50%;" ><b>상세보기</b></a>
										<a href="javascript:pageProductDetail();" class="btn btn-warning" style="width: 50%;"><b>수정</b></a>
									</div>	
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<span class="badge badge-primary" style="width: 100px; height: 25px; font-size: 15px;"><i class="fa fa-exclamation"></i> 판매중</span>
									<div class="text-center">
										<img class="profile-user-img img-fluid img-circle" src="<c:url value='/assets/img/product/chamdarae.jpg'/>" alt="User profile picture" style="width: 100px; height: 100px;">
									</div>
									<h3 class="profile-username text-center">참다래</h3>
									<p class="text-muted text-center">공급처 : 악양대봉농원</p>
									<ul class="list-group list-group-unbordered mb-3">
										<li class="list-group-item">
											<b>주문기간</b><span class="float-right">2024-06-20 ~ 2024-07-30</span>
										</li>
										<li class="list-group-item">
											<b>판매가</b><span class="float-right">₩42,000원</span>
										</li>
										<li class="list-group-item">
											<b>부가세</b><span class="float-right">면세상품</span>
										</li>
										<li class="list-group-item">
											<b>재고수량</b> <span class="float-right">9,999</span>
										</li>
										<li class="list-group-item">
											<b>택배비</b><span class="float-right">₩4,000원</span>
										</li>
										<li class="list-group-item">
											<div style="height: 80px; overflow-y: auto;">
												<b>우리나라 참다래는 뉴질랜드산에 비해 껍질이 더 녹갈색을 띄며 두껍고 털이 많다. 모양도 매끈한 계란형이기보단 불규칙한 모양이고 신맛이 더 강하다. 우리나라에서 참다래가 주로 재배되고 있는 지역은 전남, 경남, 제주도이다.</b>
											</div>	
										</li>
									</ul>
									<div class="btn-group" style="width: 100%;">
										<a href="javascript:pageProductDetail();" class="btn btn-primary" style="width: 50%;" ><b>상세보기</b></a>
										<a href="javascript:pageProductDetail();" class="btn btn-warning" style="width: 50%;"><b>수정</b></a>
									</div>	
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="callout callout-info" style="padding: 10px;">
								<h5><i class="fas fa-info"></i> 가공식품</h5>
							</div>
						</div>	
						<div class="col-md-3">
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<span class="badge badge-primary" style="width: 100px; height: 25px; font-size: 15px;"><i class="fa fa-exclamation"></i> 판매중</span>
									<div class="text-center">
										<img class="profile-user-img img-fluid img-circle" src="<c:url value='/assets/img/product/jaechub.jpg'/>" alt="User profile picture" style="width: 100px; height: 100px;">
									</div>
									<h3 class="profile-username text-center">섬진강재첩</h3>
									<p class="text-muted text-center">공급처 : 김정문의 섬진강재첩</p>
									<ul class="list-group list-group-unbordered mb-3">
										<li class="list-group-item">
											<b>주문기간</b><span class="float-right">2024-06-20 ~ 2024-07-30</span>
										</li>
										<li class="list-group-item">
											<b>판매가</b><span class="float-right">₩42,000원</span>
										</li>
										<li class="list-group-item">
											<b>부가세</b><span class="float-right">면세상품</span>
										</li>
										<li class="list-group-item">
											<b>재고수량</b> <span class="float-right">9,999</span>
										</li>
										<li class="list-group-item">
											<b>택배비</b><span class="float-right">₩4,000원</span>
										</li>
										<li class="list-group-item">
											<div style="height: 80px; overflow-y: auto;">
												<b>재칩국·재치국이라고도 하며, 경상도 지방의 향토음식이다. 재첩은 난류와 한류가 교차되고 염분이 적은 곳에서 서식하는 조개로, 낙동강하류와 김해·명지·엄궁·하단등 강 유역, 부산의 수영강 근처, 섬진강 하류 등에서 많이 산출되고 있으며, 어부들이 전마선을 타고 강가에서 잡는다.</b>
											</div>	
										</li>
									</ul>
									<div class="btn-group" style="width: 100%;">
										<a href="javascript:pageProductDetail();" class="btn btn-primary" style="width: 50%;" ><b>상세보기</b></a>
										<a href="javascript:pageProductDetail();" class="btn btn-warning" style="width: 50%;"><b>수정</b></a>
									</div>	
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<span class="badge badge-danger" style="width: 100px; height: 25px; font-size: 15px;"><i class="fa fa-ban"></i> 판매중지</span>
									<div class="text-center">
										<img class="profile-user-img img-fluid img-circle" src="<c:url value='/assets/img/product/maesilchung.jpg'/>" alt="User profile picture" style="width: 100px; height: 100px;">
									</div>
									<h3 class="profile-username text-center">매실청</h3>
									<p class="text-muted text-center">공급처 : 하동참다래매실농원</p>
									<ul class="list-group list-group-unbordered mb-3">
										<li class="list-group-item">
											<b>주문기간</b><span class="float-right">2024-06-20 ~ 2024-07-30</span>
										</li>
										<li class="list-group-item">
											<b>판매가</b><span class="float-right">₩42,000원</span>
										</li>
										<li class="list-group-item">
											<b>부가세</b><span class="float-right">면세상품</span>
										</li>
										<li class="list-group-item">
											<b>재고수량</b> <span class="float-right">9,999</span>
										</li>
										<li class="list-group-item">
											<b>택배비</b><span class="float-right">₩4,000원</span>
										</li>
										<li class="list-group-item">
											<div style="height: 80px; overflow-y: auto;">
												<b>매실청은 매실로 만든 조청이다. 매실차로 마시거나, 달콤한 맛을 내는 조미료로 이용한다. 전라남도에서는 씨를 제거하고 저며 썬 익은 황매실과 설탕을 유리병에 켜켜이 담아 3일간 재워두었다가 물을 따라내어 5∼6시간 조려 만든다.</b>
											</div>	
										</li>
									</ul>
									<div class="btn-group" style="width: 100%;">
										<a href="javascript:pageProductDetail();" class="btn btn-primary" style="width: 50%;" ><b>상세보기</b></a>
										<a href="javascript:pageProductDetail();" class="btn btn-warning" style="width: 50%;"><b>수정</b></a>
									</div>	
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<span class="badge badge-primary" style="width: 100px; height: 25px; font-size: 15px;"><i class="fa fa-exclamation"></i> 판매중</span>
									<div class="text-center">
										<img class="profile-user-img img-fluid img-circle" src="<c:url value='/assets/img/product/ggotgam.jpg'/>" alt="User profile picture" style="width: 100px; height: 100px;">
									</div>
									<h3 class="profile-username text-center">꽂감</h3>
									<p class="text-muted text-center">공급처 : (주)하동악양꽂감</p>
									<ul class="list-group list-group-unbordered mb-3">
										<li class="list-group-item">
											<b>주문기간</b><span class="float-right">2024-06-20 ~ 2024-07-30</span>
										</li>
										<li class="list-group-item">
											<b>판매가</b><span class="float-right">₩42,000원</span>
										</li>
										<li class="list-group-item">
											<b>부가세</b><span class="float-right">면세상품</span>
										</li>
										<li class="list-group-item">
											<b>재고수량</b> <span class="float-right">9,999</span>
										</li>
										<li class="list-group-item">
											<b>택배비</b><span class="float-right">₩4,000원</span>
										</li>
										<li class="list-group-item">
											<div style="height: 80px; overflow-y: auto;">
												<b>곶감은 껍질을 벗겨 말린 감이다. 건시(乾枾)라고도 한다. 명절이나 제사 때 자주 쓰인다. 꼬챙이에 꿰지 않고 납작하게 말린 준시는 큰상차림에 많이 쓰이고, 꼭지를 실로 꿰어 말린 주머니 곶감은 수정과에 넣어 먹거나 호두를 안에 넣고 만 곶감쌈을 만들어 먹는다.</b>
											</div>	
										</li>
									</ul>
									<div class="btn-group" style="width: 100%;">
										<a href="javascript:pageProductDetail();" class="btn btn-primary" style="width: 50%;" ><b>상세보기</b></a>
										<a href="javascript:pageProductDetail();" class="btn btn-warning" style="width: 50%;"><b>수정</b></a>
									</div>	
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="callout callout-info" style="padding: 10px;">
								<h5><i class="fas fa-info"></i> 채소</h5>
							</div>
						</div>	
						<div class="col-md-3">
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<span class="badge badge-danger" style="width: 100px; height: 25px; font-size: 15px;"><i class="fa fa-ban"></i> 판매중지</span>
									<div class="text-center">
										<img class="profile-user-img img-fluid img-circle" src="<c:url value='/assets/img/product/doorb.jpg'/>" alt="User profile picture" style="width: 100px; height: 100px;">
									</div>
									<h3 class="profile-username text-center">두릅</h3>
									<p class="text-muted text-center">공급처 : 정현성의 지리산두릅</p>
									<ul class="list-group list-group-unbordered mb-3">
										<li class="list-group-item">
											<b>주문기간</b><span class="float-right">2024-06-20 ~ 2024-07-30</span>
										</li>
										<li class="list-group-item">
											<b>판매가</b><span class="float-right">₩42,000원</span>
										</li>
										<li class="list-group-item">
											<b>부가세</b><span class="float-right">면세상품</span>
										</li>
										<li class="list-group-item">
											<b>재고수량</b> <span class="float-right">9,999</span>
										</li>
										<li class="list-group-item">
											<b>택배비</b><span class="float-right">₩4,000원</span>
										</li>
										<li class="list-group-item">
											<div style="height: 80px; overflow-y: auto;">
												<b>두릅은 두릅나무의 어린 순이다. 두릅나무는 오갈피나무과에 속하는 낙엽 활엽의 관목이다. 한국, 중국, 일본에 분포되어 있으며 산과들에 자생한다. 두릅은 강한 향기를 가지고 있으며 흰색으로 뚜렷한 가지는 없고 두터운 것이 부드러워서 품질이 좋다.</b>
											</div>	
										</li>
									</ul>
									<div class="btn-group" style="width: 100%;">
										<a href="javascript:pageProductDetail();" class="btn btn-primary" style="width: 50%;" ><b>상세보기</b></a>
										<a href="javascript:pageProductDetail();" class="btn btn-warning" style="width: 50%;"><b>수정</b></a>
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