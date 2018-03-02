<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/aheader.jsp"%>

<!-- 개인관리 페이지 -->
<div class="col-md-9">
	<h1>개인회원 리스트</h1>

	<table class="table table=bordered">
		<tr>
			<th>아이디</th>
			<th>회원이름</th>
			<th>이메일</th>
			<th>생년월일</th>
			<th>회원정보수정</th>
		</tr>		

	<c:forEach items="${list}" var="AmainVO">
	
		<tr>
			<td>${AmainVO.id}</td>
			<td>${AmainVO.pname}</td>
			<td>${AmainVO.email}</td>
			<td>${AmainVO.birth}</td>
			<%-- <fmt:formatDate pattern="yyyy-MM-dd" value="${AmainVO.birth}" /> --%>
			<td><input type="button" onclick="location.href='/admin/A_modify?id=${AmainVO.id}'" value="회원정보수정"></td>
	</c:forEach>
			
	</table>

	<!-- pagination 추가 -->
	<div style="text-align: center">
		<ul class="pagination">
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>
	</div>
</div>
<!-- //개인관리 페이지 -->
<!-- /.container -->

<script type="text/javascript">
var result = '${msg}';

if(result == 'success'){
	alert("수정 처리가 완료 되었습니다.");
}
</script>

<%@include file="../include/cfooter.jsp"%>