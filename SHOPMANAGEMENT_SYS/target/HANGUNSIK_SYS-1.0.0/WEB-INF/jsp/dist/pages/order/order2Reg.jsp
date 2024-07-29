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
							<h1 class="m-0">업체 등록/수정</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">업체 등록/수정</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
	
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="row">
								<div class="col-md-7">							
									<div class="card">
										<div class="card-header">
											<h3 class="card-title">업체 등록/수정</h3>
										</div>
										<div class="card-body">
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>구분</label>
														<div class="input-group-prepend">
															<select id="typeSel" style="width: 100px;height: 38px;">
																<option>제조</option>
																<option>외주</option>
															</select>
														</div>
													</div>		
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label>업체명</label>
														<input type="text" id="companyNm" class="form-control" placeholder="예시)한건식">
													</div>
												</div>		
												<div class="col-md-4">	
													<div class="form-group">
														<label>대표자명</label>
														<input type="text" id="ceoNm" class="form-control" placeholder="예시)정현성">
													</div>
												</div>		
												<div class="col-sm-4">
													<div class="form-group">
														<label>사업자번호</label>
														<div class="input-group">
															<select id="businessTaxSel" style="width: 100px;height: 38px;">
																<option>일반과세자</option>
																<option>간이과세자</option>
																<option>면세과세자</option>
															</select>
															<input type="text" id="businessNoIp" class="form-control" placeholder="예시)780-32-01218">
														</div>
													</div>	
												</div>	
												<div class="col-md-4">
													<div class="form-group">
														<label>대표 전화번호</label>
														<input type="text" id="businessTelIp" class="form-control" placeholder="예시)010-0000-0000">
													</div>
												</div>		
												<div class="col-md-4">	
													<div class="form-group">
														<label>대표 이메일</label>
														<input type="text" id="emailIp" class="form-control" placeholder="예시)abcd@naver.com">
													</div>
												</div>					
												<div class="col-md-12">	
													<div class="form-group">
														<label>업체 주소</label>
														<input type="text" id="addressIp" class="form-control" placeholder="예시)경남 하동군 하동읍">
													</div>
												</div>	
												<div class="col-sm-2">
													<div class="form-group">
														<label>주거래 은행</label>
														<div class="input-group">
															<input type="text" id="bankIp" class="form-control" placeholder="예시)하나은행">
														</div>
													</div>	
												</div>
												<div class="col-sm-4">
													<div class="form-group">
														<label>계좌번호</label>
														<div class="input-group">
															<input type="text" id="bankNoIp" class="form-control" placeholder="예시)632-00-12345">
														</div>
													</div>	
												</div>	
												<div class="col-sm-2">
													<div class="form-group">
														<label>예금주</label>
														<div class="input-group">
															<input type="text" id="bankNmIp" class="form-control" placeholder="예시)한건식">
														</div>
													</div>	
												</div>		
												<div class="col-sm-2">
													<div class="form-group">
														<label for="exampleInputEmail1">예치금</label>
														<div class="input-group">
															<input type="text" id="bankDepositIp" class="form-control" placeholder="예시)10,000,000">
														</div>
													</div>	
												</div>
											</div>	
										</div>
										<div class="card-footer clearfix">
											<button type="button" class="btn btn-success btn-xs float-right" style="width: 100px; margin-right: 5px;">
												저장
											</button>
											<button type="button" class="btn btn-default btn-xs float-right" style="width: 100px; margin-right: 5px;">
												초기화
											</button>
										</div>
									</div>	
								</div>
								<div class="col-md-5">
									<div class="card">
										<div class="card-header">
											<h3 class="card-title">문서 업로드</h3>
										</div>
										<div class="card-body">
											<div class="row">
												<div class="col-sm-12">
													<div class="form-group">
														<label for="exampleInputFile">사업자등록증</label>
														<div class="input-group">
															<div class="custom-file">
																<input type="file" class="custom-file-input" id="exampleInputFile">
																<label class="custom-file-label" for="exampleInputFile">파일 찾기</label>
															</div>
															<div class="input-group-append">
																<span class="input-group-text">올리기</span>
															</div>
														</div>
													</div>
												</div>
												<div class="col-sm-12">
													<div class="form-group">
														<label for="exampleInputFile">통장사본</label>
														<div class="input-group">
															<div class="custom-file">
																<input type="file" class="custom-file-input" id="exampleInputFile">
																<label class="custom-file-label" for="exampleInputFile">파일 찾기</label>
															</div>
															<div class="input-group-append">
																<span class="input-group-text">올리기</span>
															</div>
														</div>
													</div>
												</div>		
											</div>	
										</div>
									</div>	
								</div>
							</div>	
						</div>
					</div>	
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header border-transparent">
									<h3 class="card-title">업체 ( 12건 )</h3>
									<div class="card-tools">
										<div class="btn-group float-left" style="width: 120px; height: 30px; margin-right: 5px; margin-top: 3px;">
											<button type="button" class="btn btn-height btn-default float-left" style="margin-right: 5px; padding-top: 3px;">
												<i class="fa fa-file-excel"></i>
												엑셀출력
											</button>
										</div>	
										<div class="btn-group float-left" style="margin-top: 2px; margin-right: 5px;">
											<select style="width: 100px;height: 30px;">
												<option>업체명</option>
												<option>업체ID</option>
												<option>대표자명</option>
												<option>사업자번호</option>
											</select>
										</div>
										<div class="input-group input-group-sm float-left" style="width:200px; margin-top: 1px;">
											<input type="text" name="table_search" class="form-control float-right" placeholder="Search">
											<div class="input-group-append">
												<button type="submit" class="btn btn-default">
													<i class="fas fa-search"></i>
												</button>
											</div>
										</div>
										<div class="btn-group float-left" style="margin-top: 2px; margin-left: 5px;">
											<select style="width: 100px; height: 30px;">
												<option>전체</option>
												<option>제조</option>
												<option>외주</option>
											</select>
										</div>
										<div class="float-left" style="width:130px; margin-left: 20px;">1-50 / 200
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
												<th>#</th>
												<th>업체명</th>
												<th>업체ID</th>
												<th>대표자명</th>
												<th>대표 전화번호</th>
												<th>사업자등록번호</th>
												<th>업체구분</th>
												<th>예치금</th>
												<th>선택</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><span class="bs-stepper-circle">1</span></td>
												<td>파파야</td>
												<td>papaya01</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>627-123-1234</td>
												<td><span class="badge badge-info" style="width: 50px; height: 25px; padding-top: 7px;">제조</span></td>
												<td>0 원</td>
												<td>
													<button type="button" class="btn btn-warning btn-xs float-left" style="width: 50px; margin-right: 5px;">
														수정
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														삭제
													</button>
												</td>	
											</tr>
											<tr>
												<td><span class="bs-stepper-circle">2</span></td>
												<td>파파야</td>
												<td>papaya01</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>627-123-1234</td>
												<td><span class="badge badge-info" style="width: 50px; height: 25px; padding-top: 7px;">제조</span></td>
												<td>0 원</td>
												<td>
													<button type="button" class="btn btn-warning btn-xs float-left" style="width: 50px; margin-right: 5px;">
														수정
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														삭제
													</button>
												</td>
											</tr>
											<tr>
												<td><span class="bs-stepper-circle">3</span></td>
												<td>파파야</td>
												<td>papaya01</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>627-123-1234</td>
												<td><span class="badge badge-info" style="width: 50px; height: 25px; padding-top: 7px;">제조</span></td>
												<td>0 원</td>
												<td>
													<button type="button" class="btn btn-warning btn-xs float-left" style="width: 50px; margin-right: 5px;">
														수정
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														삭제
													</button>
												</td>
											</tr>
											<tr>
												<td><span class="bs-stepper-circle">4</span></td>
												<td>파파야</td>
												<td>papaya01</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>627-123-1234</td>
												<td><span class="badge badge-info" style="width: 50px; height: 25px; padding-top: 7px;">제조</span></td>
												<td>0 원</td>
												<td>
													<button type="button" class="btn btn-warning btn-xs float-left" style="width: 50px; margin-right: 5px;">
														수정
													</button>
													<button type="button" class="btn btn-danger btn-xs float-left" style="width: 50px; margin-right: 5px;">
														삭제
													</button>
												</td>
											</tr>
											<tr>
												<td><span class="bs-stepper-circle">5</span></td>
												<td>파파야</td>
												<td>papaya01</td>
												<td>여강동</td>
												<td>010-123-1234</td>
												<td>627-123-1234</td>
												<td><span class="badge badge-danger" style="width: 50px; height: 25px; padding-top: 7px;">외주</span></td>
												<td>250,000 원</td>
												<td>
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
					</div>
				</div>
			</section>
		</div>
		<jsp:include page="../include/footer.jsp"></jsp:include>
	</div>
</body>
</html>