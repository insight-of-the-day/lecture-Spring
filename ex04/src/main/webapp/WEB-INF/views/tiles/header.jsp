<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타일즈의헤더</title>
<!-- <link href="resources/headers.css" rel="stylesheet"> -->
<!-- 위랑 아래랑 지금 동작하는 것은 똑같음. 상:상대경로(../or '/'없이 시작) 하:절대경로
지금은 empList랑같은위치라서 상관없는데 emp/list이런식으로 경로가 달라지면 list.resources/이런식으로 됨-->
<link href="${pageContext.request.contextPath }/resources/headers.css"
	rel="stylesheet">

<!--   /resources<contextpath(이 패키지에서는 app임:contextpath는 가변적이에용톰캣설정에서도바꿀수잇스니까요)를 생략하는 꼴이 되어버림 -->
<!-- header.css>상대경로로 찾음(이 때는 현재파일의 위치를 기반으로 기술하면 안 됨) -->
<!-- url의 루트로부터 경로를 찾아라! -->
</head>
<body>
	<header class="p-3 text-bg-dark">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<a href="/"
					class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
					<svg class="bi me-2" width="40" height="32" role="img"
						aria-label="Bootstrap">
						<use xlink:href="#bootstrap" /></svg>
				</a>

				<ul
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
					<li><a href="${pageContext.request.contextPath }/boardList" class="nav-link px-2 text-secondary">BoardList</a></li>
<!-- 							현재경로에서 empList는 controller를 통해 접근하는 것이얌 -->
					<li><a href="${pageContext.request.contextPath }/" class="nav-link px-2 text-white">Home</a></li>
					<li><a href="${pageContext.request.contextPath }/boardInsert" class="nav-link px-2 text-secondary">BoardInsert</a></li>
				</ul>

				<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
					<input type="search"
						class="form-control form-control-dark text-bg-dark"
						placeholder="Search..." aria-label="Search">
				</form>

				<div class="text-end">
					<button type="button" class="btn btn-outline-light me-2">Login</button>
					<button type="button" class="btn btn-warning">Sign-up</button>
				</div>
			</div>
		</div>
	</header>
</body>
</html>