<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/sheader.jsp"%>

<!-- picker : https://lalwr.blogspot.kr/2016/04/bootstrap-datepicker.html -->
<link rel="stylesheet" type="text/css" href="/resources/rpjt/datepicker/datepicker3.css" />
<script type="text/javascript" src="/resources/rpjt/datepicker/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="/resources/rpjt/datepicker/bootstrap-datepicker.kr.js"></script>


<!-- 개인정보수정 페이지 -->
<div class="col-md-9">



	<h1>FAQ</h1>	
	<form role="form" method="POST">
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td><input class="form-control" type="text" name="title"
					value="${CsfaqVO.title}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea class="form-control" name="content" >${CsfaqVO.content}</textarea>
				</td>
			</tr>
		</table>
	</form>
	
	<input type="submit" class="btn btn-warning" value="등록">
	<input type="submit" class="btn btn-primary" value="목록">
		
</div>
<!-- //관리자정보수정 페이지 -->

<!-- 버튼에 대한 스크립트  -->
<script type="text/javascript">

var formObj = $("form[role='form']");

console.log(formObj);

$(".btn-warning").on("click", function(){
	if(confirm("등록할랭?")){
		formObj.submit();
	}
});

$(".btn-primary").on("click", function(){
	self.location = "/cs/S_faq";
});

</script>
<!-- //버튼에 대한 스크립트  -->

<%@include file="../include/cfooter.jsp"%>