<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<!-- 
<style type="text/css">
	.profile { width: 200px; height:200px;}
</style>
-->
<%@ include file="/WEB-INF/view/common/basicLib.jsp"%>

<!-- 다음 주소 API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- jquery ui API -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- jquery ui css -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


<script>

	//주소 검색 버튼 클릭 이벤트가 발생 했을떄 실행 되어야 한다
$(document).ready(function(){
	
	$('#userId').val();
	$('#name').val("testUserId");
	$('#pass').val("pass1234");
	$('#addr1').val("대전 중구 중앙로 76");
	$('#addr2').val("영민빌딩 2층 대덕인재 개발원");
	$('#zipcd').val("32250");
	$('#birth').val("2018-08-08");
	$('#email').val("test@test.com");
	$('#tel').val("010-1234-1234");
	
	
	
	$( function() {
		 $( "#birth" ).datepicker({
		      yearRange: "1920:2020",
		      dateFormat: "yy-mm-dd",
		      changeMonth: true,
		      changeYear: true
		 });
	});
		
	
	$("#addrSearch").click(function(){
		new daum.Postcode({
			oncomplete: function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
				// 예제를 참고하여 다양한 활용법을 확인해 보세요.
				//주소 roadAddress
				//상세주소 : ""
				//우편번호 zonecode
				  
				//주소 input value: data.roadAddress
				document.getElementById('addr1').value = data.roadAddress;
				//우편번호 input value: data.zoneCode
				document.getElementById("zipcd").value = data.zonecode;
				
			}
		}).open();
	});
	
});
</script>

	
	


</head>

<body>

	<%@ include file="/WEB-INF/view/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/WEB-INF/view/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			
			
				<form class="form-horizontal" role="form" action="/user/userForm" method="post" 
						enctype="multipart/form-data">
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">사진</label>
						<div class="col-sm-10">
							<input type="file" name="profilePic">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" name="userId" placeholder="사용자 아이디">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass" name="pass" placeholder="비밀번호">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name" placeholder="이름">
						</div>
					</div>



					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<!-- 주소 검색 버튼 -->					
							<button type="button" id="addrSearch" class="btn btn-default">주소검색</button>
							<input type="text" class="form-control" id="addr1" name="addr1" placeholder="주소" readonly="readonly">
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr2" name="addr2" placeholder="상세주소">
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="zipcd" name="zipcd" placeholder="우편번호" readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="birth" name="birth" placeholder="생년월일" readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="email" name="email" placeholder="Email">
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Tel</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="tel" name="tel" placeholder="Tel">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">사용자 등록</button>
						</div>
					</div>
				</form>	
			</div>
		</div>
	</div>
</body>
</html>