<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<link
	href="${pageContext.request.contextPath}/resources/css/finalcss.css"
	rel="stylesheet" type="text/css" />

<html lang="ko">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- JQuery -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-rwdImageMaps/1.6/jquery.rwdImageMaps.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/jquery.easing.min.js"></script>
<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script> -->
<script type="text/javascript"
	src="http://davidlynch.org/projects/maphilight/jquery.maphilight.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.map').maphilight();

	});
	$.fn.maphilight.defaults = {

		stroke : true,
		strokeColor : 'BFBF42',
		strokeWidth : 5,
		strokeOpacity : 1,
		fade : true,
		shadow : true,
		shadowRadius : 10,
		shadowColor : 'D1D19C',
		shadowOpacity : 0.5,
	}
</script>

<jsp:include page="header.jsp"></jsp:include>
<head>
<meta charset="UTF-8">
<title>리그오브레전드 시네마틱</title>
</head>
<body>
	<!-- Image Map Generated by http://www.image-map.net/ -->
	<div id="maploca">
		<img src="resources/image/Mmap.png" usemap=#amap class="map" />
		<map name="amap">
			<area alt="프렐요드" title="프렐요드" href="https://youtu.be/a23rEkErOdo"
				coords="210,105,168,123,183,130,148,147,168,155,171,172,146,183,132,193,110,195,85,218,71,247,92,251,92,264,80,279,95,291,115,285,132,296,148,296,158,305,170,291,182,273,198,259,217,239,205,271,193,295,183,307,212,307,234,310,266,298,305,291,346,283,366,266,383,220,414,222,448,218,482,174,528,140,567,127,599,125,645,76,648,18,584,1,456,1,400,50,358,113,321,77,283,88,270,132"
				shape="poly">
			<area alt="녹서스" title="녹서스" href="https://youtu.be/0Dy6b5GR4b0"
				coords="732,140,688,95,627,95,584,126,535,131,496,173,616,219,635,257,644,294,579,299,554,319,586,341,615,401,560,409,525,416,484,415,457,428,433,443,406,443,435,462,501,481,549,469,577,467,594,448,620,455,642,464,666,482,688,505,708,513,730,513,730,476,713,431,759,457,786,459,791,438,798,413,803,404,844,423,854,415,889,408,923,415,935,437,974,447,998,460,1010,471,1010,493,1035,506,1059,501,1039,472,1059,430,1081,416,1115,430,1120,398,1074,388,991,375,958,320,917,276,874,274,844,294,847,316,832,305,786,286,764,267,767,211,793,155,769,155"
				shape="poly">
			<area alt="데마시아" title="데마시아" href="https://youtu.be/V0tF0rzZQXI"
				coords="490,175,455,223,388,233,368,282,268,308,248,313,282,347,300,357,288,376,256,350,251,371,259,403,285,415,312,425,331,444,348,449,366,425,382,444,405,454,422,459,407,442,436,445,487,415,605,398,582,342,553,325,582,292,638,289,624,253,616,223,565,208,529,191"
				shape="poly">
			<area alt="필트오버&amp;자운" title="필트오버&amp;자운"
				href="https://youtu.be/mq3_876lnTw"
				coords="851,432,823,481,850,539,933,536,946,473,933,452,914,418,885,418"
				shape="poly">
			<area alt="타곤" title="타곤" href="https://youtu.be/oQHdEeUcfO8"
				coords="519,665,563,683,590,724,592,775,582,799,561,767,541,782,544,789,524,795,514,785,504,789,477,767,477,743,480,704,504,692"
				shape="poly">
			<area alt="슈리마" title="슈리마"
				href="https://www.youtube.com/watch?v=ZjsKfaxRz7I"
				coords="550,551,527,566,516,587,499,604,493,624,505,641,555,656,594,700,596,755,572,799,611,830,654,886,696,855,847,823,845,789,864,797,884,790,907,809,922,763,961,758,956,721,908,678,907,605,888,571,862,534,813,527,793,536,759,522,747,537,715,566,703,549,686,548,666,542,657,517,630,515,632,534,615,539,611,558,586,565"
				shape="poly">

			<area alt="이쉬탈" title="이쉬탈"
				href="https://www.youtube.com/watch?v=5SuJWpOJxJM"
				coords="921,625,921,692,958,721,989,766,1002,748,1036,729,1072,748,1091,760,1096,739,1072,702,1050,678,1053,659,1048,637,1008,625,985,612,963,617,941,614"
				shape="poly">
			<area alt="그림자군도" title="그림자군도" href="https://youtu.be/BmgnO7Pusq0"
				coords="1350,684,1345,706,1347,760,1398,771,1425,766,1443,710,1416,683,1393,700,1384,676,1377,666,1369,694,1364,662"
				shape="poly">
			<area alt="아이오니아" title="아이오니아" href="https://youtu.be/jt14VPA69cI"
				coords="1035,80,1020,111,1022,145,1003,160,1009,203,1014,230,1042,240,1074,250,1090,233,1113,248,1132,267,1156,262,1180,255,1202,257,1230,265,1217,286,1215,347,1235,373,1253,365,1280,375,1288,411,1316,407,1344,448,1355,436,1344,411,1329,346,1322,292,1305,250,1307,214,1283,193,1266,163,1270,131,1256,88,1249,46,1200,36,1137,42,1088,58,1083,83,1060,68"
				shape="poly">
			<area alt="빌지워터" title="빌지워터" href="https://youtu.be/Fao37s6Zf0Y"
				coords="1149,505,1135,506,1142,530,1132,537,1123,555,1139,564,1152,555,1156,569,1173,574,1181,567,1169,547,1173,530,1184,518,1169,516,1164,505"
				shape="poly">
			<area alt="밴들시티" title="밴들시티" href="https://youtu.be/vI23DsDLKO4"
				coords="961,511,930,512,917,540,873,539,892,590,907,617,927,598,946,603,974,600,998,619,1042,637,1076,592,1090,575,1052,529,1023,532,996,554,987,535,982,513"
				shape="poly" shape="poly">
		</map>
	</div>
</body>
<div id="mapfooter">
<jsp:include page="footer.jsp"></jsp:include>
</div>
</html>
