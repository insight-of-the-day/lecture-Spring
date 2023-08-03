<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>entireList</title>
<style>
body {
	background-image: url("resources/ddd.png");
}
</style>
</head>
<body>
	<div class="haha">
		<div>
			<select id="cntPerPage">
				<option value="5" <c:if test="${paging.cntPerPage==5 }">selected</c:if>>5555</option>
				<option value="10" <c:if test="${paging.cntPerPage==10 }">selected</c:if>>101010</option>
				<option value="15" <c:if test="${paging.cntPerPage==15 }">selected</c:if>>151515</option>
				<option value="20" <c:if test="${paging.cntPerPage==20 }">selected</c:if>>202020</option>
			</select>
<!-- 			c태그가 먼저 컴파일되기 때문에 이게 가능 -->
		</div>
		<script>
			document.addEventListener('DOMContentLoaded',function(e){
				document.getElementById('cntPerPage')
						.addEventListener('change',changeHandler)
						//change:선택 상자, 체크박스, 라디오 버튼의 상태가 변경되었을 때
			})
			function changeHandler(e){
				let selected=document.getElementById('cntPerPage').value
				//e.currentTarget.value로 해도 됨
				location.href='empList?nowPage=${paging.nowPage}&cntPerPage='+selected
			}
		</script>
		<table>
			<thead>
				<tr>
					<th>empId</th>
					<th>firstsName</th>
					<th>lastName</th>
					<th>email</th>
					<th>jobId</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empList }" var="empinfo">
					<tr>
						<td>${empinfo.employeeId }</td>
						<td>${empinfo.firstName }</td>
						<td>${empinfo.lastName }</td>
						<td>${empinfo.email }</td>
						<td>${empinfo.jobId }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="text-align:center;">
<!-- 			이전 -->
			<c:if test="${paging.startPage !=1 }">
				<a href="empList?nowPage=${paging.startPage-1 }&cntPerPage=${paging.cntPerPage }">&lt;</a>
<!-- 				&lt;==<  &gt;==> -->
			</c:if>
<!-- 			뷰 안에 보여지는 페이지 -->
			<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
				<c:choose>
					<c:when test="${p eq paging.nowPage }">
						<b>${p }</b>
					</c:when>
					<c:otherwise>
						<a href="empList?nowPage=${p }&cntPerPage=${paging.cntPerPage }">${p }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
<!-- 			다음 -->
			<c:if test="${paging.endPage!=paging.lastPage }">
				<a href="empList?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage }">&gt;</a>
			</c:if>
		</div>
	</div>

</body>
</html>