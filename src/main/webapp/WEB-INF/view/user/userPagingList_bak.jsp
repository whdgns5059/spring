<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@ include file="/WEB-INF/view/common/basicLib.jsp"%>

<style type="text/css">
	.userClick { cursor : pointer;}
</style>


<script type="text/javascript">
	
	$(document).ready(function(){
		//크롬 개발자 도구 확인 을 위한 출력문	
		console.log("document.ready");
		$(".userClick").on("click", function(){
			console.log("userClick")
			var userId = $(this).children()[1].innerHTML;
			$("#userId").val(userId);
			$("#frm").submit();				
		});
	});

</script>
</head>

<form id="frm" action="/user/userDetail" method="get">
	<input type="hidden" id="userId" name="userId"/>
</form>
<body>

	<%@ include file="/WEB-INF/view/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/WEB-INF/view/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<tr>
									<th>번호</th>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>생일</th>
								</tr>
								
								<%--	
								<% List<UserVo> userList = (List<UserVo>)request.getAttribute("userPageList"); 
								
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								for(UserVo uv : userList){
								%>
								<tr class="userClick">
									<td><%=uv.getRnum() %></td>
									<td>[<%=uv.getUserId() %>]</td>
									<td><%=uv.getName() %></td>
									<td><%=sdf.format(uv.getBirth()) %></td>
								</tr>
								<%} %>
								 --%>
								 
								 <c:forEach items="${userList }" var="uv">
								 <tr class="userClick">
									<td>${uv.rnum }</td>
									<td>${uv.userId}</td>
									<td>${uv.name }</td>
									<td><fmt:formatDate value="${uv.birth }" pattern="yyyy-MM-dd"/></td>
								</tr>
								 </c:forEach>
							</table>
						</div>

						<a class="btn btn-default pull-right" href="/user/userForm">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								 <li> <a href="userPageList?page=1&pageSize=10" aria-label="Previous"> <span aria-hidden="true">&laquo;</span> </a> </li>
								 <%--
								<% 
								int pageCnt = (Integer)request.getAttribute("pageCnt"); 
								
								for(int p = 1; p <= pageCnt; p++){
									%>
									<li><a href="userPageList?page=<%=p %>&pageSize=10"><%=p %></a></li>
									<%
								} 
								%>
								 --%>
								 
								<c:forEach begin="1" end="${pageCnt }" var="i">
									<li><a href="/user/userPageList?page=${i}&pageSize=10">${i }</a></li>
								</c:forEach>
								   <li> <a href="/user/userPageList?page=${pageCnt }&pageSize=10" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>






















