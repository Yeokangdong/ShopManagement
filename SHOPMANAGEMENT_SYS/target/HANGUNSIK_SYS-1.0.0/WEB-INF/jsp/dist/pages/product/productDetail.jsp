<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>한건식 | 상품 상세</title><!--begin::Primary Meta Tags-->
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
							<h1 class="m-0">하동 매실 상세보기</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">상품 조회 / 상품 상세보기</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
	
			<section class="content">
<section class="content">

<div class="card card-solid">
<div class="card-body">
<div class="row">
<div class="col-12 col-sm-6">
<h3 class="d-inline-block d-sm-none">LOWA Men’s Renegade GTX Mid Hiking Boots Review</h3>
<div class="col-12">
<img src="<c:url value='/assets/img/product/maesil.jpg'/>" class="product-image" style="width: 500px; height: 500px;" alt="Product Image">
</div>
<div class="col-12 product-image-thumbs">
<div class="product-image-thumb active"><img src="<c:url value='/assets/img/product/maesil1.jpg'/>" alt="Product Image"></div>
<div class="product-image-thumb active"><img src="<c:url value='/assets/img/product/maesil.jpg'/>" alt="Product Image"></div>
<div class="product-image-thumb active"><img src="<c:url value='/assets/img/product/maesil.jpg'/>" alt="Product Image"></div>
<div class="product-image-thumb active"><img src="<c:url value='/assets/img/product/maesil.jpg'/>" alt="Product Image"></div>
<div class="product-image-thumb active"><img src="<c:url value='/assets/img/product/maesil.jpg'/>" alt="Product Image"></div>
</div>
</div>
<div class="col-12 col-sm-6">
<h3 class="my-3">하동매실</h3>
<p>하동 지역의 매실은 지리산의 맑은 공기와 섬진강의 맑은 물 등 최상의 자연 조건에서 재배된다. 친환경적으로 재배되고 있으며 다른 지역 매실보다 단단하고 향이 독특하여 전국적으로 지명도가 높아 큰 인기를 얻고 있다.</p>
<hr>
<h4>분류</h4>
<div class="btn-group btn-group-toggle" data-toggle="buttons">
<label class="btn btn-default text-center active">
<input type="radio" name="color_option" id="color_option_a1" autocomplete="off" checked="">
왕특
<br>
<i class="fas fa-circle fa-2x text-green"></i>
</label>
<label class="btn btn-default text-center">
<input type="radio" name="color_option" id="color_option_a2" autocomplete="off">
특대
<br>
<i class="fas fa-circle fa-2x text-blue"></i>
</label>
<label class="btn btn-default text-center">
<input type="radio" name="color_option" id="color_option_a3" autocomplete="off">
대
<br>
<i class="fas fa-circle fa-2x text-purple"></i>
</label>
<label class="btn btn-default text-center">
<input type="radio" name="color_option" id="color_option_a4" autocomplete="off">
중
<br>
<i class="fas fa-circle fa-2x text-red"></i>
</label>
<label class="btn btn-default text-center">
<input type="radio" name="color_option" id="color_option_a5" autocomplete="off">
소
<br>
<i class="fas fa-circle fa-2x text-orange"></i>
</label>
</div>
<h4 class="mt-3">무게</h4>
<div class="btn-group btn-group-toggle" data-toggle="buttons">
<label class="btn btn-default text-center">
<input type="radio" name="color_option" id="color_option_b1" autocomplete="off">
<br>
5kg
</label>
<label class="btn btn-default text-center">
<input type="radio" name="color_option" id="color_option_b2" autocomplete="off">
<br>
15kg
</label>
<label class="btn btn-default text-center">
<input type="radio" name="color_option" id="color_option_b3" autocomplete="off">
<br>
20kg
</label>
</div>
<div class="bg-gray py-2 px-3 mt-4">
<h2 class="mb-0">
가격: ₩30,000원
</h2>
<h4 class="mt-0">
<small>택배비: ₩4000원 </small>
</h4>
</div>
<div class="mt-4">
<div class="btn btn-primary btn-lg btn-flat">
<i class="fas fa-cart-plus fa-lg mr-2"></i>
Add to Cart
</div>
<div class="btn btn-default btn-lg btn-flat">
<i class="fas fa-heart fa-lg mr-2"></i>
Add to Wishlist
</div>
</div>
</div>
</div>
<div class="row mt-4">
<nav class="w-100">
<div class="nav nav-tabs" id="product-tab" role="tablist">
<a class="nav-item nav-link active" id="product-desc-tab" data-toggle="tab" href="#product-desc" role="tab" aria-controls="product-desc" aria-selected="true">상세설명</a>
<a class="nav-item nav-link" id="product-comments-tab" data-toggle="tab" href="#product-comments" role="tab" aria-controls="product-comments" aria-selected="false">Comments</a>
<a class="nav-item nav-link" id="product-rating-tab" data-toggle="tab" href="#product-rating" role="tab" aria-controls="product-rating" aria-selected="false">Rating</a>
</div>
</nav>
<div class="tab-content p-3" id="nav-tabContent">
<div class="tab-pane fade show active" id="product-desc" role="tabpanel" aria-labelledby="product-desc-tab">하동 지역의 매실은 지리산의 맑은 공기와 섬진강의 맑은 물 등 최상의 자연 조건에서 재배된다. 친환경적으로 재배되고 있으며 다른 지역 매실보다 단단하고 향이 독특하여 전국적으로 지명도가 높아 큰 인기를 얻고 있다.</div>
<div class="tab-pane fade" id="product-comments" role="tabpanel" aria-labelledby="product-comments-tab"> Vivamus rhoncus nisl sed venenatis luctus. Sed condimentum risus ut tortor feugiat laoreet. Suspendisse potenti. Donec et finibus sem, ut commodo lectus. Cras eget neque dignissim, placerat orci interdum, venenatis odio. Nulla turpis elit, consequat eu eros ac, consectetur fringilla urna. Duis gravida ex pulvinar mauris ornare, eget porttitor enim vulputate. Mauris hendrerit, massa nec aliquam cursus, ex elit euismod lorem, vehicula rhoncus nisl dui sit amet eros. Nulla turpis lorem, dignissim a sapien eget, ultrices venenatis dolor. Curabitur vel turpis at magna elementum hendrerit vel id dui. Curabitur a ex ullamcorper, ornare velit vel, tincidunt ipsum. </div>
<div class="tab-pane fade" id="product-rating" role="tabpanel" aria-labelledby="product-rating-tab"> Cras ut ipsum ornare, aliquam ipsum non, posuere elit. In hac habitasse platea dictumst. Aenean elementum leo augue, id fermentum risus efficitur vel. Nulla iaculis malesuada scelerisque. Praesent vel ipsum felis. Ut molestie, purus aliquam placerat sollicitudin, mi ligula euismod neque, non bibendum nibh neque et erat. Etiam dignissim aliquam ligula, aliquet feugiat nibh rhoncus ut. Aliquam efficitur lacinia lacinia. Morbi ac molestie lectus, vitae hendrerit nisl. Nullam metus odio, malesuada in vehicula at, consectetur nec justo. Quisque suscipit odio velit, at accumsan urna vestibulum a. Proin dictum, urna ut varius consectetur, sapien justo porta lectus, at mollis nisi orci et nulla. Donec pellentesque tortor vel nisl commodo ullamcorper. Donec varius massa at semper posuere. Integer finibus orci vitae vehicula placerat. </div>
</div>
</div>
</div>

</div>

</section>
</div>
				</div>
			</section>
		</div>
		<jsp:include page="../include/footer.jsp"></jsp:include>
	</div>
</body>
</html>