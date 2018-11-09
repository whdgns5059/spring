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
		$("#updateProd").click(function(){
			alert("I am groot");
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
				<h2 class="sub-header">제품 상세정보</h2>
			
				<form class="form-horizontal" role="form" action="/prod/prodUpdateForm.jsp" method="post">
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">제품아이디</label>
						<div class="col-sm-10">
							<label id="prodId" class="control-label">${prodVo.prod_id }</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="prodNm" class="col-sm-2 control-label">제품명</label>
						<div class="col-sm-10">
							<label id="prodId" class="control-label">${prodVo.prod_name }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="prodNm" class="col-sm-2 control-label">제품그룹명</label>
						<div class="col-sm-10">
							<label class="control-label">${prodVo.lprod_nm}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="prodNm" class="col-sm-2 control-label">바이어이름</label>
						<div class="col-sm-10">
							<label class="control-label">${prodVo.buyer_name }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="prodNm" class="col-sm-2 control-label">바이어이메일</label>
						<div class="col-sm-10">
							<label class="control-label">${prodVo.buyer_mail }</label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="updateProd" class="btn btn-default">제품 정보 수정</button>
						</div>
					</div>	

					
				</form>	
			</div>
		</div>
	</div>
</body>
</html>