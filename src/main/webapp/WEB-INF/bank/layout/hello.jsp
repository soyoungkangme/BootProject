<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>안녕 : ${username }</h1>    <!-- localhost:1111/hello    // get 방식의 select -->

<form action="bank" method="post">    <!-- 등록 -->
	<input type="submit" value="POST 전송"/>
</form>
<!-- form 태그는 get/post만 가능 -->


</body>
</html>