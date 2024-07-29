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
							<h1 class="m-0">상품 등록/수정</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">상품 등록/수정</li>
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
									<h3 class="card-title">기본 상품</h3>
								</div>
								<div class="card-body">
									<div class="row">	
										<div class="col-md-4">	
											<div class="form-group">
												<label for="exampleInputEmail1">복사 등록</label>
												<div class="input-group">
													<div class="input-group-prepend">
														<div class="btn-group">
															<select style="width: 200px;height: 30px;">
																<option>매실 10kg 참 맛있어요</option>
																<option>하동매실 5kg 판매중</option>
																<option>하동배 10과 30,000원</option>
															</select>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label for="exampleInputEmail1">카테고리</label>
												<div class="input-group">
													<div class="input-group-prepend">
														<div class="btn-group">
															<select style="width: 100px;height: 30px;">
																<option>농산물</option>
																<option>수산물</option>
																<option>축산물</option>
																<option>가공식품</option>
																<option>기타식품</option>
															</select>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label for="exampleInputEmail1">품목</label>
												<div class="input-group">
													<div class="input-group-prepend">
														<div class="btn-group">
															<select style="width: 100px;height: 30px;">
																<option>매실</option>
																<option>배</option>
																<option>감</option>
																<option>블루베리</option>
																<option>밤</option>
															</select>
														</div>
													</div>
												</div>
											</div>
										</div>					
										<div class="col-md-4">	
											<div class="form-group">
												<label for="exampleInputEmail1">부가세</label>
												<div class="input-group">
													<div class="btn-group btn-group-toggle" data-toggle="buttons">
														<label class="btn btn-secondary">
															<input type="radio" name="options" id="option_a1" autocomplete="off" checked=""> 과세
														</label>
														<label class="btn btn-secondary active">
															<input type="radio" name="options" id="option_a2" autocomplete="off"> 면세
														</label>
														<label class="btn btn-secondary">
															<input type="radio" name="options" id="option_a3" autocomplete="off"> 영세
														</label>
													</div>
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
									<h3 class="card-title">예약구매</h3>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label for="exampleInputEmail1">예약구매</label>
												<div class="input-group">
													<div class="btn-group btn-group-toggle" data-toggle="buttons">
														<label class="btn btn-secondary">
															<input type="radio" name="options" id="option_a1" autocomplete="off" checked=""> 설정
														</label>
														<label class="btn btn-secondary active">
															<input type="radio" name="options" id="option_a2" autocomplete="off"> 설정안함
														</label>
													</div>
												</div>		
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="exampleInputEmail1">주문기간</label>
												<div class="input-group">
													<div class="input-group-prepend">
														<span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
													</div>
													<input type="text" class="form-control float-right" id="reservation">
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="exampleInputEmail1">예약구매기간 종료후 상품판매 상태</label>
												<div class="input-group">
													<div class="btn-group btn-group-toggle" data-toggle="buttons">
														<label class="btn btn-secondary">
															<input type="radio" name="options" id="option_a1" autocomplete="off" checked=""> 설정
														</label>
														<label class="btn btn-secondary active">
															<input type="radio" name="options" id="option_a2" autocomplete="off"> 설정안함
														</label>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="exampleInputEmail1">발송기간</label>
												<div class="input-group">
													<div class="input-group-prepend">
														<span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
													</div>
													<input type="text" class="form-control float-right" id="reservation">
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
									<h3 class="card-title">상품 주요 정보</h3>
								</div>
								<div class="card-body">
									<div class="row">	
										<div class="col-md-4">
											<div class="form-group">
												<label for="exampleInputEmail1">브랜드</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label for="exampleInputEmail1">출고지/제조사</label>
												<div class="input-group-prepend">
													<select style="width: 200px; height: 35px;">
														<option>(주)자연향기</option>
														<option>김정문의 섬진강재첩</option>
														<option>하동참다래매실농원</option>
														<option>(주)슬로푸드</option>
													</select>
												</div>
											</div>
										</div>		
										<div class="col-md-12">	
											<div class="form-group">
												<label for="exampleInputEmail1">인증정보</label>
												<div class="row">	
													<div class="col-md-3">	
														<input type="text" class="form-control" id="exampleInputEmail1" placeholder="HACCP 인증">										
													</div>
													<div class="col-md-3">	
														<input type="text" class="form-control" id="exampleInputEmail1" placeholder="인증기관">										
													</div>
													<div class="col-md-3">	
														<input type="text" class="form-control" id="exampleInputEmail1" placeholder="인증번호">										
													</div>
												</div>
											</div>										
										</div>	
										<div class="col-md-4">
											<div class="form-group">
												<label for="exampleInputEmail1">원산지</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>	
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">배송</h3>
								</div>
								<div class="card-body">
									<div class="row">	
										<div class="col-md-3">
											<div class="form-group">
												<label for="exampleInputEmail1">배송 속성</label>
												<div class="input-group">
													<div class="btn-group btn-group-toggle" data-toggle="buttons">
														<label class="btn btn-secondary">
															<input type="radio" name="options" id="option_a1" autocomplete="off" checked=""> 일반배송
														</label>
														<label class="btn btn-secondary active">
															<input type="radio" name="options" id="option_a2" autocomplete="off"> 당일배송
														</label>
													</div>
												</div>	
											</div>
										</div>		
										<div class="col-md-9">	
											<div class="form-group">
												<label for="exampleInputEmail1">시간 설정</label>
												<div class="input-group">
													<div class="input-group-prepend">
														<select style="width: 100px; height: 35px;">
															<option>오전 5시</option>
															<option>오전 6시</option>
															<option>오전 7시</option>
															<option>오전 8시</option>
															<option>오전 9시</option>
															<option>오전 10시</option>
															<option>오전 11시</option>
															<option>정오 12시</option>
															<option>오후 13시</option>
															<option>오후 14시</option>
															<option>오후 15시</option>
															<option>오후 16시</option>
															<option>오후 17시</option>
															<option>오후 18시</option>
														</select>
													</div>
												</div>
											</div>										
										</div>	
										<div class="col-md-3">	
											<div class="form-group">
												<label for="exampleInputEmail1">택배사</label>
												<div class="input-group">
													<div class="input-group-prepend">
														<select style="width: 120px; height: 35px;">
															<option>CJ 대한통운</option>
															<option>한진</option>
															<option>롯데</option>
															<option>로젠</option>
														</select>
													</div>
												</div>
											</div>										
										</div>	
										<div class="col-md-3">	
											<div class="form-group">
												<label for="exampleInputEmail1">묶음배송</label>
												<div class="input-group">
													<div class="btn-group btn-group-toggle" data-toggle="buttons">
														<label class="btn btn-secondary">
															<input type="radio" name="options" id="option_a1" autocomplete="off" checked=""> 가능
														</label>
														<label class="btn btn-secondary active">
															<input type="radio" name="options" id="option_a2" autocomplete="off"> 불가
														</label>
													</div>
												</div>	
											</div>
										</div>	
										<div class="col-md-3">	
											<div class="form-group">
												<label for="exampleInputEmail1">상품별 배송비</label>
												<div class="input-group">
													<div class="input-group-prepend">
														<select style="width: 120px; height: 35px;">
															<option>무료</option>
															<option>조건부 무료</option>
															<option>유료</option>
														</select>
													</div>
												</div>
											</div>										
										</div>
										<div class="col-md-3">	
											<div class="form-group">
												<label for="exampleInputEmail1">상품별 배송비</label>
												<div class="input-group">
													<div class="input-group-prepend">
														<select style="width: 100px; height: 30px;">
															<option>무료</option>
															<option>조건부 무료</option>
															<option>유료</option>
															<option>수량별</option>
														</select>
													</div>
												</div>
											</div>										
										</div>	
										<div class="col-md-3">
											<div class="form-group">
												<label for="exampleInputEmail1">기본 배송비</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="exampleInputEmail1">수량별 배송비</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="exampleInputEmail1">개별 기본 배송비 적용</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>
										<div class="col-md-3">	
											<div class="form-group">
												<label for="exampleInputEmail1">제주/도서산간 추가 배송비</label>
												<div class="input-group">
													<div class="btn-group btn-group-toggle" data-toggle="buttons">
														<label class="btn btn-secondary">
															<input type="radio" name="options" id="option_a1" autocomplete="off" checked=""> 설정
														</label>
														<label class="btn btn-secondary active">
															<input type="radio" name="options" id="option_a2" autocomplete="off"> 설정안함
														</label>
													</div>
												</div>
											</div>										
										</div>	
										<div class="col-md-3">
											<div class="form-group">
												<label for="exampleInputEmail1">제주/도서산간 추가 배송비</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>				
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">옵션 입력</h3>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label for="exampleInputEmail1">옵션명</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>		
										<div class="col-md-8">	
											<div class="form-group">
												<label for="exampleInputEmail1">옵션값</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>		
										<div class="col-md-4">	
											<div class="form-group">
												<label for="exampleInputEmail1">옵션명</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>		
										<div class="col-md-8">	
											<div class="form-group">
												<label for="exampleInputEmail1">옵션값</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>		
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">반품/교환</h3>
								</div>
								<div class="card-body">
									<div class="row">	
										<div class="col-md-3">
											<div class="form-group">
												<label for="exampleInputEmail1">반품 교환 택배사</label>
												<div class="input-group">
													<div class="input-group-prepend">
														<select style="width: 120px; height: 35px;">
															<option>CJ 대한통운</option>
															<option>한진</option>
															<option>롯데</option>
															<option>로젠</option>
														</select>
													</div>
												</div>
											</div>	
										</div>		
										<div class="col-md-3">	
											<div class="form-group">
												<label for="exampleInputEmail1">반품배송비(편도)</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>		
										<div class="col-md-3">	
											<div class="form-group">
												<label for="exampleInputEmail1">교환배송비(왕복)</label>
												<input type="text" class="form-control" id="exampleInputEmail1">
											</div>
										</div>		
										<div class="col-md-3">
											<div class="form-group">
												<label for="exampleInputEmail1">반품/교환 제조사</label>
												<div class="input-group-prepend">
													<select style="width: 200px; height: 35px;">
														<option>(주)자연향기</option>
														<option>김정문의 섬진강재첩</option>
														<option>하동참다래매실농원</option>
														<option>(주)슬로푸드</option>
													</select>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>	
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">옵션</h3>
									<div class="card-tools">
										<button type="button" class="btn btn-default" data-card-widget="collapse">
											<span><i class="fas fa-minus"></i> 삭제</span>
										</button>
									</div>
								</div>
								<div class="card-body">
									<table class="table m-0">
										<thead>
											<tr>
												<th><input type="checkbox" id="checkboxPrimary1" class="check-group" checked=""><label for="checkboxPrimary1"></label></th>
												<th>품목</th>
												<th>옵션1</th>
												<th>옵션2</th>
												<th>도매가</th>
												<th>마진율</th>
												<th>판매가</th>
												<th>재고수량</th>
												<th>판매상태</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><input type="checkbox" id="checkboxPrimary1" class="check-group" checked=""><label for="checkboxPrimary1"></label></td>
												<td>매실</td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="황매실"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 300px; height: 25px;" value="황매실 20kg 왕특"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="₩20,000원"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="10%"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="₩22,000원"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="9999"></td>
												<td>판매중</td>
											</tr>
											<tr>
												<td><input type="checkbox" id="checkboxPrimary1" class="check-group" checked=""><label for="checkboxPrimary1"></label></td>
												<td>매실</td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="황매실"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 300px; height: 25px;" value="황매실 20kg 왕특"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="₩20,000원"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="10%"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="₩22,000원"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="9999"></td>
												<td>판매중</td>
											</tr>
											<tr>
												<td><input type="checkbox" id="checkboxPrimary1" class="check-group" checked=""><label for="checkboxPrimary1"></label></td>
												<td>매실</td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="황매실"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 300px; height: 25px;" value="황매실 20kg 왕특"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="₩20,000원"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="10%"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="₩22,000원"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="9999"></td>
												<td>판매중</td>
											</tr>
											<tr>
												<td><input type="checkbox" id="checkboxPrimary1" class="check-group" checked=""><label for="checkboxPrimary1"></label></td>
												<td>매실</td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="황매실"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 300px; height: 25px;" value="황매실 20kg 왕특"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="₩20,000원"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="10%"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="₩22,000원"></td>
												<td><input type="text" class="form-control" id="exampleInputEmail1" style="width: 100px; height: 25px;" value="9999"></td>
												<td>판매중</td>
											</tr>
										</tbody>
									</table>		
								</div>
							</div>	
						</div>				
						<div class="col-md-6">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">상세 설명</h3>
								</div>
								<div class="card-body">
									<div class="col-md-12">	
										<div class="input-group">
											<textarea class="form-control" rows="15"></textarea>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">사진</h3>
									<div class="card-tools">
										<button type="button" class="btn btn-default" data-card-widget="collapse">
											<span><i class="fas fa-plus"></i> 대표사진</span>
										</button>
										<button type="submit" class="btn btn-default">
											<span><i class="fas fa-plus"></i> 상품사진</span>
										</button>
									</div>
								</div>
								<div class="card-body">
									<div class="row">	
										<div class="col-md-6">	
											<a href="https://via.placeholder.com/1200/000000.png?text=5" data-toggle="lightbox" data-title="sample 5 - black">
												<img class="img-fluid mb-2" alt="black sample" src="<c:url value='/assets/img/product/maesil.jpg'/>">
											</a>
										</div>
										<div class="col-md-6">
											<div class="row">
												<div class="col-md-4">
													<a href="https://via.placeholder.com/1200/000000.png?text=5" data-toggle="lightbox" data-title="sample 5 - black">
														<img class="img-fluid mb-2" alt="black sample" src="<c:url value='/assets/img/product/maesil.jpg'/>">
													</a>
												</div>
												<div class="col-md-4">
													<a href="https://via.placeholder.com/1200/000000.png?text=5" data-toggle="lightbox" data-title="sample 5 - black">
														<img class="img-fluid mb-2" alt="black sample" src="<c:url value='/assets/img/product/maesil.jpg'/>">
													</a>
												</div>
												<div class="col-md-4">
													<a href="https://via.placeholder.com/1200/000000.png?text=5" data-toggle="lightbox" data-title="sample 5 - black">
														<img class="img-fluid mb-2" alt="black sample" src="<c:url value='/assets/img/product/maesil.jpg'/>">
													</a>
												</div>
												<div class="col-md-4">	
													<a href="https://via.placeholder.com/1200/000000.png?text=5" data-toggle="lightbox" data-title="sample 5 - black">
														<img class="img-fluid mb-2" alt="black sample" src="<c:url value='/assets/img/product/maesil.jpg'/>">
													</a>
												</div>
												<div class="col-md-4">
													<a href="https://via.placeholder.com/1200/000000.png?text=5" data-toggle="lightbox" data-title="sample 5 - black">
														<img class="img-fluid mb-2" alt="black sample" src="<c:url value='/assets/img/product/maesil.jpg'/>">
													</a>										
												</div>
												<div class="col-md-4">	
													<a href="https://via.placeholder.com/1200/000000.png?text=5" data-toggle="lightbox" data-title="sample 5 - black">
														<img class="img-fluid mb-2" alt="black sample" src="<c:url value='/assets/img/product/maesil.jpg'/>">
													</a>
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