<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<%-- 로그인 화면 --%>


<div class="container mt-3">
	<form action="/auth/login" method="post">    <%-- login.js 사용 안하고 서버에 요청 날리기 (action, method 속성 추가, id->name 바꾸기, button 폼태그 안으로) --%>
		<div class="mb-3">
			<label for="username">Username:</label> 
			<input type="text" class="form-control" name="username" 
			placeholder="Enter username">
		</div>
		<div class="mb-3">
			<label for="password">Password:</label> 
			<input type="password" class="form-control" name="password" 
			placeholder="Enter password">
		</div>
		<button id="btn-login" class="btn btn-secondary">로그인</button>
	</form>
	
</div>

<%-- <script src="/js/login.js"></script> --%>    <%-- 버튼이 눌렸을때 lonin.js의 init() 실행 --%>

<%@ include file="../layout/footer.jsp"%>

<%-- button : 눌렸을때 
     action : 서버에 요청 (컨트롤러 매핑) 
     method : 요청 방식 
     name : 전달할 파라미터 정보 
--%>


