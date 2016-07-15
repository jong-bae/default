/**
 * 
 * JB-Park JQuery Utils
 * 2016. 07. 15
 */

$.extend( {
	
	sqiAjaxPostJson : function(url, jsonParam, callback, errCallback) {
		
		var ajaxConfig = {
				url : url,
				type : 'POST',
				data : JSON.stringify(jsonParam),
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					callback(result);
				},
				error : function(err) {
					errCallback(err);
				}
		};
		
		$.ajaxSetup(ajaxConfig);
		$.ajax();
	},

	sqiAjaxGetJson : function(url, jsonParam, callback, errCallback) {
		
		var ajaxConfig = {
				url : url,
				type : 'GET',
				data : jsonParam,
				dataType : 'json',
				contentType : 'application/json',
				success : function(result) {
					callback(result);
				},
				error : function(err) {
					errCallback(err);
				}
		};
		
		$.ajaxSetup(ajaxConfig);
		$.ajax();
	}
	
});