<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../include/aheader.jsp"%>

<!-- picker : https://lalwr.blogspot.kr/2016/04/bootstrap-datepicker.html -->
<link rel="stylesheet" type="text/css" href="/resources/rpjt/datepicker/datepicker3.css" />
<script type="text/javascript" src="/resources/rpjt/datepicker/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="/resources/rpjt/datepicker/bootstrap-datepicker.kr.js"></script>


<!-- 개인정보수정 페이지 -->
<div class="col-md-9">
	<h1>회원정보 수정</h1>
	<form role="form" method="POST">
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<td><input class="form-control" type="text" name="id" value="${AmainVO.id}"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input class="form-control" type="text" name="pw"
					placeholder="변경할 비밀번호를 입력하세요." value="${AmainVO.pw}"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input class="form-control" type="text" name="pwc"
					placeholder="비밀번호를 다시 입력하세요."></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input class="form-control" type="text" name="pname" value="${AmainVO.pname}"></td>
			</tr>
			<tr>
				<th>E-mail</th>
				<td><input class="form-control" type="text" name="email"
					value="${AmainVO.email}"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>
				<div class="input-group date" data-provide="datepicker">
				<input type="text" class="form-control" value="${AmainVO.birth}">
				<span class="input-group-addon">
				<i class="glyphicon glyphicon-calendar"></i>
				</span>
				</div>
				</td>
			</tr>
			<%-- <fmt:formatDate pattern="yyyy-MM-dd" value="${AmainVO.birth}" /> --%>
		</table>
	</form>
		<input type="submit" class="btn-warning" value="수정">
		<input type="submit" class="btn-danger" value="삭제">
		<input type="submit" class="btn-primary" value="목록">
	<h1>이력서 수정</h1>
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<th>이력서 제목</th>
			<th>수정</th>
		</tr>
		<tr>
			<td>3</td>
			<td>신입사원 땡땡땡입니다.</td>
			<td><input type="button" value="수정"></td>
		</tr>
		<tr>
			<td>2</td>
			<td>신입사원 땡땡땡입니다.</td>
			<td><input type="button" value="수정"></td>
		</tr>
		<tr>
			<td>1</td>
			<td>신입사원 땡땡땡입니다.</td>
			<td><input type="button" value="수정"></td>
		</tr>
	</table>
</div>
<!-- //개인정보수정 페이지 -->

<script type='text/javascript'>
	$(function() {
		$('.input-group.date').datepicker({
			calendarWeeks : false,
			todayHighlight : true,
			autoclose : true,
			format : "yyyy-mm-dd",
			language : "kr"
		});
	});
</script>

<script type="text/javascript">

$(function(){
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$(".btn-warning").on("click", function(){
		formObj.submit();
	});
	
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/admin/remove");
		formObj.submit();
	});
	
	$(".btn-primary").on("click", function(){
		self.location = "/admin/A_main";
	});
});
</script>

<%@include file="../include/cfooter.jsp"%>