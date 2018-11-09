<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script></script>
</head>
<body>
	
hello : <spring:message code="hello"/> <br/>
visitor : <spring:message code="visitor" arguments="${param.name }"/> <br/>

<form action="/messageView" method="post">
아이디 : <input type="text" name="name" value="brown"/> <br/>
내용 : <input type="text" name="content" value="content"/> <br/>
<select id="selecLang" name="lang">
	<option value="ko" >한국어</option>
	<option value="en" >english<option>
	<option value="ja" >日本語<option>
</select>
<input type="submit" value="전송"/>
</form>
<script type="text/javascript">
	document.getElementById('selecLang').value = "${param.lang == null ? 'ko' : param.lang}";
</script>

</body>
</html>