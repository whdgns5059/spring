<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<style type="text/css">
	.profile { width: 200px; height:200px;}
</style>
<%@ include file="/WEB-INF/view/common/basicLib.jsp"%>

<script type="text/javascript">
	
	$(document).ready(function(){
		
		$("#updateUser").click(function(){
			
			var userId = document.getElementById("userId").textContent;
			location.href = "/user/userUpdate?userId="+userId;
			
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
			
				<form class="form-horizontal" role="form" action="/user/userUpdateForm.jsp" method="post">
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">사진</label>
						<div class="col-sm-10">
							<img class="profile" src="${userVo.profile }"
							<%--	${userVo.profile != null ? userVo.profile : "/profile/noimage.png"} --%>
							>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">아이디</label>
						<div class="col-sm-10">
							<label id="userId" class="control-label">${userVo.userId }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.name}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.addr1 }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.addr2 }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.zipcd }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
							<label class="control-label">
							<fmt:formatDate value="${userVo.birth }" pattern="yyyy-MM-dd"/> 
							</label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
							<label class="control-label"> ${userVo.email }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Tel</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.tel }</label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="updateUser" class="btn btn-default">사용자 정보 수정</button>
						</div>
					</div>	

					
				</form>	
			</div>
		</div>
	</div>
</body>
</html>