<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/lib/basicLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=Scz5I6WRnkNbcyd8blkp"></script>
	

	
</head>


<body>


	<%@ include file="/WEB-INF/view/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/WEB-INF/view/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div>

					<h3>대덕 인재 개발원</h3>
					<hr />
					<!-- 네이버 지도 -->
					<div id="map" style="width: 700px; height: 400px;">
						<script type="text/javascript">
							var x = 36.324810;
							var y = 127.420097;

							var map = new naver.maps.Map('map', {
								center : new naver.maps.LatLng(x, y),
								zoom : 10,

								scaleControl : true,
								logoControl : true,
								mapDataControl : true,
								mapTypeControl : true,
								zoomControl : true
							});

							var marker = new naver.maps.Marker({
								position : new naver.maps.LatLng(x, y),
								map : map
							});

							var contentString = [
									'<div class="iw_inner" style="padding: 10px;">',
									'<h4>대덕 인재 개발원</h4>',
									'<hr/>',
									'<p>대전광역시 중구 중앙로 76 영민빌딩<br/>',
									'지번주소 대전광역시 중구 대흥동 500 영민빌딩 2층<br/>',
									'042-222-8202 | 직업,기술학원<br/>',
									'<a href="http://www.ddit.or.kr">www.ddit.or.kr</a>',
									'</p>', '</div>' ].join('');

							var infowindow = new naver.maps.InfoWindow({
								content : contentString,

								backgroundColor : "#fff",
								borderWidth : 1
							});

							infowindow.open(map, marker);
						</script>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>