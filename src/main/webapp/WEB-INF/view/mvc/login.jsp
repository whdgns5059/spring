<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp</title>
<link href="../css/bootstrap.min.css" rel="styleSheet">
<link href="../css/signin.css" rel="styleSheet" >
<%@ include file="/WEB-INF/view/common/basicLib.jsp"%>
<script type="text/javascript">

	function getCookie(cookieName){
		
		var strArr = document.cookie.split("; ");
		
		
		var targetStr = "";
		for(var index = 0; index < strArr.length; index++){
			
			if(strArr[index].indexOf(cookieName + "=") > -1){
				targetStr = strArr[index];
			}
		}
		
		var equalIndex = targetStr.indexOf("=") + 1;
		var resultStr = targetStr.substr(equalIndex);
		
		return resultStr;
	}
	
	$(document).ready(function(){
		
		if(getCookie("remember") == "Y"){
			//var inputEmail = document.getElementById("inputEmail");
			//inputEmail.value = getCookie("userId");
			//var rememberMe = document.getElementById("rememberMe");
			//rememberMe.checked = true;
			
			//jquery를 이용
			$("#rememberMe").attr("checked", true);
			$("#inputEmail").val(getCookie("userId"));

		}
	});
</script>



</head>

<body>


<!-- <form action="/login/LoginProcess.jsp" method="post"> -->

<div class="container">

<form action="/dditLogin" method="post" class="form-signin">
	<h2 class="form-signin-heading">Please sign in</h2>
	<label for="inputEmail" class="sr-only">Email address</label>	
	<input type="text" name="userId" id ="inputEmail" value="" class="form-control" placeholder="Email address" required="required" autofocus="autofocus"/>
	<label for=inputPassword class="sr-only">Password</label>
	<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required="required" value=""/>
	<div class="checkbox">
   		<label>
   			<input type="checkbox" id="rememberMe" value="remember-me" name="remember-me"> Remember me
       	</label>
   	</div>
	<input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign in"/> 	
	
</form>


</div>

</body>

</html>