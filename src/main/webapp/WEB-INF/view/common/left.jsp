<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/lib/basicLib.jsp"%>


<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="hover"><a href="/board">새 게시판 추가 </a></li>
	</ul>
	<ul class="nav nav-sidebar">
		<c:forEach items="${boardListDelY }" var="bl">
			<li class="post hover"  value="${bl.brd_id }"><a>${bl.brd_name }</a></li>
		</c:forEach>
	</ul>
</div>



<script>
	$(document).ready( function() {
		$(".post").click(function() {
			
			
			var brd_name = this.innerText;
			var brd_id = this.getAttribute("value");
			location.href = "/postList?brd_id=" + brd_id
				+ "&brd_name=" + brd_name + "&page=1";
		});
		
		$(".hover").hover(function(){
			
			$(this).addClass('active');
			this.style.cursor = "pointer";
			
		}, function(){
			
			$(this).removeClass('active');
			
		});
		
		
		
	});
</script>