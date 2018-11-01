<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<%@ include file="/lib/basicLib.jsp" %>
<link href="/lib/bootstrap/css/signin.css" rel="stylesheet" />
</head>
<body>
	<div class="container"> 	
	<form action="/user/loginProcess" method="post" class="form-signin">
		<h2 class="form-signin-heading">Login</h2>
		<label >User ID</label>
		<input type="text" name="userId" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus value="brown"/>	<br/>
		<label >Password</label>
		<input type="password"  id="inputPassword" class="form-control" placeholder="Password" required name="pass" value="brownpass" /> <br/>
		<input class="btn btn-lg btn-primary btn-block" type="submit" value="로그인"/>	
	</form>	
	</div>
</body>
</html>