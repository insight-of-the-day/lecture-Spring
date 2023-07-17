<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>crystal...수정...ㅎㅎ</h1>
	<form>
	<div align="center">
		<hr>
		<input type="hidden" name="bno" value="${boardInfo.bno }" readonly>
		<input type="hidden" name="writer" value="${boardInfo.writer }">
<!-- 		<div align="center"> -->
			<label>title: <input type="text" name="title"
				value="${boardInfo.title }"></label>
<!-- 		</div> -->
		<hr>
		<div align="center">
			<label>regdate: <input type="date" name="updatedate"
			value="<fmt:formatDate value="${boardInfo.updatedate }" pattern="yyyy-MM-dd"/>">
			</label> 
			<label>writer: <input type="text" name="writer" value="${boardInfo.writer }">
			</label>
		</div>
		<hr>
		<div align="center">
			<label>contents: <textarea name="contents" cols="50" >${boardInfo.contents }</textarea></label>
		</div>
		<hr>
		<div align="center">
			img:<input type="text" name="image" value="${boardInfo.image }">
			<button type="submit">write</button>
			<button type="button" onclick="location.href='boardInfo?bno=${boardInfo.bno }'">back</button>
		</div>
	</div>
	</form>
</body>
<script>
	$('form').on('submit',ajaxUpdate);
	
	function ajaxUpdate(e){
		let objData=seralizeObject();
		e.preventDefault();

		$.ajax({			
			url:'boardUpdate',
			method:'post',
			data://objData
			getAll()
		//비동기는 무족건 json으로 보내는 것 안임!!!!!!!!json은 데이터양이 많을 때 쓰면 좋댕
		//여기서는 객체형식으로 보냄

		})
		.done(data=>{
			if(data!=null&&data['result']==true){
				alert('success')
			}else{
				alert('fail');
			}
		})
		.fail(reject=>console.log(reject))
 		//return false;
	}
	function seralizeObject(){
		let formDta=$('form').serializeArray();
		let form={};
		$.each(formDta,function(idx,obj){
			let field=obj.name;
			let val=obj.value;
			
			form[field]=val;
		})
		return form;
	}
	//mine!~~
	function getAll(){
		let inputList=document.querySelectorAll('form input, form textarea');
		let form={};
		inputList.forEach(tag=>{
			form[tag.name]=tag.value;
		})
		console.log(form);
		return form;
	}
	//searlizeArray는 form에서만 쓸 수 있음
</script>
</html>