<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    <!--JSTL 이용하기 위해 필요 -->

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>    
 -->
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
<!-- 인터넷 연결 안되도 에러 안나도록 경로를 로컬(pom.xml에 등록한 라이브러리)로 바꾸기  -->
</head>
<body>

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/">main</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="mynavbar">
			<c:if test="${pincpal == null }">    <!-- 로그인 성공시 메뉴 바꾸기 -->
			    <ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link" href="/user/updateUser">회원상세</a></li>
					<li class="nav-item"><a class="nav-link" href="/post/insertPost">1:1문의</a></li>
					<li class="nav-item"><a class="nav-link" href="/auth/logout">로그아웃</a></li>    <!-- Controller에 로그아웃 추가 -->
				</ul>
			</c:if>
			</div>
		</div>
	</nav>
	
	
	
	
	
	
	
	
	
	
	
	
	
	