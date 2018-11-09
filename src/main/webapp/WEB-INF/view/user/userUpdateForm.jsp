<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script>

	//주소 검색 버튼 클릭 이벤트가 발생 했을떄 실행 되어야 한다
$(document).ready(function(){
	
	
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

	
	
<style type="text/css">

	.profileImg {width: :200px; height:200px}
	
</style>


<form class="form-horizontal" role="form" action="/user/userUpdate"
	method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">사진</label>
		<div class="col-sm-10">
			<img class="profileImg"
				src=${userVo.profile != null ? userVo.profile : "/profile/noimage.png"}>
			<input type="file" name="profilePic">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">아이디</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="userId" name="userId"
				placeholder="사용자 아이디" readonly="readonly" value="${userVo.userId }">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="pass" name="pass"
				placeholder="비밀번호" value="${userVo.pass }">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">이름</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="name" name="name"
				placeholder="이름" value="${userVo.name }">
		</div>
	</div>



	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">주소</label>
		<div class="col-sm-10">
			<!-- 주소 검색 버튼 -->
			<button type="button" id="addrSearch" class="btn btn-default">주소검색</button>
			<input type="text" class="form-control" id="addr1" name="addr1"
				placeholder="주소" readonly value="${userVo.addr1 }" />
		</div>
	</div>


	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">상세주소</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="addr2" name="addr2"
				placeholder="상세주소" value="${userVo.addr2 }">
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">우편번호</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="zipcd" name="zipcd"
				placeholder="우편번호" readonly="readonly" value="${userVo.zipcd }">
		</div>
	</div>

	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">생년월일</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="birth" name="birth"
				placeholder="생년월일" readonly="readonly"
				value=<fmt:formatDate value="${userVo.birth }" pattern="yyyy-MM-dd" />>
		</div>
	</div>

	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">Email</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="email" name="email"
				placeholder="Email" value="${userVo.email }">
		</div>
	</div>

	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">Tel</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="tel" name="tel"
				placeholder="Tel" value="${userVo.tel }">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">사용자 정보수정</button>
		</div>
	</div>
</form>
