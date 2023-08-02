<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 타이틀,컨텐츠,레그데이트,이미지 -->
	<h1>작성하기</h1>
	<hr>
	<form name="insertForm" action="boardInsert" method="post">
		<div align="center">
			<label>title: <input type="text" name="title"></label>
		</div>
		<hr>
		<div align="center">
			<label>regdate: <input type="date" name="regdate"></label> 
			<label>writer: <input type="text" name="writer">
			</label>
		</div>
		<hr>
		<div align="center">
			<label>contents: <textarea name="contents" cols="50"></textarea></label>
		</div>
		<hr>
		<div align="center">
			img:<input type="text" name="image">
			<button type="submit">write</button>
			<button type="reset">reset</button>
		</div>
	</form>
	
	<script>
		document.querySelector('form[name="insertForm"]')
				.addEventListener('submit',function(e){
					e.preventDefault();
					let title=document.getElementsByName('title')[0]
					let writer=document.getElementsByName('writer')[0]
					
					if(title.value==''){
						alert('please enter the title')	
						title.focus()
						return
					}
					if(writer.value==''){
						alert('please enter a writer')	
						writer.focus()
						return
					}
					insertForm.submit()
					//form태그에 한해서 name속성으로 접근가능
				})
	</script>
</body>
</html>