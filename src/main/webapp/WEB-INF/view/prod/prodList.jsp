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

	.mydiv {width : 100%}
	
</style>


<script type="text/javascript">
	
	$(document).ready(function(){
		//크롬 개발자 도구 확인 을 위한 출력문	
		console.log("document.ready");
		$(".prodClick").on("click", function(){
			console.log("userClick")
			var prodId = $(this).children()[0].innerHTML;
			$("#prodId").val(prodId);
			$("#frm").submit();				
		});
		
		$("#insertProd").click(function(){
			
			alert("I am groot");
		});
		
	});

</script>
</head>

<form id="frm" action="/prod/prodDetail" method="get">
	<input type="hidden" id="prodId" name="prodId"/>
</form>
<body>

	<%@ include file="/WEB-INF/view/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/WEB-INF/view/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main mydiv">
						<h2 class="sub-header">제품리스트</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<tr>
									<th>제품아이디</th>
									<th>제품명</th>
									<th>제품그룹명</th>
									<th>제품등록일</th>
								</tr>
								
								 <c:forEach items="${prodList }" var="pv">
								 <tr class="prodClick">
									<td>${pv.prod_id }</td>
									<td>${pv.prod_name}</td>
									<td>${pv.lprod_nm }</td>
									<td><fmt:formatDate value="${pv.prod_insdate }" pattern="yyyy-MM-dd" /></td>
								</tr>
								 </c:forEach>
							</table>
						</div>

						<a class="btn btn-default pull-right" id="insertProd" href="#" >상품 등록?</a>

						<div class="text-center">
							<ul class="pagination">
								 <li> <a href="prodPageList?page=1&pageSize=10" aria-label="Previous"> <span aria-hidden="true">&laquo;</span> </a> </li>
								<c:forEach begin="1" end="${pageCount }" var="i">
									<li><a href="prodPageList?page=${i}&pageSize=10">${i }</a></li>
								</c:forEach>
								   <li> <a href="prodPageList?page=${pageCount }&pageSize=10" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>






















