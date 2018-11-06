<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/lib/basicLib.jsp"%>



<style type="text/css">
.search {
	width: 400px;
	padding-top: 11px;
	padding-right:30px;
}
</style>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" id="userId" href="#">${nowLogin.userId }님 안녕하세요</a>



		</div>

		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<div class="search">
						<!-- 구글 맞춤 검색 -->
						<script>
							(function() {
								var cx = '001639708912764023061:_5frlotheus';
								var gcse = document.createElement('script');
								gcse.type = 'text/javascript';
								gcse.async = true;
								gcse.src = 'https://cse.google.com/cse.js?cx='
										+ cx;
								var s = document.getElementsByTagName('script')[0];
								s.parentNode.insertBefore(gcse, s);
							})();
						</script>
						<gcse:searchbox-only></gcse:searchbox-only>
					</div>
				</li>
				<li><a href="/main">Main</a></li>
				<li><a href="/index">Logout</a></li>
			</ul>
		</div>
	</div>
</nav>

<script>
	$("#userId").click(function() {
		alert("아무것도 없어 돌아가");
	});
</script>