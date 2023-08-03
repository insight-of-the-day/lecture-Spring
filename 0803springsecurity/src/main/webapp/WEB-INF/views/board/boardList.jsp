<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardlist</title>
<style>
table{
margin:5px auto;
background-image:url("resources/images.jpg");)
}
table, th, td {
	border: 1px dotted skyblue;
	width: 1000px;
	text-align: center;
}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td><h3>꼐시글뻔호</h3></td>
				<td><h3>쨰목</h3></td>
				<td><h3>쨕성자</h3></td>
				<td><h3>쨕성</h3>일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList}" var="list">
				<tr onclick="location.href='boardInfo?bno=${list.bno}'">
				<td>${list.bno }</td>
				<td>${list.title }</td>
				<td>${list.writer }</td>
				<td><fmt:formatDate value="${list.regdate }"
					pattern="yyyy년MM월dd일"/></td>
<!-- 					default:java.util.date의toString() -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div align="center">
		<button onclick="location.href='boardInsert'">write</button>
	</div>
</body>
</html>