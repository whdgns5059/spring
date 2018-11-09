<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/view/common/basicLib.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	
	var userVo = {userId: "brown", alias:"곰", name:"브라운", pass:"brownpass"};
	
	//자바스크립트 객체르 문자열로 변환 메소드 :stringify
	$("#sendData").html(JSON.stringify(userVo));
	
	
	$("#send").on("click", function(){
		$.ajax({
			contentType : "application/json; charset=UTF-8",
			url : "/ajax/getRangers",
			type : "post",
			data : JSON.stringify(userVo),
			success : function(dt){
				$("#result").html(JSON.stringify(dt));
				JSON.stringify(dt)
			}
		});
	});
	
	
	
	
});
</script>

</head>
<body>

	<h2>view.jsp</h2>	
	<button id="send" >클릭</button><br/>
	전송 데이터 : <span id="sendData"></span><br/>
	응답 결과 : <span id="result"></span>

</body>
</html>