<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/main">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="/user/userAllList">사용자 리스트</a></li>
		<li class="active"><a href="/user/userPageList?page=1&pageSize=10">사용자 페이징 리스트</a></li>
		<li class="active"><a href="/prod/prodPageList?page=1&pageSize=10">제품 리스트 </a></li>
		<!-- 사용자 리스트 클릭시 : jspuser 전체정보 조회 화면 출력 -->
	
		<!-- 
		0. 요청을 처리할 서블릿 생성 : UserServlet
		1. jspuser 전체정보 조회 : userService.selectUserAll()
			요청을 처리할 서블릿 생성
		2. 	사용자 정보를 출력할 jsp : userAllList.jsp
		
		
		 -->	
		
	</ul>
</div>