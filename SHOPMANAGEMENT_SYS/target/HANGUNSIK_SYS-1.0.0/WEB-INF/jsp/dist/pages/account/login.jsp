<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>한건식 납품관리 시스템 | Log in</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
	<link rel="stylesheet" href="<c:url value='css/all.min.css'/>"/>
	<link rel="stylesheet" href="<c:url value='css/icheck-bootstrap.min.css'/>"/>
	<link rel="stylesheet" href="<c:url value='css/adminlte.min.css?v=3.2.0'/>"/>
	<link rel="stylesheet" href="<c:url value='css/main.css'/>"/>
	
	<script src="<c:url value='js/plugins/jquery.min.js"'/>"></script>
	<script src="<c:url value='js/plugins/bootstrap.bundle.min.js"'/>"></script>
	<script src="<c:url value='js/adminlte.min.js?v=3.2.0"'/>"></script>
	<script type="text/javascript" src="<c:url value='js/account/login.js"'/>"></script>
</head>
<body class="login-page login_back">
	<div class="login-box">
		<div class="card card-outline card-primary">
			<div class="card-header text-center">
				<a href="../../index2.html" class="h1">한건식</a>
			</div>
			<div class="card-body">
				<p class="login-box-msg"></p>
				<form>
					<div class="input-group mb-3">
						<input id="userIdIp" type="email" class="form-control" placeholder="Email" value="JKY8642210@naver.com">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input id="userPasswordIp" type="password" class="form-control" placeholder="Password" value="1111">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-8">
							<div class="icheck-primary">
								<input id="adminChk" type="checkbox">
								<label for="remember">관리자</label>
							</div>
						</div>
						<div class="col-4">
							<button id="loginSubmitBtn" type="submit" class="btn btn-primary btn-block">로그인</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>