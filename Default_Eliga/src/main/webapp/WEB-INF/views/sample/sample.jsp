<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/custom/utils.js"></script>
<script>
	var obj = new Object();
	$(function() {
		$('#btn-refresh').click(function() {
			obj.data = 'testdata';
			$.sqiAjaxPostJson('${pageContext.request.contextPath}/ajaxTest', obj,
					function(result) {
						$('#p-tag').text('The time on the server is ' + result.today);
					},
					function(result) {
						
					}
			);
		});
	});
</script>
<title>Default Sample</title>
</head>
<body>
	<h1>
		Hello world!  
	</h1>
	
	<P>  The time on the server is ${serverTime} </P>
	<P id="p-tag">  The time on the server is ${serverTime2} </P>
	<p> ${id} </p>
	<p> ${name} </p>
	<button id="btn-refresh">시간갱신TEST</button>
</body>
</html>