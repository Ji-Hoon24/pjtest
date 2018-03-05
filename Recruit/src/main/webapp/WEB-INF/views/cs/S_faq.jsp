<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/sheader.jsp"%>

<!-- 개인관리 페이지 -->
<div class="col-md-9">
	<h1>FAQ</h1>

	<table class="table table-bordered">
		<tr>
			<th>제목</th>
		</tr>		
	<c:forEach items="${list}" var="CsfaqVO">
		<tr>
			<td><a href='/cs/S_faqread?bno=${CsfaqVO.bno}'>${CsfaqVO.title}</a></td>
		</tr>
	</c:forEach>
			
	</table>
	
	<button class="btn btn-success" type="button" onclick="location.href='/cs/S_faqreg'">작성</button>
	
	<%-- <!-- 검색 -->
	<div class="box-body">
		<select name="searchType">
			<option value="non" <c:out value="${cri.searchType == null?'selected':'' }"/>>----</option>
			<option value="id" <c:out value="${cri.searchType eq 'id'?'selected':'' }"/>>아이디</option>
			<option value="pname" <c:out value="${cri.searchType eq 'pname'?'selected':'' }"/>>이름</option>
			<option value="email" <c:out value="${cri.searchType eq 'email'?'selected':'' }"/>>이메일</option>
		</select>
	<input type = "text" name='keyword' id="keywordInput" value='${cri.keyword }'>
	<button id='searchBtn'>검색</button>
	</div>
	<!-- //검색 --> --%>
</div>
<!-- //개인관리 페이지 -->
<!-- /.container -->

<!-- 검색 스크립트  -->
<!-- <script type="text/javascript">
	$(function(){
		$('#searchBtn').on("click", function(event){
			self.location = "A_main"
				+ '${pageMaker.makeQuery(1)}'
				+ "&searchType="
				+ $("select option:selected").val()
				+ "&keyword=" + encodeURIComponent($('#keywordInput').val());
		})
	})
</script> -->
<!-- //검색 스크립트  -->


<!-- 수정, 삭제 처리시 -->
<script type="text/javascript">
var result = '${msg}';

if(result == 'modify'){
	alert("수정 처리가 완료 되었습니다.");
}else if(result == 'remove'){
	alert("삭제가 완료 되었습니다.");
}else if(result == 'regist'){
	alert("FAQ가 등록 되었습니다..");
}
</script>
<!-- //수정, 삭제 처리시 -->

<%@include file="../include/cfooter.jsp"%>