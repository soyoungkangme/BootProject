<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%--JSTL(태그) 이용하기 위해 필요 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<%-- 스프링 시큐리티 커스텀 태그 --%>
<sec:authorize access="isAuthenticated()">    <%-- 로그인 성공한 브라우저라면 내부 태그에 접근 가능 --%>
    <sec:authentication property="principal" var="principal"/>    <%-- JSP 파일에서 사용할 인증 관련 변수 초기화 --%>
</sec:authorize>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<%-- bootstrap, jquery  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>    
 인터넷 연결 안되도 에러 안나도록 경로를 로컬(pom.xml에 등록한 라이브러리)로 바꾸기 --%>
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<script src="/webjars/jquery/3.6.0/di st/jquery.min.js"></script>


<%-- Summernote --%>
<link href="/webjars/summernote/0.8.10/summernote-bs4.css" rel="stylesheet">
<script src="/webjars/summernote/0.8.10/summernote-bs4.min.js"></script>


</head>
<body>

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/">Main</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="mynavbar">
			
				<c:if test="${principal == null }">
					<ul class="navbar-nav me-auto">
						<li class="nav-item"><a class="nav-link" href="/auth/login">로그인</a></li>    <%-- Controller --%>
						<li class="nav-item"><a class="nav-link" href="/auth/insertUser">회원가입</a></li> <%-- 회원가입 누르면 /auth/insertUser 요청 날아감 (get방식) --%>
					</ul>
				</c:if>
				
				<%-- 로그인 성공시 메뉴 바꾸기 (스프링 시큐리티로 로그인 구현한다면 상단에 sec:authorize 추가해야 동작함) --%>
				<c:if test="${principal != null }">    <%-- Controller에서 사용자 입력값 session에 저장함 (principal) --%>
					<ul class="navbar-nav me-auto">
						<li class="nav-item"><a class="nav-link" href="/user/updateUser">회원상세</a></li>    <%-- Controller URI 매핑 --%>
						<li class="nav-item"><a class="nav-link" href="/post/insertPost">1:1문의</a></li>
						<li class="nav-item"><a class="nav-link" href="/auth/logout">로그아웃</a></li>    
					</ul>
				</c:if>
				
			</div>
		</div>
	</nav>