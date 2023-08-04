<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 방법3 -->
<sec:csrfMetaTags/>
<title>Insert title here</title>
</head>
<body>
	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
		</sec:authorize>
	</ul>
	<sec:authorize access="isAuthenticated()">
	<form action="logout" method="post">
<!-- 		csrfInput은 csrf와 관련된 토큰을 내장시키는 태그임: f12눌러보면hidden으로 value가 생성됨 방법1-->
<!-- 	security-context.xml의 disabled가 false인 경우(default)에 method 가 get방식이 아닌 것은 제어해서 -->
<!-- 	다른 것은 문제가 안 되나 여기서 문제가 생길 수 있음 -->
		<sec:csrfInput/>
		<button>로그아웃</button>
	</form>
	</sec:authorize>
	
<!-- 	form으로 보내는 형식이 아니라면... input type을 hidden으로 하면 됨 ㅂㄹ 안 쓰인대 방법2-->
	<input type="hidden" name="csrf_name" value="${_csrf.parameterName }">
	<input type="hidden" name="csrf_name" value="${_csrf.token }">
	
	
</body>
</html>