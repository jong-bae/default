<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="${pageContext.request.contextPath}/resources/js/custom/utils.js"></script>

	<h1>
		Hello world! <spring:message code="jb.common.title"/> 
	</h1>
	
	<P>  The time on the server is ${serverTime} </P>
	<P id="p-tag">  The time on the server is ${serverTime2} </P>
	<p> ${id} </p>
	<p> ${name} </p>
	<button id="btn-refresh">시간갱신TEST</button>

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