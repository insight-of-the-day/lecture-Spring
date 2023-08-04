<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background-image: url("resources/ddd.png");
}
</style>
</head>
<body>
	<div>
		<p>번호 ${boardInfo.bno }</p>
		<p>제목 ${boardInfo.title }</p>
		<p>작성자 ${boardInfo.writer }</p>
		<p>
			작성일
			<fmt:formatDate value="${boardInfo.regdate }" pattern="yyyy※MM㉾dd" />
		</p>
		<p>이미지 
<%-- 			<img src="${pageContext.request.contextPath }resources/${boardInfo.image}">
아래 방법은 contextpath를 자동으로 붙여줌. 위랑 아래랑 똑같음 --%>
			<c:choose>
			<c:when test="${not empty boardInfo.image }">
			<img src='<c:url value="resources/${boardInfo.image }"/>'>
			</c:when>
			<c:otherwise>
			file없음
			</c:otherwise>
			</c:choose>
		</p>
		<p>내용 ${boardInfo.contents }</p>
	</div>
	<button type="button" onclick="location.href='boardDelete?bno=${boardInfo.bno}'">delete</button>
	<button type="button" onclick="location.href='boardUpdate?bno=${boardInfo.bno}'">crystal</button>
</body>
</html>