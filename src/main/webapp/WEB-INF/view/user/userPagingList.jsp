<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style type="text/css">
	.userClick { cursor : pointer;}
</style>


<script type="text/javascript">
	
	$(document).ready(function(){
	
/* 		getUserList(1); */		
 		getUserListHtml(1); 
 		getUserPaginationHtml();
 
		//크롬 개발자 도구 확인 을 위한 출력문	
		$("#userList").on("click",".userClick", function(){
			var userId = $(this).children()[1].innerHTML;
			$("#userId").val(userId);
			$("#frm").submit();				
		});
	});
	
	
	//page인자를 받아서 
	//해당 페이지에 속하는 사용자 리스트 정보를 가져온다
	function getUserList(page){
		var pageSize = 10;
		console.log("page : " + page);
		
		//ajax call
		//사용자 리스트 데이터만 가져오기
		//html을 가져오는게 아니라 json  데이터를 받는 형태로 변경
		$.ajax({
			type : "GET",
			url : "/user/userPageListAjax",
			data : "page=" + page + "&pageSize=" + pageSize,
			success : function(data){
				//data(사용자 json 데이터)를 바탕으로
				//사용자 리스트 갱신
				
				//데이터가 올바르게 왔으면
				//1. 기존 데이터 삭제
				//2. data를 이용하여 table tr태그를 작성
				//3. 기존 리스트에다가 붙여넣기
				var html = "";
				$.each(data.userList, function(idx, user){
					
					html += "<tr class='userClick'>";
					html += "<td>" + user.rnum +"</td>";
					html += "<td>" + user.userId + "</td>";
					html += "<td>" + user.name + "</td>";
					html += "<td>" + user.formattedBirth + "</td>";
					html += "</tr>"
				});
				
				//선택자로 내부 데이터를 변경
				$("#userList").html("");
				$("#userList").html(html);
				
				
				var pagination = "";
				pagination += "<li><a href='javascript:getUserList(1);' aria-label='previous'> <span aria-hidden='true'>&laquo;</span> </a></li>";
				for(var i = 1; i < data.pageCnt; i++){
					pagination += "<li><a href='javascript:getUserList("+ i+");'>"+ i+"</a></li>"
				}	
				pagination += "<li><a href='javascript:getUserList("+ i+");' aria-label='Next'> <span aria-hidden='true'>&raquo;</span>";
				
				$(".pagination").html("");
				$(".pagination").html(pagination);
				
				
				
			}
		});
		
	}
	
	
	function getUserListHtml(page){
		
		var pageSize = 10;

		$.ajax({
			url : "/user/userPageListAjaxHtml",	
			type :"GET",
			data : "page=" + page + "&pageSize=" + pageSize,
			success : function(dt){
				
				console.log(dt);
				$("#userList").html(dt);
								
			}
		});
		
	}
	
	
	function getUserPaginationHtml(){
		
		var page = 1;
		var pageSize = 10;
		
		$.ajax({
			url : "/user/userPaginationHtml",
			type : "GET",
			data : "page=" + page + "&pageSize=" + pageSize,
			success : function(dt){
	
				console.log(dt);	
				$(".pagination").html(dt);
			}
		});
		
	}

</script>
<form id="frm" action="/user/userDetail" method="get">
	<input type="hidden" id="userId" name="userId"/>
</form>
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>사용자 아이디</th>
						<th>사용자 이름</th>
						<th>생일</th>
					</tr>
				</thead>
				<tbody id="userList">
					<c:forEach items="${userList }" var="uv">
						<tr class="userClick">
							<td>${uv.rnum }</td>
							<td>${uv.userId}</td>
							<td>${uv.name }</td>
							<td><fmt:formatDate value="${uv.birth }" pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>
				</tbody>	
			</table>
		</div>

		<a class="btn btn-default pull-right" href="/user/userForm">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
			
			</ul>
		</div>
	</div>
</div>