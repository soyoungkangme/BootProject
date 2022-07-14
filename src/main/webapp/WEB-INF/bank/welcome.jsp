<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 서블릿 변환 과정에서 추가할 페이지 정보 (JSP : HTML 속의 자바, 서블릿보다 적은 규칙, 리로딩X)
isErrorPage(현재 페이지가 에러 전용 페이지), errorPage(에러 발생시 처리할 페이지), import(변환된 서블릿 클래스에서), session(현재 페이지에서 객체 사용여부, 디폴트 true) --%>

<%@ include file="./layout/header.jsp"%>    <%-- 다른 JSP 코드 --%>



<%-- 포스트 목록 화면 (메인 화면) --%>



<div class="container-fluid mt-3">

	<c:if test="${!empty postList }">    <%-- 검색 후 model에 저장한 postList(컬렉션) 들어있다면 (PostController) --%>
		<div class="card">
			<c:forEach var="post" items="${postList.content}">    <%-- postList는 Page 객체 이므로 postList.content = 검색된 포스트 목록 -> 을 post라 참조 (PostService, PostController) --%>
				<div class="card-body">
					<h4 class="card-title">${post.title }</h4>   
					<a href="#" class="btn btn-secondary">상세 보기</a>
				</div>
			</c:forEach>
		</div>

		<br>    <%-- 부트스트랩 pagenation --%>
		<ul class="pagination pagination-lg justify-content-between">    
			<li class="page-item <c:if test="${postList.first }">disabled</c:if>">
			<a class="page-link" href="?page=${postList.number -1 }">이전 페이지</a></li>
			<li class="page-item"> <c:if test="${postList.last }">disabled</c:if>
			<a class="page-link" href="?page=${postList.number +1 }">다음 페이지</a></li>
		</ul>
	</c:if> 
</div>

<%@ include file="./layout/footer.jsp"%>


<%--
postList.number : postList = Page 객체 (검색된 포스트 목록 + 페이징 정보) 에서 현재 페이지의 번호 
first, last = 첫번째, 마지막 페이지 -> true, false
disabled = 버튼 비활성화 
 --%>


 <%-- 자바코드 없애기 위해 사용함 
 EL : <%자바구문%>, <%=자바변수, 메서드 출력%>을 대신함, 내장객체(request, session, application) 사용 가능, nullPointException 안뜸 
 JSTL : if, for 
 --%>




